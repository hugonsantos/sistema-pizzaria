package views.internos.produtos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
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
import model.util.ModalUtil;
import views.modal.ModalDetalhesPedido;

public class CarrinhoView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private DefaultListModel<Object> model = new DefaultListModel<>();
	
	private JList<Object> listDetalhesPedido;
	private JScrollPane spDetalhesPedido;
	
	private ModalDetalhesPedido modalDetalhesPedido;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarrinhoView frame = new CarrinhoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CarrinhoView() {
		
		setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
		bi.setNorthPane(null);
		
		JPanel panelCarrinho = new JPanel();
		panelCarrinho.setMinimumSize(new Dimension(250, 10));
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
		panelButtonFinalizar.setBackground(Color.GRAY);
		panelButtonFinalizar.setPreferredSize(new Dimension(150, 70));
		panelCarrinho.add(panelButtonFinalizar, BorderLayout.SOUTH);
		panelButtonFinalizar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
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
				
				btnFinalizarPedido.setBackground(Color.GREEN);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnFinalizarPedido.setBackground(Color.GRAY);
			}
		});
		btnFinalizarPedido.setForeground(Color.WHITE);
		btnFinalizarPedido.setFont(new Font("Leelawadee", Font.BOLD, 16));
		btnFinalizarPedido.setBackground(Color.GRAY);
		btnFinalizarPedido.setBorderPainted(false);
		btnFinalizarPedido.setFocusPainted(false);
		btnFinalizarPedido.setFocusable(false);
		btnFinalizarPedido.setPreferredSize(new Dimension(150, 50));
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
		listDetalhesPedido.revalidate();
	}
}
