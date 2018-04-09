package servlets.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Expenses
 */
@WebServlet("/Expenses")
public class Expenses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Expenses() {
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
						+ "input.cat{"
						+ "font-weight:900;}</style>"+
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
				"<title>Business Theme - Free CSS Template</title>\r\n" + 
				"<meta name=\"keywords\" content=\"\" />\r\n" + 
				"<meta name=\"description\" content=\"\" />\r\n" + 
				"<link href=\"templatemo_style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n" + 
				"<script language=\"javascript\" type=\"text/javascript\">\r\n"
				+ "function show_alert() {\r\n" + 
				"   alert(\"Successfully inserted\");\r\n" + 
				"}"); 
		out.println("function myFunction(){"
				+ "alert(\"Data Inserted Successfully!\");}");
				out.println("function clearText(field)\r\n" + 
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
		out.println("<form action=\"ExpensesController\" id=\"myform\" >");
		out.println("<span id=\"myId\">Expenses</span><br><br><br>");
		out.println("Expense*&nbsp;<input type=\"text\" placeholder=\"Movie\" name=\"expense\" required=\"\"><br><br>");
		HashMap<Integer,String> list=(HashMap<Integer, String>) request.getAttribute("list");
		Set<Entry<Integer, String>> s=list.entrySet();
		Iterator<Entry<Integer, String>> itr=s.iterator();
		out.println("Category&nbsp;&nbsp;<select required=\"\" name=\"category\">\r\n");
		while(itr.hasNext()) {
			Map.Entry m1=(Map.Entry)itr.next(); 
				out.println("<option value="+m1.getValue()+">"+m1.getKey()+"</option>\r\n"); 
		}
		out.println("</select><br><br>");
		out.println("Amount*&nbsp;&nbsp;<input type=\"number\" placeholder=\"254.26\" step=\"0.000005\" name=\"amount\" required=\"\">");
		out.println("<br><br>Pay By*&nbsp;&nbsp;&nbsp;<select name=\"payBy\" required=\"\">\r\n" + 
				"<option value=\"cash\">Cash</option>\r\n" + 
				"<option value=\"Bank\">Bank</option>\r\n" + 
				"</select><br><br>");
		out.println("Remark*&nbsp;&nbsp;<input type=\"text\" placeholder=\"Fantastic Movie\" name=\"remark\" required=\"required\"><br><br>\r\n" + 
				"Date*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"date\" name=\"dat\"><br><br>");
		out.println("<br><br><input type=\"submit\" onclick=\"myFunction();\" name=\"btn\" value=\"Submit\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "<input type=\"reset\" value=\"Reset\">");
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
