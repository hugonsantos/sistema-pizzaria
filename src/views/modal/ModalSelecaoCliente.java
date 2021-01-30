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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.entities.Cliente;
import model.table.ClientesTableModel;

public final class ModalSelecaoCliente extends ModalCustom {

	private static final long serialVersionUID = 1L;
	
	private ClientesTableModel modelTable = new ClientesTableModel();
	private DefaultListModel<Object> model = new DefaultListModel<>();

	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtComplemento;
	private JTextField txtCep;
	private JTextField txtCidade;
	private JComboBox<Object> cbxEstado;
	private JTextField txtPesquisar;
	
	private JList<Object> listClientes;
	private JList<Object> listEnderecos;

	public ModalSelecaoCliente() {
		
		JPanel panelEnderecoPrincipal = new JPanel();
		panelEnderecoPrincipal.setPreferredSize(new Dimension(471, 10));
		getContentPane().add(panelEnderecoPrincipal);
		panelEnderecoPrincipal.setLayout(null);

		JLabel lblEntrega = new JLabel("Entrega");
		lblEntrega.setFont(new Font("Leelawadee UI", Font.BOLD, 16));
		lblEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrega.setBounds(10, 11, 930, 47);
		panelEnderecoPrincipal.add(lblEntrega);

		JLabel lblCepEP = new JLabel("Cep:");
		lblCepEP.setSize(new Dimension(30, 0));
		lblCepEP.setPreferredSize(new Dimension(30, 14));
		lblCepEP.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblCepEP.setBounds(10, 58, 46, 30);
		panelEnderecoPrincipal.add(lblCepEP);

		txtCep = new JTextField();
		txtCep.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(listClientes.getSelectedIndex() != -1) {
					
					listClientes.clearSelection();
					
					listEnderecos.setModel(new DefaultListModel<>());
					listEnderecos.revalidate();
				}
			}
		});
		txtCep.setColumns(10);
		txtCep.setBounds(10, 88, 150, 30);
		panelEnderecoPrincipal.add(txtCep);

		JLabel lblEnderecoEP = new JLabel("Endere\u00E7o:");
		lblEnderecoEP.setSize(new Dimension(30, 0));
		lblEnderecoEP.setPreferredSize(new Dimension(30, 14));
		lblEnderecoEP.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblEnderecoEP.setBounds(10, 129, 76, 30);
		panelEnderecoPrincipal.add(lblEnderecoEP);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(10, 159, 451, 30);
		panelEnderecoPrincipal.add(txtEndereco);
		txtEndereco.setColumns(10);

		JLabel lblNumeroEP = new JLabel("N\u00B0:");
		lblNumeroEP.setSize(new Dimension(30, 0));
		lblNumeroEP.setPreferredSize(new Dimension(30, 14));
		lblNumeroEP.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblNumeroEP.setBounds(485, 129, 37, 30);
		panelEnderecoPrincipal.add(lblNumeroEP);

		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(485, 159, 76, 30);
		panelEnderecoPrincipal.add(txtNumero);

		JLabel lblBairroEP = new JLabel("Bairro:");
		lblBairroEP.setSize(new Dimension(30, 0));
		lblBairroEP.setPreferredSize(new Dimension(30, 14));
		lblBairroEP.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblBairroEP.setBounds(583, 129, 58, 30);
		panelEnderecoPrincipal.add(lblBairroEP);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(583, 159, 357, 30);
		panelEnderecoPrincipal.add(txtBairro);

		JLabel lblComplementoEP = new JLabel("Complemento:");
		lblComplementoEP.setSize(new Dimension(30, 0));
		lblComplementoEP.setPreferredSize(new Dimension(30, 14));
		lblComplementoEP.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblComplementoEP.setBounds(10, 200, 117, 30);
		panelEnderecoPrincipal.add(lblComplementoEP);

		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(10, 230, 451, 30);
		panelEnderecoPrincipal.add(txtComplemento);

		JLabel lblCidadeEP = new JLabel("Cidade:");
		lblCidadeEP.setSize(new Dimension(30, 0));
		lblCidadeEP.setPreferredSize(new Dimension(30, 14));
		lblCidadeEP.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblCidadeEP.setBounds(485, 200, 117, 30);
		panelEnderecoPrincipal.add(lblCidadeEP);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(485, 229, 357, 30);
		panelEnderecoPrincipal.add(txtCidade);

		JLabel lblEstadoEP = new JLabel("Estado:");
		lblEstadoEP.setSize(new Dimension(30, 0));
		lblEstadoEP.setPreferredSize(new Dimension(30, 14));
		lblEstadoEP.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblEstadoEP.setBounds(860, 200, 58, 30);
		panelEnderecoPrincipal.add(lblEstadoEP);

		cbxEstado = new JComboBox<>();
		cbxEstado.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB",
						"PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO" }));
		cbxEstado.setBounds(860, 229, 80, 30);
		panelEnderecoPrincipal.add(cbxEstado);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setColumns(10);
		txtPesquisar.setBounds(681, 309, 259, 30);
		panelEnderecoPrincipal.add(txtPesquisar);
		
		JLabel lblPesquisa = new JLabel("Pesquisar:");
		lblPesquisa.setSize(new Dimension(30, 0));
		lblPesquisa.setPreferredSize(new Dimension(30, 14));
		lblPesquisa.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblPesquisa.setBounds(607, 309, 76, 28);
		panelEnderecoPrincipal.add(lblPesquisa);
		
		listClientes = new JList<>();
		listClientes.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(listClientes.getSelectedIndex() != -1) {
					
					txtCep.setText("");
					txtEndereco.setText("");
					txtNumero.setText("");
					txtBairro.setText("");
					txtComplemento.setText("");
					txtCidade.setText("");
					cbxEstado.setSelectedIndex(0);
					
					Cliente cliente = (Cliente) listClientes.getSelectedValue();
					
					DefaultListModel<Object> model = new DefaultListModel<>();
					model.addAll(modelTable.capturarEnderecos(cliente.getId()));
					
					listEnderecos.setModel(model);
					listEnderecos.revalidate();
				}
			}
		});
		model.addAll(modelTable.capturarClientes());
		listClientes.setModel(model);
		
		JScrollPane scrollListClientes = new JScrollPane(listClientes);
		scrollListClientes.setBounds(10, 348, 306, 184);
		scrollListClientes.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollListClientes.getVerticalScrollBar().setUnitIncrement(30);
		panelEnderecoPrincipal.add(scrollListClientes);
		
		listEnderecos = new JList<>();
		
		JScrollPane scrollListEnderecos = new JScrollPane(listEnderecos);
		scrollListEnderecos.setBounds(326, 348, 614, 184);
		scrollListEnderecos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollListEnderecos.getVerticalScrollBar().setUnitIncrement(30);
		panelEnderecoPrincipal.add(scrollListEnderecos);
		
		JPanel panelAcoes = new JPanel();
		panelAcoes.setBorder(null);
		panelAcoes.setBackground(Color.DARK_GRAY);
		panelAcoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelAcoes, BorderLayout.SOUTH);

		JButton btnLimparSelecao = new JButton("Limpar sele\u00E7\u00E3o");
		btnLimparSelecao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				txtCep.setText("");
				txtEndereco.setText("");
				txtNumero.setText("");
				txtBairro.setText("");
				txtComplemento.setText("");
				txtCidade.setText("");
				cbxEstado.setSelectedIndex(0);
				
				if(listClientes.getSelectedIndex() != -1) {
					
					listClientes.clearSelection();

					listEnderecos.setModel(new DefaultListModel<>());
					listEnderecos.revalidate();
				}

				btnLimparSelecao.setBackground(Color.DARK_GRAY);
				dispose();
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
