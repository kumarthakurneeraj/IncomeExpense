package servlets.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.UsersDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("email");
		String password=request.getParameter("pass");
		System.out.println("User Name : "+userName);
		System.out.println("Password : "+password);
		int userId=UsersDao.checkAvailablity(userName, password);
		System.out.println("User Id: "+userId);
		if(userName==null&&password==null)
			response.sendRedirect("LoginPage");
		if(userId!=-1)
		{
			HttpSession session=request.getSession();
			session.setAttribute("userName", userName);
			session.setAttribute("password", password);
			session.setAttribute("userId", new Integer(userId));
			response.sendRedirect("Empty");
		}
		else
			response.sendRedirect("LoginPage");
	}

}
