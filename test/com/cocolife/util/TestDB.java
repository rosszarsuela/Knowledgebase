package com.cocolife.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.SessionFactory;

import com.oris.base.BaseDaoHibernate;

public class TestDB extends BaseDaoHibernate {
	SessionFactory sf;
	
	public TestDB(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.sf = sessionFactory;
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {
		try {
			String url = "jdbc:mysql://localhost:3306/oris_db";
			String user = "root";
			String password = "";

			// Load the Connector/J driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Establish connection to MySQL
			Connection conn = DriverManager.getConnection(url, user, password);

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String query = "call sp_getAllPO('po','po_no','desc')";

			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getDate(2) + "  ");
				System.out.println(rs.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
