package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BasketBean;
import beans.ProductBean;

/**
 * Servlet implementation class BakeryServlet
 */

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final HashMap<String, BasketBean> baskets = new HashMap<String, BasketBean>();

	public BasketServlet() {
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
		request.setAttribute("basket", getBasket(request));
		getServletContext().getRequestDispatcher("/basket.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("add") != null) {
			int id = Integer.parseInt(request.getParameter("add"));
			getBasket(request).add(new ProductBean(id));
			response.sendRedirect("stock");
		} else if (request.getParameter("remove") != null) {
			int id = Integer.parseInt(request.getParameter("remove"));
			getBasket(request).remove(id);
			response.sendRedirect("basket");
		}
	}
	
	public static BasketBean getBasket(HttpServletRequest request) {
		String session = request.getSession().getId();
		BasketBean basket = null;
		boolean exists = false;
		for(String savedSession : baskets.keySet()) {
			if(savedSession.equals(session)) {
				exists = true;
				break;
			}
		}
		if(!exists) {
			basket = new BasketBean();
			baskets.put(session, basket);
		} else {
			basket = baskets.get(session);
		}
		return basket;
	}
}
