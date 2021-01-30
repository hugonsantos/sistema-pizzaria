package model.dao.source;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBConexao;
import DB.DBExcecao;
import model.dao.EnderecoDao;
import model.entities.Endereco;

public class EnderecoSourceDao implements EnderecoDao{

	private Connection con;
	private PreparedStatement prepared;
	private ResultSet resultSet;
	private String sql;
	
	@Override
	public void inserir(Endereco enderecos) {

		sql = "insert into enderecos(endereco, numero, bairro, complemento, cep, cidade, estado, enderecoEntrega, idCliente) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			con = DBConexao.connection();
			prepared = con.prepareStatement(sql);
			
			prepared.setString(1, enderecos.getEndereco());
			prepared.setString(2, enderecos.getNumero());
			prepared.setString(3, enderecos.getBairro());
			prepared.setString(4, enderecos.getComplemento());
			prepared.setString(5, enderecos.getCep());
			prepared.setString(6, enderecos.getCidade());
			prepared.setString(7, enderecos.getEstado());
			prepared.setString(8, enderecos.getEnderecoEntrega());
			prepared.setInt(9, enderecos.getIdClientes().getId());
			
			prepared.executeUpdate();
			
			con.commit();
		}
		catch (SQLException e) {

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
	public void alterar(Endereco enderecos) {

		sql = "update enderecos set endereco = ?, numero = ?, bairro = ?, complemento = ?, cep = ?, cidade = ?, estado = ?, enderecoEntrega = ? where id = ?";
		
		try {
			
			con = DBConexao.connection();
			prepared = con.prepareStatement(sql);
			
			prepared.setString(1, enderecos.getEndereco());
			prepared.setString(2, enderecos.getNumero());
			prepared.setString(3, enderecos.getBairro());
			prepared.setString(4,  enderecos.getComplemento());
			prepared.setString(5, enderecos.getCep());
			prepared.setString(6, enderecos.getCidade());
			prepared.setString(7, enderecos.getEstado());
			prepared.setString(8, enderecos.getEnderecoEntrega());
			prepared.setInt(9, enderecos.getId());
			
			prepared.executeUpdate();
			
			con.commit();
		}
		catch (SQLException e) {

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
	public void deletar(Endereco enderecos) {

		sql = "delete from enderecos where id = ?";
		
		try {
			
			con = DBConexao.connection();
			prepared = con.prepareStatement(sql);
			
			prepared.setInt(1, enderecos.getId());
			
			prepared.executeUpdate();
			
			con.commit();
		}
		catch (SQLException e) {

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
	public List<Endereco> buscarEnderecosCliente(Integer id) {

		List<Endereco> lista = new ArrayList<>();
		
		sql = "select * from enderecos where idCliente = ?";
		
		try {
			
			con = DBConexao.connection();
			prepared = con.prepareStatement(sql);
			
			prepared.setInt(1, id);
			
			resultSet = prepared.executeQuery();
			
			while(resultSet.next()) {
				
				Endereco endereco = new Endereco();
				
				endereco.setId(resultSet.getInt("id"));
				endereco.setEndereco(resultSet.getString("endereco"));
				endereco.setNumero(resultSet.getString("numero"));
				endereco.setBairro(resultSet.getString("bairro"));
				endereco.setComplemento(resultSet.getString("complemento"));
				endereco.setCep(resultSet.getString("cep"));
				endereco.setCidade(resultSet.getString("cidade"));
				endereco.setEstado(resultSet.getString("estado"));
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
			DBConexao.closeConnection(con);
		}
	}

	@Override
	public Boolean localizarEndereco(Integer id) {

		boolean localizacao = false;
		
		sql = "select * from enderecos where id = ?";
		
		try {
			
			con = DBConexao.connection();
			prepared = con.prepareStatement(sql);
			
			prepared.setInt(1, id);
			
			resultSet = prepared.executeQuery();
			
			if(resultSet.next()) localizacao = true;
			
			return localizacao;
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
