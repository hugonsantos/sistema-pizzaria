package DB;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataBaseConnection {

	private static Connection con = null;
	
	public static Connection connection() {
		
		if(con == null) {
			
			try {
				
				Properties properties = loadProperties();
				String url = properties.getProperty("url");
				
				con = DriverManager.getConnection(url, properties);
			}
			catch(SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
		
		return con;
	}
	
	public static Connection closeConnection() {
		
		if(con != null) {
			
			try {
				
				con.close();
			}
			catch(SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
		
		return con;
	}
	
	public static Statement closeStatment(Statement statement) {
		
		if(statement != null) {
			
			try {
				
				statement.close();
			}
			catch(SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
		
		return statement;
	}
	
	public static ResultSet closeStatment(ResultSet resultSet) {
		
		if(resultSet != null) {
			
			try {
				
				resultSet.close();
			}
			catch(SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
		
		return resultSet;
	}
	
	private static Properties loadProperties() {
		
		try(FileInputStream file = new FileInputStream("db.properties")) {
			
			Properties properties = new Properties();
			properties.load(file);
			return properties;
		}
		catch(IOException e) {
			throw new DBException(e.getMessage());
		}
	}
}
