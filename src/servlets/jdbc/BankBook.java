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
import javax.servlet.http.HttpSession;

import daos.BankBookDao;
import pojos.BankBookPojo;

/**
 * Servlet implementation class BankBook
 */
@WebServlet("/BankBook")
public class BankBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankBook() {
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
		out.println("<form action=\"BankBookController\" id=\"myform\">");
		out.println("<table><tr>");
		out.println("<th>Bank Book</th><th>Date From<br><input "
				+ "value=\"2018-03-01\" type=\"date\" name=\"dat\"></th><th>To<input"
				+ " value=\"2018-03-12\" type=\"date\" name=\"dat1\"></th>"
				+ "<th><input value=\"Show\" type=\"submit\" name=\"show\"></th>");
		ArrayList<BankBookPojo> list=(ArrayList<BankBookPojo>)request.getAttribute("list");
		int sno=1;
		if(list.isEmpty()==false)
		{
			out.println("</tr>\r\n");
			out.println("<tr><th>S. No.</th><th>Date </th><th>Amount </th><th>Pay/Receive</th></tr>");
		}
		for(BankBookPojo p:list)
		{
			out.println("<tr>");
			out.println("<td align=\"center\">"+sno+"</td>");
			out.println("<td align=\"center\">"+p.getTranDate()+"</td>");
			out.println("<td align=\"center\">"+p.getAmount()+"</td>");
			out.println("<td align=\"center\">"+p.getOperation()+"</td>");
			out.println("</tr>");
			sno++;
		}
		HttpSession session=request.getSession();
		out.println("\r\n<tr>");
		out.println("<th colspan=\"2\">Closing Balance </th><th colspan=\"2\">"+BankBookDao.closingBalance((Integer)session.getAttribute("userId")));
		out.println("</th>");
		out.println("</tr></table>");
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
