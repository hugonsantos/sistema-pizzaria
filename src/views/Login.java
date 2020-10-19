package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passSenha;
	
	private static Login frame;
	private static Point point = new Point();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new Login();
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

	public Login() {
		
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
		lblImagem.setIcon(new ImageIcon(Login.class.getResource("/imagens/preparo.gif")));
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
		
		passSenha = new JPasswordField();
		passSenha.setFont(new Font("Leelawadee", Font.PLAIN, 18));
		passSenha.setBorder(new EmptyBorder(0, 0, 0, 0));
		passSenha.setBounds(765, 346, 335, 38);
		contentPane.add(passSenha);
		
		JLabel lblExit = new JLabel("X");
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
		lblExit.setFont(new Font("Leelawadee", Font.BOLD, 24));
		lblExit.setBounds(1054, 11, 73, 28);
		contentPane.add(lblExit);
		
		JButton btnLogin = new JButton("Logar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
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
