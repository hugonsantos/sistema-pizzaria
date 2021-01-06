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
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.entities.Cliente;
import model.entities.Endereco;
import model.table.ClientesTableModel;

public final class ModalCliente extends ModalCustom {

	private static final long serialVersionUID = 1L;
	
	private JTextField txtNome;
	private JTextField txtCpf;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private JTextField txtEnderecoEP;
	private JTextField txtNumeroEP;
	private JTextField txtBairroEP;
	private JTextField txtComplementoEP;
	private JTextField txtCepEP;
	private JCheckBox checkboxConfigEndereco;
	private JTextField txtEnderecoEE;
	private JTextField txtNumeroEE;
	private JTextField txtBairroEE;
	private JTextField txtComplementoEE;
	private JTextField txtCepEE;
	
	private List<Endereco> enderecos;
	
	ClientesTableModel clientesTableModel;

	private ButtonGroup generoBtns = new ButtonGroup();

	public ModalCliente(ClientesTableModel clientesTableModel, Cliente cliente) {
		
		this.clientesTableModel = clientesTableModel;
		
		setBounds(100, 100, 950, 900);
		
		JPanel panelDadosCadastrais = new JPanel();
		getContentPane().add(panelDadosCadastrais, BorderLayout.CENTER);
		panelDadosCadastrais.setLayout(null);

		JPanel panelNome = new JPanel();
		panelNome.setBounds(0, 1, 475, 120);
		panelDadosCadastrais.add(panelNome);
		panelNome.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(new Rectangle(0, 0, 30, 0));
		lblNome.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblNome.setBounds(10, 11, 55, 30);
		panelNome.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 41, 455, 30);
		panelNome.add(txtNome);
		txtNome.setColumns(10);
		
		JPanel panelGenero = new JPanel();
		panelGenero.setBounds(475, 1, 475, 120);
		panelGenero.setLayout(null);
		panelDadosCadastrais.add(panelGenero);

		JLabel lblGenero = new JLabel("Gen\u00EAro:");
		lblGenero.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblGenero.setBounds(111, 49, 63, 14);
		panelGenero.add(lblGenero);

		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
		rdbtnMasculino.setBounds(193, 30, 94, 23);
		panelGenero.add(rdbtnMasculino);

		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
		rdbtnFeminino.setBounds(193, 66, 94, 23);
		panelGenero.add(rdbtnFeminino);

		generoBtns.add(rdbtnMasculino);
		generoBtns.add(rdbtnFeminino);
		
		JPanel panelCpf = new JPanel();
		panelCpf.setBounds(0, 121, 475, 120);
		panelCpf.setLayout(null);
		panelDadosCadastrais.add(panelCpf);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblCpf.setBounds(10, 24, 55, 30);
		panelCpf.add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setSize(new Dimension(0, 60));
		txtCpf.setMinimumSize(new Dimension(7, 60));
		txtCpf.setPreferredSize(new Dimension(0, 60));
		txtCpf.setColumns(10);
		txtCpf.setBounds(10, 54, 258, 30);
		panelCpf.add(txtCpf);
		
		JPanel panelEnderecos = new JPanel();
		panelEnderecos.setBounds(0, 241, 950, 598);
		panelDadosCadastrais.add(panelEnderecos);
		panelEnderecos.setLayout(new GridLayout(1, 2));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setAlignmentY(Component.CENTER_ALIGNMENT);
		splitPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		splitPane.setPreferredSize(new Dimension(500, 25));
		panelEnderecos.add(splitPane);
		
		JPanel panelEnderecoPrincipal = new JPanel();
		panelEnderecoPrincipal.setPreferredSize(new Dimension(471, 10));
		splitPane.setLeftComponent(panelEnderecoPrincipal);
		panelEnderecoPrincipal.setLayout(null);
		
		JLabel lblEnderecoPrincipal = new JLabel("Endere\u00E7o Principal");
		lblEnderecoPrincipal.setFont(new Font("Leelawadee UI", Font.BOLD, 16));
		lblEnderecoPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnderecoPrincipal.setBounds(10, 11, 451, 47);
		panelEnderecoPrincipal.add(lblEnderecoPrincipal);
		
