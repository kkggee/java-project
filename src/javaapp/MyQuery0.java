package javaapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MyQuery0 {

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "rkqls1313**");
		} catch (Exception e) {
			e.getMessage();
		}
		return con;
	}

	public ArrayList<Product0> BindTable(String ans) {

		ArrayList<Product0> list = new ArrayList<Product0>();
		Connection con = getConnection();
		Statement st;
		ResultSet rs;

		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT careNm,careAddr,careTel FROM " + ans + ";");

			Product0 p;
			while (rs.next()) {
				p = new Product0(rs.getString("careNm"), rs.getString("careAddr"), rs.getString("careTel"));
				list.add(p);
			}

		} catch (SQLException ex) {
			System.out.println("¿À·ù");
		}
		return list;
	}
}
