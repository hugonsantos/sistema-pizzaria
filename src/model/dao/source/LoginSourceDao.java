package model.dao.source;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBConexao;
import DB.DBExcecao;
import model.dao.LoginDao;
import model.entities.Funcionario;

public class LoginSourceDao implements LoginDao {
	
	private Connection con;
	private PreparedStatement prepared;
	private ResultSet resultSet;

	@Override
	public Boolean AutenticacaoLogin(Funcionario funcionario) {
		
		String sql = "select cpf, usuario, senha from funcionarios where cpf = ? or usuario = ?";
		
		boolean autenticacao = false;
		
		try {
			
			con = DBConexao.connection();
			prepared = con.prepareStatement(sql);
			
			prepared.setString(1, funcionario.getCpf());
			prepared.setString(2, funcionario.getUsuario());
			
			resultSet = prepared.executeQuery();
			
			if(resultSet.next()) {
				
				if(resultSet.getString("usuario").equals(funcionario.getUsuario()) && resultSet.getString("senha").equals(funcionario.getSenha())) {
					
					autenticacao = true;
				}
				else if(resultSet.getString("cpf").equals(funcionario.getCpf()) && resultSet.getString("senha").equals(funcionario.getSenha())) {
					
					autenticacao = true;
				}
			}
			
			return autenticacao;
		}
		catch(SQLException e) {

			throw new DBExcecao(e.getMessage());
		}
		finally {
			
			DBConexao.closeStatment(prepared);
			DBConexao.closeResultSet(resultSet);
			DBConexao.closeConnection(con);
		}
	}
}