		JLabel lblEnderecoEP = new JLabel("Endere\u00E7o:");
		lblEnderecoEP.setSize(new Dimension(30, 0));
		lblEnderecoEP.setPreferredSize(new Dimension(30, 14));
		lblEnderecoEP.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblEnderecoEP.setBounds(10, 69, 76, 30);
		panelEnderecoPrincipal.add(lblEnderecoEP);
		
		txtEnderecoEP = new JTextField();
		txtEnderecoEP.setBounds(10, 99, 451, 30);
		panelEnderecoPrincipal.add(txtEnderecoEP);
		txtEnderecoEP.setColumns(10);
		
		JLabel lblNumeroEP = new JLabel("N\u00B0:");
		lblNumeroEP.setSize(new Dimension(30, 0));
		lblNumeroEP.setPreferredSize(new Dimension(30, 14));
		lblNumeroEP.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblNumeroEP.setBounds(10, 156, 37, 30);
		panelEnderecoPrincipal.add(lblNumeroEP);
		
		txtNumeroEP = new JTextField();
		txtNumeroEP.setColumns(10);
		txtNumeroEP.setBounds(10, 186, 76, 30);
		panelEnderecoPrincipal.add(txtNumeroEP);
		
		JLabel lblBairroEP = new JLabel("Bairro:");
		lblBairroEP.setSize(new Dimension(30, 0));
		lblBairroEP.setPreferredSize(new Dimension(30, 14));
		lblBairroEP.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblBairroEP.setBounds(104, 156, 58, 30);
		panelEnderecoPrincipal.add(lblBairroEP);
		
		txtBairroEP = new JTextField();
		txtBairroEP.setColumns(10);
		txtBairroEP.setBounds(104, 186, 357, 30);
		panelEnderecoPrincipal.add(txtBairroEP);
		
		JLabel lblComplementoEP = new JLabel("Complemento:");
		lblComplementoEP.setSize(new Dimension(30, 0));
		lblComplementoEP.setPreferredSize(new Dimension(30, 14));
		lblComplementoEP.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblComplementoEP.setBounds(10, 247, 117, 30);
		panelEnderecoPrincipal.add(lblComplementoEP);
		
		txtComplementoEP = new JTextField();
		txtComplementoEP.setColumns(10);
		txtComplementoEP.setBounds(10, 277, 451, 30);
		panelEnderecoPrincipal.add(txtComplementoEP);
		
		JLabel lblCepEP = new JLabel("Cep:");
		lblCepEP.setSize(new Dimension(30, 0));
		lblCepEP.setPreferredSize(new Dimension(30, 14));
		lblCepEP.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblCepEP.setBounds(10, 337, 46, 30);
		panelEnderecoPrincipal.add(lblCepEP);
		
		txtCepEP = new JTextField();
		txtCepEP.setColumns(10);
		txtCepEP.setBounds(10, 367, 150, 30);
		panelEnderecoPrincipal.add(txtCepEP);
		
		JPanel panelEnderecoEntrega = new JPanel();
		splitPane.setRightComponent(panelEnderecoEntrega);
		panelEnderecoEntrega.setLayout(null);
		
		JLabel lblEnderecoEntrega = new JLabel("Endere\u00E7o de Entrega");
		lblEnderecoEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnderecoEntrega.setFont(new Font("Leelawadee UI", Font.BOLD, 16));
		lblEnderecoEntrega.setBounds(10, 11, 451, 47);
		panelEnderecoEntrega.add(lblEnderecoEntrega);
		
		JLabel lblEnderecoEE = new JLabel("Endere\u00E7o:");
		lblEnderecoEE.setSize(new Dimension(30, 0));
		lblEnderecoEE.setPreferredSize(new Dimension(30, 14));
		lblEnderecoEE.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblEnderecoEE.setBounds(10, 69, 76, 30);
		panelEnderecoEntrega.add(lblEnderecoEE);
		
