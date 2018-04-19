package CRUD;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import Database.Connect;

public class CRUDUser {

	Connect connect = new Connect();
	
	public boolean InsertUser(User user) {
		String sql = "INSERT INTO user (nome,email,senha) VALUES (?,?,?)";
		try {
			java.sql.PreparedStatement stmt = connect.getConnect().prepareStatement(sql);
			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getSenha());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}