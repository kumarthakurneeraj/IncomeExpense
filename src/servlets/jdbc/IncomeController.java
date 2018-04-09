package servlets.jdbc;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.BankBookDao;
import daos.CashBookDao;
import daos.IncomeCategoryDao;
import daos.IncomesDao;
import pojos.BankBookPojo;
import pojos.CashBookPojo;
import pojos.IncomeCategoryPojo;
import pojos.IncomesPojo;

/**
 * Servlet implementation class IncomeController
 */
@WebServlet("/IncomeController")
public class IncomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int category=0;
		double amount=0;
		HttpSession session=request.getSession();
		int userId=(Integer)session.getAttribute("userId");
		String expense=request.getParameter("income");
		if(request.getParameter("category")!=null&&request.getParameter("amount")!=null) {
		category=Integer.parseInt(request.getParameter("category"));
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
		if(userId!=-1&&expense==null&&category==0&&amount==0&&payBy==null&&remark==null&&date==null )
		{
			ArrayList<IncomeCategoryPojo> list=IncomeCategoryDao.findAll();
			HashMap<String,Integer> m=new HashMap<>();
			for(IncomeCategoryPojo p:list )
			{
				m.put(p.getIncCatName(), p.getIncCatId());
			}
			request.setAttribute("list", m);
		}
		if(userId!=-1&&expense!=null&&category!=0&&amount!=0&&payBy!=null&&remark!=null&&date!=null )
		{
			IncomesPojo p=new IncomesPojo(expense, userId, category, amount, date, payBy,
					remark);
			IncomesDao.create(p);
			if(payBy!=null&&payBy.equals("cash"))
			{
				CashBookPojo cp=new CashBookPojo(expense, date, amount, userId, "receive");
				CashBookDao.create(cp);
			}
			if(payBy!=null&&payBy.equals("bank"))
			{
				BankBookPojo cp=new BankBookPojo(expense, date, amount, userId, "receive");
				BankBookDao.create(cp);
			}
		}
		if(request.getParameter("btn")!=null&&request.getParameter("btn").equals("Submit"))
		{
			response.sendRedirect("Empty");
		}
		else
		{
		RequestDispatcher rd=request.getRequestDispatcher("Income");
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
