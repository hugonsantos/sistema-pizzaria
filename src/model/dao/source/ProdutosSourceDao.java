package model.dao.source;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.DBConexao;
import DB.DBExcecao;
import model.dao.ProdutosDao;
import model.entities.Categoria;
import model.entities.Produto;

public class ProdutosSourceDao implements ProdutosDao {

	private Statement statement;
	private PreparedStatement prepared;
	private ResultSet resultSet;
	private String sql;
	private Produto produto;
	private Categoria categoria;

	@Override
	public Integer inserir(Produto produto) {

		int id = 0;

		sql = "insert into produtos(imagem, nome, descricao, valor, quantidade, idCategoria) values(?, ?, ?, ?, ?, ?)";

		try {

			prepared = DBConexao.connection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			prepared.setString(1, produto.getImagem());
			prepared.setString(2, produto.getNome());
			prepared.setString(3, produto.getDescricao());
			prepared.setDouble(4, produto.getValor());
			prepared.setInt(5, produto.getQuantidade());
			prepared.setInt(6, produto.getCategoria().getId());

			prepared.executeUpdate();
			resultSet = prepared.getGeneratedKeys();

			if (resultSet.next()) {

				id = resultSet.getInt(1);
			}

			return id;
		}
		catch (SQLException e) {
			
			throw new DBExcecao(e.getMessage());
		}
		finally {

			DBConexao.closeStatment(prepared);
			DBConexao.closeResultSet(resultSet);
		}
	}

	@Override
	public void alterar(Produto produto) {
		
		sql = "update produtos set imagem = ?, nome = ?, descricao = ?, valor = ?, quantidade = ?, idCategoria = ? where id = ?";

		try {

			prepared = DBConexao.connection().prepareStatement(sql);

			prepared.setString(1, produto.getImagem());
			prepared.setString(2, produto.getNome());
			prepared.setString(3, produto.getDescricao());
			prepared.setDouble(4, produto.getValor());
			prepared.setInt(5, produto.getQuantidade());
			prepared.setInt(6, produto.getCategoria().getId());
			prepared.setInt(7, produto.getId());

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
	public void deletar(Produto produto) {
		
		sql = "delete from produtos where id = ?";

		try {

			prepared = DBConexao.connection().prepareStatement(sql);

			prepared.setInt(1, produto.getId());

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
	public List<Produto> listarProdutos() {

		List<Produto> lista = new ArrayList<>();

		sql = "select produtos.*, categorias.categoria as catNome from produtos inner join categorias on produtos.id = categorias.id";

		try {

			statement = DBConexao.connection().createStatement();

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
				produto.setValor(Double.valueOf(resultSet.getString("valor")));
				produto.setQuantidade(Integer.valueOf(resultSet.getString("quantidade")));
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
		}
	}
	
	@Override
	public Produto buscarProduto(Integer id) {

		sql = "select produtos.*, categorias.categoria as catNome from produtos inner join categorias on produtos.id = categorias.id where id = ?";

		try {

			prepared = DBConexao.connection().prepareStatement(sql);

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
				produto.setValor(Double.valueOf(resultSet.getString("valor")));
				produto.setQuantidade(Integer.valueOf(resultSet.getString("quantidade")));
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
		}
	}
	
	@Override
	public List<Categoria> listarCategorias() {

		List<Categoria> lista = new ArrayList<>();

		sql = "select * from categorias";

		try {

			statement = DBConexao.connection().createStatement();

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
		}
	}
}
