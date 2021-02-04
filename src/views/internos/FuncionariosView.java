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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import model.entities.Funcionario;
import model.table.FuncionariosTableModel;
import model.util.ViewsUtil;
import model.util.ModalUtil;
import model.util.TableModelUtil;
import views.modal.ModalAlerta;
import views.modal.ModalDeletar;
import views.modal.ModalFuncionario;
import views.modal.enums.ModalAlertaEnum;

public class FuncionariosView extends TelaInternaCustom {

	private static final long serialVersionUID = 1L;

	private Funcionario funcionario;
	
	private ModalFuncionario modalFuncionario;
	private ModalDeletar modalDeletar;
	private ModalAlerta modalAlerta;

	private FuncionariosTableModel funcionariosTableModel = new FuncionariosTableModel();

	private JTable tableFuncionarios;
	private JButton btnIncluirProduto;
	private JButton btnEditar;
	private JButton btnDeletar;

	private MouseListener btnIncluirProdutoML;
	private MouseListener btnEditarML;
	private MouseListener btnDeletarML;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionariosView frame = new FuncionariosView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FuncionariosView() {

		JPanel panelFuncionariosView = new JPanel();
		panelFuncionariosView.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {

				tableFuncionarios.clearSelection();
			}
		});
		panelFuncionariosView.setBackground(Color.WHITE);

		JScrollPane scrollPaneFuncionariosView = new JScrollPane(panelFuncionariosView);
		panelFuncionariosView.setLayout(new BorderLayout(0, 0));
		getContentPane().add(scrollPaneFuncionariosView, BorderLayout.CENTER);

		JLabel lblFuncionarios = new JLabel("Funcion\u00E1rios");
		lblFuncionarios.setBackground(Color.WHITE);
		lblFuncionarios.setPreferredSize(new Dimension(60, 60));
		lblFuncionarios.setFont(new Font("Leelawadee UI", Font.BOLD, 22));
		lblFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
		panelFuncionariosView.add(lblFuncionarios, BorderLayout.NORTH);

		tableFuncionarios = new JTable();
		tableFuncionarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableFuncionarios.setSelectionForeground(Color.WHITE);
		tableFuncionarios.setSelectionBackground(Color.GRAY);
		tableFuncionarios.setModel(funcionariosTableModel);
		tableFuncionarios.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		tableFuncionarios.setBorder(null);
		tableFuncionarios.setShowVerticalLines(false);
		tableFuncionarios.setFocusable(false);
		tableFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(300);
		tableFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(300);
		TableModelUtil.customizarTable(tableFuncionarios.getTableHeader());

		JScrollPane scrollPaneTableFuncionarios = new JScrollPane(tableFuncionarios);
		scrollPaneTableFuncionarios.setViewportBorder(null);
		scrollPaneTableFuncionarios.setBorder(null);
		panelFuncionariosView.add(scrollPaneTableFuncionarios, BorderLayout.CENTER);

		JPanel panelAcoes = new JPanel();
		panelAcoes.setBackground(Color.WHITE);
		panelAcoes.setPreferredSize(new Dimension(10, 100));
		panelFuncionariosView.add(panelAcoes, BorderLayout.SOUTH);

		btnIncluirProduto = new JButton("Incluir novo");
		btnIncluirProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				modalFuncionario = new ModalFuncionario(funcionariosTableModel, null);
				ModalUtil.MovimentacaoModal(modalFuncionario);
				modalFuncionario.setLocationRelativeTo(null);
				modalFuncionario.setVisible(true);
				
				tableFuncionarios.clearSelection();
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
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if (tableFuncionarios.getSelectedRow() != -1) {

					modalFuncionario = new ModalFuncionario(funcionariosTableModel, funcionariosTableModel.capturarFuncionario(tableFuncionarios.getSelectedRow()));
					ModalUtil.MovimentacaoModal(modalFuncionario);
					modalFuncionario.setLocationRelativeTo(null);
					modalFuncionario.setVisible(true);
				}
				
				tableFuncionarios.clearSelection();
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
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if (tableFuncionarios.getSelectedRow() != -1) {

					modalDeletar = new ModalDeletar("Realmente deseja deletar esse funcion�rio?");
					ModalUtil.MovimentacaoModal(modalDeletar);
					modalDeletar.setLocationRelativeTo(null);
					modalDeletar.setVisible(true);

					if (modalDeletar.confirmacao()) {

						funcionario = funcionariosTableModel.capturarFuncionario(tableFuncionarios.getSelectedRow());
						funcionariosTableModel.deletarFuncionario(funcionario);
					}
					
					tableFuncionarios.clearSelection();
				}
				else {

					modalAlerta = new ModalAlerta("Desculpe, primeiro voc� deve selecionar um funcion�rio na tabela!", ModalAlertaEnum.ALERTA);
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
