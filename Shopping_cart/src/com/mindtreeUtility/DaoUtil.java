package com.mindtreeUtility;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import com.mindtreeexception.DatabaseFailedConnection;

	public class DaoUtil {
		private static final String sql = "jdbc:mysql://127.0.0.1:3306/Shopping";
		private static final String root = "root";
		private static final String password = "root@123";

		public static Connection createCon() throws DatabaseFailedConnection {
			Connection connection = null;

			try {

				connection = DriverManager.getConnection(sql, root, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DatabaseFailedConnection("Database could not be connected");
			}

			return connection;
		}

		public static void closeConnection(ResultSet rs) {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		public static void closeConnection(Statement s) {
			if (s != null) {
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		public static void closeConnection(Connection connection) {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

