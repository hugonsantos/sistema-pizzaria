package model.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.dao.ClienteDao;
import model.dao.EnderecoDao;
import model.dao.FabricaDao;
import model.entities.Cliente;
import model.entities.Endereco;

public final class ClientesTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private String[] colunas = {"Id", "Nome", "CPF"};
	
	private ClienteDao clientesDao = FabricaDao.createClienteDao();
	private EnderecoDao enderecosDao = FabricaDao.createEnderecoDao();
	private List<Cliente> list = clientesDao.listarTodos();
	
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
		default:
			return "";
		}
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
		Cliente clientes = list.get(linha);
		
		switch(coluna) {
		
		case 0:
			return clientes.getId();
		case 1: 
			return clientes.getNome();
		case 2:
			return clientes.getCpf();
		default:
			return "";
		}	
	}
	
	public final void adicionarCliente(Cliente clientes, List<Endereco> enderecos) {
		
		clientes.setId(clientesDao.inserir(clientes));
		
		for(Endereco e : enderecos) {

			e.setIdClientes(clientes);
			enderecosDao.inserir(e);
		}
		
		list.add(clientes);
		fireTableDataChanged();
	}
	
	public final void alterarCliente(Cliente clientes, List<Endereco> enderecos) {
		
		clientesDao.alterar(clientes);
		
		for(Endereco endereco : enderecos) {

			enderecosDao.alterar(endereco);
		}
		
		fireTableDataChanged();
	}
	
	public final void deletarCliente(Cliente clientes, List<Endereco> enderecos) {
		
		for(Endereco endereco : enderecos) {
			
			enderecosDao.deletar(endereco);
		}
		
		clientesDao.deletar(clientes);
		list.remove(clientes);
		
		fireTableDataChanged();
	}
	
	public final void adicionarEnderecoEntrega(Endereco endereco) {
		
		enderecosDao.inserir(endereco);
	}
	
	public final void alterarEndereco(Endereco endereco) {
		
		enderecosDao.alterar(endereco);
	}
	
	public final void deletarEndereco(Endereco endereco) {
		
		enderecosDao.deletar(endereco);
	}
	
	public Cliente capturarCliente(Integer linha) {
		
		Cliente cliente = list.get(linha);
		return cliente;
	}
	
	public List<Cliente> capturarClientes() {
		
		List<Cliente> clientes = clientesDao.listarTodos();
		return clientes;
	}
	
	public List<Endereco> capturarEnderecos(Integer idCliente) {
		
		List<Endereco> enderecos = enderecosDao.buscarEnderecosCliente(idCliente);
		return enderecos;
	}
}
