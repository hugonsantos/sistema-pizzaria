package model.entities;

public class Borda {

	private Integer id;
	private String borda;
	private String tipoBorda;
	
	public Borda() {
		
	}

	public Borda(Integer id, String borda, String tipoBorda) {
		
		this.id = id;
		this.borda = borda;
		this.tipoBorda = tipoBorda;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBorda() {
		return borda;
	}

	public void setBorda(String borda) {
		this.borda = borda;
	}

	public String getTipoBorda() {
		return tipoBorda;
	}

	public void setTipoBorda(String tipoBorda) {
		this.tipoBorda = tipoBorda;
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
		Borda other = (Borda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		return borda;
	}
}
