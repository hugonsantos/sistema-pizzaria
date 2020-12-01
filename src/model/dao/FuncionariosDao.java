package model.dao;

import java.util.List;

import model.entities.Funcionario;

public interface FuncionariosDao {

	public Integer inserir(Funcionario funcionarios);
	public void alterar(Funcionario funcionarios);
	public void deletar(Funcionario funcionarios);
	public List<Funcionario> listarTodos();
	public Funcionario buscarFuncionario(Integer id);
}
