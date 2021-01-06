package model.dao;

import java.util.List;

import model.entities.Categoria;
import model.entities.Produto;

public interface ProdutosDao {

	public Integer inserir(Produto produto);
	public void alterar(Produto produto);
	public void deletar(Produto produto);
	public List<Produto> listarProdutos();
	public Produto buscarProduto(Integer id);
	public List<Categoria> listarCategorias();
}
