package servlets.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationPage
 */
@WebServlet("/RegistrationPage")
public class RegistrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>User Registration</title>\r\n" + 
				"<style type=\"text/css\">\r\n" + 
				"body{\r\n" + 
				"background:#ff6045;\r\n" + 
				"text-align:center;\r\n" + 
				"}\r\n" + 
				"</style>\r\n");
		out.println("<script>");
		out.println("function myFunction(){"
				+ "alert(\"You have successfully registered, please login using your username and password!\");}");
		out.println("</script>");
				out.println("</head>\r\n" + 
				"<body>\r\n" + 
				"<h1>User Registration</h1>\r\n" + 
				"<form action=\"RegistrationServlet\" name=\"RegistrationForm\" method=\"post\"><br><br>\r\n" + 
				"<ul style=\"list-style-type:none\">\r\n" + 
				"<li>User Name*</li><input type=\"text\" name=\"userName\" required=\"\"><br>\r\n" + 
				"<li>Password*</li><input type=\"text\" name=\"password\" required=\"\"><br>\r\n" + 
				"<li>Name*</li><input type=\"text\" name=\"name\" required=\"\"><br>\r\n" + 
				"<li>Address*</li><input type=\"text\" name=\"address\" required=\"\"><br>\r\n" + 
				"<li>Mobile No.*</li><input type=\"text\" name=\"mob\" required=\"\"><br>\r\n" + 
				"<li>E-Mail*</li><input type=\"text\" name=\"email\" required=\"\"><br><br>\r\n" + 
				"</ul>\r\n" + 
				"<input type=\"submit\" onclick=\"myFunction();\" value=\"Register\" name=\"regButton\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n" + 
				"<a href=\"LoginPage\"><input type=\"button\" value=\"Cancel\" name=\"cancelButton\"></a>\r\n" + 
				"</form>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

}
