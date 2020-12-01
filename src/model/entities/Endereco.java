package model.entities;

public class Endereco {

	private Integer id;
	private String endereco;
	private Integer numero;
	private String bairro;
	private String complemento;
	private Integer cep;
	private String enderecoEntrega;
	
	private Cliente idClientes;
	
	public Endereco() {
		
	}

	public Endereco(Integer id, String endereco, Integer numero, String bairro, String complemento, Integer cep, String enderecoEntrega, Cliente idClientes) {
		this.id = id;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cep = cep;
		this.enderecoEntrega = enderecoEntrega;
		this.idClientes = idClientes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}
	
	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public Cliente getIdClientes() {
		return idClientes;
	}

	public void setIdClientes(Cliente idClientes) {
		this.idClientes = idClientes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enderecoEntrega == null) ? 0 : enderecoEntrega.hashCode());
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
		Endereco other = (Endereco) obj;
		if (enderecoEntrega == null) {
			if (other.enderecoEntrega != null)
				return false;
		} else if (!enderecoEntrega.equals(other.enderecoEntrega))
			return false;
		return true;
	}
}
