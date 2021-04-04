package model.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.dao.FabricaDao;
import model.dao.ProdutoDao;
import model.entities.Produto;

public final class ProdutosTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private String[] colunas = {"Id", "Nome", "R$ Broto", "R$ Tradicional", "R$ Grande", "R$ Extra Grande", "Categoria"};
	
	private ProdutoDao produtosDao = FabricaDao.createProdutoDao();
	private List<Produto> list = produtosDao.listarProdutos();
	
	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	
	@Override
	public String getColumnName(int coluna) {
		
		switch(coluna) {
		
		case 0:
			return colunas[0];
		case 1:
			return colunas[1];
		case 2:
			return colunas[2];
		case 3:
			return colunas[3];
		case 4:
			return colunas[4];
		case 5:
			return colunas[5];
		case 6:
			return colunas[6];
		default:
			return "";
		}
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
		Produto produtos = list.get(linha);
		
		switch(coluna) {
		
		case 0:
			return produtos.getId();
		case 1:
			return produtos.getNome();
		case 2:
			return String.format("%.2f", produtos.getValorBroto());
		case 3:
			return String.format("%.2f", produtos.getValorTradicional());
		case 4:
			return String.format("%.2f", produtos.getValorGrande());
		case 5:
			return String.format("%.2f", produtos.getValorExtraGrande());
		case 6:
			return produtos.getCategoria().getCategoria();
		default:
			return "";
		}	
	}
	
	public final void adicionarProduto(Produto produtos) {
		
		produtos.setId(produtosDao.inserir(produtos));
		list.add(produtos);
		
		fireTableDataChanged();
	}
	
	public final void alterarProduto(Produto produtos) {
		
		produtosDao.alterar(produtos);
		
		fireTableDataChanged();
	}
	
	public final void deletarProduto(Produto produtos) {
		
		produtosDao.deletar(produtos);
		list.remove(produtos);
		
		fireTableDataChanged();
	}
	
	public Produto capturarProduto(Integer linha) {
		
		Produto produtos = list.get(linha);
		return produtos;
	}
}
