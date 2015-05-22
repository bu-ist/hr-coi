package edu.bu.ist.coi_adm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

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
      logger.error(e.getMessage());
      out.print("<br>ERROR! " + e.getMessage());
    }
  }

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		String actionChoice = request.getParameter("action");
		if (actionChoice == null) actionChoice = "";
		if (actionChoice.equals("loadEmployees")) {
			response.sendRedirect("LoadEmployees.jsp");
		} else if (actionChoice.equals("activateEmployees")) {
			response.sendRedirect("ActivateEmployees.jsp");
		} else {
			return;
		}
	}
}

