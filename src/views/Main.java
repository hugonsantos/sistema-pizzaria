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
import java.awt.Component;

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
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		setPreferredSize(new Dimension(70, 30));
		
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
		btnExit.setFont(new Font("Leelawadee", Font.BOLD, 24));
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelTopo.add(btnExit);
		
		JPanel panelLateral = new JPanel();
		panelLateral.setBackground(Color.DARK_GRAY);
		contentPane.add(panelLateral, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setPreferredSize(new Dimension(350, 50));
		panelLateral.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panelLateral.add(panel);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setAlignmentY(Component.TOP_ALIGNMENT);
		lblMenu.setBorder(null);
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMenu.setIconTextGap(0);
		lblMenu.setPreferredSize(new Dimension(350, 50));
		lblMenu.setFont(new Font("Leelawadee", Font.BOLD, 35));
		panel.add(lblMenu);
	}
}
