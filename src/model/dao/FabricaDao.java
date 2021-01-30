package model.dao;

import model.dao.source.BordaSourceDao;
import model.dao.source.ClienteSourceDao;
import model.dao.source.EnderecoSourceDao;
import model.dao.source.FuncionarioSourceDao;
import model.dao.source.LoginSourceDao;
import model.dao.source.ProdutoSourceDao;

public class FabricaDao {

	public static FuncionarioDao createFuncionarioDao() {
		return new FuncionarioSourceDao();
	}
	
	public static LoginDao createLoginDao() {
		return new LoginSourceDao();
	}
	
	public static ClienteDao createClienteDao() {
		return new ClienteSourceDao();
	}
	
	public static EnderecoDao createEnderecoDao() {
		return new EnderecoSourceDao();
	}
	
	public static ProdutoDao createProdutoDao() {
		return new ProdutoSourceDao();
	}
	
	public static BordaDao createBordaDao() {
		return new BordaSourceDao();
	}
}
