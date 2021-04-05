package views.modal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import model.table.CarrinhoTableModel;
import model.util.TableCelulasCustomizadas;
import javax.swing.border.EmptyBorder;

public final class ModalDetalhesPedido extends ModalCustom {

	private static final long serialVersionUID = 1L;
	
	private TableCelulasCustomizadas cel = new TableCelulasCustomizadas();
	private CarrinhoTableModel model = new CarrinhoTableModel();
	private JTable tableProdutos;

	public ModalDetalhesPedido() {
		
		setBounds(100, 100, 1024, 738);
		
		JPanel panelDetalhesPedido = new JPanel();
		panelDetalhesPedido.setBackground(Color.WHITE);
		getContentPane().add(panelDetalhesPedido, BorderLayout.CENTER);
		panelDetalhesPedido.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDetalhesPedido = new JLabel("Detalhes do pedido");
		lblDetalhesPedido.setBackground(Color.WHITE);
		lblDetalhesPedido.setPreferredSize(new Dimension(92, 70));
		lblDetalhesPedido.setBounds(new Rectangle(0, 0, 0, 50));
		lblDetalhesPedido.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		lblDetalhesPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetalhesPedido.setEnabled(true);
		panelDetalhesPedido.add(lblDetalhesPedido, BorderLayout.NORTH);
		
		JPanel panelListPrdodutos = new JPanel();
		panelListPrdodutos.setBackground(Color.WHITE);
		panelDetalhesPedido.add(panelListPrdodutos, BorderLayout.CENTER);
		panelListPrdodutos.setLayout(null);
		
		tableProdutos = new JTable();
		tableProdutos.setModel(model);
		tableProdutos.setFont(new Font("Leelawadee UI", Font.PLAIN, 12));
		tableProdutos.setBorder(null);
		tableProdutos.setShowHorizontalLines(true);
		tableProdutos.setShowVerticalLines(false);
		tableProdutos.setFocusable(false);
		tableProdutos.getColumnModel().getColumn(0).setCellRenderer(cel);
		tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(10);
		tableProdutos.getColumnModel().getColumn(1).setCellRenderer(cel);
		tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(50);
		tableProdutos.getColumnModel().getColumn(2).setCellRenderer(cel);
		tableProdutos.getColumnModel().getColumn(2).setPreferredWidth(120);
		tableProdutos.getColumnModel().getColumn(3).setCellRenderer(cel);
		tableProdutos.getColumnModel().getColumn(3).setPreferredWidth(150);
		tableProdutos.getColumnModel().getColumn(4).setCellRenderer(cel);
		tableProdutos.getColumnModel().getColumn(4).setPreferredWidth(250);
		tableProdutos.getColumnModel().getColumn(5).setCellRenderer(cel);
		tableProdutos.getColumnModel().getColumn(5).setPreferredWidth(10);
		tableProdutos.getColumnModel().getColumn(6).setCellRenderer(cel);
		tableProdutos.getColumnModel().getColumn(6).setPreferredWidth(20);
		
		JScrollPane spTableProdutos = new JScrollPane(tableProdutos);
		spTableProdutos.setColumnHeaderView(tableProdutos.getTableHeader());
		spTableProdutos.getColumnHeader().setVisible(false);
		spTableProdutos.getViewport().setBackground(Color.WHITE);
		spTableProdutos.setFont(new Font("Leelawadee UI", Font.PLAIN, 14));
		spTableProdutos.setBorder(new EmptyBorder(0, 0, 0, 0));
		spTableProdutos.setFocusable(false);
		spTableProdutos.setBounds(10, 11, 1024, 425);
		panelListPrdodutos.add(spTableProdutos);
		
		JPanel panelAcoes = new JPanel();
		panelAcoes.setBorder(null);
		panelAcoes.setBackground(Color.DARK_GRAY);
		panelAcoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelAcoes, BorderLayout.SOUTH);

		JButton btnLimparSelecao = new JButton("Limpar sele\u00E7\u00E3o");
		btnLimparSelecao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				

				btnLimparSelecao.setBackground(Color.DARK_GRAY);
			}
		});
		btnLimparSelecao.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {

				btnLimparSelecao.setBackground(new Color(173, 216, 230));
			}

			@Override
			public void mouseExited(MouseEvent e) {

				btnLimparSelecao.setBackground(Color.DARK_GRAY);
			}
		});
		btnLimparSelecao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimparSelecao.setPreferredSize(new Dimension(100, 23));
		btnLimparSelecao.setMargin(new Insets(0, 0, 0, 0));
		btnLimparSelecao.setForeground(Color.WHITE);
		btnLimparSelecao.setFont(new Font("Leelawadee", Font.BOLD, 12));
		btnLimparSelecao.setFocusable(false);
		btnLimparSelecao.setBorder(null);
		btnLimparSelecao.setBackground(Color.DARK_GRAY);
		btnLimparSelecao.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAcoes.add(btnLimparSelecao);

		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				
				btnSelecionar.setBackground(Color.DARK_GRAY);
				dispose();
			}
		});
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
		btnSelecionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSelecionar.setMargin(new Insets(0, 0, 0, 0));
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
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				
				btnLimparSelecao.setBackground(Color.DARK_GRAY);
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
