package views.modal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.util.MainViewUtil;

public final class ModalAlerta extends ModalCustom {

	private static final long serialVersionUID = 1L;
	
	private MainViewUtil mainUtil = new MainViewUtil();
	
	private MouseListener btnOkML;
	
	public ModalAlerta( String textoAlerta, Integer tipo) {

		setBounds(100, 100, 700, 300);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIcon.setPreferredSize(new Dimension(150, 0));
		lblIcon.setIcon(new ImageIcon(ModalAlerta.class.getResource("/imagens/alerta-64.png")));
		getContentPane().add(lblIcon, BorderLayout.WEST);
		
		JLabel lblAlerta = new JLabel(textoAlerta);
		lblAlerta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlerta.setBorder(null);
		lblAlerta.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
		getContentPane().add(lblAlerta, BorderLayout.CENTER);
		
		JPanel panelAcoes = new JPanel();
		panelAcoes.setBorder(null);
		panelAcoes.setBackground(Color.DARK_GRAY);
		panelAcoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelAcoes, BorderLayout.SOUTH);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnOkML = mainUtil.adicionarAcaoMouse(btnOk, Color.DARK_GRAY, new Color(173, 216, 230));
		btnOk.addMouseListener(btnOkML);
		btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOk.setMargin(new Insets(0, 0, 0, 0));
		btnOk.setFocusable(false);
		btnOk.setFont(new Font("Leelawadee", Font.BOLD, 12));
		btnOk.setForeground(Color.WHITE);
		btnOk.setBackground(Color.DARK_GRAY);
		btnOk.setPreferredSize(new Dimension(70, 23));
		btnOk.setBorder(null);
		btnOk.setActionCommand("OK");
		panelAcoes.add(btnOk);
		getRootPane().setDefaultButton(btnOk);
	}
}