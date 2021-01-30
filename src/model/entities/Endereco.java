package model.entities;

public class Endereco {

	private Integer id;
	private String endereco;
	private String numero;
	private String bairro;
	private String complemento;
	private String cep;
	private String cidade;
	private String estado;
	private String enderecoEntrega;
	
	private Cliente idClientes;
	
	public Endereco() {
		
	}

	public Endereco(Integer id, String endereco, String numero, String bairro, String complemento, String cep, String cidade, String estado, String enderecoEntrega, Cliente idClientes) {
		this.id = id;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<html>");
		sb.append("<br>");
		sb.append("<font style='font-size: 10px;'>");
		
		if(enderecoEntrega.equalsIgnoreCase("Sim")) {
			
			sb.append("<p align='center' color='red'>*Este endereço é o padrão de entrega*</p>");
			sb.append("<br>");
		}
		
		sb.append("<p>Endereço: <span style='font-family: leelawadee ui; font-weight: lighter;'>" + endereco + "</span>, N°: <span style='font-family: leelawadee ui; font-weight: lighter;'>" + numero + "</span>, Bairro: <span style='font-family: leelawadee ui; font-weight: lighter;'>" + bairro + "</span></p>");
		sb.append("<p>Complemento: <span style='font-family: leelawadee ui; font-weight: lighter;'>" + complemento + "</span>, CEP: <span style='font-family: leelawadee ui; font-weight: lighter;'>" + cep + "</span>, Cidade: <span style='font-family: leelawadee ui; font-weight: lighter;'>" + cidade + "</span>, Estado: <span style='font-family: leelawadee ui; font-weight: lighter;'>" + estado + "</span></p>");
		sb.append("</font>");
		sb.append("_______________________________________________________________________________________");
		sb.append("</html>");
		
		return sb.toString();
	}
}
