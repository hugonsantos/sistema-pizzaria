package controllers;

import java.util.ArrayList;
import java.util.List;

import model.entities.ItemPedido;

public class CarrinhoController {

	private static List<ItemPedido> carrinho = new ArrayList<>();
	
	public CarrinhoController() {
	}

	public static void addItem(ItemPedido itemPedido) {
		
		carrinho.add(itemPedido);
	}
	
	public static void incrementarQtd(Integer index) {
		
		carrinho.get(index).setQuantidade(carrinho.get(index).getQuantidade() + 1);
	}
	
	public static void decrementarQtd(Integer index) {
		
		if( ! ((carrinho.get(index).getQuantidade() - 1) < 1)) {
			carrinho.get(index).setQuantidade(carrinho.get(index).getQuantidade() - 1);
		}
	}
	
	public static void deletarItem(ItemPedido itemPedido) {
		
		carrinho.remove(itemPedido);
	}
	
	public static void limparCarrinho() {
		
		carrinho.removeAll(carrinho);
	}
	
	public static List<ItemPedido> buscarTodos() {
		
		return carrinho;
	}
	
	public static Double total() {
		
		Double total = 0.0;
		
		for(ItemPedido it : carrinho) {
			
			total += it.getPreco() * it.getQuantidade();
		}
		
		return total;
	}
}