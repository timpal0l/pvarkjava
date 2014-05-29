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

import util.DBConnector;
import beans.StockBean;

/**
 * Servlet implementation class BakeryServlet
 */

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

	DBConnector dbms = new DBConnector();
	Connection conn = dbms.getConnection();

	private static final long serialVersionUID = 1L;

	public AdminServlet() {
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
		StockBean stock = new StockBean("");
		request.setAttribute("stock", stock);
		getServletContext().getRequestDispatcher("/admin.jsp").forward(request,
				response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String tmpAmount = request.getParameter("amount");
		int amount = Integer.parseInt(tmpAmount);

		try {
			String tmpId = request.getParameter("id");
			int id = Integer.parseInt(tmpId);

			PreparedStatement ps = conn
					.prepareStatement("UPDATE component SET amount = amount + ? WHERE id=?");
			ps.setInt(1, amount);
			ps.setInt(2, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("admin");
	}

}
