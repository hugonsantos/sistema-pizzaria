package views.internos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import controllers.CarrinhoController;
import model.entities.ItemPedido;
import model.util.ModalUtil;
import views.modal.ModalDetalhesPedido;

public final class CarrinhoView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private DefaultListModel<Object> model = new DefaultListModel<>();
	
	private JList<Object> listDetalhesPedido;
	private JScrollPane spDetalhesPedido;
	
	private ModalDetalhesPedido modalDetalhesPedido;
	
	private JLabel lblValorSubTotal;

	public CarrinhoView() {
		
		setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
		bi.setNorthPane(null);
		
		JPanel panelCarrinho = new JPanel();
		panelCarrinho.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				listDetalhesPedido.clearSelection();
			}
		});
		panelCarrinho.setMinimumSize(new Dimension(200, 10));
		panelCarrinho.setPreferredSize(new Dimension(260, 55));
		panelCarrinho.setBackground(Color.GRAY);
		this.getContentPane().add(panelCarrinho, BorderLayout.EAST);
		panelCarrinho.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCarrinho = new JLabel("Carrinho");
		lblCarrinho.setBorder(new EmptyBorder(8, 0, 8, 0));
		lblCarrinho.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarrinho.setFont(new Font("Leelawadee", Font.BOLD, 22));
		lblCarrinho.setForeground(Color.WHITE);
		panelCarrinho.add(lblCarrinho, BorderLayout.NORTH);
		
		JPanel panelDetalhesPedido = new JPanel();
		panelDetalhesPedido.setLayout(new BorderLayout());
		
		listDetalhesPedido = new JList<>();
		listDetalhesPedido.setFont(new Font("Leelawadee UI", Font.BOLD, 12));
		listDetalhesPedido.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listDetalhesPedido.setFixedCellWidth(260);
		model.addAll(CarrinhoController.buscarTodos());
		listDetalhesPedido.setModel(model);
		panelDetalhesPedido.add(listDetalhesPedido, BorderLayout.CENTER);
		
		spDetalhesPedido = new JScrollPane(panelDetalhesPedido);
		spDetalhesPedido.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spDetalhesPedido.getVerticalScrollBar().setUnitIncrement(30);
		panelCarrinho.add(spDetalhesPedido, BorderLayout.CENTER);
		
		JPanel panelButtonFinalizar = new JPanel();
		panelButtonFinalizar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				listDetalhesPedido.clearSelection();
			}
		});
		panelButtonFinalizar.setBackground(Color.GRAY);
		panelButtonFinalizar.setPreferredSize(new Dimension(150, 160));
		panelCarrinho.add(panelButtonFinalizar, BorderLayout.SOUTH);
		panelButtonFinalizar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblSubTotal = new JLabel("Sub total: R$");
		lblSubTotal.setForeground(Color.WHITE);
		lblSubTotal.setFont(new Font("Leelawadee", Font.BOLD, 14));
		lblSubTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		panelButtonFinalizar.add(lblSubTotal);
		
		lblValorSubTotal = new JLabel("0,00");
		lblValorSubTotal.setPreferredSize(new Dimension(150, 14));
		lblValorSubTotal.setForeground(Color.WHITE);
		lblValorSubTotal.setFont(new Font("Leelawadee", Font.BOLD, 14));
		panelButtonFinalizar.add(lblValorSubTotal);
		
		JPanel panelAjustarQtd = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelAjustarQtd.getLayout();
		flowLayout.setVgap(15);
		panelAjustarQtd.setPreferredSize(new Dimension(200, 70));
		panelAjustarQtd.setBackground(Color.GRAY);
		panelButtonFinalizar.add(panelAjustarQtd);
		
		JButton btnDiminuirQtd = new JButton("-");
		btnDiminuirQtd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CarrinhoController.decrementarQtd(listDetalhesPedido.getSelectedIndex());
				AtualizarLista();
			}
		});
		btnDiminuirQtd.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnDiminuirQtd.setForeground(Color.WHITE);
				btnDiminuirQtd.setBackground(Color.RED);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnDiminuirQtd.setForeground(Color.GRAY);
				btnDiminuirQtd.setBackground(Color.WHITE);
			}
		});
		btnDiminuirQtd.setVerticalAlignment(SwingConstants.TOP);
		btnDiminuirQtd.setPreferredSize(new Dimension(35, 35));
		btnDiminuirQtd.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDiminuirQtd.setForeground(Color.GRAY);
		btnDiminuirQtd.setFont(new Font("Leelawadee", Font.BOLD, 28));
		btnDiminuirQtd.setFocusable(false);
		btnDiminuirQtd.setFocusPainted(false);
		btnDiminuirQtd.setBorderPainted(false);
		btnDiminuirQtd.setBorder(null);
		btnDiminuirQtd.setBackground(Color.WHITE);
		btnDiminuirQtd.setAlignmentX(0.5f);
		btnDiminuirQtd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelAjustarQtd.add(btnDiminuirQtd);
		
		JPanel panelAjustarCarrinho = new JPanel();
		panelAjustarCarrinho.setPreferredSize(new Dimension(100, 45));
		panelAjustarCarrinho.setBackground(Color.GRAY);
		panelAjustarQtd.add(panelAjustarCarrinho);
		
		JButton btnRemoverItem = new JButton("Remover item");
		btnRemoverItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CarrinhoController.deletarItem((ItemPedido) listDetalhesPedido.getSelectedValue());
				AtualizarLista();
			}
		});
		btnRemoverItem.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnRemoverItem.setForeground(Color.RED);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnRemoverItem.setForeground(Color.WHITE);
			}
		});
		panelAjustarCarrinho.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnRemoverItem.setPreferredSize(new Dimension(100, 15));
		btnRemoverItem.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRemoverItem.setForeground(Color.WHITE);
		btnRemoverItem.setFont(new Font("Leelawadee", Font.BOLD, 12));
		btnRemoverItem.setFocusable(false);
		btnRemoverItem.setFocusPainted(false);
		btnRemoverItem.setBorderPainted(false);
		btnRemoverItem.setBorder(null);
		btnRemoverItem.setBackground(Color.GRAY);
		btnRemoverItem.setAlignmentX(0.5f);
		btnRemoverItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelAjustarCarrinho.add(btnRemoverItem);
		
		JButton btnLimparCarrinho = new JButton("Limpar carrinho");
		btnLimparCarrinho.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CarrinhoController.limparCarrinho();
				AtualizarLista();
			}
		});
		btnLimparCarrinho.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnLimparCarrinho.setForeground(Color.RED);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnLimparCarrinho.setForeground(Color.WHITE);
			}
		});
		btnLimparCarrinho.setPreferredSize(new Dimension(100, 15));
		btnLimparCarrinho.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLimparCarrinho.setForeground(Color.WHITE);
		btnLimparCarrinho.setFont(new Font("Leelawadee", Font.BOLD, 12));
		btnLimparCarrinho.setFocusable(false);
		btnLimparCarrinho.setFocusPainted(false);
		btnLimparCarrinho.setBorderPainted(false);
		btnLimparCarrinho.setBorder(null);
		btnLimparCarrinho.setBackground(Color.GRAY);
		btnLimparCarrinho.setAlignmentX(0.5f);
		btnLimparCarrinho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelAjustarCarrinho.add(btnLimparCarrinho);
		
		JButton btnAumentarQtd = new JButton("+");
		btnAumentarQtd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CarrinhoController.incrementarQtd(listDetalhesPedido.getSelectedIndex());
				AtualizarLista();
			}
		});
		btnAumentarQtd.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnAumentarQtd.setForeground(Color.WHITE);
				btnAumentarQtd.setBackground(Color.GREEN);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnAumentarQtd.setForeground(Color.GRAY);
				btnAumentarQtd.setBackground(Color.WHITE);
			}
		});
		btnAumentarQtd.setVerticalAlignment(SwingConstants.TOP);
		btnAumentarQtd.setPreferredSize(new Dimension(35, 35));
		btnAumentarQtd.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAumentarQtd.setForeground(Color.GRAY);
		btnAumentarQtd.setFont(new Font("Leelawadee", Font.BOLD, 25));
		btnAumentarQtd.setFocusable(false);
		btnAumentarQtd.setFocusPainted(false);
		btnAumentarQtd.setBorderPainted(false);
		btnAumentarQtd.setBorder(null);
		btnAumentarQtd.setBackground(Color.WHITE);
		btnAumentarQtd.setAlignmentX(0.5f);
		btnAumentarQtd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelAjustarQtd.add(btnAumentarQtd);
		
		JButton btnFinalizarPedido = new JButton("Finalizar pedido");
		btnFinalizarPedido.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				modalDetalhesPedido = new ModalDetalhesPedido();
				ModalUtil.MovimentacaoModal(modalDetalhesPedido);
				modalDetalhesPedido.setLocationRelativeTo(null);
				modalDetalhesPedido.setVisible(true);
			}
		});
		btnFinalizarPedido.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnFinalizarPedido.setForeground(Color.WHITE);
				btnFinalizarPedido.setBackground(Color.GREEN);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnFinalizarPedido.setForeground(Color.GRAY);
				btnFinalizarPedido.setBackground(Color.WHITE);
			}
		});
		btnFinalizarPedido.setForeground(Color.GRAY);
		btnFinalizarPedido.setFont(new Font("Leelawadee", Font.BOLD, 16));
		btnFinalizarPedido.setBackground(Color.WHITE);
		btnFinalizarPedido.setBorderPainted(false);
		btnFinalizarPedido.setFocusPainted(false);
		btnFinalizarPedido.setFocusable(false);
		btnFinalizarPedido.setPreferredSize(new Dimension(180, 50));
		btnFinalizarPedido.setBorder(null);
		btnFinalizarPedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFinalizarPedido.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFinalizarPedido.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelButtonFinalizar.add(btnFinalizarPedido, BorderLayout.CENTER);
	}
	
	public void AtualizarLista() {
		
		model.removeAllElements();
		model.addAll(CarrinhoController.buscarTodos());
		listDetalhesPedido.setModel(model);
		
		lblValorSubTotal.setText(String.format("%.2f", CarrinhoController.total()));
		
		listDetalhesPedido.revalidate();
		lblValorSubTotal.revalidate();
	}
}
