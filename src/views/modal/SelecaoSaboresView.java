package views.modal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class SelecaoSaboresView extends ModalCustom {

	private static final long serialVersionUID = 1L;

	public SelecaoSaboresView() {

		JList<?> list = new JList<>();
		getContentPane().add(list, BorderLayout.WEST);

		JLabel lblNewLabel = new JLabel("Imagem");
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);

		JPanel panelAcoes = new JPanel();
		panelAcoes.setBorder(null);
		panelAcoes.setBackground(Color.DARK_GRAY);
		panelAcoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelAcoes, BorderLayout.SOUTH);

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
		panelAcoes.add(btnSelecionar);
		getRootPane().setDefaultButton(btnSelecionar);

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
		panelAcoes.add(btnCancelar);
	}
}
