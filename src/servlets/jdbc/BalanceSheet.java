package servlets.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.ExpensesPojo;
import pojos.IncomesPojo;

/**
 * Servlet implementation class BalanceSheet
 */
@WebServlet("/BalanceSheet")
public class BalanceSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BalanceSheet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
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
				"<script language=\"javascript\" type=\"text/javascript\">\r\n" + 
				"function clearText(field)\r\n" + 
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
		out.println("<form action=\"BalanceSheetController\" id=\"myform\">");
	    out.println("<h2>Balance Sheet</h2>");
	    out.println("<table name=\"dateTable\">");
		out.println("<tr>");
		out.println("<th colspan=\"2\">Date From<br><input id=\"dat\" type=\"date\" name=\"dat\" value=\"2018-03-01\"></th><th colspan=\"2\">To<br><input type=\"date\" value=\"2018-03-12\" id=\"dat1\" name=\"dat1\"></th><th><input type=\"submit\" name=\"submit\" onclick=\"myFunction();\" value=\"Show\"</th>");
		out.println("</tr>\r\n<tr>");
		out.println("</table>");
		ArrayList<IncomesPojo> list=(ArrayList<IncomesPojo>) request.getAttribute("list");
		   double total=0;
		   if(list.isEmpty()==false)
		   {
			   out.println("<table>");
				out.println("<tr>");
				out.println("<th>");
				out.println("<table>");
				out.println("<tr>");
				out.println("<th align=\"center\" colspan=\"2\">Incomes</th>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th align=\"center\">Incomes</th>");
				out.println("<th align=\"center\">Amount</th>");
				out.println("</tr>");
		   }
		    for(IncomesPojo p:list)
		    {
		    	out.println("<tr>");
		    	out.println("<td align=\"center\">"+p.getIncAc()+"</td>");
		    	out.println("<td align=\"center\">"+p.getAmount()+"</td>");
		    	out.println("</tr>");
		    	total=total+p.getAmount();
		    }
		out.println("<tr>");
	  	out.println("<th align=\"center\">Total</th>");
	  	out.println("<th align=\"center\">"+total+"</th>");
	  	out.println("</tr>");
		out.println("</table>");
		out.println("</th>");
		out.println("<th>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th align=\"center\" colspan=\"2\">Expenses</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th align=\"center\">Expenses</th>");
		out.println("<th align=\"center\">Amount</th>");
		out.println("</tr>");
		 ArrayList<ExpensesPojo> list1=(ArrayList<ExpensesPojo>) request.getAttribute("list1");
		   double total1=0;
		    for(ExpensesPojo l:list1)
		    {
		    	out.println("<tr>");
		    	out.println("<td align=\"center\">"+l.getExpAc()+"</td>");
		    	out.println("<td align=\"center\">"+l.getAmount()+"</td>");
		    	out.println("</tr>");
		    	total1=total1+l.getAmount();
		    }
		out.println("<tr>");
	  	out.println("<th align=\"center\">Total</th>");
	  	out.println("<th align=\"center\">"+total1+"</th>");
	  	out.println("</tr>");
		out.println("</table>");
		out.println("</th>");
		out.println("</tr>");
		out.println("</table>");
	    out.println("<h5 align=\"right\">Gross Profit :" +(total - total1));
	    out.println("</h5><br><br>");
	    out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	    out.println("<a href=\"Empty\"><input type=\"button\" value=\"Back\"></a>");
	    out.println("</form>");
		out.println("</form>");
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
