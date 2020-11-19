package views.internos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class ProdutosView extends TelaInternaCustom {

	private static final long serialVersionUID = 1L;
	private JTable table;

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
		
		JScrollPane scrollPane = new JScrollPane(panelProdutos);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		panelProdutos.setLayout(new BorderLayout(0, 0));
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setPreferredSize(new Dimension(43, 100));
		lblProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdutos.setFont(new Font("Leelawadee UI", Font.BOLD, 22));
		panelProdutos.add(lblProdutos, BorderLayout.NORTH);
		
		JPanel panelListaProdutos = new JPanel();
		panelProdutos.add(panelListaProdutos, BorderLayout.CENTER);
		
		table = new JTable();
		panelListaProdutos.add(table);
		
		JPanel panelAcoes = new JPanel();
		panelAcoes.setPreferredSize(new Dimension(10, 100));
		panelProdutos.add(panelAcoes, BorderLayout.SOUTH);
		
		JButton btnIncluirProduto = new JButton("Incluir novo");
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
