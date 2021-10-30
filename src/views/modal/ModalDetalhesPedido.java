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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.CarrinhoController;
import model.table.CarrinhoTableModel;
import model.util.CalculoFreteUtil;
import model.util.ModalUtil;
import model.util.TableCelulasCustomizadas;

public final class ModalDetalhesPedido extends ModalCustom {

	private static final long serialVersionUID = 1L;
	
	private TableCelulasCustomizadas cel = new TableCelulasCustomizadas();
	private CarrinhoTableModel model = new CarrinhoTableModel();
	
	private ModalPagamento modalPagamento = null;
	
	private JTable tableProdutos;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtComplemento;
	private JTextField txtCidade;
	private JTextField txtNome;
	private JTextField txtTelefone;

	public ModalDetalhesPedido() {
		
		setBounds(100, 100, 1024, 738);
		
		JPanel panelDetalhesPedido = new JPanel();
		panelDetalhesPedido.setBackground(Color.WHITE);
		getContentPane().add(panelDetalhesPedido, BorderLayout.CENTER);
		panelDetalhesPedido.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDetalhesPedido = new JLabel("Detalhes do pedido");
		lblDetalhesPedido.setBackground(Color.WHITE);
		lblDetalhesPedido.setPreferredSize(new Dimension(92, 50));
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
		spTableProdutos.setBounds(10, 11, 1004, 366);
		panelListPrdodutos.add(spTableProdutos);
		
		JPanel panelDadosCliente = new JPanel();
		panelDadosCliente.setBackground(Color.WHITE);
		panelDadosCliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDadosCliente.setPreferredSize(new Dimension(10, 250));
		panelDetalhesPedido.add(panelDadosCliente, BorderLayout.SOUTH);
		panelDadosCliente.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setSize(new Dimension(37, 25));
		lblNome.setPreferredSize(new Dimension(30, 20));
		lblNome.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNome.setBounds(11, 11, 50, 25);
		panelDadosCliente.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtNome.setColumns(10);
		txtNome.setBounds(10, 39, 214, 25);
		panelDadosCliente.add(txtNome);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setSize(new Dimension(37, 25));
		lblTelefone.setPreferredSize(new Dimension(30, 20));
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTelefone.setBounds(251, 11, 73, 25);
		panelDadosCliente.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(251, 39, 155, 25);
		panelDadosCliente.add(txtTelefone);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setLocation(499, 11);
		lblCep.setSize(new Dimension(37, 25));
		lblCep.setPreferredSize(new Dimension(30, 20));
		lblCep.setFont(new Font("Dialog", Font.BOLD, 14));
		panelDadosCliente.add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setBounds(499, 39, 120, 25);
		txtCep.setColumns(10);
		panelDadosCliente.add(txtCep);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setLocation(10, 87);
		lblEndereco.setSize(new Dimension(81, 25));
		lblEndereco.setPreferredSize(new Dimension(30, 20));
		lblEndereco.setFont(new Font("Dialog", Font.BOLD, 14));
		panelDadosCliente.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(10, 114, 351, 25);
		txtEndereco.setColumns(10);
		panelDadosCliente.add(txtEndereco);
		
		JLabel lblNumero = new JLabel("N\u00B0:");
		lblNumero.setLocation(388, 87);
		lblNumero.setSize(new Dimension(30, 25));
		lblNumero.setPreferredSize(new Dimension(30, 20));
		lblNumero.setFont(new Font("Dialog", Font.BOLD, 14));
		panelDadosCliente.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(388, 114, 86, 25);
		txtNumero.setColumns(10);
		panelDadosCliente.add(txtNumero);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setLocation(499, 87);
		lblBairro.setSize(new Dimension(56, 25));
		lblBairro.setPreferredSize(new Dimension(30, 20));
		lblBairro.setFont(new Font("Dialog", Font.BOLD, 14));
		panelDadosCliente.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(499, 114, 238, 25);
		txtBairro.setColumns(10);
		panelDadosCliente.add(txtBairro);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setLocation(10, 165);
		lblComplemento.setSize(new Dimension(108, 25));
		lblComplemento.setPreferredSize(new Dimension(30, 20));
		lblComplemento.setFont(new Font("Dialog", Font.BOLD, 14));
		panelDadosCliente.add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(10, 193, 351, 25);
		txtComplemento.setColumns(10);
		panelDadosCliente.add(txtComplemento);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setLocation(388, 165);
		lblCidade.setSize(new Dimension(61, 25));
		lblCidade.setPreferredSize(new Dimension(30, 20));
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 14));
		panelDadosCliente.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(388, 193, 263, 25);
		txtCidade.setColumns(10);
		panelDadosCliente.add(txtCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setLocation(681, 165);
		lblEstado.setSize(new Dimension(56, 25));
		lblEstado.setPreferredSize(new Dimension(30, 20));
		lblEstado.setFont(new Font("Dialog", Font.BOLD, 14));
		panelDadosCliente.add(lblEstado);
		
		JComboBox<Object> cbxEstado = new JComboBox<Object>();
		cbxEstado.setBounds(681, 193, 56, 25);
		panelDadosCliente.add(cbxEstado);
		
		JButton btnSelecionarCliente = new JButton("Buscar cliente");
		btnSelecionarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSelecionarCliente.setFocusable(false);
		btnSelecionarCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnSelecionarCliente.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {


				btnSelecionarCliente.setForeground(Color.BLACK);
				btnSelecionarCliente.setBackground(new Color(173, 216, 230));
			}

			@Override
			public void mouseExited(MouseEvent e) {

				btnSelecionarCliente.setForeground(Color.WHITE);
				btnSelecionarCliente.setBackground(Color.DARK_GRAY);
			}
		});
		btnSelecionarCliente.setForeground(Color.WHITE);
		btnSelecionarCliente.setBorder(null);
		btnSelecionarCliente.setBackground(Color.GRAY);
		btnSelecionarCliente.setFont(new Font("Leelawadee", Font.BOLD, 12));
		btnSelecionarCliente.setBounds(671, 10, 113, 30);
		panelDadosCliente.add(btnSelecionarCliente);
		
		JPanel panelValores = new JPanel();
		panelValores.setBackground(Color.WHITE);
		panelValores.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelValores.setBounds(794, 0, 230, 250);
		panelDadosCliente.add(panelValores);
		panelValores.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		
		JLabel lblSubTotal = new JLabel("Sub total:");
		lblSubTotal.setIconTextGap(15);
		lblSubTotal.setBounds(new Rectangle(5, 0, 0, 0));
		lblSubTotal.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblSubTotal.setPreferredSize(new Dimension(210, 14));
		lblSubTotal.setFont(new Font("Leelawadee", Font.BOLD, 15));
		panelValores.add(lblSubTotal);
		
		JLabel lblValorSubTotal = new JLabel("R$" + String.format("%.2f", CarrinhoController.total()));
		lblValorSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorSubTotal.setPreferredSize(new Dimension(210, 14));
		lblValorSubTotal.setFont(new Font("Leelawadee", Font.BOLD, 15));
		panelValores.add(lblValorSubTotal);
		
		JLabel lblFrete = new JLabel("Frete:");
		lblFrete.setPreferredSize(new Dimension(210, 14));
		lblFrete.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblFrete.setFont(new Font("Leelawadee", Font.BOLD, 15));
		panelValores.add(lblFrete);
		
		JLabel lblValorFrete = new JLabel((CalculoFreteUtil.calcularFrete() == 0)? "Gratis" : "R$" + String.format("%.2f", CalculoFreteUtil.calcularFrete()));
		lblValorFrete.setPreferredSize(new Dimension(210, 14));
		lblValorFrete.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorFrete.setFont(new Font("Leelawadee", Font.BOLD, 15));
		lblValorFrete.setAlignmentX(0.5f);
		panelValores.add(lblValorFrete);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setPreferredSize(new Dimension(210, 14));
		lblTotal.setFont(new Font("Leelawadee", Font.BOLD, 18));
		lblTotal.setAlignmentX(0.5f);
		panelValores.add(lblTotal);
		
		JLabel lblValorTotal = new JLabel("R$" + String.format("%.2f", CarrinhoController.total() + CalculoFreteUtil.calcularFrete()));
		lblValorTotal.setPreferredSize(new Dimension(210, 20));
		lblValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorTotal.setFont(new Font("Leelawadee", Font.BOLD, 18));
		lblValorTotal.setAlignmentX(0.5f);
		panelValores.add(lblValorTotal);
		
		JPanel panelAcoes = new JPanel();
		panelAcoes.setBorder(null);
		panelAcoes.setBackground(Color.DARK_GRAY);
		panelAcoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelAcoes, BorderLayout.SOUTH);

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
				
				modalPagamento = new ModalPagamento();
				ModalUtil.MovimentacaoModal(modalPagamento);
				modalPagamento.setLocationRelativeTo(null);
				modalPagamento.setVisible(true);
			}
		});
		btnContinuar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {

				btnContinuar.setBackground(Color.GREEN);
			}

			@Override
			public void mouseExited(MouseEvent e) {

				btnContinuar.setBackground(Color.DARK_GRAY);
			}
		});
		btnContinuar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnContinuar.setMargin(new Insets(0, 0, 0, 0));
		btnContinuar.setFocusable(false);
		btnContinuar.setFont(new Font("Leelawadee", Font.BOLD, 12));
		btnContinuar.setForeground(Color.WHITE);
		btnContinuar.setBackground(Color.DARK_GRAY);
		btnContinuar.setPreferredSize(new Dimension(70, 23));
		btnContinuar.setBorder(null);
		btnContinuar.setActionCommand("OK");
		panelAcoes.add(btnContinuar);
		getRootPane().setDefaultButton(btnContinuar);

		JButton btnReverItens = new JButton("Rever itens");
		btnReverItens.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				btnReverItens.setBackground(Color.DARK_GRAY);
				dispose();
			}
		});
		btnReverItens.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReverItens.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnReverItens.setMargin(new Insets(0, 0, 0, 0));
		btnReverItens.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {

				btnReverItens.setBackground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {

				btnReverItens.setBackground(Color.DARK_GRAY);
			}
		});
		btnReverItens.setForeground(Color.WHITE);
		btnReverItens.setFont(new Font("Leelawadee", Font.BOLD, 12));
		btnReverItens.setFocusable(false);
		btnReverItens.setBackground(Color.DARK_GRAY);
		btnReverItens.setPreferredSize(new Dimension(80, 23));
		btnReverItens.setBorderPainted(false);
		btnReverItens.setBorder(null);
		panelAcoes.add(btnReverItens);
	}
}
