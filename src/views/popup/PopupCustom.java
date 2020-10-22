package views.popup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Component;

public abstract class PopupCustom extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	public PopupCustom() {
		
		setUndecorated(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.SOUTH);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(null);
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSelecionar = new JButton("Selecionar");
				btnSelecionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnSelecionar.setMargin(new Insets(0, 0, 0, 0));
				btnSelecionar.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseEntered(MouseEvent e) {
						
						btnSelecionar.setBackground(new Color(173, 216, 230));
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						
						btnSelecionar.setBackground(Color.DARK_GRAY);
					}
				});
				btnSelecionar.setFocusable(false);
				btnSelecionar.setFont(new Font("Leelawadee", Font.BOLD, 12));
				btnSelecionar.setForeground(Color.WHITE);
				btnSelecionar.setBackground(Color.DARK_GRAY);
				btnSelecionar.setPreferredSize(new Dimension(70, 23));
				btnSelecionar.setBorder(null);
				btnSelecionar.setActionCommand("OK");
				buttonPane.add(btnSelecionar);
				getRootPane().setDefaultButton(btnSelecionar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnCancelar.setAlignmentX(Component.CENTER_ALIGNMENT);
				btnCancelar.setMargin(new Insets(0, 0, 0, 0));
				btnCancelar.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseEntered(MouseEvent e) {
						
						btnCancelar.setBackground(Color.RED);
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						
						btnCancelar.setBackground(Color.DARK_GRAY);
					}
				});
				btnCancelar.setForeground(Color.WHITE);
				btnCancelar.setFont(new Font("Leelawadee", Font.BOLD, 12));
				btnCancelar.setFocusable(false);
				btnCancelar.setBackground(Color.DARK_GRAY);
				btnCancelar.setPreferredSize(new Dimension(70, 23));
				btnCancelar.setBorderPainted(false);
				btnCancelar.setBorder(null);
				buttonPane.add(btnCancelar);
			}
		}
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTopo = new JPanel();
		panelTopo.setBackground(Color.DARK_GRAY);
		getContentPane().add(panelTopo, BorderLayout.NORTH);
		panelTopo.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
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
				
				dispose();
			}
		});
		btnExit.setFocusable(false);
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setBorder(null);
		btnExit.setPreferredSize(new Dimension(50, 28));
		btnExit.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExit.setFont(new Font("Leelawadee", Font.BOLD, 14));
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelTopo.add(btnExit);
	}
}
