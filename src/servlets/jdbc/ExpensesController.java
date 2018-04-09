package servlets.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.BankBookDao;
import daos.CashBookDao;
import daos.ExpensesCategoryDao;
import daos.ExpensesDao;
import pojos.BankBookPojo;
import pojos.CashBookPojo;
import pojos.ExpensesCategoryPojo;
import pojos.ExpensesPojo;

/**
 * Servlet implementation class ExpensesController
 */
@WebServlet("/ExpensesController")
public class ExpensesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpensesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int category=0;
		double amount=0;
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		int userId=(Integer)session.getAttribute("userId");
		String expense=request.getParameter("expense");
		if(request.getParameter("category")!=null) {
	    category=Integer.parseInt(request.getParameter("category"));
		}
		if(request.getParameter("amount")!=null) {
		 amount=Double.parseDouble(request.getParameter("amount"));
		}
		String payBy=request.getParameter("payBy");
		String remark=request.getParameter("remark");
		String dat=request.getParameter("dat");
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		if(dat!=null) {
		try {
			date = df.parse(dat);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(expense==null&&amount!=-1&&payBy==null&&dat==null)
		{
		 ArrayList<ExpensesCategoryPojo> list=ExpensesCategoryDao.findAll();
		 HashMap<String,Integer> m=new HashMap<>();
		 for(ExpensesCategoryPojo p:list)
		 {
			 String key=p.getExpCatName();
			 Integer catName=p.getExpCatId();
			 m.put(key, catName);
		 }
		 request.setAttribute("list", m);
		}
		if(userId!=-1&&category!=0&&expense!=null&&amount!=0&&payBy!=null&&remark!=null&&date!=null )
		{
			ExpensesPojo p=new ExpensesPojo(expense, userId, category, amount, date, payBy,
					remark);
			ExpensesDao.create(p);
		}
		if(payBy!=null&&payBy.equals("cash"))
		{
			CashBookPojo cp=new CashBookPojo(expense, date, amount, userId, "pay");
			CashBookDao.create(cp);
		}
		if(payBy!=null&&payBy.equals("Bank"))
		{
			BankBookPojo cp=new BankBookPojo(expense, date, amount, userId, "pay");
			BankBookDao.create(cp);
		}
		System.out.println("Button :"+request.getParameter("btn"));
		if(request.getParameter("btn")!=null&&request.getParameter("btn").equals("Submit"))
		{
		response.sendRedirect("Empty");
		}
		else {
		RequestDispatcher rd=request.getRequestDispatcher("Expenses");
		rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
