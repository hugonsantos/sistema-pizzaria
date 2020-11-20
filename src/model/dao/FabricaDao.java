package model.dao;

import model.dao.source.FuncionariosSourceDao;
import model.dao.source.LoginSourceDao;

public class FabricaDao {

	public static FuncionariosDao createFuncionariosDao() {
		return new FuncionariosSourceDao();
	}
	
	public static LoginDao createLoginDao() {
		return new LoginSourceDao();
	}
}
