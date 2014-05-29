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
import beans.UserBean;

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
		try {
			UserBean user = LoginServlet.getUser(request);
			boolean isAdmin = user.isAdmin();
			if (isAdmin == true) {
				response.setContentType("text/html");
				StockBean stock = new StockBean("");
				request.setAttribute("stock", stock);
				getServletContext().getRequestDispatcher("/admin.jsp").forward(
						request, response);
			} else {
				response.setContentType("text/html");
				getServletContext().getRequestDispatcher("/not_admin.jsp")
						.forward(request, response);
			}

		} catch (NullPointerException e) {
			response.setContentType("text/html");
			getServletContext().getRequestDispatcher("/not_admin.jsp").forward(
					request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String tmpAmount = request.getParameter("amount");
			int amount = Integer.parseInt(tmpAmount);
			String tmpId = request.getParameter("id");
			int id = Integer.parseInt(tmpId);

			PreparedStatement ps = conn
					.prepareStatement("UPDATE component SET amount = amount + ? WHERE id=? AND amount+? >= 0");
			ps.setInt(1, amount);
			ps.setInt(2, id);
			ps.setInt(3, amount);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException nfe) {
			//Do nothing, the user is stupid
		}
		response.sendRedirect("admin");
	}

}
