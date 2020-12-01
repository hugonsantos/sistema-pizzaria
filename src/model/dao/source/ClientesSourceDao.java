package model.dao.source;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.DBConexao;
import DB.DBExcecao;
import model.dao.ClientesDao;
import model.entities.Cliente;

public class ClientesSourceDao implements ClientesDao{
	
	private Statement statement;
	private PreparedStatement prepared;
	private ResultSet resultSet;
	private String sql;
	private Cliente clientes;

	@Override
	public Integer inserir(Cliente clientes) {

		int id = 0;
		sql = "insert into clientes(nome, genero, cpf) values(?, ?, ?)";
		
		try {
			
			prepared = DBConexao.connection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			prepared.setString(1, clientes.getNome());
			prepared.setString(2, clientes.getGenero());
			prepared.setString(3, clientes.getCpf());
			
			prepared.executeUpdate();
			resultSet = prepared.getGeneratedKeys();
			
			if(resultSet.next()) {
				
				id = resultSet.getInt(1);
			}
			
			return id;
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
	public void alterar(Cliente clientes) {

		sql = "update clientes set nome = ?, genero = ?, cpf = ? where id = ?";
		
		try {
			
			prepared = DBConexao.connection().prepareStatement(sql);
			
			prepared.setString(1, clientes.getNome());
			prepared.setString(2, clientes.getGenero());
			prepared.setString(3, clientes.getCpf());
			prepared.setInt(4, clientes.getId());
			
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
	public void deletar(Cliente clientes) {

		sql = "delete from clientes where id = ?";
		
		try {
			
			prepared = DBConexao.connection().prepareStatement(sql);
			
			prepared.setInt(1, clientes.getId());
			
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
	public List<Cliente> listarTodos() {

		List<Cliente> lista = new ArrayList<>();
		
		sql = "select * from clientes";
		
		try {
			
			statement = DBConexao.connection().createStatement();
			
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				
				clientes = new Cliente();
				
				clientes.setId(resultSet.getInt("id"));
				clientes.setNome(resultSet.getString("nome"));
				clientes.setGenero(resultSet.getString("genero"));
				clientes.setCpf(resultSet.getString("cpf"));
				
				lista.add(clientes);
			}
			
			return lista;
		}
		catch (SQLException e) {

			throw new DBExcecao(e.getMessage());
		}
		finally {
			
			DBConexao.closeStatment(statement);
			DBConexao.closeResultSet(resultSet);
		}
	}

	@Override
	public Cliente buscarFuncionario(Integer id) {

		sql = "select * from clientes where id = ?";
		
		try {
			
			prepared = DBConexao.connection().prepareStatement(sql);
			
			prepared.setInt(1, id);
			
			resultSet = prepared.executeQuery();
			
			if(resultSet.next()) {
				
				clientes = new Cliente();
				
				clientes.setId(resultSet.getInt("id"));
				clientes.setNome(resultSet.getString("nome"));
				clientes.setGenero(resultSet.getString("genero"));
				clientes.setCpf(resultSet.getString("cpf"));
			}
			
			return clientes;
		}
		catch (SQLException e) {
			throw new DBExcecao(e.getMessage());
		}
		finally {
			
			DBConexao.closeStatment(prepared);
			DBConexao.closeResultSet(resultSet);
		}
	}
}
