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
import model.dao.BordaDao;
import model.entities.Borda;

public class BordaSourceDao implements BordaDao {

	private Connection con;
	private Statement statement;
	private PreparedStatement prepared;
	private ResultSet resultSet;
	private String sql;
	private Borda borda;

	@Override
	public Integer inserir(Borda borda) {

		int id = 0;

		sql = "insert into bordas(borda, tipoBorda) values(?, ?)";

		try {

			con = DBConexao.connection();
			prepared = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			prepared.setString(1, borda.getBorda());
			prepared.setString(2, borda.getTipoBorda());

			prepared.executeUpdate();
			resultSet = prepared.getGeneratedKeys();

			if (resultSet.next()) {

				id = resultSet.getInt(1);
			}
			
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
			DBConexao.closeResultSet(resultSet);
			DBConexao.closeConnection(con);
		}
		
		return id;
	}

	@Override
	public void alterar(Borda borda) {
		
		sql = "update bordas set borda = ?, tipoBorda = ? where id = ?";

		try {

			con = DBConexao.connection();
			prepared = con.prepareStatement(sql);

			prepared.setString(1, borda.getBorda());
			prepared.setString(2, borda.getTipoBorda());
			prepared.setInt(3, borda.getId());

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
	public void deletar(Borda borda) {
		
		sql = "delete from bordas where id = ?";

		try {

			con = DBConexao.connection();
			prepared = con.prepareStatement(sql);

			prepared.setInt(1, borda.getId());

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
	public List<Borda> listarBordas() {

		List<Borda> lista = new ArrayList<>();

		sql = "select * from bordas";

		try {

			con = DBConexao.connection();
			statement = con.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				
				borda = new Borda();

				borda.setId(resultSet.getInt("id"));
				borda.setBorda(resultSet.getString("borda"));
				borda.setTipoBorda(resultSet.getString("tipoBorda"));

				lista.add(borda);
			}
		}
		catch (SQLException e) {

			throw new DBExcecao(e.getMessage());
		}
		finally {

			DBConexao.closeStatment(statement);
			DBConexao.closeResultSet(resultSet);
			DBConexao.closeConnection(con);
		}
		
		return lista;
	}
	
	@Override
	public List<Borda> listarBordasSalgadas() {

		List<Borda> lista = new ArrayList<>();

		sql = "select * from bordas where tipoBorda = 'Salgada' or tipoBorda = 'Selecione'";

		try {

			con = DBConexao.connection();
			statement = con.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				
				borda = new Borda();

				borda.setId(resultSet.getInt("id"));
				borda.setBorda(resultSet.getString("borda"));
				borda.setTipoBorda(resultSet.getString("tipoBorda"));

				lista.add(borda);
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
	public List<Borda> listarBordasDoces() {

		List<Borda> lista = new ArrayList<>();

		sql = "select * from bordas where tipoBorda = 'Doce' or tipoBorda = 'Selecione'";

		try {

			con = DBConexao.connection();
			statement = con.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				
				borda = new Borda();

				borda.setId(resultSet.getInt("id"));
				borda.setBorda(resultSet.getString("borda"));
				borda.setTipoBorda(resultSet.getString("tipoBorda"));

				lista.add(borda);
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
	public Borda buscarBorda(Integer id) {

		sql = "select * from bordas where id = ?";

		try {

			con = DBConexao.connection();
			prepared = con.prepareStatement(sql);

			prepared.setInt(1, id);

			resultSet = prepared.executeQuery();

			if (resultSet.next()) {
				
				borda = new Borda();

				borda.setId(resultSet.getInt("id"));
				borda.setBorda(resultSet.getString("borda"));
			}
			
			return borda;
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
