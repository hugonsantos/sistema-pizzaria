package views.modal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import model.util.ModalUtil;

public class ModalPagamento extends ModalCustom {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		ModalPagamento mp = new ModalPagamento();
		
		ModalUtil.MovimentacaoModal(mp);
		mp.setLocationRelativeTo(null);
		mp.setVisible(true);
	}
	
	public ModalPagamento() {

		setBounds(100, 100, 600, 400);
		
		JPanel panelPagamento = new JPanel();
		panelPagamento.setBackground(Color.WHITE);
		getContentPane().add(panelPagamento, BorderLayout.CENTER);
		panelPagamento.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCabecalho = new JPanel();
		panelCabecalho.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPagamento.add(panelCabecalho, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Dinheiro");
		lblTitulo.setFont(new Font("Leelawadee", Font.BOLD, 22));
		panelCabecalho.add(lblTitulo);
		
		JPanel panelMetodosPagamento = new JPanel();
		panelPagamento.add(panelMetodosPagamento, BorderLayout.CENTER);
		panelMetodosPagamento.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLateral = new JPanel();
		panelMetodosPagamento.add(panelLateral, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("New label");
		panelLateral.add(lblNewLabel);

		JPanel panelAcoes = new JPanel();
		panelAcoes.setBorder(null);
		panelAcoes.setBackground(Color.DARK_GRAY);
		panelAcoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelAcoes, BorderLayout.SOUTH);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				btnCancelar.setBackground(Color.DARK_GRAY);
				dispose();
			}
		});
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
