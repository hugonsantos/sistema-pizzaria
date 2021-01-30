package model.dao;

import java.util.List;

import model.entities.Borda;

public interface BordaDao {

	public Integer inserir(Borda borda);
	public void alterar(Borda borda);
	public void deletar(Borda borda);
	public List<Borda> listarBordas();
	public List<Borda> listarBordasSalgadas();
	public List<Borda> listarBordasDoces();
	public Borda buscarBorda(Integer id);
}
