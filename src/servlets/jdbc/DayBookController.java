package servlets.jdbc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.ExpensesDao;
import daos.IncomesDao;
import pojos.ExpensesPojo;
import pojos.IncomesPojo;

/**
 * Servlet implementation class DayBookController
 */
@WebServlet("/DayBookController")
public class DayBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DayBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session =request.getSession();
	int userId=(Integer)session.getAttribute("userId");
	String from=request.getParameter("dat");
	String to=request.getParameter("dat1");
	if(userId!=-1&&from==null&&to==null)
	{
		ArrayList<ExpensesPojo> p=ExpensesDao.findAllDateWise("2018-03-01", "2018-03-12", userId);
		request.setAttribute("list", p);
		ArrayList<IncomesPojo> ip=IncomesDao.findAllDateWise("2018-03-01", "2018-03-12", userId);
		request.setAttribute("list1", ip);
	}
	if(userId!=-1&&from!=null&&to!=null)
	{
		ArrayList<ExpensesPojo> p=ExpensesDao.findAllDateWise(from, to, userId);
		request.setAttribute("list", p);
		ArrayList<IncomesPojo> ip=IncomesDao.findAllDateWise(from, to, userId);
		request.setAttribute("list1", ip);
	}
	RequestDispatcher rd=request.getRequestDispatcher("DayBook");
	rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
