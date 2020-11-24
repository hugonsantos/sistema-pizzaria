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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.entities.Funcionarios;
import model.table.FuncionariosTableModel;

public final class ModalFuncionario extends ModalCustom {

	private static final long serialVersionUID = 1L;

	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtDataNascimento;
	private JTextField txtCpf;
	private JTextField txtApelido;
	private JPasswordField ptxtSenha;
	private JRadioButton rdbtnSim;
	private JRadioButton rdbtnNao;

	private ButtonGroup administradorBtns = new ButtonGroup();

	public ModalFuncionario(FuncionariosTableModel funcionariosTableModel) {

		JPanel panelDadosCadastrais = new JPanel();
		getContentPane().add(panelDadosCadastrais, BorderLayout.CENTER);
		panelDadosCadastrais.setLayout(new GridLayout(5, 2));

		JPanel panelNome = new JPanel();
		panelDadosCadastrais.add(panelNome);
		panelNome.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblNome.setBounds(58, 31, 55, 14);
		panelNome.add(lblNome);

		txtNome = new JTextField();
		txtNome.setSize(new Dimension(0, 60));
		txtNome.setMinimumSize(new Dimension(7, 60));
		txtNome.setPreferredSize(new Dimension(0, 60));
		txtNome.setBounds(58, 53, 358, 29);
		panelNome.add(txtNome);
		txtNome.setColumns(10);

		JPanel panelEmail = new JPanel();
		panelEmail.setLayout(null);
		panelDadosCadastrais.add(panelEmail);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblEmail.setBounds(58, 31, 55, 14);
		panelEmail.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setSize(new Dimension(0, 60));
		txtEmail.setMinimumSize(new Dimension(7, 60));
		txtEmail.setPreferredSize(new Dimension(0, 60));
		txtEmail.setColumns(10);
		txtEmail.setBounds(58, 53, 358, 29);
		panelEmail.add(txtEmail);

		JPanel panelDataNascimento = new JPanel();
		panelDataNascimento.setLayout(null);
		panelDadosCadastrais.add(panelDataNascimento);

		JLabel lblDataNascimento = new JLabel("Data de nascimento:");
		lblDataNascimento.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblDataNascimento.setBounds(58, 31, 148, 14);
		panelDataNascimento.add(lblDataNascimento);

		txtDataNascimento = new JTextField();
		txtDataNascimento.setSize(new Dimension(0, 60));
		txtDataNascimento.setMinimumSize(new Dimension(7, 60));
		txtDataNascimento.setPreferredSize(new Dimension(0, 60));
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(58, 53, 206, 29);
		panelDataNascimento.add(txtDataNascimento);

		JPanel panelCpf = new JPanel();
		panelCpf.setLayout(null);
		panelDadosCadastrais.add(panelCpf);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblCpf.setBounds(58, 31, 55, 14);
		panelCpf.add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setSize(new Dimension(0, 60));
		txtCpf.setMinimumSize(new Dimension(7, 60));
		txtCpf.setPreferredSize(new Dimension(0, 60));
		txtCpf.setColumns(10);
		txtCpf.setBounds(58, 53, 185, 29);
		panelCpf.add(txtCpf);

		JPanel panelApelido = new JPanel();
		panelApelido.setLayout(null);
		panelDadosCadastrais.add(panelApelido);

		JLabel lblApelido = new JLabel("Apelido:");
		lblApelido.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblApelido.setBounds(58, 31, 73, 14);
		panelApelido.add(lblApelido);

		txtApelido = new JTextField();
		txtApelido.setSize(new Dimension(0, 60));
		txtApelido.setMinimumSize(new Dimension(7, 60));
		txtApelido.setPreferredSize(new Dimension(0, 60));
		txtApelido.setColumns(10);
		txtApelido.setBounds(58, 53, 264, 29);
		panelApelido.add(txtApelido);

		JPanel panelSenha = new JPanel();
		panelSenha.setLayout(null);
		panelDadosCadastrais.add(panelSenha);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblSenha.setBounds(58, 31, 66, 14);
		panelSenha.add(lblSenha);

		ptxtSenha = new JPasswordField();
		ptxtSenha.setSize(new Dimension(0, 60));
		ptxtSenha.setMinimumSize(new Dimension(7, 60));
		ptxtSenha.setPreferredSize(new Dimension(0, 60));
		ptxtSenha.setBounds(58, 49, 254, 33);
		panelSenha.add(ptxtSenha);

		JPanel panelAdministrador = new JPanel();
		panelAdministrador.setLayout(null);
		panelDadosCadastrais.add(panelAdministrador);

		JLabel lblAdministrador = new JLabel("Administrador:");
		lblAdministrador.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblAdministrador.setBounds(61, 47, 114, 14);
		panelAdministrador.add(lblAdministrador);

		rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
		rdbtnSim.setBounds(194, 28, 53, 23);
		panelAdministrador.add(rdbtnSim);

		rdbtnNao = new JRadioButton("N\u00E3o");
		rdbtnNao.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
		rdbtnNao.setBounds(194, 64, 53, 23);
		panelAdministrador.add(rdbtnNao);

		administradorBtns.add(rdbtnSim);
		administradorBtns.add(rdbtnNao);

		JPanel panelAcoes = new JPanel();
		panelAcoes.setBorder(null);
		panelAcoes.setBackground(Color.DARK_GRAY);
		panelAcoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelAcoes, BorderLayout.SOUTH);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Funcionarios funcionario = new Funcionarios();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				try {
					
					funcionario.setNome(txtNome.getText());
					funcionario.setEmail(txtEmail.getText());
					funcionario.setDataNascimento(new Date(sdf.parse(txtDataNascimento.getText()).getTime()));
					funcionario.setCpf(txtCpf.getText());
					funcionario.setApelido(txtApelido.getText());
					funcionario.setSenha(String.copyValueOf(ptxtSenha.getPassword()));
					if(rdbtnSim.isSelected()) funcionario.setAdministrador(rdbtnSim.getText()); else funcionario.setAdministrador(rdbtnNao.getText());
					
					funcionariosTableModel.adicionarFuncionario(funcionario);
					
					txtNome.setText("");
					txtEmail.setText("");
					txtDataNascimento.setText("");
					txtCpf.setText("");
					txtApelido.setText("");
					ptxtSenha.setText("");
					administradorBtns.clearSelection();
					
				} catch (ParseException pe) {
					pe.printStackTrace();
				}
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