		txtEnderecoEE = new JTextField();
		txtEnderecoEE.setColumns(10);
		txtEnderecoEE.setBounds(10, 99, 451, 30);
		panelEnderecoEntrega.add(txtEnderecoEE);
		
		JLabel lblNumeroEE = new JLabel("N\u00B0:");
		lblNumeroEE.setSize(new Dimension(30, 0));
		lblNumeroEE.setPreferredSize(new Dimension(30, 14));
		lblNumeroEE.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblNumeroEE.setBounds(10, 156, 37, 30);
		panelEnderecoEntrega.add(lblNumeroEE);
		
		txtNumeroEE = new JTextField();
		txtNumeroEE.setColumns(10);
		txtNumeroEE.setBounds(10, 186, 76, 30);
		panelEnderecoEntrega.add(txtNumeroEE);
		
		JLabel lblBairroEE = new JLabel("Bairro:");
		lblBairroEE.setSize(new Dimension(30, 0));
		lblBairroEE.setPreferredSize(new Dimension(30, 14));
		lblBairroEE.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblBairroEE.setBounds(104, 156, 58, 30);
		panelEnderecoEntrega.add(lblBairroEE);
		
		txtBairroEE = new JTextField();
		txtBairroEE.setColumns(10);
		txtBairroEE.setBounds(104, 186, 357, 30);
		panelEnderecoEntrega.add(txtBairroEE);
		
		JLabel lblComplementoEE = new JLabel("Complemento:");
		lblComplementoEE.setSize(new Dimension(30, 0));
		lblComplementoEE.setPreferredSize(new Dimension(30, 14));
		lblComplementoEE.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblComplementoEE.setBounds(10, 247, 117, 30);
		panelEnderecoEntrega.add(lblComplementoEE);
		
		txtComplementoEE = new JTextField();
		txtComplementoEE.setColumns(10);
		txtComplementoEE.setBounds(10, 277, 451, 30);
		panelEnderecoEntrega.add(txtComplementoEE);
		
		JLabel lblCepEE = new JLabel("Cep:");
		lblCepEE.setSize(new Dimension(30, 0));
		lblCepEE.setPreferredSize(new Dimension(30, 14));
		lblCepEE.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblCepEE.setBounds(10, 337, 46, 30);
		panelEnderecoEntrega.add(lblCepEE);
		
		txtCepEE = new JTextField();
		txtCepEE.setColumns(10);
		txtCepEE.setBounds(10, 367, 150, 30);
		panelEnderecoEntrega.add(txtCepEE);
		
		checkboxConfigEndereco = new JCheckBox("O endere\u00E7o de entrega \u00E9 o mesmo do endere\u00E7o principal!");
		checkboxConfigEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblEnderecoEntrega.setEnabled(checkboxConfigEndereco.isSelected() == false);
				lblEnderecoEE.setEnabled(checkboxConfigEndereco.isSelected() == false);
				txtEnderecoEE.setEnabled(checkboxConfigEndereco.isSelected() == false);
				lblNumeroEE.setEnabled(checkboxConfigEndereco.isSelected() == false);
				txtNumeroEE.setEnabled(checkboxConfigEndereco.isSelected() == false);
				lblBairroEE.setEnabled(checkboxConfigEndereco.isSelected() == false);
				txtBairroEE.setEnabled(checkboxConfigEndereco.isSelected() == false);
				lblComplementoEE.setEnabled(checkboxConfigEndereco.isSelected() == false);
				txtComplementoEE.setEnabled(checkboxConfigEndereco.isSelected() == false);
				lblCepEE.setEnabled(checkboxConfigEndereco.isSelected() == false);
				txtCepEE.setEnabled(checkboxConfigEndereco.isSelected() == false);
				
