package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBConnector;
import beans.BasketBean;
import beans.StockBean;
import beans.UserBean;

/**
 * Servlet implementation class BakeryServlet
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final HashMap<String, UserBean> users = new HashMap<String, UserBean>();

	public LoginServlet() {
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
		if(users.containsKey(request.getSession().getId())) {
			response.sendRedirect("profile");
		} else {
			getServletContext().getRequestDispatcher("/login.jsp").forward(request,
					response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			response.setContentType("text/html");

			DBConnector dbms = new DBConnector();
			Connection conn = dbms.getConnection();

			PreparedStatement ps = conn.prepareStatement(
					"SELECT username, admin, address FROM user WHERE username = ? AND password = ?");

			ps.setString(1, username); 
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				UserBean user = new UserBean();
				user.setName(rs.getString("username"));
				user.setAddress(rs.getString("address"));
				users.put(request.getSession().getId(), user);
				response.sendRedirect("profile");
			} else {
				getServletContext().getRequestDispatcher("/login_error.jsp").forward(request,
						response);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static UserBean getUser(HttpServletRequest request) {
		String session = request.getSession().getId();
		return users.get(session);
	}

}
