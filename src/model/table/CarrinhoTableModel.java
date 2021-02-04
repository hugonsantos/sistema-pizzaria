package model.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import controllers.CarrinhoController;
import model.entities.Borda;
import model.entities.ItemPedido;
import model.entities.Produto;

public final class CarrinhoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private List<ItemPedido> list = CarrinhoController.buscarTodos();

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {

		ItemPedido item = list.get(linha);
		StringBuilder sb;
		
		switch (coluna) {
		case 0:
			sb = new StringBuilder();
			
			sb.append(item.getTipoProduto());
			return sb;
		case 1:
			sb = new StringBuilder();
			
			sb.append(item.getTamanho());
			return sb;
		case 2:
			sb = new StringBuilder();
			
			for(Produto p : item.getProdutos()) {
				sb.append(p.getNome() + "\n");
			}
			return sb;
		case 3:
			sb = new StringBuilder();
			
			if(item.getBordas().size() != 0) {
				for(Borda b : item.getBordas()) {
					sb.append(b.getBorda() + "\n");
				}
				return sb;
			}
			else return "Sem borda";
		case 4:
			sb = new StringBuilder();
			
			if(item.getObservacoes().equals("") || item.getObservacoes() == null) {
				return "Sem observações";
			}
			else {
				sb.append(item.getObservacoes());
				return sb;
			}
		case 5:
			sb = new StringBuilder();
			
			sb.append(item.getQuantidade());
			return sb;
		case 6:
			sb = new StringBuilder();
			
			sb.append(item.getPrecoTotal());
			return sb;
		default:
			return null;
		}
	}
}
