package model.dao;

import java.util.List;

import model.entities.Funcionarios;

public interface FuncionariosDao {

	public void inserir(Funcionarios funcionarios);
	public void alterar(Funcionarios funcionarios);
	public void deletar(Funcionarios funcionarios);
	public Funcionarios buscarFuncionario();
	public List<Funcionarios> listarTodos();
}
