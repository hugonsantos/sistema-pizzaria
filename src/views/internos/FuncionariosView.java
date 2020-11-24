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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import model.table.FuncionariosTableModel;
import model.util.ModalUtil;
import model.util.TableModelUtil;
import views.modal.ModalFuncionario;

public class FuncionariosView extends TelaInternaCustom {

	private static final long serialVersionUID = 1L;

	private ModalFuncionario modalFuncionario;

	private ModalUtil modalUtil = new ModalUtil();
	private FuncionariosTableModel funcionariosTableModel = new FuncionariosTableModel();
	private TableModelUtil tableModelUtil = new TableModelUtil();

	private JTable tableFuncionarios;
	private JButton btnIncluirProduto;
	private JButton btnEditar;
	private JButton btnDeletar;

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
				btnEditar.setEnabled(false);
				btnDeletar.setEnabled(false);
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
		tableFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (tableFuncionarios.getSelectedRow() != -1) {

					btnEditar.setEnabled(true);
					btnDeletar.setEnabled(true);
				}
			}
		});
		tableFuncionarios.setModel(funcionariosTableModel);
		tableFuncionarios.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		tableFuncionarios.setBorder(null);
		tableFuncionarios.setShowVerticalLines(false);
		tableFuncionarios.setFocusable(false);
		tableFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(300);
		tableFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(300);
		tableModelUtil.customizarTable(tableFuncionarios.getTableHeader());

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
			public void actionPerformed(ActionEvent e) {

				if (modalFuncionario == null) {

					modalFuncionario = new ModalFuncionario(funcionariosTableModel);
				}

				modalUtil.MovimentacaoModal(modalFuncionario);
				modalFuncionario.setLocationRelativeTo(null);
				modalFuncionario.setVisible(true);
			}
		});
		btnIncluirProduto.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {

				btnIncluirProduto.setForeground(Color.WHITE);
				btnIncluirProduto.setBackground(Color.GREEN);
			}

			@Override
			public void mouseExited(MouseEvent e) {

				btnIncluirProduto.setForeground(Color.BLACK);
				btnIncluirProduto.setBackground(Color.WHITE);
			}
		});
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
		btnEditar.setEnabled(false);
		btnEditar.setBorderPainted(false);

		btnEditar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {

				if (tableFuncionarios.getSelectedRow() != -1) {

					btnEditar.setForeground(Color.WHITE);
					btnEditar.setBackground(Color.GREEN);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {

				btnEditar.setForeground(Color.BLACK);
				btnEditar.setBackground(Color.WHITE);
			}
		});

		btnEditar.setFocusable(false);
		btnEditar.setBorderPainted(false);
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setFont(new Font("Leelawadee UI", Font.BOLD, 16));
		btnEditar.setPreferredSize(new Dimension(180, 40));
		btnEditar.setBorder(null);
		panelAcoes.add(btnEditar);

		btnDeletar = new JButton("Deletar");
		btnDeletar.setEnabled(false);
		btnDeletar.setBorderPainted(false);
		btnDeletar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {

				if (tableFuncionarios.getSelectedRow() != -1) {

					btnDeletar.setForeground(Color.WHITE);
					btnDeletar.setBackground(Color.RED);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {

				btnDeletar.setForeground(Color.BLACK);
				btnDeletar.setBackground(Color.WHITE);
			}
		});
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
