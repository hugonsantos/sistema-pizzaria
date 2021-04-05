package model.entities;

import java.util.ArrayList;
import java.util.List;

public class ItemPedido {

	private String tamanho;
	private String observacoes;
	private Integer quantidade;
	private Double preco;
	private String tipoProduto;
	
	private List<Produto> produtos = new ArrayList<>();
	private Borda bordas[] = new Borda[2];
	
	public ItemPedido() {
		
	}

	public ItemPedido(String tamanho, String observacoes, Integer quantidade, Double preco, String tipoProduto) {
		
		this.tamanho = tamanho;
		this.observacoes = observacoes;
		this.quantidade = quantidade;
		this.preco = preco;
		this.tipoProduto = tipoProduto;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void addProduto(Integer indice, Produto produto) {
		produtos.add(indice, produto);
	}
	
	public void removerProduto(Produto produto) {
		produtos.remove(produto);
	}
	
	public void removerProdutos() {
		produtos.removeAll(produtos);
	}
	
	public Borda[] getBordas() {
		return bordas;
	}
	
	public void addBorda(int index, Borda borda) {
		bordas[index] = borda;
	}
	
	public void removerBorda(int index, Borda borda) {
		bordas[index] = null;
	}
	
	public void removerBordas() {
		
	}

	public Double definirPreco() {
		
		Double maiorValor = 0.0;
		
		switch (tamanho) {
		case "Broto":
			for(Produto p : getProdutos()) {
				
				if(maiorValor < p.getValorBroto()) {
					
					maiorValor = p.getValorBroto();
				}
			}
			
			return maiorValor;
		case "Tradicional":
			for(Produto p : getProdutos()) {
				
				if(maiorValor < p.getValorTradicional()) {
					
					maiorValor = p.getValorTradicional();
				}
			}
			
			return maiorValor;
		case "Grande":
			for(Produto p : getProdutos()) {
				
				if(maiorValor < p.getValorGrande()) {
					
					maiorValor = p.getValorGrande();
				}
			}
			
			return maiorValor;
		case "Extra grande":
			for(Produto p : getProdutos()) {
				
				if(maiorValor < p.getValorExtraGrande()) {
					
					maiorValor = p.getValorExtraGrande();
				}
			}
			
			return maiorValor;
		default:
			return null;
		}
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<html>");
		sb.append("<p style='text-align: center;'>" + tipoProduto + "</p>");
		sb.append("<p>Tamanho:</p>");
		sb.append("<pre>    " + tamanho + "</pre>");
		sb.append("<p>Sabor(es):</p>");
		
		for(Produto p : produtos) {
			
			sb.append("<pre>    " + p.getNome() + "</pre>");
		}
		
		sb.append("<p>Borda(s):</p>");
		
		if(bordas[0] == null && bordas[1] == null) sb.append("<pre>    Sem borda</pre>");
		if(bordas[0] != null) sb.append("<pre>    " + bordas[0].getBorda() + "</pre>");
		if(bordas[1] != null) sb.append("<pre>    " + bordas[1].getBorda() + "</pre>");
		
		sb.append("<br>");
		sb.append("<p style='text-align: center;'>Qtd: " + quantidade + " ____________ Preço: R$" + String.format("%.2f", preco) + "</p>");
		sb.append("-----------------------------------------------------------------");
		sb.append("<br>");
		sb.append("</html>");
		 
		return sb.toString();
	}
}

