package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import javax.swing.plaf.basic.BasicInternalFrameUI;

import views.internos.Teste;

import java.awt.Component;
import javax.swing.JInternalFrame;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private static Main frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new Main();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		
		setMinimumSize(new Dimension(1024, 768));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
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
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
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
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
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
		panelLateral.setBackground(Color.DARK_GRAY);
		contentPane.add(panelLateral, BorderLayout.WEST);
		panelLateral.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setFont(new Font("Leelawadee", Font.BOLD, 25));
		lblMenu.setPreferredSize(new Dimension(300, 55));
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		panelLateral.add(lblMenu, BorderLayout.NORTH);
		
		JPanel panelGrid = new JPanel();
		panelGrid.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelGrid.setForeground(Color.DARK_GRAY);
		panelGrid.setBackground(Color.DARK_GRAY);
		panelLateral.add(panelGrid, BorderLayout.CENTER);
		panelGrid.setLayout(new GridLayout(5, 1));
		
		//Linha 1 do GRID
		JPanel panelGridLinha1 = new JPanel();
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
				
				JInternalFrame teste = telaInterna(new JInternalFrame());
				teste.add(new Teste());
				contentPane.add(teste, BorderLayout.CENTER);
				teste.setVisible(true);
			}
		});
		panelGridLinha1.setBackground(Color.DARK_GRAY);
		panelGridLinha1.setFocusable(false);
		panelGrid.add(panelGridLinha1);
		panelGridLinha1.setLayout(null);
		
		JLabel lblIconVender = new JLabel("");
		lblIconVender.setBorder(null);
		lblIconVender.setIcon(new ImageIcon(Main.class.getResource("/imagens/carrinho-de-compras-64.png")));
		lblIconVender.setFocusable(false);
		lblIconVender.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconVender.setBounds(0, 0, 300, 199);
		panelGridLinha1.add(lblIconVender);
		
		JLabel lblVender = new JLabel("Vender");
		lblVender.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblVender.setBackground(Color.WHITE);
		lblVender.setBorder(new EmptyBorder(0, 0, 0, 15));
		lblVender.setForeground(Color.WHITE);
		lblVender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVender.setFont(new Font("Leelawadee", Font.BOLD, 16));
		lblVender.setBounds(0, 163, 300, 36);
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
		panelGridLinha2.setLayout(null);
		
		JLabel lblIconClientes = new JLabel("");
		lblIconClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIconClientes.setIcon(new ImageIcon(Main.class.getResource("/imagens/cliente-64.png")));
		lblIconClientes.setFocusable(false);
		lblIconClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconClientes.setBounds(0, 0, 300, 199);
		panelGridLinha2.add(lblIconClientes);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBorder(new EmptyBorder(0, 0, 0, 15));
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientes.setFont(new Font("Leelawadee", Font.BOLD, 16));
		lblClientes.setBounds(0, 163, 300, 36);
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
		panelGridLinha3.setLayout(null);
		
		JLabel lblIconRelatorios = new JLabel("");
		lblIconRelatorios.setIcon(new ImageIcon(Main.class.getResource("/imagens/grafico-de-barras-64.png")));
		lblIconRelatorios.setFocusable(false);
		lblIconRelatorios.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconRelatorios.setBounds(0, 0, 300, 199);
		panelGridLinha3.add(lblIconRelatorios);
		
		JLabel lblRelatorios = new JLabel("Relatórios");
		lblRelatorios.setBorder(new EmptyBorder(0, 0, 0, 15));
		lblRelatorios.setForeground(Color.WHITE);
		lblRelatorios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRelatorios.setFont(new Font("Leelawadee", Font.BOLD, 16));
		lblRelatorios.setBounds(0, 163, 300, 36);
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
		panelGridLinha4.setLayout(null);
		
		JLabel lblIconFuncionarios = new JLabel("");
		lblIconFuncionarios.setIcon(new ImageIcon(Main.class.getResource("/imagens/equipe-64.png")));
		lblIconFuncionarios.setFocusable(false);
		lblIconFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconFuncionarios.setBounds(0, 0, 300, 199);
		panelGridLinha4.add(lblIconFuncionarios);
		
		JLabel lblFuncionarios = new JLabel("Funcionários");
		lblFuncionarios.setBorder(new EmptyBorder(0, 0, 0, 15));
		lblFuncionarios.setForeground(Color.WHITE);
		lblFuncionarios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFuncionarios.setFont(new Font("Leelawadee", Font.BOLD, 16));
		lblFuncionarios.setBounds(0, 163, 300, 36);
		panelGridLinha4.add(lblFuncionarios);
		
		//Linha 5 do GRID
		JPanel panelGridLinha5 = new JPanel();
		panelGridLinha5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelGridLinha5.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				panelGridLinha5.setBackground(Color.BLACK);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				panelGridLinha5.setBackground(Color.DARK_GRAY);
			}
		});
		panelGridLinha5.setBackground(Color.DARK_GRAY);
		panelGridLinha5.setFocusable(false);
		panelGrid.add(panelGridLinha5);
		panelGridLinha5.setLayout(null);
		
		JLabel lblIconConfig = new JLabel("");
		lblIconConfig.setIcon(new ImageIcon(Main.class.getResource("/imagens/configuracoes-64.png")));
		lblIconConfig.setFocusable(false);
		lblIconConfig.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconConfig.setBounds(0, 0, 300, 199);
		panelGridLinha5.add(lblIconConfig);
		
		JLabel lblConfig = new JLabel("Configurações");
		lblConfig.setBorder(new EmptyBorder(0, 0, 0, 15));
		lblConfig.setForeground(Color.WHITE);
		lblConfig.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfig.setFont(new Font("Leelawadee", Font.BOLD, 16));
		lblConfig.setBounds(0, 163, 300, 36);
		panelGridLinha5.add(lblConfig);
	}
	
	public JInternalFrame telaInterna(JInternalFrame internalFrame) {
		
		internalFrame = new JInternalFrame();
		BasicInternalFrameUI basicUI = (BasicInternalFrameUI) internalFrame.getUI();
		basicUI.setNorthPane(null);
		internalFrame.setBorder(null);
		
		JPanel jifPanelTopo = new JPanel();
		jifPanelTopo.setPreferredSize(new Dimension(10, 25));
		jifPanelTopo.setBackground(Color.GRAY);
		internalFrame.getContentPane().add(jifPanelTopo, BorderLayout.NORTH);
		
		return internalFrame;
	}
}
