package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.util.ImagensUtil;
import views.internos.ClientesView;
import views.internos.FuncionariosView;
import views.internos.ProdutosView;
import views.internos.VenderView;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panelLateral;
	private JLabel lblIconVender;
	private JLabel lblVender;
	private JLabel lblIconClientes;
	private JLabel lblClientes;
	private JLabel lblIconRelatorios;
	private JLabel lblRelatorios;
	private JLabel lblIconFuncionarios;
	private JLabel lblFuncionarios;
	private JLabel lblIconProdutos;
	private JLabel lblProdutos;

	private static MainView frame;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				try {

					frame = new MainView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);

				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}	
		});
	}

	public MainView() {

		setMinimumSize(new Dimension(1024, 768));
		/* setExtendedState(JFrame.MAXIMIZED_BOTH); */
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
		btnMinimizar.addActionListener(e -> frame.setState(Frame.ICONIFIED));
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
			@Override
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

		JPanel panelViewsInternas = new JPanel();
		contentPane.add(panelViewsInternas, BorderLayout.CENTER);
		panelViewsInternas.setLayout(new BorderLayout(0, 0));

		panelLateral = new JPanel();
		panelLateral.setPreferredSize(new Dimension(200, 55));
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

		// Linha 1 do GRID
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
			public void mousePressed(MouseEvent e) {

				panelViewsInternas.removeAll();
				
				VenderView vender = new VenderView();
				
				panelViewsInternas.add(vender, BorderLayout.CENTER);
				vender.setVisible(true);

				panelViewsInternas.repaint();
				panelViewsInternas.validate();
			}
		});
		panelGridLinha1.setBackground(Color.DARK_GRAY);
		panelGridLinha1.setFocusable(false);
		panelGrid.add(panelGridLinha1);
		panelGridLinha1.setLayout(new GridLayout(1, 2));

		lblIconVender = new JLabel("");
		lblIconVender.setBorder(null);
		lblIconVender.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(getClass().getResource("/imagens/carrinho-de-compras-64.png")), 48, 48));
		lblIconVender.setFocusable(false);
		lblIconVender.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGridLinha1.add(lblIconVender);

		lblVender = new JLabel("Vender");
		lblVender.setVerticalAlignment(SwingConstants.BOTTOM);
		lblVender.setBorder(new EmptyBorder(0, 0, 10, 15));
		lblVender.setForeground(Color.WHITE);
		lblVender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVender.setFont(new Font("Leelawadee", Font.BOLD, 14));
		panelGridLinha1.add(lblVender);

		// Linha 2 do GRID
		JPanel panelGridLinha2 = new JPanel();
		panelGridLinha2.setToolTipText("Lista de todos os cliente cadastrados.");
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
			
			@Override
			public void mousePressed(MouseEvent e) {

				panelViewsInternas.removeAll();

				ClientesView clientes = new ClientesView();

				panelViewsInternas.add(clientes, BorderLayout.CENTER);
				clientes.setVisible(true);

				panelViewsInternas.repaint();
				panelViewsInternas.validate();
			}
		});
		panelGridLinha2.setBackground(Color.DARK_GRAY);
		panelGridLinha2.setFocusable(false);
		panelGrid.add(panelGridLinha2);
		panelGridLinha2.setLayout(new GridLayout(1, 2));

		lblIconClientes = new JLabel("");
		lblIconClientes.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(getClass().getResource("/imagens/cliente-64.png")), 48, 48));
		lblIconClientes.setFocusable(false);
		lblIconClientes.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGridLinha2.add(lblIconClientes);

		lblClientes = new JLabel("Clientes");
		lblClientes.setVerticalAlignment(SwingConstants.BOTTOM);
		lblClientes.setBorder(new EmptyBorder(0, 0, 10, 15));
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientes.setFont(new Font("Leelawadee", Font.BOLD, 14));
		panelGridLinha2.add(lblClientes);

		// Linha 3 do GRID
		JPanel panelGridLinha3 = new JPanel();
		panelGridLinha3.setToolTipText("Gere seus relatórios e fique por dentro das suas vendas!");
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

		lblIconRelatorios = new JLabel("");
		lblIconRelatorios.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(getClass().getResource("/imagens/grafico-de-barras-64.png")), 48, 48));
		lblIconRelatorios.setFocusable(false);
		lblIconRelatorios.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGridLinha3.add(lblIconRelatorios);

		lblRelatorios = new JLabel("Relatórios");
		lblRelatorios.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRelatorios.setBorder(new EmptyBorder(0, 0, 10, 15));
		lblRelatorios.setForeground(Color.WHITE);
		lblRelatorios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRelatorios.setFont(new Font("Leelawadee", Font.BOLD, 14));
		panelGridLinha3.add(lblRelatorios);

		// Linha 4 do GRID
		JPanel panelGridLinha4 = new JPanel();
		panelGridLinha4.setToolTipText("Lista de todos os funcionários cadastrados.");
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

			@Override
			public void mousePressed(MouseEvent e) {

				panelViewsInternas.removeAll();

				FuncionariosView funcionarios = new FuncionariosView();

				panelViewsInternas.add(funcionarios, BorderLayout.CENTER);
				funcionarios.setVisible(true);

				panelViewsInternas.repaint();
				panelViewsInternas.validate();
			}
		});
		panelGridLinha4.setBackground(Color.DARK_GRAY);
		panelGridLinha4.setFocusable(false);
		panelGrid.add(panelGridLinha4);
		panelGridLinha4.setLayout(new GridLayout(1, 2));

		lblIconFuncionarios = new JLabel("");
		lblIconFuncionarios.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(getClass().getResource("/imagens/equipe-64.png")), 48, 48));
		lblIconFuncionarios.setFocusable(false);
		lblIconFuncionarios.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGridLinha4.add(lblIconFuncionarios);

		lblFuncionarios = new JLabel("Funcionários");
		lblFuncionarios.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFuncionarios.setBorder(new EmptyBorder(0, 0, 10, 15));
		lblFuncionarios.setForeground(Color.WHITE);
		lblFuncionarios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFuncionarios.setFont(new Font("Leelawadee", Font.BOLD, 14));
		panelGridLinha4.add(lblFuncionarios);

		// Linha 5 do GRID
		JPanel panelGridLinha5 = new JPanel();
		panelGridLinha5.setToolTipText("Lista de todos os produtos cadastrados.");
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

			@Override
			public void mousePressed(MouseEvent e) {

				panelViewsInternas.removeAll();

				ProdutosView produtos = new ProdutosView();
				
				panelViewsInternas.add(produtos, BorderLayout.CENTER);
				produtos.setVisible(true);

				panelViewsInternas.repaint();
				panelViewsInternas.validate();
			}
		});
		panelGridLinha5.setBackground(Color.DARK_GRAY);
		panelGridLinha5.setFocusable(false);
		panelGrid.add(panelGridLinha5);
		panelGridLinha5.setLayout(new GridLayout(1, 2));

		lblIconProdutos = new JLabel("");
		lblIconProdutos.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(getClass().getResource("/imagens/inventario-64.png")), 48, 48));
		lblIconProdutos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIconProdutos.setFocusable(false);
		panelGridLinha5.add(lblIconProdutos);

		lblProdutos = new JLabel("Produtos");
		lblProdutos.setVerticalAlignment(SwingConstants.BOTTOM);
		lblProdutos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProdutos.setForeground(Color.WHITE);
		lblProdutos.setFont(new Font("Leelawadee", Font.BOLD, 14));
		lblProdutos.setBorder(new EmptyBorder(0, 0, 10, 15));
		panelGridLinha5.add(lblProdutos);
		
		Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
		
		if(1200 < 1366) {
			
			panelLateral.setPreferredSize(new Dimension(80, 55));
			
			panelGridLinha1.remove(lblVender);
			lblIconVender.setHorizontalAlignment(SwingConstants.CENTER);
			panelGridLinha2.remove(lblClientes);
			lblIconClientes.setHorizontalAlignment(SwingConstants.CENTER);
			panelGridLinha3.remove(lblRelatorios);
			lblIconRelatorios.setHorizontalAlignment(SwingConstants.CENTER);
			panelGridLinha4.remove(lblFuncionarios);
			lblIconFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
			panelGridLinha5.remove(lblProdutos);
			lblIconProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
}
