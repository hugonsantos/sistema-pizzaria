package model.dao;

import model.dao.source.ClientesSourceDao;
import model.dao.source.EnderecosSourceDao;
import model.dao.source.FuncionariosSourceDao;
import model.dao.source.LoginSourceDao;

public class FabricaDao {

	public static FuncionariosDao createFuncionariosDao() {
		return new FuncionariosSourceDao();
	}
	
	public static LoginDao createLoginDao() {
		return new LoginSourceDao();
	}
	
	public static ClientesDao createClientesDao() {
		return new ClientesSourceDao();
	}
	
	public static EnderecosDao createEnderecosDao() {
		return new EnderecosSourceDao();
	}
}
