package model.table;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import org.apache.tomcat.util.codec.binary.Base64;

import model.dao.FabricaDao;
import model.dao.ProdutoDao;
import model.entities.Produto;

public final class PizzasDocesTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private ProdutoDao produtoDao = FabricaDao.createProdutoDao();
	private List<Produto> list = produtoDao.buscarProdutosCategoria("Pizza doce");
	
	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
		Produto produto = list.get(linha);
		
		byte[] bytesMiniatura = Base64.decodeBase64(produto.getMiniaturaBase64());
		
		switch(coluna) {
		case 0:
			return new ImageIcon(bytesMiniatura);
		case 1:
			return produto.getNome();
		case 2:
			
			StringBuilder str = new StringBuilder();
			
			str.append("<html>");
			str.append("Broto: R$" + String.format("%.2f", produto.getValorBroto()));
			str.append("<br>");
			str.append("Tradicional: R$" + String.format("%.2f", produto.getValorTradicional()));
			str.append("<br>");
			str.append("Grande: R$" + String.format("%.2f", produto.getValorGrande()));
			str.append("<br>");
			str.append("Extra grande: R$" + String.format("%.2f", produto.getValorExtraGrande()));
			str.append("</html>");
			
			return str.toString();
		default:
			return "";
		}
	}
	
	public Produto capturarSelecionado(Integer linha) {
		
		Produto produto = list.get(linha);
		return produto;
	}
	
	public void atualizar() {
		
		list = produtoDao.buscarProdutosCategoria("Pizza doce");
	}
}
