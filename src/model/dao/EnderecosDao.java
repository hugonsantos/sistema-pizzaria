package model.dao;

import java.util.List;

import model.entities.Endereco;

public interface EnderecosDao {

	public void inserir(Endereco enderecos);
	public void alterar(Endereco enderecos);
	public void deletar(Endereco enderecos);
	public List<Endereco> buscarEnderecosCliente(Integer id);
	public Boolean localizarEndereco(Integer id);
}
