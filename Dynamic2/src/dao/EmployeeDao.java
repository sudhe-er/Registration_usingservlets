package dao;

import java.sql.Connection;

import model.User;

public class EmployeeDao {
	DBConnect dbconnection;
	Connection connection;

	public int registerEmployee(User employee) throws ClassNotFoundException {

		try {
			String INSERT_USERS_SQL = "INSERT INTO sudheera_users"
					+ "  (id, first_name, last_name, username, password,  contact) VALUES " + " (?, ?, ?, ?, ?,?,?);";

			int result = 0;

			Class.forName("com.mysql.jdbc.Driver");
			connection = DBConnect.connect();

		} catch (Exception e) {
		}
		return 0;
	}

}
