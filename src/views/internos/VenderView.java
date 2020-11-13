package views.internos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import views.internos.produtos.PizzasView;

public class VenderView extends TelaInternaCustom {

	private static final long serialVersionUID = 1L;
	
	private static VenderView frame;
	private final ButtonGroup grupoBotoesLaterais = new ButtonGroup();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VenderView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VenderView() {
		
		JPanel panelCarrinho = new JPanel();
		panelCarrinho.setPreferredSize(new Dimension(250, 55));
		panelCarrinho.setBackground(Color.GRAY);
		this.getContentPane().add(panelCarrinho, BorderLayout.EAST);
		panelCarrinho.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCarrinho = new JLabel("Carrinho");
		lblCarrinho.setBorder(new EmptyBorder(8, 0, 8, 0));
		lblCarrinho.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarrinho.setFont(new Font("Leelawadee", Font.BOLD, 22));
		lblCarrinho.setForeground(Color.WHITE);
		panelCarrinho.add(lblCarrinho, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setPreferredSize(new Dimension(150, 70));
		panelCarrinho.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnFinalizarPedido = new JButton("Finalizar pedido");
		btnFinalizarPedido.setForeground(Color.WHITE);
		btnFinalizarPedido.setFont(new Font("Leelawadee", Font.BOLD, 16));
		btnFinalizarPedido.setContentAreaFilled(false);
		btnFinalizarPedido.setBackground(Color.WHITE);
		btnFinalizarPedido.setBorderPainted(false);
		btnFinalizarPedido.setFocusable(false);
		btnFinalizarPedido.setPreferredSize(new Dimension(150, 50));
		btnFinalizarPedido.setBorder(null);
		btnFinalizarPedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFinalizarPedido.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFinalizarPedido.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnFinalizarPedido);
		
		JPanel panelProdutos = new JPanel();
		getContentPane().add(panelProdutos, BorderLayout.CENTER);
		panelProdutos.setLayout(new BorderLayout(0, 0));
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setBorder(new EmptyBorder(10, 0, 10, 0));
		lblProdutos.setFont(new Font("Leelawadee", Font.BOLD, 22));
		lblProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		panelProdutos.add(lblProdutos, BorderLayout.NORTH);
		
		JPanel panelLateral = new JPanel();
		panelLateral.setFocusable(false);
		panelLateral.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelLateral.setPreferredSize(new Dimension(120, 0));
		panelLateral.setBackground(Color.GRAY);
		panelLateral.setLayout(new GridLayout(5, 1));
		
		JScrollPane scrollPane = new JScrollPane(panelLateral);
		scrollPane.setBorder(null);
		getContentPane().add(scrollPane, BorderLayout.WEST);
		
		JButton btnPizzas = new JButton("Pizzas");
		btnPizzas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PizzasView pizzas = new PizzasView();
				panelProdutos.add(pizzas);
				pizzas.setVisible(true);
			}
		});
		btnPizzas.setContentAreaFilled(false);
		grupoBotoesLaterais.add(btnPizzas);
		btnPizzas.setRolloverEnabled(false);
		btnPizzas.setRequestFocusEnabled(false);
		btnPizzas.setFocusTraversalKeysEnabled(false);
		btnPizzas.setFocusPainted(false);
		btnPizzas.setBorderPainted(false);
		btnPizzas.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				

				btnPizzas.setContentAreaFilled(true);
				btnPizzas.setForeground(Color.BLACK);
				btnPizzas.setBackground(Color.WHITE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnPizzas.setContentAreaFilled(false);
				btnPizzas.setForeground(Color.WHITE);
				btnPizzas.setBackground(Color.GRAY);
			}
		});
		btnPizzas.setForeground(Color.WHITE);
		btnPizzas.setFont(new Font("Leelawadee", Font.BOLD, 16));
		btnPizzas.setBackground(Color.GRAY);
		btnPizzas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPizzas.setFocusable(false);
		btnPizzas.setBorder(null);
		btnPizzas.setMargin(new Insets(0, 0, 0, 0));
		panelLateral.add(btnPizzas);
		
		JButton btnLanches = new JButton("Lanches");
		btnLanches.setContentAreaFilled(false);
		grupoBotoesLaterais.add(btnLanches);
		btnLanches.setBorderPainted(false);
		btnLanches.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnLanches.setForeground(Color.BLACK);
				btnLanches.setBackground(Color.WHITE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnLanches.setForeground(Color.WHITE);
				btnLanches.setBackground(Color.GRAY);
			}
		});
		btnLanches.setForeground(Color.WHITE);
		btnLanches.setFont(new Font("Leelawadee", Font.BOLD, 16));
		btnLanches.setBackground(Color.GRAY);
		btnLanches.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLanches.setFocusable(false);
		btnLanches.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnLanches.setMargin(new Insets(0, 0, 0, 0));
		panelLateral.add(btnLanches);
		
		JButton btnPorcoes = new JButton("Porções");
		btnPorcoes.setContentAreaFilled(false);
		grupoBotoesLaterais.add(btnPorcoes);
		btnPorcoes.setBorderPainted(false);
		btnPorcoes.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnPorcoes.setForeground(Color.BLACK);
				btnPorcoes.setBackground(Color.WHITE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnPorcoes.setForeground(Color.WHITE);
				btnPorcoes.setBackground(Color.GRAY);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
		});
		btnPorcoes.setForeground(Color.WHITE);
		btnPorcoes.setFont(new Font("Leelawadee", Font.BOLD, 16));
		btnPorcoes.setBackground(Color.GRAY);
		btnPorcoes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPorcoes.setFocusable(false);
		btnPorcoes.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnPorcoes.setMargin(new Insets(0, 0, 0, 0));
		panelLateral.add(btnPorcoes);
		
		JButton btnBebidas = new JButton("Bebidas");
		btnBebidas.setContentAreaFilled(false);
		grupoBotoesLaterais.add(btnBebidas);
		btnBebidas.setBorderPainted(false);
		btnBebidas.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnBebidas.setForeground(Color.BLACK);
				btnBebidas.setBackground(Color.WHITE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnBebidas.setForeground(Color.WHITE);
				btnBebidas.setBackground(Color.GRAY);
			}
		});
		btnBebidas.setForeground(Color.WHITE);
		btnBebidas.setFont(new Font("Leelawadee", Font.BOLD, 16));
		btnBebidas.setBackground(Color.GRAY);
		btnBebidas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBebidas.setFocusable(false);
		btnBebidas.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnBebidas.setMargin(new Insets(0, 0, 0, 0));
		panelLateral.add(btnBebidas);
	}
}
