package servlets.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Header
 */
@WebServlet("/Header")
public class Header extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Header() {
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
		out.println("  <div id=\"templatemo_content\">\r\n" + 
				"    	\r\n" + 
				"        <div id=\"templatemo_menu\">\r\n" + 
				"			<ul>\r\n" + 
				"                <li><a href=\"Empty\" class=\"current\">Home</a></li>\r\n" + 
				"                <li><a href=\"UserProfile\">Profile</a></li>\r\n" + 
				"                <li><a href=\"LogoutServlet\">Logout</a></li>\r\n" + 
				"            </ul>    	\r\n" + 
				"	        <div class=\"cleaner\"></div>\r\n" + 
				"        </div> <!-- end of templatemo_menu -->\r\n" + 
				"        \r\n" + 
				"        <div class=\"content_box\">\r\n" + 
				"        	\r\n" +  
				"</div>");
	}

}
