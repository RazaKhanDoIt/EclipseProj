package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB
{
	public static Connection getConnection() throws SQLException
	{
		Connection con =null;
		
		String user,pwd,service,url;
		
		user="facultydb";
		pwd="admin";
		service="localhost:1522:";
		url="jdbc:oracle:thin:";
		
		url += user + "/" + pwd + "@" +service;
		
		con = DriverManager.getConnection(url);
		
		
		
		return con;
		
	}
}

