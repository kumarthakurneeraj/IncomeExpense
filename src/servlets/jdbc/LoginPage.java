package servlets.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	doPost(request,response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"<head>\r\n" + 
				"	<title>Login</title>\r\n" + 
				"	<meta charset=\"UTF-8\">\r\n" + 
				"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"<!--===============================================================================================-->	\r\n" + 
				"	<link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.ico\"/>\r\n" + 
				"<!--===============================================================================================-->\r\n" + 
				"	<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\">\r\n" + 
				"<!--===============================================================================================-->\r\n" + 
				"	<link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\">\r\n" + 
				"<!--===============================================================================================-->\r\n" + 
				"	<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\">\r\n" + 
				"<!--===============================================================================================-->	\r\n" + 
				"	<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css-hamburgers/hamburgers.min.css\">\r\n" + 
				"<!--===============================================================================================-->\r\n" + 
				"	<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\">\r\n" + 
				"<!--===============================================================================================-->\r\n" + 
				"	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\">\r\n" + 
				"	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\r\n" + 
				"<!--===============================================================================================-->\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	\r\n" +
				"	<div class=\"limiter\">\r\n" + 
				"		<div class=\"container-login100\">\r\n" + 
				"			<div class=\"wrap-login100\">\r\n" + 
				"				<div class=\"login100-pic js-tilt\" data-tilt>\r\n" + 
				"					<img src=\"images/img-01.png\" alt=\"IMG\">\r\n" + 
				"				</div>\r\n" + 
				"\r\n" + 
				"				<form class=\"login100-form validate-form\" action=\"LoginServlet\" method=\"post\">\r\n" + 
				"					<span class=\"login100-form-title\">\r\n" + 
				"						Member Login\r\n" + 
				"					</span>\r\n" + 
				"\r\n" + 
				"					<div class=\"wrap-input100 validate-input\" data-validate = \"Valid email is required: ex@abc.xyz\">\r\n" + 
				"						<input class=\"input100\" type=\"text\" name=\"email\" placeholder=\"User Name\">\r\n" + 
				"						<span class=\"focus-input100\"></span>\r\n" + 
				"						<span class=\"symbol-input100\">\r\n" + 
				"							<i class=\"fa fa-envelope\" aria-hidden=\"true\"></i>\r\n" + 
				"						</span>\r\n" + 
				"					</div>\r\n" + 
				"\r\n" + 
				"					<div class=\"wrap-input100 validate-input\" data-validate = \"Password is required\">\r\n" + 
				"						<input class=\"input100\" type=\"password\" name=\"pass\" placeholder=\"Password\">\r\n" + 
				"						<span class=\"focus-input100\"></span>\r\n" + 
				"						<span class=\"symbol-input100\">\r\n" + 
				"							<i class=\"fa fa-lock\" aria-hidden=\"true\"></i>\r\n" + 
				"						</span>\r\n" + 
				"					</div>\r\n" + 
				"					\r\n" + 
				"					<div class=\"container-login100-form-btn\">\r\n" + 
				"						<button class=\"login100-form-btn\">\r\n" + 
				"							Login\r\n" + 
				"						</button>\r\n" + 
				"					</div>\r\n" + 
				"\r\n" + 
				"					<div class=\"text-center p-t-12\">\r\n" + 
				"						<span class=\"txt1\">\r\n" + 
				"							Forgot\r\n" + 
				"						</span>\r\n" + 
				"						<a class=\"txt2\" href=\"#\">\r\n" + 
				"							Username / Password?\r\n" + 
				"						</a>\r\n" + 
				"					</div>\r\n" + 
				"\r\n" + 
				"					<div class=\"text-center p-t-136\">\r\n" + 
				"						<a class=\"txt2\" href=\"RegistrationPage\">\r\n" + 
				"							Create your Account\r\n" + 
				"							<i class=\"fa fa-long-arrow-right m-l-5\" aria-hidden=\"true\"></i>\r\n" + 
				"						</a>\r\n" + 
				"					</div>\r\n" + 
				"				</form>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	\r\n" + 
				"	\r\n" + 
				"\r\n" + 
				"	\r\n" +
				"<!--===============================================================================================-->	\r\n" + 
				"	<script src=\"vendor/jquery/jquery-3.2.1.min.js\"></script>\r\n" + 
				"<!--===============================================================================================-->\r\n" + 
				"	<script src=\"vendor/bootstrap/js/popper.js\"></script>\r\n" + 
				"	<script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n" + 
				"<!--===============================================================================================-->\r\n" + 
				"	<script src=\"vendor/select2/select2.min.js\"></script>\r\n" + 
				"<!--===============================================================================================-->\r\n" + 
				"	<script src=\"vendor/tilt/tilt.jquery.min.js\"></script>\r\n" + 
				"	<script >\r\n" + 
				"		$('.js-tilt').tilt({\r\n" + 
				"			scale: 1.1\r\n" + 
				"		})\r\n" + 
				"	</script>\r\n" + 
				"<!--===============================================================================================-->\r\n" + 
				"	<script src=\"js/main.js\"></script>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

}
