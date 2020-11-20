package model.dao.source;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DB.DBExcecao;
import DB.DBConexao;
import model.dao.FuncionariosDao;
import model.entities.Funcionarios;

public class FuncionariosSourceDao implements FuncionariosDao {

	private Statement statement;
	private PreparedStatement prepared;
	private ResultSet resultSet;
	
	@Override
	public void inserir(Funcionarios funcionarios) {
		
		String sql = "insert into funcionarios(nome, email, dataNascimento, cpf, apelido, senha, administrador) values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			prepared = DBConexao.connection().prepareStatement(sql);
			
			prepared.setString(1, funcionarios.getNome());
			prepared.setString(2, funcionarios.getEmail());
			prepared.setDate(3, new Date(funcionarios.getDataNascimento().getTime()));
			prepared.setString(4, funcionarios.getCpf());
			prepared.setString(5, funcionarios.getApelido());
			prepared.setString(6, funcionarios.getSenha());
			prepared.setString(7, funcionarios.getAdministrador());
			
			prepared.executeUpdate();
			
		}
		catch(SQLException e) {
			
			throw new DBExcecao(e.getMessage());
		}
		
		finally {
			
			DBConexao.closeStatment(prepared);
		}
	}

	@Override
	public void alterar(Funcionarios funcionarios) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Funcionarios funcionarios) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Funcionarios buscarFuncionario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionarios> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