				if(cliente != null) {
					
					List<Endereco> enderecos = clientesTableModel.capturarEnderecos(cliente.getId());
					
					if(checkboxConfigEndereco.isSelected() == true) {
						if(enderecos.size() == 2) {
						
							Endereco endereco = enderecos.get(1);
							clientesTableModel.deletarEndereco(endereco);
							
							endereco = enderecos.get(0);
							endereco.setEnderecoEntrega("Sim");
							clientesTableModel.alterarEndereco(endereco);
							
							txtEnderecoEE.setText("");
							txtNumeroEE.setText("");
							txtBairroEE.setText("");
							txtComplementoEE.setText("");
							txtCepEE.setText("");
						}
					}
				}
			}
		});
		checkboxConfigEndereco.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		checkboxConfigEndereco.setBounds(10, 459, 451, 38);
		panelEnderecoPrincipal.add(checkboxConfigEndereco);
		
		if(cliente != null) {
			capturarDados(cliente);
		}
		
		if(checkboxConfigEndereco.isSelected() == true) {
			
			lblEnderecoEntrega.setEnabled(false);
			lblEnderecoEE.setEnabled(false);
			txtEnderecoEE.setEnabled(false);
			lblNumeroEE.setEnabled(false);
			txtNumeroEE.setEnabled(false);
			lblBairroEE.setEnabled(false);
			txtBairroEE.setEnabled(false);
			lblComplementoEE.setEnabled(false);
			txtComplementoEE.setEnabled(false);
			lblCepEE.setEnabled(false);
			txtCepEE.setEnabled(false);
		}

		JPanel panelAcoes = new JPanel();
		panelAcoes.setBorder(null);
		panelAcoes.setBackground(Color.DARK_GRAY);
		panelAcoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelAcoes, BorderLayout.SOUTH);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(cliente == null) {
					
					Cliente cliente = new Cliente();
					
					cliente.setNome(txtNome.getText());
					cliente.setCpf(txtCpf.getText());
					if(rdbtnMasculino.isSelected()) cliente.setGenero(rdbtnMasculino.getText()); else cliente.setGenero(rdbtnFeminino.getText());
					
					List<Endereco> enderecos = new ArrayList<>();
					Endereco endereco = new Endereco();
					
					endereco.setEndereco(txtEnderecoEP.getText());
					endereco.setNumero(Integer.valueOf(txtNumeroEP.getText()));
					endereco.setBairro(txtBairroEP.getText());
					endereco.setComplemento(txtComplementoEP.getText());
					endereco.setCep(Integer.valueOf(txtCepEP.getText()));
					if(checkboxConfigEndereco.isSelected()) endereco.setEnderecoEntrega("Sim"); else endereco.setEnderecoEntrega("Não");
					
					enderecos.add(endereco);
					
					if(endereco.getEnderecoEntrega().equals("Não")) {
						
						endereco = new Endereco();
						
						endereco.setEndereco(txtEnderecoEE.getText());
						endereco.setNumero(Integer.valueOf(txtNumeroEE.getText()));
						endereco.setBairro(txtBairroEE.getText());
						endereco.setComplemento(txtComplementoEE.getText());
						endereco.setCep(Integer.valueOf(txtCepEE.getText()));
						endereco.setEnderecoEntrega("Sim");
						
						enderecos.add(endereco);
					}
					
					clientesTableModel.adicionarCliente(cliente, enderecos);
				}
				else {
					
					cliente.setNome(txtNome.getText());
					cliente.setCpf(txtCpf.getText());
					if(rdbtnMasculino.isSelected()) cliente.setGenero(rdbtnMasculino.getText()); else cliente.setGenero(rdbtnFeminino.getText());
					
					List<Endereco> enderecos = clientesTableModel.capturarEnderecos(cliente.getId());
					Endereco endereco = enderecos.get(0);
					
					endereco.setEndereco(txtEnderecoEP.getText());
					endereco.setNumero(Integer.valueOf(txtNumeroEP.getText()));
					endereco.setBairro(txtBairroEP.getText());
					endereco.setComplemento(txtComplementoEP.getText());
					endereco.setCep(Integer.valueOf(txtCepEP.getText()));
					if(checkboxConfigEndereco.isSelected() == true) endereco.setEnderecoEntrega("Sim"); else endereco.setEnderecoEntrega("Não");
					endereco.setIdClientes(cliente);
					
					enderecos.set(0, endereco);
					
					if(endereco.getEnderecoEntrega().equals("Não")) {
						
						if(enderecos.size() < 2) {
							
							enderecos.get(0).setEnderecoEntrega("Não");
							
							clientesTableModel.alterarEndereco(endereco);
							
							endereco = new Endereco();
							
							endereco.setEndereco(txtEnderecoEE.getText());
							endereco.setNumero(Integer.valueOf(txtNumeroEE.getText()));
							endereco.setBairro(txtBairroEE.getText());
							endereco.setComplemento(txtComplementoEE.getText());
							endereco.setCep(Integer.valueOf(txtCepEE.getText()));
							endereco.setEnderecoEntrega("Sim");
							endereco.setIdClientes(cliente);
							
							enderecos.add(endereco);
							
							clientesTableModel.adicionarEnderecoEntrega(endereco);
						}
						else {
							
							endereco = enderecos.get(1);
							
							endereco.setEndereco(txtEnderecoEE.getText());
							endereco.setNumero(Integer.valueOf(txtNumeroEE.getText()));
							endereco.setBairro(txtBairroEE.getText());
							endereco.setComplemento(txtComplementoEE.getText());
							endereco.setCep(Integer.valueOf(txtCepEE.getText()));
							endereco.setEnderecoEntrega("Sim");
							endereco.setIdClientes(cliente);
							
							clientesTableModel.alterarCliente(cliente, enderecos);
						}
					}
				}
				
				enderecos = clientesTableModel.capturarEnderecos(cliente.getId());
				
				txtNome.setText("");
				txtCpf.setText("");
				generoBtns.clearSelection();
				
				dispose();
			}
		});
		btnSalvar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {

				btnSalvar.setBackground(new Color(173, 216, 230));
			}

			@Override
			public void mouseExited(MouseEvent e) {

				btnSalvar.setBackground(Color.DARK_GRAY);
			}
		});
		btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvar.setMargin(new Insets(0, 0, 0, 0));
		btnSalvar.setFocusable(false);
		btnSalvar.setFont(new Font("Leelawadee", Font.BOLD, 12));
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(Color.DARK_GRAY);
		btnSalvar.setPreferredSize(new Dimension(70, 23));
		btnSalvar.setBorder(null);
		btnSalvar.setActionCommand("OK");
		panelAcoes.add(btnSalvar);
		getRootPane().setDefaultButton(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
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
	
	protected void capturarDados(Cliente cliente) {
		
		txtNome.setText(cliente.getNome());
		txtCpf.setText(cliente.getCpf());
		if(cliente.getGenero().equals("Masculino")) rdbtnMasculino.setSelected(true); else rdbtnFeminino.setSelected(true);
		
		enderecos = clientesTableModel.capturarEnderecos(cliente.getId());
		
		txtEnderecoEP.setText(enderecos.get(0).getEndereco());
		txtNumeroEP.setText(String.valueOf(enderecos.get(0).getNumero()));
		txtBairroEP.setText(enderecos.get(0).getBairro());
		txtComplementoEP.setText(enderecos.get(0).getComplemento());
		txtCepEP.setText(String.valueOf(enderecos.get(0).getCep()));
		if(enderecos.get(0).getEnderecoEntrega().equals("Sim")) checkboxConfigEndereco.setSelected(true); else checkboxConfigEndereco.setSelected(false);
		
		if(checkboxConfigEndereco.isSelected() == false) {
			
			txtEnderecoEE.setText(enderecos.get(1).getEndereco());
			txtNumeroEE.setText(String.valueOf(enderecos.get(1).getNumero()));
			txtBairroEE.setText(enderecos.get(1).getBairro());
			txtComplementoEE.setText(enderecos.get(1).getComplemento());
			txtCepEE.setText(String.valueOf(enderecos.get(1).getCep()));
		}
	}
}
