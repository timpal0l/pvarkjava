package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.StockBean;

/**
 * Servlet implementation class BakeryServlet
 */

@WebServlet("/stock")
public class StockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StockServlet() {
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
		StockBean stock = new StockBean(request.getParameter("search"));
		request.setAttribute("stock", stock);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
	}

}
