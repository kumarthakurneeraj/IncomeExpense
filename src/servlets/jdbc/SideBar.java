package servlets.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SideBar
 */
@WebServlet("/SideBar")
public class SideBar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SideBar() {
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
		out.println("<div id=\"templatemo_wrapper\">\r\n" + 
				"\r\n" + 
				"    <div id=\"templatemo_sidebar\">\r\n" + 
				"    \r\n" + 
				"		<div id=\"site_title\">\r\n" + 
				"            <h1><a href=\"Empty\">MyProject</a></h1>\r\n" + 
				"        </div> <!-- end of site_title --> \r\n" + 
				"    \r\n" + 
				"        \r\n" + 
				"        <div class=\"sidebar_box\">\r\n" + 
				"        	<h3>Masters</h3>\r\n" + 
				"        	<div class=\"sidebar_content\">\r\n" + 
				"				<ul id=\"news_box\">\r\n" + 
				"                	<li>\r\n" + 
				"                    	<h6><a href=\"ExpensesCategoryController\">Expenses Category</a></h6>\r\n" + 
				"         			</li>\r\n" + 
				"                    <li>\r\n" + 
				"                    	<h6><a href=\"IncomeCategoriesController\">Income Category</a></h6>\r\n" + 
				"                    </li>\r\n" + 
				"                    <li>\r\n" + 
				"                    	<h6><a href=\"ExpensesController\">Expenses</a></h6>\r\n" + 
				"                    </li>\r\n" + 
				"                    <li>\r\n" + 
				"                    	<h6><a href=\"IncomeController\">Income</a></h6>\r\n" + 
				"                    </li>\r\n" + 
				"                    <li>\r\n" + 
				"                    	<h6><a href=\"CashBookController\">Cash Book</a></h6>\r\n" + 
				"                    </li>\r\n" + 
				"                    <li>\r\n" + 
				"                    	<h6><a href=\"BankBookController\">Bank Book</a></h6>\r\n" + 
				"                    </li>\r\n" + 
				"                    <li>\r\n" + 
				"                    	<h6><a href=\"DayBookController\">Day Book</a></h6>\r\n" + 
				"                    </li>\r\n" + 
				"                    <li class=\"last\">\r\n" + 
				"                    	<h6><a href=\"BalanceSheetController\">Balance Sheet</a></h6>\r\n" + 
				"                    	</li>\r\n" + 
				"                </ul>\r\n" + 
				"            </div>\r\n" + 
				"        </div>  \r\n" + 
				"        \r\n" + 
				"    </div>\r\n" + 
				"");
	}

}
