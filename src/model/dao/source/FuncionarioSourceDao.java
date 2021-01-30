package model.dao.source;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.DBConexao;
import DB.DBExcecao;
import model.dao.FuncionarioDao;
import model.entities.Funcionario;

public class FuncionarioSourceDao implements FuncionarioDao {

	private Connection con;
	private Statement statement;
	private PreparedStatement prepared;
	private ResultSet resultSet;
	private String sql;
	private Funcionario funcionario;
	
	@Override
	public Integer inserir(Funcionario funcionarios) {
		
		int id = 0;
		
		sql = "insert into funcionarios(nome, email, dataNascimento, cpf, usuario, senha, administrador) values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			con = DBConexao.connection();
			prepared = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			prepared.setString(1, funcionarios.getNome());
			prepared.setString(2, funcionarios.getEmail());
			prepared.setDate(3, new Date(funcionarios.getDataNascimento().getTime()));
			prepared.setString(4, funcionarios.getCpf());
			prepared.setString(5, funcionarios.getUsuario());
			prepared.setString(6, funcionarios.getSenha());
			prepared.setString(7, funcionarios.getAdministrador());
			
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
			DBConexao.closeConnection(con);
		}
		
		return id;
	}

	@Override
	public void alterar(Funcionario funcionarios) {

		sql = "update funcionarios set nome = ?, email = ?, dataNascimento = ?, cpf = ?, usuario = ?, senha = ?, administrador = ? where id = ?";
		
		try {
			
			con = DBConexao.connection();
			prepared = con.prepareStatement(sql);
			
			prepared.setString(1, funcionarios.getNome());
			prepared.setString(2, funcionarios.getEmail());
			prepared.setDate(3, new Date(funcionarios.getDataNascimento().getTime()));
			prepared.setString(4, funcionarios.getCpf());
			prepared.setString(5, funcionarios.getUsuario());
			prepared.setString(6, funcionarios.getSenha());
			prepared.setString(7, funcionarios.getAdministrador());
			prepared.setInt(8, funcionarios.getId());
			
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
	public void deletar(Funcionario funcionarios) {

		sql = "delete from funcionarios where id = ?";
		
		try {
			
			con = DBConexao.connection();
			prepared = con.prepareStatement(sql);
			
			prepared.setInt(1, funcionarios.getId());
			
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
	public Funcionario buscarFuncionario(Integer id) {
		
		sql = "select * from funcionarios where id = ?";
		
		try {
			
			con = DBConexao.connection();
			prepared = con.prepareStatement(sql);
			
			prepared.setInt(1, id);
			
			resultSet = prepared.executeQuery(sql);
			
			if(resultSet.next()) {
				
				funcionario = new Funcionario();
				
				funcionario.setId(resultSet.getInt("id"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setEmail(resultSet.getString("email"));
				funcionario.setDataNascimento(resultSet.getDate("dataNascimento"));
				funcionario.setCpf(resultSet.getString("cpf"));
				funcionario.setUsuario(resultSet.getString("usuario"));
				funcionario.setSenha(resultSet.getString("senha"));
				funcionario.setAdministrador(resultSet.getString("administrador"));
			}
			
			return funcionario;
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
	public List<Funcionario> listarTodos() {

		List<Funcionario> lista = new ArrayList<>();
		
		sql = "select * from funcionarios";
		
		try {
			
			statement = DBConexao.connection().createStatement();
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				
				funcionario = new Funcionario();
				
				funcionario.setId(resultSet.getInt("id"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setEmail(resultSet.getString("email"));
				funcionario.setDataNascimento(resultSet.getDate("dataNascimento"));
				funcionario.setCpf(resultSet.getString("cpf"));
				funcionario.setUsuario(resultSet.getString("usuario"));
				funcionario.setSenha(resultSet.getString("senha"));
				funcionario.setAdministrador(resultSet.getString("administrador"));
				
				lista.add(funcionario);
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
}
