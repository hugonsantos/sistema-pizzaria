package model.dao;

import java.util.List;

import model.entities.Cliente;

public interface ClienteDao {

	public Integer inserir(Cliente clientes);
	public void alterar(Cliente clientes);
	public void deletar(Cliente clientes);
	public List<Cliente> listarTodos();
	public Cliente buscarFuncionario(Integer id);
}
