package views.internos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vender extends TelaInternaCustom {

	private static final long serialVersionUID = 1L;
	
	private static Vender frame;
	private final ButtonGroup grupoBotoesLaterais = new ButtonGroup();
	private final ButtonGroup grupoTamanhos = new ButtonGroup();
	private final ButtonGroup grupoQTDSabores = new ButtonGroup();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Vender();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Vender() {
		
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
		
		JPanel panelPizzas = new JPanel();
		panelProdutos.add(panelPizzas, BorderLayout.CENTER);
		panelPizzas.setLayout(new BoxLayout(panelPizzas, BoxLayout.Y_AXIS));
		
		JPanel panelTamanho = new JPanel();
		panelTamanho.setPreferredSize(new Dimension(10, 120));
		panelTamanho.setBorder(new EmptyBorder(20, 0, 20, 0));
		panelPizzas.add(panelTamanho);
		panelTamanho.setLayout(new BoxLayout(panelTamanho, BoxLayout.X_AXIS));
		
		JRadioButton rdbtnBroto = new JRadioButton("Broto");
		rdbtnBroto.setContentAreaFilled(false);
		grupoTamanhos.add(rdbtnBroto);
		rdbtnBroto.setFocusable(false);
		rdbtnBroto.setBorder(new EmptyBorder(0, 0, 0, 60));
		rdbtnBroto.setFont(new Font("Leelawadee", Font.BOLD, 19));
		panelTamanho.add(rdbtnBroto);
		
		JRadioButton rdbtnTradicional = new JRadioButton("Tradicional");
		rdbtnTradicional.setContentAreaFilled(false);
		grupoTamanhos.add(rdbtnTradicional);
		rdbtnTradicional.setFocusable(false);
		rdbtnTradicional.setBorder(new EmptyBorder(0, 60, 0, 60));
		rdbtnTradicional.setFont(new Font("Leelawadee", Font.BOLD, 19));
		panelTamanho.add(rdbtnTradicional);
		
		JRadioButton rdbtnGrande = new JRadioButton("Grande");
		rdbtnGrande.setContentAreaFilled(false);
		grupoTamanhos.add(rdbtnGrande);
		rdbtnGrande.setFocusable(false);
		rdbtnGrande.setBorder(new EmptyBorder(0, 60, 0, 0));
		rdbtnGrande.setFont(new Font("Leelawadee", Font.BOLD, 19));
		panelTamanho.add(rdbtnGrande);
		
		JPanel panelQTDSabores = new JPanel();
		panelQTDSabores.setPreferredSize(new Dimension(10, 120));
		panelQTDSabores.setBorder(new EmptyBorder(20, 0, 20, 0));
		panelPizzas.add(panelQTDSabores);
		
		JLabel lblSelecionarSabores = new JLabel("Selecione o(s) sabor(es):");
		lblSelecionarSabores.setFont(new Font("Leelawadee", Font.BOLD, 19));
		lblSelecionarSabores.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecionarSabores.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelPizzas.add(lblSelecionarSabores);
		
		JPanel panelSelecionarSabor = new JPanel();
		panelSelecionarSabor.setPreferredSize(new Dimension(10, 500));
		panelPizzas.add(panelSelecionarSabor);
		panelSelecionarSabor.setLayout(new GridLayout(1, 4));
		
		JLabel lblSabor1 = new JLabel("Primeiro sabor");
		lblSabor1.setIconTextGap(20);
		lblSabor1.setIcon(new ImageIcon(Vender.class.getResource("/imagens/pizza-64.png")));
		lblSabor1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSabor1.setFont(new Font("Leelawadee", Font.BOLD, 16));
		
		JLabel lblSabor2 = new JLabel("Segundo sabor");
		lblSabor2.setIconTextGap(20);
		lblSabor2.setIcon(new ImageIcon(Vender.class.getResource("/imagens/pizza-64.png")));
		lblSabor2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSabor2.setFont(new Font("Leelawadee", Font.BOLD, 16));
		
		JLabel lblSabor3 = new JLabel("Terceiro sabor");
		lblSabor3.setIconTextGap(20);
		lblSabor3.setIcon(new ImageIcon(Vender.class.getResource("/imagens/pizza-64.png")));
		lblSabor3.setHorizontalAlignment(SwingConstants.CENTER);
		lblSabor3.setFont(new Font("Leelawadee", Font.BOLD, 16));
		
		JLabel lblSabor4 = new JLabel("Quarto sabor");
		lblSabor4.setIconTextGap(20);
		lblSabor4.setIcon(new ImageIcon(Vender.class.getResource("/imagens/pizza-64.png")));
		lblSabor4.setHorizontalAlignment(SwingConstants.CENTER);
		lblSabor4.setFont(new Font("Leelawadee", Font.BOLD, 16));
		
		JRadioButton rdbtnUmSabor = new JRadioButton("1 Sabor");
		rdbtnUmSabor.setContentAreaFilled(false);
		rdbtnUmSabor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelSelecionarSabor.removeAll();
				JLabel lblSabor1 = new JLabel("Sabor");
				lblSabor1.setIconTextGap(20);
				lblSabor1.setIcon(new ImageIcon(Vender.class.getResource("/imagens/pizza-64.png")));
				lblSabor1.setHorizontalAlignment(SwingConstants.CENTER);
				lblSabor1.setFont(new Font("Leelawadee", Font.BOLD, 16));
				panelSelecionarSabor.add(lblSabor1);
				panelSelecionarSabor.repaint();
				panelSelecionarSabor.validate();
			}
		});
		grupoQTDSabores.add(rdbtnUmSabor);
		rdbtnUmSabor.setFocusable(false);
		rdbtnUmSabor.setAlignmentX(Component.CENTER_ALIGNMENT);
		rdbtnUmSabor.setBorder(new EmptyBorder(0, 0, 0, 30));
		rdbtnUmSabor.setFont(new Font("Leelawadee", Font.BOLD, 19));
		panelQTDSabores.setLayout(new BoxLayout(panelQTDSabores, BoxLayout.X_AXIS));
		panelQTDSabores.add(rdbtnUmSabor);
		
		JRadioButton rdbtnDoisSabores = new JRadioButton("2 Sabores");
		rdbtnDoisSabores.setContentAreaFilled(false);
		rdbtnDoisSabores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelSelecionarSabor.removeAll();
				panelSelecionarSabor.add(lblSabor1);
				panelSelecionarSabor.add(lblSabor2);
				panelSelecionarSabor.repaint();
				panelSelecionarSabor.validate();
			}
		});
		grupoQTDSabores.add(rdbtnDoisSabores);
		rdbtnDoisSabores.setFocusable(false);
		rdbtnDoisSabores.setBorder(new EmptyBorder(0, 30, 0, 30));
		rdbtnDoisSabores.setFont(new Font("Leelawadee", Font.BOLD, 19));
		panelQTDSabores.add(rdbtnDoisSabores);
		
		JRadioButton rdbtnTresSabores = new JRadioButton("3 Sabores");
		rdbtnTresSabores.setContentAreaFilled(false);
		rdbtnTresSabores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelSelecionarSabor.removeAll();
				panelSelecionarSabor.add(lblSabor1);
				panelSelecionarSabor.add(lblSabor2);
				panelSelecionarSabor.add(lblSabor3);
				panelSelecionarSabor.repaint();
				panelSelecionarSabor.validate();
			}
		});
		grupoQTDSabores.add(rdbtnTresSabores);
		rdbtnTresSabores.setFocusable(false);
		rdbtnTresSabores.setBorder(new EmptyBorder(0, 30, 0, 30));
		rdbtnTresSabores.setFont(new Font("Leelawadee", Font.BOLD, 19));
		panelQTDSabores.add(rdbtnTresSabores);
		
		JRadioButton rdbtnQuatroSabores = new JRadioButton("4 Sabores");
		rdbtnQuatroSabores.setContentAreaFilled(false);
		rdbtnQuatroSabores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelSelecionarSabor.removeAll();
				panelSelecionarSabor.add(lblSabor1);
				panelSelecionarSabor.add(lblSabor2);
				panelSelecionarSabor.add(lblSabor3);
				panelSelecionarSabor.add(lblSabor4);
				panelSelecionarSabor.repaint();
				panelSelecionarSabor.validate();
			}
		});
		grupoQTDSabores.add(rdbtnQuatroSabores);
		rdbtnQuatroSabores.setFont(new Font("Leelawadee", Font.BOLD, 19));
		rdbtnQuatroSabores.setFocusable(false);
		rdbtnQuatroSabores.setBorder(new EmptyBorder(0, 30, 0, 0));
		panelQTDSabores.add(rdbtnQuatroSabores);
			
		JPanel panelOutros = new JPanel();
		panelOutros.setPreferredSize(new Dimension(10, 200));
		panelProdutos.add(panelOutros, BorderLayout.SOUTH);
		panelOutros.setLayout(new BoxLayout(panelOutros, BoxLayout.X_AXIS));
	}
}
