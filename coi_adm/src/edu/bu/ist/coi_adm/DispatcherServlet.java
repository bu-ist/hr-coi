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

import com.opencsv.CSVReader;
import edu.bu.ist.coi.db._EmployeeListAdditionsId;

@WebServlet(name = "DispatcherServlet", urlPatterns = { "/dispatcher" })
@MultipartConfig
public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static Logger logger = Logger.getLogger(DispatcherServlet.class);

  public DispatcherServlet() {
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

		String actionChoice = request.getParameter("action");
		if (actionChoice == null) actionChoice = "";
		if (actionChoice.equals("loadEmployees")) {
			response.sendRedirect("LoadEmployees.jsp");
		} else {
			return;
		}
	}
}

