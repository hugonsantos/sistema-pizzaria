package model.dao.source;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBConexao;
import DB.DBExcecao;
import model.dao.LoginDao;
import model.entities.Funcionarios;

public class LoginSourceDao implements LoginDao {
	
	private PreparedStatement prepared;
	private ResultSet resultSet;

	@Override
	public Boolean AutenticacaoLogin(Funcionarios funcionario) {
		
		String sql = "select cpf, apelido, senha from funcionarios where cpf = ? or apelido = ?";
		
		try {
			
			prepared = DBConexao.connection().prepareStatement(sql);
			
			prepared.setString(1, funcionario.getCpf());
			prepared.setString(2, funcionario.getApelido());
			
			resultSet = prepared.executeQuery();
			
			if(resultSet.next()) {
				
				if(resultSet.getString("apelido").equals(funcionario.getApelido()) || resultSet.getString("cpf").equals(funcionario.getCpf()) && resultSet.getString("senha").equals(funcionario.getSenha())) {
					
					return true;
					
				}
			}
		}
		catch(SQLException e) {
			throw new DBExcecao(e.getMessage());
		}
		
		return false;
	}
}