package servlets.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.UsersDao;
import pojos.UsersPojo;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + 
				"<head>\r\n" + "<style>#myId{\r\n" + 
						"	align:center;\r\n" + 
						"	background-color:green;\r\n" + 
						"	color:#ffffff;\r\n" + 
						"    font-size:30px;\r\n" + 
						"}"
						+ "table{font-family:arial,sans-serif;\r\n"
						+ "border-collapse: collapse;\r\n"
						+ "width:100%; }\r\n"
						+ "td,th{\r\n"
						+ "border:1px solid #dddddd;\r\n"
						+ "text-align:left;\r\n"
						+ "padding:8px;}\r\n"
						+ "tr:nth-child(even){\r\n"
						+ "background-color:#dddddd;}"
						+ "</style>"+
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
				"<title>Business Theme - Free CSS Template</title>\r\n" + 
				"<meta name=\"keywords\" content=\"\" />\r\n" + 
				"<meta name=\"description\" content=\"\" />\r\n" + 
				"<link href=\"templatemo_style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n" + 
				"<script language=\"javascript\" type=\"text/javascript\">\r\n");
		out.println("function myFunction(){"
				+ "alert(\"Information has Changed Successfully!\");}");
				out.println("function clearText(field)\r\n" + 
				"{\r\n" + 
				"	if (field.defaultValue == field.value) field.value = '';\r\n" + 
				"	else if (field.value == '') field.value = field.defaultValue;\r\n" + 
				"}\r\n" + 
				"</script>\r\n" + 
				"</head>\r\n" + 
				"<body>");
		RequestDispatcher rd=null;
		rd=request.getRequestDispatcher("SideBar");
		rd.include(request, response);
		rd=request.getRequestDispatcher("Header");
		rd.include(request, response);
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n");
		HttpSession session=request.getSession();
		int userId=(Integer)session.getAttribute("userId");
		UsersPojo u=UsersDao.find(userId);
				out.println("<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>User Profile</title>\r\n" + 
				"<style type=\"text/css\">\r\n" + 
				"body{\r\n" + 
				"background:#ff6045;\r\n" + 
				"text-align:center;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<h1>User Profile</h1>\r\n" + 
				"<form action=\"UserProfileServlet\"><br><br>\r\n" + 
				"<ul style=\"list-style-type:none\">\r\n" + 
				"<li>User Name*</li><input type=\"text\" name=\"userName\" value="+u.getUserName()+" required=\"\"><br>\r\n" + 
				"<li>Password*</li><input type=\"text\" name=\"password\" value="+u.getPassword()+" required=\"\"><br>\r\n" + 
				"<li>Name*</li><input type=\"text\" name=\"name\" value="+u.getName()+" required=\"\"><br>\r\n" + 
				"<li>Address*</li><input type=\"text\" name=\"address\" value="+u.getAddress()+" required=\"\"><br>\r\n" + 
				"<li>Mobile No.*</li><input type=\"text\" name=\"mob\" value="+u.getMobile()+" required=\"\"><br>\r\n" + 
				"<li>E-Mail*</li><input type=\"text\" name=\"email\" value="+u.getEmail()+" required=\"\"><br><br>\r\n" + 
				"</ul>\r\n" + 
				"<input type=\"submit\" value=\"Update\" onclick=\"myFunction();\" name=\"updateButton\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n" + 
				"<a href=\"Empty\"><input type=\"button\" value=\"Cancel\"></a>" + 
				"</form>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		rd=request.getRequestDispatcher("Footer");
		rd.include(request, response);
		out.println("</body>\r\n" + 
				"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
