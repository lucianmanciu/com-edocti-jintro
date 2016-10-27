package com.edocti.jintro.lab10;

import java.sql.*;

public class SimpleJdbc {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Connection conn = connect("mysql", "localhost", "3306", "jintro", "root", "abc123");
		deleteAuthors(conn);
		displayAuthors(conn);
		generateAuthors(conn, 0, 10);
		displayAuthors(conn);
		conn.close();
	}

	private static Connection connect(String type, String host, 
									  String port, String dbName, 
									  String user, String password) 
		throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		DriverManager.setLoginTimeout(30);
		StringBuilder sb = new StringBuilder();
		// build the connection string:
		// jdbc:mysql://host:port/dbName?user=root&password=abc123&useSSL=false
		sb.append("jdbc:").append(type)
		  .append("://").append(host)
		  .append(":").append(port)
		  .append("/").append(dbName)
		  .append("?user=").append(user)
		  .append("&password=").append(password)
		  .append("&useSSL=false");
		
		String connURL = sb.toString();
		return DriverManager.getConnection(connURL);
	}
	
	private static void displayAuthors(Connection conn) throws SQLException {
		Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = st.executeQuery("select * from authors");
		try {
			boolean hasResults = rs.next();
			if(hasResults) {
				System.out.printf("%4s%25s%25s\n", "ID", "NAME", "EMAIL");
				do {
					System.out.printf("%4d%25s%25s\n",
							rs.getInt("id"),
							rs.getString("name"),
							rs.getString("email"));
				} while (rs.next());
			} else {
				System.out.println("No results");
			}
		} finally {
			rs.close();
		}
	}
	
	private static void generateAuthors(Connection conn, int start, int n) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("insert into authors(id, name, email) values (?, ?, ?)");
		try {
			for (int i = 0; i < n; i++) {
				ps.setInt(1, (start + i));
				ps.setString(2, "Nume " + (start + i));
				ps.setString(3,  "nume" + (start + i) + "@" + "gmail.com");
				ps.executeUpdate();
			}
		} finally {
			ps.close();
		}
	}
	
	private static void deleteAuthors(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("delete from authors");
		ps.executeUpdate();
		ps.close();
	}
}
