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
import pojos.IncomeCategoryPojo;

/**
 * Servlet implementation class IncomeCategories
 */
@WebServlet("/IncomeCategories")
public class IncomeCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomeCategories() {
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
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
		out.println("<script>");
		out.println("function del(categoryId) {");
		out.println("document.getElementById(\"categoryId\").value = categoryId;");
		out.println("document.getElementById(\"operation\").value = 'remove';");
		out.println("document.myform.submit();");
		out.println("}");
		out.println("function mod(categoryId,categoryName,categoryDetails,userId) {");
		out.println("document.getElementById(\"categoryId\").value = categoryId;");
		out.println("document.getElementById(\"catName\").value = categoryName;");
		out.println("document.getElementById(\"catDetails\").value = categoryDetails;");
		out.println("document.getElementById(\"userId\").value = userId;");
		out.println("document.getElementById(\"add\").value = 'Save!';");
		out.println("document.getElementById(\"operation\").value = 'edit';");
		out.println("}");
		out.println("</script>");
				out.println("<head>\r\n" + "<style>#myId{\r\n" + 
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
		out.println("<form action=\"IncomeCategoriesController\" name=\"myform\" id=\"myform\">");
		out.println("<span id=\"myId\">Income Categories</span><br><br><br>");
		out.println("Category Name*<input placeholder=\"Rental Income\" type=\"text\" id=\"catName\" name=\"catName\" required=\"\" class=\"cat\"><br><br>");
		out.println("Category Details*<textarea placeholder=\"Income from room rent\" class=\"cat\" id=\"catDetails\" name=\"catDetails\" form=\"myform\" required=\"\"></textarea><br><br>");
		out.println("<br><br><input type=\"submit\" name=\"add\" id=\"add\"  value=\"Add\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "<input type=\"reset\" value=\"Reset\"><br><br>");
		out.println("<input name=\"operation\" id=\"operation\"  value=\"create\" type=\"hidden\">");
		out.println("<input name=\"categoryId\" id=\"categoryId\"   type=\"hidden\">");
		out.println("<input name=\"userId\" id=\"userId\"   type=\"hidden\">");
		out.println("<table><tr>");
		out.println("<th>Category Name</th><th>Category Details</th><th>Edit</th><th>Delete</th></tr>");
		ArrayList<IncomeCategoryPojo> catList = (ArrayList<IncomeCategoryPojo>) request.getAttribute("catList");
		for (IncomeCategoryPojo cat : catList) {
			out.println("<tr>");
			out.println("<td>" + cat.getIncCatName() + "</td>");
			out.println("<td>" + cat.getIncCatDetails() + "</td>");
			out.println(
					"<td ><input  class=\"buttom\"  name=\"edit\" id=\"edit\" value=\"Edit!\" type=\"button\" "
					+ "onclick=\"mod('"+cat.getIncCatId()+"','"+cat.getIncCatName()+"','"+cat.getIncCatDetails()+"','"+cat.getUserId()+"');\"></td>");
			out.println(
					"<td ><input class=\"buttom\" name=\"delete\" id=\"delete\" value=\"Delete!\" type=\"button\" onclick=\"del('"+cat.getIncCatId()+"');\" ></td>");
			out.println("</tr>");
		}
		out.println("</table>");
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
