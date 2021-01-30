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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.dao.FabricaDao;
import model.dao.ProdutoDao;
import model.entities.Categoria;
import model.entities.Produto;
import model.table.ProdutosTableModel;
import model.util.ImagensUtil;
import model.util.ModalUtil;
import views.modal.enums.ModalAlertaEnum;

public final class ModalProdutos extends ModalCustom {

	private static final long serialVersionUID = 1L;

	private JTextField txtCaminhoImagem;
	private JFileChooser jfcSelecaoImagem;
	private JLabel lblImagem;
	private JTextField txtNome;
	private JTextArea txtDescricao;
	private JTextField txtValorBroto;
	private JComboBox<Object> cbxCategoria;
			
	private ProdutoDao produtoDao = FabricaDao.createProdutoDao();
	private JTextField txtValorTradicional;
	private JTextField txtValorGrande;
	private JTextField txtValorExtraGrande;
	
	public ModalProdutos(ProdutosTableModel produtosTableModel, Produto produto) {
		
		JPanel panelDadosProdutos = new JPanel();
		getContentPane().add(panelDadosProdutos, BorderLayout.CENTER);
		panelDadosProdutos.setLayout(null);

		JPanel panelImagem = new JPanel();
		panelImagem.setBounds(0, 2, 556, 324);
		panelDadosProdutos.add(panelImagem);
		panelImagem.setLayout(null);

		JLabel lblCaminhoImagem = new JLabel("Caminho da imagem:");
		lblCaminhoImagem.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblCaminhoImagem.setBounds(10, 11, 536, 20);
		panelImagem.add(lblCaminhoImagem);

		txtCaminhoImagem = new JTextField();
		txtCaminhoImagem.setEnabled(false);
		txtCaminhoImagem.setSize(new Dimension(0, 60));
		txtCaminhoImagem.setMinimumSize(new Dimension(7, 60));
		txtCaminhoImagem.setPreferredSize(new Dimension(0, 60));
		txtCaminhoImagem.setBounds(10, 40, 536, 36);
		panelImagem.add(txtCaminhoImagem);
		
		lblImagem = new JLabel();
		lblImagem.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblImagem.setBounds(159, 123, 230, 190);
		panelImagem.add(lblImagem);
		
		JButton btnSelecionarImagem = new JButton("Selecionar imagem");
		btnSelecionarImagem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String destino = System.getProperty("user.dir") + "//src//imagens//";
				
				jfcSelecaoImagem = new JFileChooser(System.getProperty("user.dir"));
				jfcSelecaoImagem.setApproveButtonText("Selecionar");
				
				if(jfcSelecaoImagem.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					
					File fRemetenteImagem = jfcSelecaoImagem.getSelectedFile();
					
					txtCaminhoImagem.setText(fRemetenteImagem.getName());
					
					ImageIcon imgProduto = ImagensUtil.redimensionarImagem(new ImageIcon(fRemetenteImagem.getAbsolutePath()), 230, 190);
					lblImagem.setIcon(imgProduto);
					
					try {
						
						File fDestinoImagem = new File(destino + fRemetenteImagem.getName());
						
						if(Files.notExists(fDestinoImagem.toPath())) {
							
							Files.copy(fRemetenteImagem.toPath(), fDestinoImagem.toPath());
						}
					}
					catch (IOException e2) {

						e2.printStackTrace();
						
						ModalAlerta modalAlerta = new ModalAlerta("Erro ao copiar a imagem!", ModalAlertaEnum.ERRO);

						ModalUtil.MovimentacaoModal(modalAlerta);
						modalAlerta.setLocationRelativeTo(null);
						modalAlerta.setVisible(true);
						
					}
				}
			}
		});
		btnSelecionarImagem.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		btnSelecionarImagem.setBounds(374, 87, 172, 30);
		panelImagem.add(btnSelecionarImagem);

		JPanel panelNome = new JPanel();
		panelNome.setBounds(0, 326, 556, 107);
		panelNome.setLayout(null);
		panelDadosProdutos.add(panelNome);

		JLabel lblNome = new JLabel("Nome do produto:");
		lblNome.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblNome.setBounds(44, 26, 441, 20);
		panelNome.add(lblNome);

		txtNome = new JTextField();
		txtNome.setSize(new Dimension(0, 60));
		txtNome.setMinimumSize(new Dimension(7, 60));
		txtNome.setPreferredSize(new Dimension(0, 60));
		txtNome.setColumns(10);
		txtNome.setBounds(44, 53, 441, 30);
		panelNome.add(txtNome);

		JPanel panelDescricao = new JPanel();
		panelDescricao.setBounds(555, 2, 395, 324);
		panelDescricao.setLayout(null);
		panelDadosProdutos.add(panelDescricao);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o do produto:");
		lblDescricao.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblDescricao.setBounds(10, 11, 193, 20);
		panelDescricao.add(lblDescricao);

		txtDescricao = new JTextArea();
		txtDescricao.setSize(new Dimension(0, 60));
		txtDescricao.setMinimumSize(new Dimension(7, 60));
		txtDescricao.setPreferredSize(new Dimension(0, 60));
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(10, 42, 375, 271);
		panelDescricao.add(txtDescricao);

		JPanel panelValor = new JPanel();
		panelValor.setBounds(555, 326, 395, 213);
		panelValor.setLayout(null);
		panelDadosProdutos.add(panelValor);

		JLabel lblValorBroto = new JLabel("Valor Broto:");
		lblValorBroto.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblValorBroto.setBounds(42, 32, 140, 20);
		panelValor.add(lblValorBroto);

		txtValorBroto = new JTextField();
		txtValorBroto.setSize(new Dimension(0, 60));
		txtValorBroto.setMinimumSize(new Dimension(7, 60));
		txtValorBroto.setPreferredSize(new Dimension(0, 60));
		txtValorBroto.setColumns(10);
		txtValorBroto.setBounds(42, 56, 140, 30);
		panelValor.add(txtValorBroto);
		
		JLabel lblValorTradicional = new JLabel("Valor Tradicional:");
		lblValorTradicional.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblValorTradicional.setBounds(42, 119, 140, 20);
		panelValor.add(lblValorTradicional);
		
		txtValorTradicional = new JTextField();
		txtValorTradicional.setSize(new Dimension(0, 60));
		txtValorTradicional.setPreferredSize(new Dimension(0, 60));
		txtValorTradicional.setMinimumSize(new Dimension(7, 60));
		txtValorTradicional.setColumns(10);
		txtValorTradicional.setBounds(42, 142, 140, 30);
		panelValor.add(txtValorTradicional);
		
		JLabel lblValorGrande = new JLabel("Valor Grande:");
		lblValorGrande.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblValorGrande.setBounds(213, 32, 140, 20);
		panelValor.add(lblValorGrande);
		
		txtValorGrande = new JTextField();
		txtValorGrande.setSize(new Dimension(0, 60));
		txtValorGrande.setPreferredSize(new Dimension(0, 60));
		txtValorGrande.setMinimumSize(new Dimension(7, 60));
		txtValorGrande.setColumns(10);
		txtValorGrande.setBounds(213, 56, 140, 30);
		panelValor.add(txtValorGrande);
		
		JLabel lblValorExtraGrande = new JLabel("Valor Extra grande:");
		lblValorExtraGrande.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblValorExtraGrande.setBounds(213, 119, 140, 20);
		panelValor.add(lblValorExtraGrande);
		
		txtValorExtraGrande = new JTextField();
		txtValorExtraGrande.setSize(new Dimension(0, 60));
		txtValorExtraGrande.setPreferredSize(new Dimension(0, 60));
		txtValorExtraGrande.setMinimumSize(new Dimension(7, 60));
		txtValorExtraGrande.setColumns(10);
		txtValorExtraGrande.setBounds(213, 142, 140, 30);
		panelValor.add(txtValorExtraGrande);
		
		JPanel panelCategoria = new JPanel();
		panelCategoria.setBounds(0, 432, 556, 107);
		panelDadosProdutos.add(panelCategoria);
		panelCategoria.setLayout(null);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblCategoria.setBounds(48, 25, 263, 20);
		panelCategoria.add(lblCategoria);
		
		cbxCategoria = new JComboBox<>();
		cbxCategoria.setModel(new DefaultComboBoxModel<Object>(produtoDao.listarCategorias().toArray()));
		cbxCategoria.setBounds(48, 51, 263, 30);
		panelCategoria.add(cbxCategoria);
		
		if(produto != null) {
			capturarDados(produto);
		}

		JPanel panelAcoes = new JPanel();
		panelAcoes.setBorder(null);
		panelAcoes.setBackground(Color.DARK_GRAY);
		panelAcoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelAcoes, BorderLayout.SOUTH);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(produto == null) {
					
					Produto produto = new Produto();
					
					produto.setImagem(txtCaminhoImagem.getText());
					produto.setNome(txtNome.getText());
					produto.setDescricao(txtDescricao.getText());
					produto.setValorBroto(Double.valueOf(txtValorBroto.getText()));
					produto.setValorTradicional(Double.valueOf(txtValorTradicional.getText()));
					produto.setValorGrande(Double.valueOf(txtValorGrande.getText()));
					produto.setValorExtraGrande(Double.valueOf(txtValorExtraGrande.getText()));
					produto.setCategoria((Categoria) cbxCategoria.getSelectedItem());
					
					produtosTableModel.adicionarProduto(produto);
				}
				else {
					
					produto.setImagem(txtCaminhoImagem.getText());
					produto.setNome(txtNome.getText());
					produto.setDescricao(txtDescricao.getText());
					produto.setValorBroto(Double.valueOf(txtValorBroto.getText()));
					produto.setValorTradicional(Double.valueOf(txtValorTradicional.getText()));
					produto.setValorGrande(Double.valueOf(txtValorGrande.getText()));
					produto.setValorExtraGrande(Double.valueOf(txtValorExtraGrande.getText()));
					produto.setCategoria((Categoria) cbxCategoria.getSelectedItem());
					
					produtosTableModel.alterarProduto(produto);
				}
				
				produtosTableModel.fireTableDataChanged();
				
				txtNome.setText("");
				txtNome.setText("");
				txtDescricao.setText("");
				txtValorBroto.setText("");
				txtValorTradicional.setText("");
				txtValorGrande.setText("");
				txtValorExtraGrande.setText("");
				cbxCategoria.setSelectedIndex(0);
				
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
			
			@Override
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

	protected void capturarDados(Produto produto) {

		txtCaminhoImagem.setText(produto.getImagem());
		lblImagem.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(getClass().getResource("/imagens/" + produto.getImagem())), 230, 190));
		txtNome.setText(produto.getNome());
		txtDescricao.setText(produto.getDescricao());
		txtValorBroto.setText(String.valueOf(produto.getValorBroto()));
		txtValorTradicional.setText(String.valueOf(produto.getValorTradicional()));
		txtValorGrande.setText(String.valueOf(produto.getValorGrande()));
		txtValorExtraGrande.setText(String.valueOf(produto.getValorExtraGrande()));
		cbxCategoria.setSelectedItem(produto.getCategoria());
	}
}
