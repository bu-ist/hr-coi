package edu.bu.ist.coi_adm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.connector.Request;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.opencsv.CSVReader;

import edu.bu.ist.coi.db.CoiEmployee;
import edu.bu.ist.coi.db.CoiEmployeeDAO;
import edu.bu.ist.coi.db._EmployeeListAdditionsId;

@WebServlet(name = "LoadEmployeesServlet", urlPatterns = { "/loadEmployees" })
@MultipartConfig
public class LoadEmployeesServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String uploadFolderName = "uploads";
  private static volatile String uploadFolder = null;
  private static Logger logger = Logger.getLogger(LoadEmployeesServlet.class);

  public LoadEmployeesServlet() {
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
		final String fileName = getCurrentTimeStamp() + "." + getFileName(filePart);
		final String serverFilePath = getUploadFolder() + File.separator + fileName;
		long timeBefore = System.currentTimeMillis();

		String writeMethod = request.getParameter("writemethod");
		if (writeMethod == null) writeMethod = "";
		if (writeMethod.equals("partwrite")) {
			out.println("<br>Using Part.write method...");
			filePart.write(serverFilePath);
		} else {
			out.println("<br>Using fileoutputstream method...");
			writeToFileUsingFileOutputStream(filePart.getInputStream(), serverFilePath);
		}
		long timeAfter = System.currentTimeMillis();
		out.println("<br>New file " + fileName + " created at " + uploadFolder);// serverFilePath);
		out.println("<br>Time elapsed= " + (timeAfter - timeBefore));

		// Read CSV line by line and use the string array as you want
		CSVReader csvReader = new CSVReader(new FileReader(serverFilePath));

		String[] csvLine;
		while ((csvLine = csvReader.readNext()) != null) {
			//_EmployeeListAdditionsId 
			System.out.println(Arrays.toString(csvLine));
			logger.info(Arrays.toString(csvLine));
			   
			_EmployeeListAdditionsId _emp = null;
			try {
				_emp = new _EmployeeListAdditionsId(csvLine);
			} catch (ArrayIndexOutOfBoundsException e) {
				logger.error("bad csv format");
				continue;
//				throw(e);				// TODO:  exception handling
			}
			CoiEmployee emp = new CoiEmployee();
			CoiEmployeeDAO eDAO = new CoiEmployeeDAO();

			org.hibernate.Session hibSession = eDAO.getSession();
			Transaction hibTransaction = hibSession.beginTransaction();
			
			boolean found = true;
			emp = (CoiEmployee)hibSession.get(CoiEmployee.class, _emp.getEmpUid());
			if (emp == null){
				found = false;
				emp = new CoiEmployee();
			}
			_emp.mergeInCoiEmp(emp);
//			eDAO.save(emp);
//			eDAO.merge(emp);
			if (found == true)
				hibSession.saveOrUpdate(emp);
			else
				eDAO.save(emp);
			hibTransaction.commit();
		}	
		csvReader.close();
	}
  private String getUploadFolder() { //TODO: synchronization not handled.
    if (uploadFolder == null) {
      String contextRealPath = getServletContext().getRealPath("/");
      uploadFolder = contextRealPath + File.separator + uploadFolderName;
      File dir = new File(uploadFolder);
      if (!dir.exists()) {
        boolean create = dir.mkdir();
        if (create) {
          System.out.println("Uploads directory created:" + uploadFolder);
        } else {
          throw new RuntimeException("Directory Cannot Be Created!");
        }
      }
    }
    return uploadFolder;
  }
  private void writeToFileUsingFileOutputStream(InputStream filecontent,
      String filePath) throws IOException {
    OutputStream out = null;
    try {
      out = new FileOutputStream(new File(filePath));
      int read = 0;
      final byte[] bytes = new byte[1024];
      while ((read = filecontent.read(bytes)) != -1) {
        out.write(bytes, 0, read);
      }
    } finally {
      if (out != null) {
        out.close();
      }
      if (filecontent != null) {
        filecontent.close();
      }
    }
  }
  private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
    String[] sections = partHeader.split(";");
    for (String content : sections) {
      if (content.trim().startsWith("filename")) {
        return content.substring(content.indexOf('=') + 1).trim()
            .replace("\"", "");
      }
    }
    return null;
  }
  private static String getCurrentTimeStamp() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd_HHmm-ss");
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}
}

