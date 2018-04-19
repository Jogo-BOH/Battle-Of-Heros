package Email;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.naming.spi.DirStateFactory.Result;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import com.mysql.jdbc.PreparedStatement;
import Database.Connect;

public class EnviarEmail {

	public ResultSet verificaEmail(String email) {
		ResultSet emailValido = null;
		String sql = "SELECT * FROM user WHERE email = ?";
		try {
			java.sql.PreparedStatement stmt = Connect.getConnect().prepareStatement(sql);
			stmt.setString(1, email);
			emailValido = stmt.executeQuery();
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emailValido;
	}
	
	public String novaSenha() {
		String nova = "";
		Random r = new Random();
		int numero = 0;
		char valor;
		for(int x=0;x<8;x++) {
			numero = r.nextInt(74)+48;
			if((numero > 57 && numero < 65) || (numero > 90 && numero < 97)) {
				x--;
				continue;
			}
			valor = (char)numero;
			nova = nova + valor;
		}
		return nova;
	}
	
	public String enviarEmail(String email) {
		ResultSet conta = new EnviarEmail().verificaEmail(email);
		String novaSenha;
		int idUsuario;
		try {
			if(conta.next()) {
				novaSenha = new EnviarEmail().novaSenha();
				idUsuario = conta.getInt("idUser");
			}else {
				return "E-mail invalido";
			}
			
			if(alteraSenha(idUsuario, novaSenha)) {
				return "Erro ao alterar a senha no BD";
			}else {
				try {
					SimpleEmail enviarEmail = new SimpleEmail();
					enviarEmail.setHostName("smtp.gmail.com");
					enviarEmail.setSmtpPort(465);
					enviarEmail.setAuthentication("mias.dragneel15@gmail.com", "natsudragneel");
					enviarEmail.setSSLOnConnect(true);
					enviarEmail.setFrom("mias.dragneel15@gmail.com");
					enviarEmail.setSubject("Password Recovery - Battle of Heros");
					enviarEmail.setMsg("Password Recovery \n"
							+ "Your new Password is"+novaSenha
							+"\n Dont answer this E-mail. This is an automatic E-mail. \n"
							+ "JOP Team 2018");
					enviarEmail.addTo(email);
					enviarEmail.send();
				}catch(EmailException e){
					//TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			alteraSenha(idUsuario,novaSenha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "E-mail enviado com sucesso!";
	}
	
	public boolean alteraSenha(int id, String senha) {
		boolean resposta = true;
		String sql = "UPDATE user SET senha=? WHERE idUser=?";
		try {
			java.sql.PreparedStatement stmt = Connect.getConnect().prepareStatement(sql);
			stmt.setString(1, senha);
			stmt.setInt(2, id);
			resposta = stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resposta;
	}
	
	public static void main(String[] args) {
		System.out.println(new EnviarEmail().enviarEmail("mias.dragneel15@gmail.com"));
	}
	
}
