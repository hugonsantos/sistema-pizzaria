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
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import model.entities.Produto;
import model.table.ProdutosTableModel;
import model.util.ModalUtil;
import model.util.TableModelUtil;
import views.modal.ModalAlerta;
import views.modal.ModalDeletar;
import views.modal.ModalProdutos;
import views.modal.enums.ModalAlertaEnum;

public class ProdutosView extends TelaInternaCustom {

	private static final long serialVersionUID = 1L;
	private JTable tableProdutos;
	
	private Produto produto;
	
	private ModalProdutos modalProdutos;
	private ModalAlerta modalAlerta;
	
	private ProdutosTableModel produtosTableModel = new ProdutosTableModel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutosView frame = new ProdutosView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProdutosView() {
		
		JPanel panelProdutos = new JPanel();
		panelProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				tableProdutos.clearSelection();
			}
		});
		panelProdutos.setBackground(Color.WHITE);
		
		JScrollPane scrollPane = new JScrollPane(panelProdutos);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		panelProdutos.setLayout(new BorderLayout(0, 0));
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setBackground(Color.WHITE);
		lblProdutos.setPreferredSize(new Dimension(43, 100));
		lblProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdutos.setFont(new Font("Leelawadee UI", Font.BOLD, 22));
		panelProdutos.add(lblProdutos, BorderLayout.NORTH);
		
		JPanel panelListaProdutos = new JPanel();
		panelListaProdutos.setBackground(Color.WHITE);
		panelProdutos.add(panelListaProdutos, BorderLayout.CENTER);
		
		tableProdutos = new JTable();
		tableProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableProdutos.setSelectionForeground(Color.WHITE);
		tableProdutos.setSelectionBackground(Color.GRAY);
		tableProdutos.setModel(produtosTableModel);
		tableProdutos.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		tableProdutos.setBorder(null);
		tableProdutos.setShowVerticalLines(false);
		tableProdutos.setFocusable(false);
		tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(10);
		tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(200);
		TableModelUtil.customizarTable(tableProdutos.getTableHeader());
		panelListaProdutos.add(tableProdutos);
		
		JScrollPane scrollPaneTableProdutos = new JScrollPane(tableProdutos);
		scrollPaneTableProdutos.setViewportBorder(null);
		scrollPaneTableProdutos.setBorder(null);
		panelProdutos.add(scrollPaneTableProdutos, BorderLayout.CENTER);
		
		JPanel panelAcoes = new JPanel();
		panelAcoes.setBackground(Color.WHITE);
		panelAcoes.setPreferredSize(new Dimension(10, 100));
		panelProdutos.add(panelAcoes, BorderLayout.SOUTH);
		
		JButton btnIncluirProduto = new JButton("Incluir novo");
		btnIncluirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modalProdutos = new ModalProdutos(produtosTableModel, null);

				ModalUtil.MovimentacaoModal(modalProdutos);
				modalProdutos.setLocationRelativeTo(null);
				modalProdutos.setVisible(true);
			}
		});
		btnIncluirProduto.setBorderPainted(false);
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
		btnIncluirProduto.setFocusable(false);
		btnIncluirProduto.setBorderPainted(false);
		btnIncluirProduto.setBackground(Color.WHITE);
		btnIncluirProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIncluirProduto.setFont(new Font("Leelawadee UI", Font.BOLD, 16));
		btnIncluirProduto.setPreferredSize(new Dimension(180, 40));
		btnIncluirProduto.setBorder(null);
		panelAcoes.add(btnIncluirProduto);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tableProdutos.getSelectedRow() != -1) {
					
					modalProdutos = new ModalProdutos(produtosTableModel, produtosTableModel.capturarProduto(tableProdutos.getSelectedRow()));

					ModalUtil.MovimentacaoModal(modalProdutos);
					modalProdutos.setLocationRelativeTo(null);
					modalProdutos.setVisible(true);
					
					tableProdutos.clearSelection();
				}
				else {
					
					modalAlerta = new ModalAlerta("Primeiro você deve selecionar um produto na tabela para editar!", ModalAlertaEnum.ALERTA);
					
					ModalUtil.MovimentacaoModal(modalAlerta);
					modalAlerta.setLocationRelativeTo(null);
					modalAlerta.setVisible(true);
				}
			}
		});
		btnEditar.setBorderPainted(false);
		btnEditar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnEditar.setForeground(Color.WHITE);
				btnEditar.setBackground(Color.GREEN);
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
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tableProdutos.getSelectedRow() != -1) {
					
					ModalDeletar modalDeletar = new ModalDeletar("Realmente deseja deletar esse produto?");
					ModalUtil.MovimentacaoModal(modalDeletar);
					modalDeletar.setLocationRelativeTo(null);
					modalDeletar.setVisible(true);
					
					if(modalDeletar.confirmacao()) {
						
						produto = produtosTableModel.capturarProduto(tableProdutos.getSelectedRow());
						produtosTableModel.deletarProduto(produto);
					}
					
					tableProdutos.clearSelection();
				}
				else {
					
					modalAlerta = new ModalAlerta("Primeiro você deve selecionar um produto na tabela para deletar!", ModalAlertaEnum.ALERTA);
					
					ModalUtil.MovimentacaoModal(modalAlerta);
					modalAlerta.setLocationRelativeTo(null);
					modalAlerta.setVisible(true);
				}
			}
		});
		btnDeletar.setBorderPainted(false);
		btnDeletar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnDeletar.setForeground(Color.WHITE);
				btnDeletar.setBackground(Color.RED);
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
