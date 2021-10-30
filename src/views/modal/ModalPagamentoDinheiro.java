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

public class ModalPagamentoDinheiro extends ModalCustom {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		ModalPagamentoDinheiro mp = new ModalPagamentoDinheiro();
		
		ModalUtil.MovimentacaoModal(mp);
		mp.setLocationRelativeTo(null);
		mp.setVisible(true);
	}
	
	public ModalPagamentoDinheiro() {

		setBounds(100, 100, 600, 400);
		
		JPanel panelPagamento = new JPanel();
		panelPagamento.setBackground(Color.WHITE);
		getContentPane().add(panelPagamento, BorderLayout.CENTER);
		panelPagamento.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCabecalho = new JPanel();
		panelCabecalho.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPagamento.add(panelCabecalho, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("M\u00E9todos de pagamento");
		lblNewLabel.setFont(new Font("Leelawadee", Font.BOLD, 22));
		panelCabecalho.add(lblNewLabel);
		
		JPanel panelMetodosPagamento = new JPanel();
		panelPagamento.add(panelMetodosPagamento, BorderLayout.CENTER);
		panelMetodosPagamento.setLayout(new GridLayout(2, 0));
		
		JPanel panelPagarBalcao = new JPanel();
		panelPagarBalcao.setBorder(new LineBorder(new Color(0, 0, 0)));
		FlowLayout fl_panelPagarBalcao = (FlowLayout) panelPagarBalcao.getLayout();
		fl_panelPagarBalcao.setHgap(45);
		fl_panelPagarBalcao.setVgap(15);
		panelMetodosPagamento.add(panelPagarBalcao);
		
		JLabel lblPagarBalcao = new JLabel("PAGAR NO BALC\u00C3O");
		lblPagarBalcao.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagarBalcao.setPreferredSize(new Dimension(590, 30));
		lblPagarBalcao.setFont(new Font("Leelawadee", Font.BOLD, 14));
		panelPagarBalcao.add(lblPagarBalcao);
		
		JButton btnPagarBalcaoDinheiro = new JButton("Dinheiro");
		btnPagarBalcaoDinheiro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPagarBalcaoDinheiro.setFocusable(false);
		btnPagarBalcaoDinheiro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnPagarBalcaoDinheiro.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnPagarBalcaoDinheiro.setForeground(Color.BLACK);
				btnPagarBalcaoDinheiro.setBackground(new Color(173, 216, 230));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnPagarBalcaoDinheiro.setForeground(Color.WHITE);
				btnPagarBalcaoDinheiro.setBackground(Color.DARK_GRAY);
			}
		});
		btnPagarBalcaoDinheiro.setPreferredSize(new Dimension(100, 60));
		btnPagarBalcaoDinheiro.setFont(new Font("Leelawadee", Font.BOLD, 14));
		btnPagarBalcaoDinheiro.setForeground(Color.WHITE);
		btnPagarBalcaoDinheiro.setBackground(Color.DARK_GRAY);
		btnPagarBalcaoDinheiro.setBorder(null);
		panelPagarBalcao.add(btnPagarBalcaoDinheiro);
		
		JButton btnPagarBalcaoPOS = new JButton("POS");
		btnPagarBalcaoPOS.setFocusable(false);
		btnPagarBalcaoPOS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPagarBalcaoPOS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnPagarBalcaoPOS.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnPagarBalcaoPOS.setForeground(Color.BLACK);
				btnPagarBalcaoPOS.setBackground(new Color(219, 112, 147));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnPagarBalcaoPOS.setForeground(Color.WHITE);
				btnPagarBalcaoPOS.setBackground(Color.DARK_GRAY);
			}
		});
		btnPagarBalcaoPOS.setPreferredSize(new Dimension(100, 60));
		btnPagarBalcaoPOS.setFont(new Font("Leelawadee", Font.BOLD, 14));
		btnPagarBalcaoPOS.setForeground(Color.WHITE);
		btnPagarBalcaoPOS.setBackground(Color.DARK_GRAY);
		btnPagarBalcaoPOS.setBorder(null);
		panelPagarBalcao.add(btnPagarBalcaoPOS);
		
		JPanel panelPagarNaEntrega = new JPanel();
		FlowLayout fl_panelPagarNaEntrega = (FlowLayout) panelPagarNaEntrega.getLayout();
		fl_panelPagarNaEntrega.setHgap(45);
		fl_panelPagarNaEntrega.setVgap(15);
		panelPagarNaEntrega.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMetodosPagamento.add(panelPagarNaEntrega);
		
		JLabel lblPagarEntrega = new JLabel("PAGAR NA ENTREGA");
		lblPagarEntrega.setPreferredSize(new Dimension(590, 30));
		lblPagarEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagarEntrega.setFont(new Font("Leelawadee", Font.BOLD, 14));
		panelPagarNaEntrega.add(lblPagarEntrega);
		
		JButton btnPagarEntregaDinheiro = new JButton("Dinheiro");
		btnPagarEntregaDinheiro.setFocusable(false);
		btnPagarEntregaDinheiro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPagarEntregaDinheiro.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnPagarEntregaDinheiro.setForeground(Color.BLACK);
				btnPagarEntregaDinheiro.setBackground(new Color(173, 216, 230));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnPagarEntregaDinheiro.setForeground(Color.WHITE);
				btnPagarEntregaDinheiro.setBackground(Color.DARK_GRAY);
			}
		});
		btnPagarEntregaDinheiro.setPreferredSize(new Dimension(100, 60));
		btnPagarEntregaDinheiro.setForeground(Color.WHITE);
		btnPagarEntregaDinheiro.setFont(new Font("Leelawadee", Font.BOLD, 14));
		btnPagarEntregaDinheiro.setBorder(null);
		btnPagarEntregaDinheiro.setBackground(Color.DARK_GRAY);
		panelPagarNaEntrega.add(btnPagarEntregaDinheiro);
		
		JButton btnPagarEntregaPOS = new JButton("POS");
		btnPagarEntregaPOS.setFocusable(false);
		btnPagarEntregaPOS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPagarEntregaPOS.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnPagarEntregaPOS.setForeground(Color.BLACK);
				btnPagarEntregaPOS.setBackground(new Color(219, 112, 147));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnPagarEntregaPOS.setForeground(Color.WHITE);
				btnPagarEntregaPOS.setBackground(Color.DARK_GRAY);
			}
		});
		btnPagarEntregaPOS.setPreferredSize(new Dimension(100, 60));
		btnPagarEntregaPOS.setForeground(Color.WHITE);
		btnPagarEntregaPOS.setFont(new Font("Leelawadee", Font.BOLD, 14));
		btnPagarEntregaPOS.setBorder(null);
		btnPagarEntregaPOS.setBackground(Color.DARK_GRAY);
		panelPagarNaEntrega.add(btnPagarEntregaPOS);

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
