package model.table;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import model.dao.FabricaDao;
import model.dao.ProdutoDao;
import model.entities.Produto;

public final class PizzasDocesTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private String[] colunas = {"Imagem", "Nome", "Valor"};
	
	private ProdutoDao produtosDao = FabricaDao.createProdutoDao();
	private List<Produto> list = produtosDao.buscarProdutosCategoria("Pizza doce");
	
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
		
		return null;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
		Produto produtos = list.get(linha);
		
		switch(coluna) {
		case 0:
			return new ImageIcon(getClass().getResource("/imagens/" + produtos.getImagem()));
		case 1:
			return produtos.getNome();
		case 2:
			
			StringBuilder str = new StringBuilder();
			
			str.append("<html>");
			str.append("Broto: R$" + String.format("%.2f", produtos.getValorBroto()));
			str.append("<br>");
			str.append("Tradicional: R$" + String.format("%.2f", produtos.getValorTradicional()));
			str.append("<br>");
			str.append("Grande: R$" + String.format("%.2f", produtos.getValorGrande()));
			str.append("<br>");
			str.append("Extra grande: R$" + String.format("%.2f", produtos.getValorExtraGrande()));
			str.append("</html>");
			
			return str.toString();
		default:
			return "";
		}	
	}
	
	public final void mostrarProduto(Produto produtos) {
		
		
	}
	
	public Produto capturarSelecionado(Integer linha) {
		
		Produto produto = list.get(linha);
		return produto;
	}
}
