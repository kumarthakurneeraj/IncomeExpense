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
import daos.CashBookDao;
import pojos.CashBookPojo;

/**
 * Servlet implementation class CashBookController
 */
@WebServlet("/CashBookController")
public class CashBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CashBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String from=request.getParameter("dat");
		String to=request.getParameter("dat1");
		HttpSession session=request.getSession();
		int userId=(Integer)session.getAttribute("userId");
		System.out.println("User"+userId);
		if(userId!=-1&&from==null&&to==null) {
			ArrayList<CashBookPojo> list=CashBookDao.findAllDateWise("201-03-01", "2018-03-12", userId);
			request.setAttribute("list", list);
			}
		if(userId!=-1&&from!=null&&to!=null) {
		ArrayList<CashBookPojo> list=CashBookDao.findAllDateWise(from, to, userId);
		request.setAttribute("list", list);
		}
		RequestDispatcher rd=request.getRequestDispatcher("CashBook");
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
