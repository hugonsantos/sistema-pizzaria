package model.table;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.dao.FabricaDao;
import model.dao.FuncionarioDao;
import model.entities.Funcionario;

public final class FuncionariosTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private String[] colunas = {"Id", "Nome", "Email", "Usuário", "Administrador"};
	
	private FuncionarioDao funcionariosDao = FabricaDao.createFuncionarioDao();
	private List<Funcionario> list = funcionariosDao.listarTodos();
	
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
		default:
			return "";
		}
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
		Funcionario funcionarios = list.get(linha);
		
		switch(coluna) {
		
		case 0:
			return funcionarios.getId();
		case 1: 
			return funcionarios.getNome();
		case 2:
			return funcionarios.getEmail();
		case 3:
			return funcionarios.getUsuario();
		case 4:
			return funcionarios.getAdministrador();
		default:
			return "";
		}	
	}
	
	public final void adicionarFuncionario(Funcionario funcionarios) {
		
		Integer id = funcionariosDao.inserir(funcionarios);
		funcionarios.setId(id);
		list.add(funcionarios);
		fireTableDataChanged();
	}
	
	public final void alterarFuncionario(Funcionario funcionarios) {
		
		funcionariosDao.alterar(funcionarios);
		fireTableDataChanged();
	}
	
	public final void deletarFuncionario(Funcionario funcionarios) {
		
		funcionariosDao.deletar(funcionarios);
		list.remove(funcionarios);
	}
	
	public Funcionario capturarFuncionario(Integer linha) {
		
		Funcionario funcionarios = list.get(linha);
		return funcionarios;
	}
}
