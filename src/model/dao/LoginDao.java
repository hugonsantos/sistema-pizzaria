package model.dao;

import model.entities.Funcionario;

public interface LoginDao {

	public Boolean AutenticacaoLogin(Funcionario funcionario);
}
