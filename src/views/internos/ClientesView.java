package views.internos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import model.entities.Cliente;
import model.entities.Endereco;
import model.table.ClientesTableModel;
import model.util.ModalUtil;
import model.util.TableModelUtil;
import model.util.ViewsUtil;
import views.modal.ModalAlerta;
import views.modal.ModalCliente;
import views.modal.ModalDeletar;
import views.modal.enums.ModalAlertaEnum;

public class ClientesView extends TelaInternaCustom {

	private static final long serialVersionUID = 1L;

	private ModalCliente modalCliente;
	private ModalAlerta modalAlerta;

	private Cliente cliente = new Cliente();
	private ClientesTableModel clientesTableModel = new ClientesTableModel();

	private JTable tableClientes;
	private JButton btnIncluirProduto;
	private JButton btnEditar;
	private JButton btnDeletar;
	
	private List<Endereco> enderecos = new ArrayList<>();
	
	private MouseListener btnIncluirProdutoML;
	private MouseListener btnEditarML;
	private MouseListener btnDeletarML;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientesView frame = new ClientesView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ClientesView() {

		JPanel panelClientesView = new JPanel();
		panelClientesView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				tableClientes.clearSelection();
			}
		});
		panelClientesView.setBackground(Color.WHITE);

		JScrollPane scrollPanepanelClientesView = new JScrollPane(panelClientesView);
		panelClientesView.setLayout(new BorderLayout(0, 0));
		getContentPane().add(scrollPanepanelClientesView, BorderLayout.CENTER);

		JLabel lblFuncionarios = new JLabel("Clientes");
		lblFuncionarios.setBackground(Color.WHITE);
		lblFuncionarios.setPreferredSize(new Dimension(60, 60));
		lblFuncionarios.setFont(new Font("Leelawadee UI", Font.BOLD, 22));
		lblFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
		panelClientesView.add(lblFuncionarios, BorderLayout.NORTH);

		tableClientes = new JTable();
		tableClientes.setModel(clientesTableModel);
		tableClientes.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		tableClientes.setBorder(null);
		tableClientes.setShowVerticalLines(false);
		tableClientes.setFocusable(false);
		tableClientes.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableClientes.getColumnModel().getColumn(1).setPreferredWidth(500);
		TableModelUtil.customizarTable(tableClientes.getTableHeader());

		JScrollPane scrollPanetableClientes = new JScrollPane(tableClientes);
		scrollPanetableClientes.setViewportBorder(null);
		scrollPanetableClientes.setBorder(null);
		panelClientesView.add(scrollPanetableClientes, BorderLayout.CENTER);

		JPanel panelAcoes = new JPanel();
		panelAcoes.setBackground(Color.WHITE);
		panelAcoes.setPreferredSize(new Dimension(10, 100));
		panelClientesView.add(panelAcoes, BorderLayout.SOUTH);
		
		btnIncluirProduto = new JButton("Incluir novo");
		btnIncluirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modalCliente = new ModalCliente(clientesTableModel, null);

				ModalUtil.MovimentacaoModal(modalCliente);
				modalCliente.setLocationRelativeTo(null);
				modalCliente.setVisible(true);
				
				tableClientes.clearSelection();
			}
		});
		btnIncluirProdutoML = ViewsUtil.adicionarAcaoMouse(btnIncluirProduto, Color.WHITE, Color.GREEN);
		btnIncluirProduto.addMouseListener(btnIncluirProdutoML);
		btnIncluirProduto.setBorderPainted(false);
		btnIncluirProduto.setFocusable(false);
		btnIncluirProduto.setBorderPainted(false);
		btnIncluirProduto.setBackground(Color.WHITE);
		btnIncluirProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIncluirProduto.setFont(new Font("Leelawadee UI", Font.BOLD, 16));
		btnIncluirProduto.setPreferredSize(new Dimension(180, 40));
		btnIncluirProduto.setBorder(null);
		panelAcoes.add(btnIncluirProduto);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tableClientes.getSelectedRow() != -1) {
					
					modalCliente = new ModalCliente(clientesTableModel, clientesTableModel.capturarCliente(tableClientes.getSelectedRow()));

					ModalUtil.MovimentacaoModal(modalCliente);
					modalCliente.setLocationRelativeTo(null);
					modalCliente.setVisible(true);
				}
				
				tableClientes.clearSelection();
			}
		});
		btnEditarML = ViewsUtil.adicionarAcaoMouse(btnEditar, Color.WHITE, Color.GREEN);
		btnEditar.addMouseListener(btnEditarML);
		btnEditar.setBorderPainted(false);
		btnEditar.setFocusable(false);
		btnEditar.setBorderPainted(false);
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setFont(new Font("Leelawadee UI", Font.BOLD, 16));
		btnEditar.setPreferredSize(new Dimension(180, 40));
		btnEditar.setBorder(null);
		panelAcoes.add(btnEditar);

		btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tableClientes.getSelectedRow() != -1) {
					
					ModalDeletar modalDeletar = new ModalDeletar("Realmente deseja deletar esse cliente?");
					ModalUtil.MovimentacaoModal(modalDeletar);
					modalDeletar.setLocationRelativeTo(null);
					modalDeletar.setVisible(true);
					
					if(modalDeletar.confirmacao()) {
						
						cliente = clientesTableModel.capturarCliente(tableClientes.getSelectedRow());
						enderecos = clientesTableModel.capturarEnderecos(cliente.getId());
						
						clientesTableModel.deletarCliente(cliente, enderecos);
					}
					
					tableClientes.clearSelection();
				}
				else {
					
					modalAlerta = new ModalAlerta("Primeiro você deve selecionar um cliente na tabela para deletar!", ModalAlertaEnum.ALERTA);
					
					ModalUtil.MovimentacaoModal(modalAlerta);
					modalAlerta.setLocationRelativeTo(null);
					modalAlerta.setVisible(true);
				}
			}
		});
		btnDeletarML = ViewsUtil.adicionarAcaoMouse(btnDeletar, Color.WHITE, Color.RED);
		btnDeletar.addMouseListener(btnDeletarML);
		btnDeletar.setBorderPainted(false);
		btnDeletar.setFocusable(false);
		btnDeletar.setBorderPainted(false);
		btnDeletar.setBackground(Color.WHITE);
		btnDeletar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeletar.setFont(new Font("Leelawadee UI", Font.BOLD, 16));
		btnDeletar.setPreferredSize(new Dimension(180, 40));
		btnDeletar.setBorder(null);
		panelAcoes.add(btnDeletar);
	}
}
