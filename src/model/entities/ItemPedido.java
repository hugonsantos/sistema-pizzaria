package model.entities;

import java.util.ArrayList;
import java.util.List;

public class ItemPedido {

	private String tamanho;
	private String observacoes;
	private Integer quantidade;
	private Double precoTotal;
	private String tipoProduto;
	
	private List<Produto> produtos = new ArrayList<>();
	private List<Borda> bordas = new ArrayList<>();
	
	public ItemPedido() {
		
	}

	public ItemPedido(String tamanho, String observacoes, Integer quantidade, Double precoTotal, String tipoProduto) {
		
		this.tamanho = tamanho;
		this.observacoes = observacoes;
		this.quantidade = quantidade;
		this.precoTotal = precoTotal;
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

	public Double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
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
	
	public List<Borda> getBordas() {
		return bordas;
	}
	
	public void addBorda(Borda borda) {
		bordas.add(borda);
	}
	
	public void removerBorda(Borda borda) {
		bordas.remove(borda);
	}
	
	public void removerBordas() {
		bordas.removeAll(bordas);
	}

	public Double calculoPrecoTotal() {
		
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
		
		if(bordas.size() != 0) {
			
			for(Borda b : bordas) {
				
				sb.append("<pre>    " + b.getBorda() + "</pre>");
			}
		}
		else sb.append("<pre>    Sem borda</pre>");
		
		sb.append("<br>");
		sb.append("<p style='text-align: center;'>Qtd: " + quantidade + " ____________ Preço: R$" + String.format("%.2f", precoTotal) + "</p>");
		sb.append("---------------------------------------------------");
		sb.append("<br>");
		sb.append("</html>");
		 
		return sb.toString();
	}
}

