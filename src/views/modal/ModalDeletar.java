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

import model.util.ViewsUtil;

public final class ModalDeletar extends ModalCustom {

	private static final long serialVersionUID = 1L;
	
	private MouseListener btnSimML;
	private MouseListener btnNaoML;
	
	private static Boolean confirmacao;
	
	public ModalDeletar(String texto) {

		setBounds(100, 100, 700, 300);
		
		JLabel lblConfirmacao = new JLabel(texto);
		lblConfirmacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmacao.setFont(new Font("Leelawadee UI", Font.BOLD, 16));
		getContentPane().add(lblConfirmacao, BorderLayout.CENTER);
		
		JPanel panelAcoes = new JPanel();
		panelAcoes.setBorder(null);
		panelAcoes.setBackground(Color.DARK_GRAY);
		panelAcoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelAcoes, BorderLayout.SOUTH);

		JButton btnSim = new JButton("Sim");
		btnSim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				confirmacao = true;
				dispose();
			}
		});
		btnNaoML = ViewsUtil.adicionarAcaoMouse(btnSim, Color.WHITE, new Color(173, 216, 230));
		btnSim.addMouseListener(btnNaoML);
		btnSim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSim.setMargin(new Insets(0, 0, 0, 0));
		btnSim.setFocusable(false);
		btnSim.setFont(new Font("Leelawadee", Font.BOLD, 12));
		btnSim.setForeground(Color.WHITE);
		btnSim.setBackground(Color.DARK_GRAY);
		btnSim.setPreferredSize(new Dimension(70, 23));
		btnSim.setBorder(null);
		btnSim.setActionCommand("OK");
		panelAcoes.add(btnSim);
		getRootPane().setDefaultButton(btnSim);

		JButton btnNao = new JButton("Cancelar");
		btnNao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				confirmacao = false;
				dispose();
			}
		});
		btnSimML = ViewsUtil.adicionarAcaoMouse(btnNao, Color.WHITE, Color.RED);
		btnNao.addMouseListener(btnSimML);
		btnNao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNao.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNao.setMargin(new Insets(0, 0, 0, 0));
		btnNao.setForeground(Color.WHITE);
		btnNao.setFont(new Font("Leelawadee", Font.BOLD, 12));
		btnNao.setFocusable(false);
		btnNao.setBackground(Color.DARK_GRAY);
		btnNao.setPreferredSize(new Dimension(70, 23));
		btnNao.setBorderPainted(false);
		btnNao.setBorder(null);
		panelAcoes.add(btnNao);
	}
	
	public Boolean confirmacao() {
		
		return confirmacao;
	}
}
