package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	static String ip = "127.0.0.1";
	static String porta = "3307";
	static String user = "root";
	static String senha = "root";
	static String nomeBd = "bokunohero";
	
	
	public static Connection getConnect() {
		Connection connect = null; 
		String url = "jdbc:mysql://"+ip+":"+porta+"/"+nomeBd;
		try {
			connect = DriverManager.getConnection(url,user,senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro");
		}
		return connect;
	}
	
}