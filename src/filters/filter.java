package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.UsersDao;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/*")
public class filter implements Filter {

private ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		this.context.log("Requested Resource::" + uri);

		if (uri.endsWith("LoginForm") || uri.endsWith("LoginPage")|| uri.endsWith("LoginServlet") || uri.endsWith("html") || uri.endsWith("js")
				|| uri.endsWith("css") || uri.endsWith("png") ||uri.endsWith("jpg") || uri.endsWith("UserRegistration") || uri.endsWith("RegistrationPage")) {
			this.context.log("Home Page Access");
			chain.doFilter(request, response);
		} else {
			HttpSession session = req.getSession();
			int uid = 0;
			String userName = new String();
			String password = new String();
			if (session != null) {
				Integer sessionId = (Integer) session.getAttribute("userId");
				userName = (String) session.getAttribute("userName");
				password = (String) session.getAttribute("password");
				if (sessionId != null && userName != null && password != null) {
					uid = UsersDao.checkAvailablity(userName, password);
					if (uid == sessionId) {
						chain.doFilter(request, response);
					} else {
						res.sendRedirect("LoginPage");
					}
				} else
					res.sendRedirect("LoginPage");
			}
		}

	}

	public void destroy() {
		// close any resources here
	}

}
