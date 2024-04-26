package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		connection = DBConnect.connect();
		try {
			String fname = request.getParameter("firstname");
			String lname = request.getParameter("lastname");
			String uname = request.getParameter("username");
			String psswd = request.getParameter("password");
			String mob = request.getParameter("contact");

			PreparedStatement stat = connection.prepareStatement("INSERT INTO SudheerA_Users VALUES(?, ?, ?, ?, ?)");
			stat.setString(1, fname);
			stat.setString(1, lname);
			stat.setString(1, uname);
			stat.setString(1, psswd);
			stat.setString(1, mob);

			int i = stat.executeUpdate();
			if (i > 0)
				out.print("You are successfully registered...");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
