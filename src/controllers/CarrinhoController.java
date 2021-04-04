package controllers;

import java.util.ArrayList;
import java.util.List;

import model.entities.ItemPedido;

public class CarrinhoController {

	private static List<ItemPedido> carrinho = new ArrayList<>();
	
	public CarrinhoController() {
	}

	public static void addProduto(ItemPedido itemPedido) {
		
		carrinho.add(itemPedido);
	}
	
	public static void deletarProduto(ItemPedido itemPedido) {
		
		carrinho.remove(itemPedido);
	}
	
	public static void limparCarrinho(ItemPedido itemPedido) {
		
		carrinho.removeAll(carrinho);
	}
	
	public static List<ItemPedido> buscarTodos() {
		
		return carrinho;
	}
}