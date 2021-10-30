package model.entities;

public class Cliente {

	private Integer id;
	private String nome;
	private String genero;
	private String cpf;
	private String telfixo;
	private String celular;
	
	public Cliente() {
		
	}

	public Cliente(Integer id, String nome, String genero, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelfixo() {
		return telfixo;
	}

	public void setTelfixo(String telfixo) {
		this.telfixo = telfixo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<html>");
		sb.append("<font style='font-size: 11px;'>");
		sb.append("<p>" + nome + "</p>");
		sb.append("</font>");
		sb.append("</html>");
		
		return sb.toString();
	}
}
