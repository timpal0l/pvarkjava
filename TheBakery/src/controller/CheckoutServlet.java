package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBConnector;
import beans.BasketBean;
import beans.ComponentBean;
import beans.ProductBean;
import beans.UserBean;

/**
 * Servlet implementation class BakeryServlet
 */

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckoutServlet() {
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
		request.setAttribute("basket", BasketServlet.getBasket(request));
		getServletContext().getRequestDispatcher("/checkout.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		BasketBean basket = BasketServlet.getBasket(request);
		UserBean user = null;
		if(LoginServlet.getUser(request) == null) {
			getServletContext().getRequestDispatcher("/login.jsp").forward(request,
					response);
		} else {
			user = LoginServlet.getUser(request);
			try {
				DBConnector dbms = new DBConnector();
				Connection conn = dbms.getConnection();

				PreparedStatement ps = conn.prepareStatement(
						"INSERT INTO `order` (user_id) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

				ps.setInt(1, user.getId()); 
				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					int orderId = rs.getInt(1);
					for(ProductBean product : basket.getBasket()) {
						for(ComponentBean component : product.getComponentList()) {
							PreparedStatement ps3 = conn.prepareStatement(
									"UPDATE `component` SET amount = amount-1 WHERE id = ? AND amount > 0");
							ps3.setInt(1, component.getId());
							int result = ps3.executeUpdate();
							if(result == 0) {
								throw new IllegalArgumentException(product.getName());
							}
						}
						PreparedStatement ps2 = conn.prepareStatement(
								"INSERT INTO `order_product` (order_id, product_id) VALUES (?, ?)");
						ps2.setInt(1, orderId);
						ps2.setInt(2, product.getId());
						ps2.executeUpdate();
					}
					basket.clear();
					getServletContext().getRequestDispatcher("/thankyou.jsp").forward(request,
							response);
				} else {
					getServletContext().getRequestDispatcher("/login_error.jsp").forward(request,
							response);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} catch(IllegalArgumentException e) {
				request.setAttribute("product", e.getMessage());
				getServletContext().getRequestDispatcher("/checkout_error.jsp").forward(request,
						response);
			}
		}
	}
}
