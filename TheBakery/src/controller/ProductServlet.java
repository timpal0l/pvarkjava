package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import util.DBConnector;
import beans.ProductBean;
import beans.StockBean;

/**
 * Servlet implementation class BakeryServlet
 */

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductServlet() {
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
		int parameter = Integer.parseInt(request.getParameter("id"));
		ProductBean product = new ProductBean(parameter);
		request.setAttribute("product", product);
		getServletContext().getRequestDispatcher("/product.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("product");
		if(request.getParameter("component") == null) {
			String description = request.getParameter("description");
			double price = Double.parseDouble(request.getParameter("price"));
			try {
				Connection conn = new DBConnector().getConnection();
				PreparedStatement ps = conn
						.prepareStatement("INSERT INTO product "
								+ "(name, description, price) "
								+ "VALUES (?, ?, ?)");
				ps.setString(1, name);
				ps.setString(2, description);
				ps.setDouble(3, price);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			String component = request.getParameter("component");
			try {
				Connection conn = new DBConnector().getConnection();
				PreparedStatement ps = conn
						.prepareStatement("INSERT INTO product_component "
								+ "(product_id, component_id) "
								+ "VALUES (?, ?)");
				ps.setInt(1, Integer.parseInt(name));
				ps.setInt(2, Integer.parseInt(component));
				ps.executeUpdate();
			} catch (MySQLIntegrityConstraintViolationException e) {
				//Already have the ingredient
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("admin");
	}
}
