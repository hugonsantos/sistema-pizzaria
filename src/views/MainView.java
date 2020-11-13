package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JButton;

import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import views.internos.VenderView;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private static MainView frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new MainView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainView() {
		
		setMinimumSize(new Dimension(1024, 768));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTopo = new JPanel();
		panelTopo.setBackground(Color.DARK_GRAY);
		contentPane.add(panelTopo, BorderLayout.NORTH);
		panelTopo.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		JButton btnMinimizar = new JButton("-");
		btnMinimizar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnMinimizar.setBackground(new Color(173, 216, 230));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnMinimizar.setBackground(Color.DARK_GRAY);
			}
		});
		btnMinimizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setState(Frame.ICONIFIED);
			}
		});
		btnMinimizar.setFocusable(false);
		btnMinimizar.setForeground(Color.WHITE);
		btnMinimizar.setBackground(Color.DARK_GRAY);
		btnMinimizar.setPreferredSize(new Dimension(60, 28));
		btnMinimizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMinimizar.setBorder(null);
		btnMinimizar.setFont(new Font("Leelawadee", Font.BOLD, 24));
		btnMinimizar.setHorizontalTextPosition(SwingConstants.CENTER);
		panelTopo.add(btnMinimizar);
		
		JButton btnExit = new JButton("X");
		btnExit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {

				btnExit.setBackground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				btnExit.setBackground(Color.DARK_GRAY);
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnExit.setFocusable(false);
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setBorder(null);
		btnExit.setPreferredSize(new Dimension(60, 28));
		btnExit.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExit.setFont(new Font("Leelawadee", Font.BOLD, 20));
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelTopo.add(btnExit);
		
		JPanel panelLateral = new JPanel();
		panelLateral.setPreferredSize(new Dimension(250, 55));
		panelLateral.setBackground(Color.DARK_GRAY);
		panelLateral.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scroll = new JScrollPane(panelLateral);
		scroll.setBorder(null);
		contentPane.add(scroll, BorderLayout.WEST);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setFont(new Font("Leelawadee", Font.BOLD, 25));
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		panelLateral.add(lblMenu, BorderLayout.NORTH);
		
		JPanel panelGrid = new JPanel();
		panelGrid.setAutoscrolls(true);
		panelGrid.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelGrid.setForeground(Color.DARK_GRAY);
		panelGrid.setBackground(Color.DARK_GRAY);
		panelLateral.add(panelGrid, BorderLayout.CENTER);
		panelGrid.setLayout(new GridLayout(6, 1));
		
		//Linha 1 do GRID
		JPanel panelGridLinha1 = new JPanel();
		panelGridLinha1.setToolTipText("Tela para vender os produtos!");
		panelGridLinha1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelGridLinha1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				panelGridLinha1.setBackground(new Color(173, 216, 230));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				panelGridLinha1.setBackground(Color.DARK_GRAY);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				VenderView vender = new VenderView();
				contentPane.add(vender, BorderLayout.CENTER);
				vender.setVisible(true);
			}
		});
		panelGridLinha1.setBackground(Color.DARK_GRAY);
		panelGridLinha1.setFocusable(false);
		panelGrid.add(panelGridLinha1);
		panelGridLinha1.setLayout(new GridLayout(1, 2));
		
		JLabel lblIconVender = new JLabel("");
		lblIconVender.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblIconVender.setBorder(null);
		lblIconVender.setIcon(new ImageIcon(MainView.class.getResource("/imagens/carrinho-de-compras-64.png")));
		lblIconVender.setFocusable(false);
		lblIconVender.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGridLinha1.add(lblIconVender);
		
		JLabel lblVender = new JLabel("Vender");
		lblVender.setVerticalAlignment(SwingConstants.BOTTOM);
		lblVender.setBorder(new EmptyBorder(0, 0, 10, 15));
		lblVender.setForeground(Color.WHITE);
		lblVender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVender.setFont(new Font("Leelawadee", Font.BOLD, 16));
		panelGridLinha1.add(lblVender);
		
		//Linha 2 do GRID
		JPanel panelGridLinha2 = new JPanel();
		panelGridLinha2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelGridLinha2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				panelGridLinha2.setBackground(new Color(219, 112, 147));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				panelGridLinha2.setBackground(Color.DARK_GRAY);
			}
		});
		panelGridLinha2.setBackground(Color.DARK_GRAY);
		panelGridLinha2.setFocusable(false);
		panelGrid.add(panelGridLinha2);
		panelGridLinha2.setLayout(new GridLayout(1, 2));
		
		JLabel lblIconClientes = new JLabel("");
		lblIconClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIconClientes.setIcon(new ImageIcon(MainView.class.getResource("/imagens/cliente-64.png")));
		lblIconClientes.setFocusable(false);
		lblIconClientes.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGridLinha2.add(lblIconClientes);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setVerticalAlignment(SwingConstants.BOTTOM);
		lblClientes.setBorder(new EmptyBorder(0, 0, 10, 15));
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientes.setFont(new Font("Leelawadee", Font.BOLD, 16));
		panelGridLinha2.add(lblClientes);
		
		//Linha 3 do GRID
		JPanel panelGridLinha3 = new JPanel();
		panelGridLinha3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelGridLinha3.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				panelGridLinha3.setBackground(new Color(173, 216, 230));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				panelGridLinha3.setBackground(Color.DARK_GRAY);
			}
		});
		panelGridLinha3.setBackground(Color.DARK_GRAY);
		panelGridLinha3.setFocusable(false);
		panelGrid.add(panelGridLinha3);
		panelGridLinha3.setLayout(new GridLayout(1, 2));
		
		JLabel lblIconRelatorios = new JLabel("");
		lblIconRelatorios.setIcon(new ImageIcon(MainView.class.getResource("/imagens/grafico-de-barras-64.png")));
		lblIconRelatorios.setFocusable(false);
		lblIconRelatorios.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGridLinha3.add(lblIconRelatorios);
		
		JLabel lblRelatorios = new JLabel("Relatórios");
		lblRelatorios.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRelatorios.setBorder(new EmptyBorder(0, 0, 10, 15));
		lblRelatorios.setForeground(Color.WHITE);
		lblRelatorios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRelatorios.setFont(new Font("Leelawadee", Font.BOLD, 16));
		panelGridLinha3.add(lblRelatorios);
		
		//Linha 4 do GRID
		JPanel panelGridLinha4 = new JPanel();
		panelGridLinha4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelGridLinha4.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				panelGridLinha4.setBackground(new Color(219, 112, 147));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				panelGridLinha4.setBackground(Color.DARK_GRAY);
			}
		});
		panelGridLinha4.setBackground(Color.DARK_GRAY);
		panelGridLinha4.setFocusable(false);
		panelGrid.add(panelGridLinha4);
		panelGridLinha4.setLayout(new GridLayout(1, 2));
		
		JLabel lblIconFuncionarios = new JLabel("");
		lblIconFuncionarios.setIcon(new ImageIcon(MainView.class.getResource("/imagens/equipe-64.png")));
		lblIconFuncionarios.setFocusable(false);
		lblIconFuncionarios.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGridLinha4.add(lblIconFuncionarios);
		
		JLabel lblFuncionarios = new JLabel("Funcionários");
		lblFuncionarios.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFuncionarios.setBorder(new EmptyBorder(0, 0, 10, 15));
		lblFuncionarios.setForeground(Color.WHITE);
		lblFuncionarios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFuncionarios.setFont(new Font("Leelawadee", Font.BOLD, 16));
		panelGridLinha4.add(lblFuncionarios);
		
		//Linha 5 do GRID
		JPanel panelGridLinha5 = new JPanel();
		panelGridLinha5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelGridLinha5.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				panelGridLinha5.setBackground(new Color(173, 216, 230));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				panelGridLinha5.setBackground(Color.DARK_GRAY);
			}
		});
		panelGridLinha5.setBackground(Color.DARK_GRAY);
		panelGridLinha5.setFocusable(false);
		panelGrid.add(panelGridLinha5);
		panelGridLinha5.setLayout(new GridLayout(1, 2));
		
		JLabel lblIconEstoque = new JLabel("");
		lblIconEstoque.setIcon(new ImageIcon(MainView.class.getResource("/imagens/inventario-64.png")));
		lblIconEstoque.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIconEstoque.setFocusable(false);
		panelGridLinha5.add(lblIconEstoque);
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEstoque.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstoque.setForeground(Color.WHITE);
		lblEstoque.setFont(new Font("Leelawadee", Font.BOLD, 16));
		lblEstoque.setBorder(new EmptyBorder(0, 0, 10, 15));
		panelGridLinha5.add(lblEstoque);
		
		//Linha 6 do GRID
		JPanel panelGridLinha6 = new JPanel();
		panelGridLinha6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelGridLinha6.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				panelGridLinha6.setBackground(Color.BLACK);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				panelGridLinha6.setBackground(Color.DARK_GRAY);
			}
		});
		panelGridLinha6.setFocusable(false);
		panelGridLinha6.setBackground(Color.DARK_GRAY);
		panelGrid.add(panelGridLinha6);
		panelGridLinha6.setLayout(new GridLayout(1, 2));
		
		JLabel lblIconConfig = new JLabel("");
		lblIconConfig.setIcon(new ImageIcon(MainView.class.getResource("/imagens/configuracoes-64.png")));
		lblIconConfig.setFocusable(false);
		lblIconConfig.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGridLinha6.add(lblIconConfig);
		
		JLabel lblConfig = new JLabel("Configurações");
		lblConfig.setVerticalAlignment(SwingConstants.BOTTOM);
		lblConfig.setBorder(new EmptyBorder(0, 0, 10, 15));
		lblConfig.setForeground(Color.WHITE);
		lblConfig.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfig.setFont(new Font("Dialog", Font.BOLD, 14));
		panelGridLinha6.add(lblConfig);
	}
}
