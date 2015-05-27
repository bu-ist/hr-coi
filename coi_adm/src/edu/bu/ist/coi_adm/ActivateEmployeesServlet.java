package edu.bu.ist.coi_adm;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;
import org.hibernate.Transaction;
import com.opencsv.CSVReader;

import edu.bu.ist.coi.db.CoiActive;
//import edu.bu.ist.coi.db.CoiActiveDAO;
import edu.bu.ist.coi.db.CoiActiveId;
import edu.bu.ist.coi.db.CoiEmployee;
import edu.bu.ist.coi.db.CoiEmployeeDAO;

@WebServlet(name = "ActivateEmployeesServlet", urlPatterns = { "/activateEmployees" })
@MultipartConfig
public class ActivateEmployeesServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static volatile String uploadFolder = null;
  private static Logger logger = Logger.getLogger(ActivateEmployeesServlet.class);

  public ActivateEmployeesServlet() {
    super();
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    final PrintWriter out = response.getWriter();
    try {
      processRequest(request, response);
    } catch (IOException e) {
      out.print("<br>ERROR! " + e.getMessage());
    }
  }

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		final PrintWriter out = response.getWriter();
		final Part filePart = request.getPart("file");
		final String fileName = Uploader.getCurrentTimeStamp() + "." + Uploader.getFileName(filePart);
		final String serverFilePath = Uploader.getUploadFolder() + File.separator + fileName;

		Uploader.writeToFileUsingFileOutputStream(filePart.getInputStream(), serverFilePath);
		out.println("<br>New file " + fileName + " created at " + uploadFolder);// serverFilePath);

		// Read CSV line by line and use the string array as you want
		CSVReader csvReader = new CSVReader(new FileReader(serverFilePath));

		String[] csvLine;
		while ((csvLine = csvReader.readNext()) != null) {
			//_EmployeeListAdditionsId 
//			out.println(Arrays.toString(csvLine));
			logger.info(Arrays.toString(csvLine));
			   
			String uid = null;
			int year = 0;
	        boolean isSenior = false;    
			try {
				uid = csvLine[0];
				year = Integer.parseInt(csvLine[1]);
		        isSenior = Boolean.parseBoolean(csvLine[2]);        
			} catch (ArrayIndexOutOfBoundsException e) {
				logger.error("*** Bad csv format - skipping record ***");
				continue;
//				TODO??:  exception handling
			}
		
			CoiEmployeeDAO eDAO = new CoiEmployeeDAO();
			org.hibernate.Session hibSession = eDAO.getSession();
			Transaction hibTransaction = hibSession.beginTransaction();	
			CoiEmployee emp = (CoiEmployee)hibSession.get(CoiEmployee.class, uid);
			if (emp == null){
				logger.error("*** CoiEmployee not found: " + uid + " - skipping ***");
//				// TODO??:  possible exception handling
				continue;
			}
			CoiActiveId actId = new CoiActiveId(emp, year);
			CoiActive actRecord = new CoiActive(actId, isSenior);
//			CoiActiveDAO actDAO = new CoiActiveDAO();	
//			actDAO.save(actRecord);  //FIXME: add dup record processing
			hibSession.saveOrUpdate(actRecord);;
			hibTransaction.commit();
		}
		csvReader.close();
	}
}

