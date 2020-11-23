package model.dao.source;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.DBConexao;
import DB.DBExcecao;
import model.dao.FuncionariosDao;
import model.entities.Funcionarios;

public class FuncionariosSourceDao implements FuncionariosDao {

	private Statement statement;
	private PreparedStatement prepared;
	private ResultSet resultSet;
	private String sql;
	private Funcionarios funcionarios;
	
	@Override
	public void inserir(Funcionarios funcionarios) {
		
		sql = "insert into funcionarios(nome, email, dataNascimento, cpf, apelido, senha, administrador) values(?, ?, ?, ?, ?, ?, ?)";
		
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

		List<Funcionarios> list = new ArrayList<>();
		
		sql = "select * from funcionarios";
		
		try {
			
			statement = DBConexao.connection().createStatement();
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				
				funcionarios = new Funcionarios();
				
				funcionarios.setId(resultSet.getInt("id"));
				funcionarios.setNome(resultSet.getString("nome"));
				funcionarios.setEmail(resultSet.getString("email"));
				funcionarios.setDataNascimento(resultSet.getDate("dataNascimento"));
				funcionarios.setCpf(resultSet.getString("cpf"));
				funcionarios.setApelido(resultSet.getString("apelido"));
				funcionarios.setAdministrador(resultSet.getString("administrador"));
				
				list.add(funcionarios);
			}
			
			return list;
		}
		catch(SQLException e) {
			throw new DBExcecao(e.getMessage());
		}
	}
}
