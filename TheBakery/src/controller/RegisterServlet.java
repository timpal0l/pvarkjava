package controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
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
        
		getServletContext().getRequestDispatcher("/register.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		
		DBConnector dbms = new DBConnector();
		Connection conn = dbms.getConnection();
		
		try{
		PreparedStatement ps = conn.prepareStatement("insert into user(username, password, address) values(?, ?, ?)");
		
		  ps.setString(1, username); 
		  ps.setString(2, password);
	      ps.setString(3, address); 
	      ps.executeUpdate();
	      
	      
	      
		}catch(SQLException e) {
            e.printStackTrace();
        }
		
		response.sendRedirect("profile");
	}

}
