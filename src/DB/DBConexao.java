package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConexao {

	private static Connection con = null;
	
	public static Connection connection() {
		
		try {
			
			if(con == null || con.isClosed()) {
				
				try {
					
					Properties properties = loadProperties();
					String url = properties.getProperty("url");
					
					con = DriverManager.getConnection(url, properties);
					con.setAutoCommit(false);
				}
				catch(SQLException e) {
					
					throw new DBExcecao(e.getMessage());
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeConnection(Connection con) {
		
		if(con != null) {
			
			try {
				
				con.close();
			}
			catch(SQLException e) {
				throw new DBExcecao(e.getMessage());
			}
		}
	}
	
	public static void closeStatment(Statement statement) {
		
		if(statement != null) {
			
			try {
				
				statement.close();
			}
			catch(SQLException e) {
				throw new DBExcecao(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet resultSet) {
		
		if(resultSet != null) {
			
			try {
				
				resultSet.close();
			}
			catch(SQLException e) {
				throw new DBExcecao(e.getMessage());
			}
		}
	}
	
	private static Properties loadProperties() {
		
		try {
			
			Properties properties = new Properties();

			properties.setProperty("user", "root");
			properties.setProperty("password", "admin");
			properties.setProperty("url", "jdbc:mysql://localhost:3306/pizzariadb?useTimezone=true&serverTimezone=UTC");
			properties.setProperty("useSSL", "false");
			properties.setProperty("allowPublicKeyRetrieval", "true");
			
			return properties;
		}
		catch(Exception e) {
			throw new DBExcecao(e.getMessage());
		}
	}
}
