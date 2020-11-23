package model.table;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.dao.FabricaDao;
import model.dao.FuncionariosDao;
import model.entities.Funcionarios;

public class FuncionariosTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private String[] colunas = {"Id", "Nome", "Email", "Data de Nascimento", "CPF", "Apelido", "Administrador"};
	
	private FuncionariosDao funcionariosDao = FabricaDao.createFuncionariosDao();
	List<Funcionarios> list = funcionariosDao.listarTodos();
	
	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	
	@Override
	public String getColumnName(int coluna) {
		
		switch(coluna) {
		
		case 0:
			return colunas[0];
		case 1:
			return colunas[1];
		case 2:
			return colunas[2];
		case 3:
			return colunas[3];
		case 4:
			return colunas[4];
		case 5:
			return colunas[5];
		case 6:
			return colunas[6];
		default:
			return "";
		}
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
		Funcionarios funcionarios = list.get(linha);
		
		switch(coluna) {
		
		case 0:
			return funcionarios.getId();
		case 1: 
			return funcionarios.getNome();
		case 2:
			return funcionarios.getEmail();
		case 3:
			return sdf.format(funcionarios.getDataNascimento());
		case 4:
			return funcionarios.getCpf();
		case 5:
			return funcionarios.getApelido();
		case 6:
			return funcionarios.getAdministrador();
		default:
			return "";
		}	
	}
}
