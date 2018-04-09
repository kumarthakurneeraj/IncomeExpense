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

import daos.ExpensesCategoryDao;
import pojos.ExpensesCategoryPojo;

/**
 * Servlet implementation class ExpensesCategoryController
 */
@WebServlet("/ExpensesCategoryController")
public class ExpensesCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpensesCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId = 0;
		if (request.getParameter("categoryId") != null && request.getParameter("categoryId").trim().length()>0)
			categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("catName");
		if (categoryName == null) {
			categoryName = new String();
		}
		String categoryDetails = request.getParameter("catDetails");
		if (categoryDetails == null) {
			categoryDetails = new String();
		}
		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}
		HttpSession session=request.getSession();
		int userId=(Integer)session.getAttribute("userId");
		if (operation.equals("create")) {
			ExpensesCategoryPojo cat = new ExpensesCategoryPojo( categoryName, categoryDetails,userId);
			ExpensesCategoryDao.create(cat);
		} else if (operation.equals("edit")) {
			ExpensesCategoryPojo cat = new ExpensesCategoryPojo(categoryId, categoryName, categoryDetails,userId);
			ExpensesCategoryDao.edit(cat);
		} else if (operation.equals("remove")) {
			ExpensesCategoryDao.remove(categoryId);
		} 

		ArrayList<ExpensesCategoryPojo> catList = ExpensesCategoryDao.findAll();
		request.setAttribute("catList", catList);
		RequestDispatcher rd = request.getRequestDispatcher("ExpensesCategory");
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
