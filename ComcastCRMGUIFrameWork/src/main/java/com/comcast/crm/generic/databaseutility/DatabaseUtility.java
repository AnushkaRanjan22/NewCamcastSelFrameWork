package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection con;

	public void getDBconnection(String url, String username, String password) throws SQLException {
		Connection con;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closedbconnection() throws SQLException {
		con.close();
	}
	
	public ResultSet executeConSelectQuery(String query) throws SQLException {
		ResultSet resultset = null;
		try {
		Statement stet = con.createStatement();
	     resultset = stet.executeQuery(query);
		return resultset;
		}
		 catch (Exception e) {
				e.printStackTrace();
			}
		return resultset;
		
	}
	
	public boolean executeNonSelectQuery(String query) {
		boolean result = false;
		try {
			Statement stet = con.createStatement();
			result=stet.execute(query);
		
		}
		 catch (Exception e) {
				e.printStackTrace();
			}
		return result;
		
	}
}
