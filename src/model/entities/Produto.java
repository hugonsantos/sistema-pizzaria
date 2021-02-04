package model.entities;

public class Produto {

	private Integer id;
	private String miniaturaBase64;
	private String extensao;
	private String nome;
	private String descricao;
	private Double valorBroto;
	private Double valorTradicional;
	private Double valorGrande;
	private Double valorExtraGrande;
	
	private Categoria categoria;
	
	public Produto() {
		
	}

	public Produto(Integer id, String miniaturaBase64, String extensao, String nome, String descricao, Double valorBroto, Double valorTradicional, Double valorGrande, Double valorExtraGrande, Categoria categoria) {
		
		this.id = id;
		this.miniaturaBase64 = miniaturaBase64;
		this.extensao = extensao;
		this.nome = nome;
		this.descricao = descricao;
		this.valorBroto = valorBroto;
		this.valorTradicional = valorTradicional;
		this.valorGrande = valorGrande;
		this.valorExtraGrande = valorExtraGrande;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMiniaturaBase64() {
		return miniaturaBase64;
	}

	public void setMiniaturaBase64(String miniaturaBase64) {
		this.miniaturaBase64 = miniaturaBase64;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorBroto() {
		return valorBroto;
	}

	public void setValorBroto(Double valorBroto) {
		this.valorBroto = valorBroto;
	}

	public Double getValorTradicional() {
		return valorTradicional;
	}

	public void setValorTradicional(Double valorTradicional) {
		this.valorTradicional = valorTradicional;
	}

	public Double getValorGrande() {
		return valorGrande;
	}

	public void setValorGrande(Double valorGrande) {
		this.valorGrande = valorGrande;
	}

	public Double getValorExtraGrande() {
		return valorExtraGrande;
	}

	public void setValorExtraGrande(Double valorExtraGrande) {
		this.valorExtraGrande = valorExtraGrande;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		return nome;
	}
}
