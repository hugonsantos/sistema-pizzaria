package model.dao.source;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.DBConexao;
import DB.DBExcecao;
import model.dao.ClienteDao;
import model.entities.Cliente;

public class ClienteSourceDao implements ClienteDao{
	
	private Connection con;
	private Statement statement;
	private PreparedStatement prepared;
	private ResultSet resultSet;
	private String sql;
	private Cliente cliente;

	@Override
	public Integer inserir(Cliente clientes) {

		int id = 0;
		
		sql = "insert into clientes(nome, genero, cpf) values(?, ?, ?)";
		
		try {
			
			con = DBConexao.connection();
			prepared = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			prepared.setString(1, clientes.getNome());
			prepared.setString(2, clientes.getGenero());
			prepared.setString(3, clientes.getCpf());
			
			prepared.executeUpdate();
			resultSet = prepared.getGeneratedKeys();
			
			if(resultSet.next()) {
				
				id = resultSet.getInt(1);
			}
			
			con.commit();
		}
		catch(SQLException e) {
			
			try {
				
				con.rollback();
				throw new DBExcecao(e.getMessage());
			}
			catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		finally {
			
			DBConexao.closeStatment(prepared);
			DBConexao.closeResultSet(resultSet);
			DBConexao.closeConnection(con);
		}
		
		return id;
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
			
			con.commit();
		}
		catch(SQLException e) {
			
			try {
				
				con.rollback();
				throw new DBExcecao(e.getMessage());
			}
			catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		finally {
			
			DBConexao.closeStatment(prepared);
			DBConexao.closeConnection(con);
		}
	}

	@Override
	public void deletar(Cliente clientes) {

		sql = "delete from clientes where id = ?";
		
		try {
			
			prepared = DBConexao.connection().prepareStatement(sql);
			
			prepared.setInt(1, clientes.getId());
			
			prepared.executeUpdate();
			
			con.commit();
		}
		catch(SQLException e) {
			
			try {
				
				con.rollback();
				throw new DBExcecao(e.getMessage());
			}
			catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		finally {
			
			DBConexao.closeStatment(prepared);
			DBConexao.closeConnection(con);
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
				
				cliente = new Cliente();
				
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setGenero(resultSet.getString("genero"));
				cliente.setCpf(resultSet.getString("cpf"));
				
				lista.add(cliente);
			}
			
			return lista;
		}
		catch (SQLException e) {

			throw new DBExcecao(e.getMessage());
		}
		finally {
			
			DBConexao.closeStatment(statement);
			DBConexao.closeResultSet(resultSet);
			DBConexao.closeConnection(con);
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
				
				cliente = new Cliente();
				
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setGenero(resultSet.getString("genero"));
				cliente.setCpf(resultSet.getString("cpf"));
			}
			
			return cliente;
		}
		catch (SQLException e) {

			throw new DBExcecao(e.getMessage());
		}
		finally {
			
			DBConexao.closeStatment(prepared);
			DBConexao.closeResultSet(resultSet);
			DBConexao.closeConnection(con);
		}
	}
}
