package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.dao.FabricaDao;
import model.dao.LoginDao;
import model.entities.Funcionario;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField ptxtSenha;
	
	private static LoginView frame;
	private static Point point = new Point();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new LoginView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
					frame.addMouseListener(new MouseAdapter() {
						
						@Override
						public void mousePressed(MouseEvent e) {
							point.x = e.getX();
							point.y = e.getY();
						}
					});

					frame.addMouseMotionListener(new MouseMotionAdapter() {
						
						@Override
						public void mouseDragged(MouseEvent e) {
							Point p = frame.getLocation();
							frame.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginView() {
		
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1137, 600);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelImagem = new JPanel();
		panelImagem.setBounds(0, 0, 725, 600);
		contentPane.add(panelImagem);
		panelImagem.setLayout(null);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setIconTextGap(2);
		lblImagem.setHorizontalTextPosition(SwingConstants.CENTER);
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setIcon(new ImageIcon(LoginView.class.getResource("/imagens/login.gif")));
		lblImagem.setBounds(0, 0, 725, 600);
		panelImagem.add(lblImagem);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Leelawadee", Font.BOLD, 27));
		lblLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(735, 102, 392, 60);
		contentPane.add(lblLogin);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		lblUsuario.setFont(new Font("Leelawadee", Font.PLAIN, 18));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(765, 189, 73, 28);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Leelawadee", Font.PLAIN, 18));
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(765, 307, 62, 28);
		contentPane.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Leelawadee", Font.PLAIN, 18));
		txtUsuario.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtUsuario.setBounds(765, 228, 335, 38);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		ptxtSenha = new JPasswordField();
		ptxtSenha.setFont(new Font("Leelawadee", Font.PLAIN, 18));
		ptxtSenha.setBorder(new EmptyBorder(0, 0, 0, 0));
		ptxtSenha.setBounds(765, 346, 335, 38);
		contentPane.add(ptxtSenha);
		
		JLabel lblExit = new JLabel("X");
		lblExit.setHorizontalTextPosition(SwingConstants.CENTER);
		lblExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblExit.setOpaque(true);
		lblExit.setBackground(Color.DARK_GRAY);
		lblExit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblExit.setBackground(Color.RED);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				lblExit.setBackground(Color.DARK_GRAY);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0);
			}
		});
		lblExit.setForeground(Color.WHITE);
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblExit.setBounds(1075, 0, 62, 28);
		contentPane.add(lblExit);
		
		JButton btnLogin = new JButton("Logar");
		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Funcionario funcionario = new Funcionario();
				LoginDao loginDao = FabricaDao.createLoginDao();
				
				funcionario.setApelido(txtUsuario.getText());
				funcionario.setSenha(String.copyValueOf(ptxtSenha.getPassword()));
				
				Boolean autenticacao = loginDao.AutenticacaoLogin(funcionario);
				
				if(autenticacao.booleanValue() == true) {
					
					MainView frame = new MainView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
					dispose();
				}
				else {
					
					System.out.println("O usuário ou a senha digitada não confere, por favor verifique o que foi digitado!");
				}
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnLogin.setBackground(Color.GREEN);
				btnLogin.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnLogin.setBackground(Color.WHITE);
				btnLogin.setForeground(Color.BLACK);
			}
		});
		btnLogin.setFocusable(false);
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setBorder(null);
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogin.setFont(new Font("Leelawadee", Font.BOLD, 18));
		btnLogin.setBounds(871, 461, 130, 47);
		contentPane.add(btnLogin);
		
		JLabel lblRedefinirSenha = new JLabel("Esqueceu a senha? Clique aqui");
		lblRedefinirSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblRedefinirSenha.setForeground(new java.awt.Color(135, 206, 250));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				lblRedefinirSenha.setForeground(Color.WHITE);
			}
		});
		lblRedefinirSenha.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRedefinirSenha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRedefinirSenha.setForeground(Color.WHITE);
		lblRedefinirSenha.setFont(new Font("Leelawadee", Font.BOLD, 12));
		lblRedefinirSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblRedefinirSenha.setBounds(846, 548, 181, 20);
		contentPane.add(lblRedefinirSenha);
	}
}
