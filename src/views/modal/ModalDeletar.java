package views.modal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.util.MainViewUtil;

public final class ModalDeletar extends ModalCustom {

	private static final long serialVersionUID = 1L;
	
	private MainViewUtil mainUtil = new MainViewUtil();
	
	private MouseListener btnOkML;
	private MouseListener btnCancelarML;
	
	public ModalDeletar(Integer linha, String textoConfirmacao) {

		setBounds(100, 100, 700, 300);
		
		JLabel lblConfirmacao = new JLabel(textoConfirmacao);
		lblConfirmacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmacao.setFont(new Font("Leelawadee UI", Font.BOLD, 16));
		getContentPane().add(lblConfirmacao, BorderLayout.CENTER);
		
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
		btnCancelarML = mainUtil.adicionarAcaoMouse(btnOk, Color.WHITE, new Color(173, 216, 230));
		btnOk.addMouseListener(btnCancelarML);
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

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnOkML = mainUtil.adicionarAcaoMouse(btnCancelar, Color.WHITE, Color.RED);
		btnCancelar.addMouseListener(btnOkML);
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCancelar.setMargin(new Insets(0, 0, 0, 0));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Leelawadee", Font.BOLD, 12));
		btnCancelar.setFocusable(false);
		btnCancelar.setBackground(Color.DARK_GRAY);
		btnCancelar.setPreferredSize(new Dimension(70, 23));
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		panelAcoes.add(btnCancelar);
	}
}
