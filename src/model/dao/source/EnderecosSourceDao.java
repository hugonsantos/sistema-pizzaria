package model.dao.source;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBConexao;
import DB.DBExcecao;
import model.dao.EnderecosDao;
import model.entities.Endereco;

public class EnderecosSourceDao implements EnderecosDao{

	private PreparedStatement prepared;
	private ResultSet resultSet;
	private String sql;
	
	@Override
	public void inserir(Endereco enderecos) {

		sql = "insert into enderecos(endereco, numero, bairro, complemento, cep, enderecoEntrega, idCliente) values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			prepared = DBConexao.connection().prepareStatement(sql);
			
			prepared.setString(1, enderecos.getEndereco());
			prepared.setInt(2, enderecos.getNumero());
			prepared.setString(3, enderecos.getBairro());
			prepared.setString(4,  enderecos.getComplemento());
			prepared.setInt(5, enderecos.getCep());
			prepared.setString(6, enderecos.getEnderecoEntrega());
			prepared.setInt(7, enderecos.getIdClientes().getId());
			
			prepared.executeUpdate();
		}
		catch (SQLException e) {
			throw new DBExcecao(e.getMessage());
		}
		
		finally {
			
			DBConexao.closeStatment(prepared);
		}
	}

	@Override
	public void alterar(Endereco enderecos) {

		sql = "update enderecos set endereco = ?, numero = ?, bairro = ?, complemento = ?, cep = ?, enderecoEntrega = ? where id = ?";
		
		try {
			
			prepared = DBConexao.connection().prepareStatement(sql);
			
			prepared.setString(1, enderecos.getEndereco());
			prepared.setInt(2, enderecos.getNumero());
			prepared.setString(3, enderecos.getBairro());
			prepared.setString(4,  enderecos.getComplemento());
			prepared.setInt(5, enderecos.getCep());
			prepared.setString(6, enderecos.getEnderecoEntrega());
			prepared.setInt(7, enderecos.getId());
			
			prepared.executeUpdate();
		}
		catch (SQLException e) {
			throw new DBExcecao(e.getMessage());
		}
		
		finally {
			
			DBConexao.closeStatment(prepared);
		}
	}

	@Override
	public void deletar(Endereco enderecos) {

		sql = "delete from enderecos where id = ?";
		
		try {
			
			prepared = DBConexao.connection().prepareStatement(sql);
			
			prepared.setInt(1, enderecos.getId());
			
			prepared.executeUpdate();
		}
		catch (SQLException e) {
			throw new DBExcecao(e.getMessage());
		}
		
		finally {
			
			DBConexao.closeStatment(prepared);
		}
	}

	@Override
	public List<Endereco> buscarEnderecosCliente(Integer id) {

		List<Endereco> lista = new ArrayList<>();
		
		sql = "select * from enderecos where idCliente = ?";
		
		try {
			
			prepared = DBConexao.connection().prepareStatement(sql);
			
			prepared.setInt(1, id);
			
			resultSet = prepared.executeQuery();
			
			while(resultSet.next()) {
				
				Endereco endereco = new Endereco();
				
				endereco.setId(resultSet.getInt("id"));
				endereco.setEndereco(resultSet.getString("endereco"));
				endereco.setNumero(resultSet.getInt("numero"));
				endereco.setBairro(resultSet.getString("bairro"));
				endereco.setComplemento(resultSet.getString("complemento"));
				endereco.setCep(resultSet.getInt("cep"));
				endereco.setEnderecoEntrega(resultSet.getString("enderecoEntrega"));
				
				lista.add(endereco);
			}
			
			return lista;
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
	public Boolean localizarEndereco(Integer id) {

		sql = "select * from enderecos where id = ?";
		
		try {
			
			prepared = DBConexao.connection().prepareStatement(sql);
			
			prepared.setInt(1, id);
			
			resultSet = prepared.executeQuery();
			
			if(resultSet.next()) {
				
				return true;
			}
		}
		catch(SQLException e) {
			
			throw new DBExcecao(e.getMessage());
		}
		finally {
			
			DBConexao.closeStatment(prepared);
			DBConexao.closeResultSet(resultSet);
		}
		
		return false;
	}
}
