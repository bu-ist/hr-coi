package edu.bu.ist.coi_adm;

import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
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
import com.opencsv.CSVWriter;

import edu.bu.ist.coi.db.CoiEmployee;
import edu.bu.ist.coi.db.CoiEmployeeDAO;
import edu.bu.ist.coi.db._EmployeeListAdditionsId;

@WebServlet(name = "LoadEmployeesServlet", urlPatterns = { "/loadEmployees" })
@MultipartConfig
public class LoadEmployeesServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static Logger logger = Logger.getLogger(LoadEmployeesServlet.class);

	public LoadEmployeesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		final PrintWriter out = response.getWriter();
		try {
			processRequest(request, response);
		} catch (IOException e) {
			out.print("<br>ERROR! " + e.getMessage());
		}
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
		final PrintWriter out = response.getWriter();
		final Part filePart = request.getPart("file");
		final String inFileName = Uploader.getCurrentTimeStamp() + 
				"." + Uploader.getFileName(filePart);  		// Server copy of input csv file
		final String backFileName = "back." + inFileName;	// Server's backup csv file
		final String uploadFolder = Uploader.getUploadFolder();
		final String inFilePath = uploadFolder + File.separator + inFileName;
		final String backFilePath = uploadFolder + File.separator + backFileName;

		String writeMethod = request.getParameter("writemethod");
		if (writeMethod == null) writeMethod = "";
		if (writeMethod.equals("partwrite")) {
//			out.println("<br>Using Part.write method...");
			logger.info("Using Part.write method...");
			filePart.write(inFilePath);
		} else {
//			out.println("<br>Using fileoutputstream method...");
			logger.info("Using fileoutputstream method...");
			Uploader.writeToFileUsingFileOutputStream(filePart.getInputStream(), inFilePath);
		}
		out.println("<br>New file " + inFileName + " created at " + uploadFolder);
		logger.info("New file " + inFileName + " created at " + uploadFolder);

		CSVReader csvReader = new CSVReader(new FileReader(inFilePath));
		CSVWriter csvWriter = new CSVWriter(new FileWriter(backFilePath));
		String[] inCsvLine;
		while ((inCsvLine = csvReader.readNext()) != null) {
			logger.info("in: "+Arrays.toString(inCsvLine));
			_EmployeeListAdditionsId _emp = null;
			try {
				_emp = new _EmployeeListAdditionsId(inCsvLine);
			} catch (ArrayIndexOutOfBoundsException e) {
				logger.error("*** Bad csv format - skipping record ***");
				continue;
//				throw(e);				// TODO: better exception handling??
			}
			
			CoiEmployeeDAO eDAO = new CoiEmployeeDAO();
			org.hibernate.Session hibSession = eDAO.getSession();
			Transaction hibTransaction = hibSession.beginTransaction();	
//			boolean found = true;
			CoiEmployee emp = (CoiEmployee)hibSession.get(CoiEmployee.class, _emp.getEmpUid());
			if (emp == null){
//				found = false;
				logger.debug(" CoiEmployee not found: " + _emp.getEmpUid());
				emp = new CoiEmployee();
			} else {
				_EmployeeListAdditionsId _backEmp = new _EmployeeListAdditionsId(emp);
				csvWriter.writeNext(_backEmp._EmpToStringArray());
			}
			_emp.mergeInCoiEmp(emp);
			hibSession.saveOrUpdate(emp);
//			eDAO.merge(emp);
//			if (found == true)		hibSession.saveOrUpdate(emp);
//			else					eDAO.save(emp);
			hibTransaction.commit();
		}
		csvReader.close();
		csvWriter.close();
	}
}
