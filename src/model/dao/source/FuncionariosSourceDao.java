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
import model.entities.Funcionario;

public class FuncionariosSourceDao implements FuncionariosDao {

	private Statement statement;
	private PreparedStatement prepared;
	private ResultSet resultSet;
	private String sql;
	private Funcionario funcionarios;
	
	@Override
	public Integer inserir(Funcionario funcionarios) {
		
		sql = "insert into funcionarios(nome, email, dataNascimento, cpf, apelido, senha, administrador) values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			prepared = DBConexao.connection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			prepared.setString(1, funcionarios.getNome());
			prepared.setString(2, funcionarios.getEmail());
			prepared.setDate(3, new Date(funcionarios.getDataNascimento().getTime()));
			prepared.setString(4, funcionarios.getCpf());
			prepared.setString(5, funcionarios.getApelido());
			prepared.setString(6, funcionarios.getSenha());
			prepared.setString(7, funcionarios.getAdministrador());
			
			prepared.executeUpdate();
			
			resultSet = prepared.getGeneratedKeys();
			
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
			
			return 0;
		}
		catch(SQLException e) {
			
			throw new DBExcecao(e.getMessage());
		}
		finally {
			
			DBConexao.closeStatment(prepared);
		}
	}

	@Override
	public void alterar(Funcionario funcionarios) {

		sql = "update funcionarios set nome = ?, email = ?, dataNascimento = ?, cpf = ?, apelido = ?, senha = ?, administrador = ? where id = ?";
		
		try {
			
			prepared = DBConexao.connection().prepareStatement(sql);
			
			prepared.setString(1, funcionarios.getNome());
			prepared.setString(2, funcionarios.getEmail());
			prepared.setDate(3, new Date(funcionarios.getDataNascimento().getTime()));
			prepared.setString(4, funcionarios.getCpf());
			prepared.setString(5, funcionarios.getApelido());
			prepared.setString(6, funcionarios.getSenha());
			prepared.setString(7, funcionarios.getAdministrador());
			prepared.setInt(8, funcionarios.getId());
			
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
	public void deletar(Funcionario funcionarios) {

		sql = "delete from funcionarios where id = ?";
		
		try {
			
			prepared = DBConexao.connection().prepareStatement(sql);
			
			prepared.setInt(1, funcionarios.getId());
			
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
	public Funcionario buscarFuncionario(Integer id) {
		
		sql = "select * from funcionarios where id = ?";
		
		try {
			
			prepared = DBConexao.connection().prepareStatement(sql);
			prepared.setInt(1, id);
			
			resultSet = prepared.executeQuery(sql);
			
			if(resultSet.next()) {
				
				funcionarios = new Funcionario();
				
				funcionarios.setId(resultSet.getInt("id"));
				funcionarios.setNome(resultSet.getString("nome"));
				funcionarios.setEmail(resultSet.getString("email"));
				funcionarios.setDataNascimento(resultSet.getDate("dataNascimento"));
				funcionarios.setCpf(resultSet.getString("cpf"));
				funcionarios.setApelido(resultSet.getString("apelido"));
				funcionarios.setSenha(resultSet.getString("senha"));
				funcionarios.setAdministrador(resultSet.getString("administrador"));
			}
			
			return funcionarios;
		}
		catch(SQLException e) {
			
			throw new DBExcecao(e.getMessage());
		}
		finally {
			
			DBConexao.closeStatment(prepared);
			DBConexao.closeResultSet(resultSet);
		}
	}

	@Override
	public List<Funcionario> listarTodos() {

		List<Funcionario> list = new ArrayList<>();
		
		sql = "select * from funcionarios";
		
		try {
			
			statement = DBConexao.connection().createStatement();
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				
				funcionarios = new Funcionario();
				
				funcionarios.setId(resultSet.getInt("id"));
				funcionarios.setNome(resultSet.getString("nome"));
				funcionarios.setEmail(resultSet.getString("email"));
				funcionarios.setDataNascimento(resultSet.getDate("dataNascimento"));
				funcionarios.setCpf(resultSet.getString("cpf"));
				funcionarios.setApelido(resultSet.getString("apelido"));
				funcionarios.setSenha(resultSet.getString("senha"));
				funcionarios.setAdministrador(resultSet.getString("administrador"));
				
				list.add(funcionarios);
			}
			
			return list;
		}
		catch(SQLException e) {
			throw new DBExcecao(e.getMessage());
		}
		finally {
			
			DBConexao.closeStatment(prepared);
			DBConexao.closeResultSet(resultSet);
		}
	}
}
