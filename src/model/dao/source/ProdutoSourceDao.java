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
import model.dao.ProdutoDao;
import model.entities.Categoria;
import model.entities.Produto;

public class ProdutoSourceDao implements ProdutoDao {

	private Connection con;
	private Statement statement;
	private PreparedStatement prepared;
	private ResultSet resultSet;
	private String sql;
	private Produto produto;
	private Categoria categoria;

	@Override
	public Integer inserir(Produto produto) {
		
		int id = 0;

		sql = "insert into produtos(imagem, nome, descricao, valorBroto, valorTradicional, valorGrande, valorExtraGrande, idCategoria) values(?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			con = DBConexao.connection();
			prepared = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			prepared.setString(1, produto.getImagem());
			prepared.setString(2, produto.getNome());
			prepared.setString(3, produto.getDescricao());
			prepared.setDouble(4, produto.getValorBroto());
			prepared.setDouble(5, produto.getValorTradicional());
			prepared.setDouble(6, produto.getValorGrande());
			prepared.setDouble(7, produto.getValorExtraGrande());
			prepared.setInt(8, produto.getCategoria().getId());

			prepared.executeUpdate();
			resultSet = prepared.getGeneratedKeys();

			if (resultSet.next()) {

				id = resultSet.getInt(1);
			}

			con.commit();
			
			return id;
		}
		catch (SQLException e) {
			
			try {
				
				con.rollback();
				throw new DBExcecao(e.getMessage());
			}
			catch (SQLException e1) {
				
				e1.printStackTrace();
				return null;
			}
		}
		finally {

			DBConexao.closeStatment(prepared);
			DBConexao.closeResultSet(resultSet);
			DBConexao.closeConnection(con);
		}
	}

	@Override
	public void alterar(Produto produto) {
		
		sql = "update produtos set imagem = ?, nome = ?, descricao = ?, valorBroto = ?, valorTradicional = ?, valorGrande = ?, valorExtraGrande = ?, idCategoria = ? where id = ?";

		try {

			con = DBConexao.connection();
			prepared = con.prepareStatement(sql);

			prepared.setString(1, produto.getImagem());
			prepared.setString(2, produto.getNome());
			prepared.setString(3, produto.getDescricao());
			prepared.setDouble(4, produto.getValorBroto());
			prepared.setDouble(5, produto.getValorTradicional());
			prepared.setDouble(6, produto.getValorGrande());
			prepared.setDouble(7, produto.getValorExtraGrande());
			prepared.setInt(8, produto.getCategoria().getId());
			prepared.setInt(9, produto.getId());

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
	public void deletar(Produto produto) {
		
		sql = "delete from produtos where id = ?";

		try {

			con = DBConexao.connection();
			prepared = con.prepareStatement(sql);

			prepared.setInt(1, produto.getId());

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
	public List<Produto> listarProdutos() {
		
		List<Produto> lista = new ArrayList<>();

		sql = "select produtos.*, categorias.categoria as catNome from produtos inner join categorias on idCategoria = categorias.id";

		try {

			con = DBConexao.connection();
			statement = con.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				categoria = new Categoria();
				
				categoria.setId(resultSet.getInt("idCategoria"));
				categoria.setCategoria(resultSet.getString("catNome"));
				
				produto = new Produto();

				produto.setId(resultSet.getInt("id"));
				produto.setImagem(resultSet.getString("imagem"));
				produto.setNome(resultSet.getString("nome"));
				produto.setDescricao(resultSet.getString("descricao"));
				produto.setValorBroto(Double.parseDouble(resultSet.getString("valorBroto")));
				produto.setValorTradicional(Double.parseDouble(resultSet.getString("valorTradicional")));
				produto.setValorGrande(Double.parseDouble(resultSet.getString("valorGrande")));
				produto.setValorExtraGrande(Double.parseDouble(resultSet.getString("valorExtraGrande")));
				produto.setCategoria(categoria);

				lista.add(produto);
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
	public Produto buscarProduto(Integer id) {
		
		sql = "select produtos.*, categorias.categoria as catNome from produtos inner join categorias on produtos.idCategoria = categorias.id where produtos.id = ?";

		try {

			con = DBConexao.connection();
			prepared = con.prepareStatement(sql);

			prepared.setInt(1, id);

			resultSet = prepared.executeQuery();

			if (resultSet.next()) {

				categoria = new Categoria();
				
				categoria.setId(resultSet.getInt("idCategoria"));
				categoria.setCategoria(resultSet.getString("catNome"));
				
				produto = new Produto();

				produto.setId(resultSet.getInt("id"));
				produto.setImagem(resultSet.getString("imagem"));
				produto.setNome(resultSet.getString("nome"));
				produto.setDescricao(resultSet.getString("descricao"));
				produto.setValorBroto(Double.parseDouble(resultSet.getString("valorBroto")));
				produto.setValorTradicional(Double.parseDouble(resultSet.getString("valorTradicional")));
				produto.setValorGrande(Double.parseDouble(resultSet.getString("valorGrande")));
				produto.setValorExtraGrande(Double.parseDouble(resultSet.getString("valorExtraGrande")));
				produto.setCategoria(categoria);
			}

			return produto;
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
	
	@Override
	public List<Categoria> listarCategorias() {
		
		List<Categoria> lista = new ArrayList<>();

		sql = "select * from categorias";

		try {

			con = DBConexao.connection();
			statement = con.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				categoria = new Categoria();
				
				categoria.setId(resultSet.getInt("id"));
				categoria.setCategoria(resultSet.getString("categoria"));

				lista.add(categoria);
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
	public List<Produto> buscarProdutosCategoria(String categoria) {
		
		List<Produto> lista = new ArrayList<>();
		
		sql = "select produtos.*, categorias.categoria as catNome from produtos inner join categorias on produtos.idCategoria = categorias.id where categorias.categoria = ?";

		try {

			con = DBConexao.connection();
			prepared = con.prepareStatement(sql);

			prepared.setString(1, categoria);

			resultSet = prepared.executeQuery();

			while (resultSet.next()) {

				this.categoria = new Categoria();
				
				this.categoria.setId(resultSet.getInt("idCategoria"));
				this.categoria.setCategoria(resultSet.getString("catNome"));
				
				produto = new Produto();

				produto.setId(resultSet.getInt("id"));
				produto.setImagem(resultSet.getString("imagem"));
				produto.setNome(resultSet.getString("nome"));
				produto.setDescricao(resultSet.getString("descricao"));
				produto.setValorBroto(Double.parseDouble(resultSet.getString("valorBroto")));
				produto.setValorTradicional(Double.parseDouble(resultSet.getString("valorTradicional")));
				produto.setValorGrande(Double.parseDouble(resultSet.getString("valorGrande")));
				produto.setValorExtraGrande(Double.parseDouble(resultSet.getString("valorExtraGrande")));
				produto.setCategoria(this.categoria);
				
				lista.add(produto);
			}

			return lista;
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
