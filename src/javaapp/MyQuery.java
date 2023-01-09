package javaapp;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.sql.*;
import java.util.*;

public class MyQuery {
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "rkqls1313**");
		} catch (Exception e) {
			e.getMessage();
		}
		return con;
	}

	public ArrayList<Product2> BindTable(String ans) {
		ArrayList<Product2> list = new ArrayList<Product2>();
		Connection con = getConnection();
		Statement st;
		ResultSet rs;

		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM " + ans + ";");

			Product2 p;
			while (rs.next()) {
				p = new Product2(rs.getString("popfile"), rs.getString("age"), rs.getString("kindCd"),
						rs.getString("sexCd"), rs.getString("happenDt"), rs.getString("happenPlace"),
						rs.getString("careNm"));
				list.add(p);
			}
		} catch (SQLException ex) {
		}
		return list;
	}
}
