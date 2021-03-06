package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.StockBean;
import beans.UserBean;

/**
 * Servlet implementation class BakeryServlet
 */

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfileServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		if(LoginServlet.getUser(request) != null) {
			request.setAttribute("user", LoginServlet.getUser(request));
			getServletContext().getRequestDispatcher("/profile.jsp").forward(request,
					response);
		} else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
	
	}

}
