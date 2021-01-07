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
import javax.swing.JTextField;

import model.dao.FabricaDao;
import model.dao.ProdutosDao;
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
	private JTextField txtDescricao;
	private JTextField txtValor;
	private JTextField txtQuantidade;
	private JComboBox<Object> cbxCategoria;
	
	private static final String destino = System.getProperty("user.dir") + "\\src\\imagens\\";
			
	private ProdutosDao produtoDao = FabricaDao.createProdutosDao();
	
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
		lblCaminhoImagem.setBounds(10, 11, 172, 20);
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
			public void actionPerformed(ActionEvent e) {
				
				jfcSelecaoImagem = new JFileChooser();
				jfcSelecaoImagem.showOpenDialog(null);
				
				File fRemetenteImagem = jfcSelecaoImagem.getSelectedFile();
				
				txtCaminhoImagem.setText(fRemetenteImagem.getName());
				
				lblImagem.setIcon(new ImageIcon(fRemetenteImagem.getAbsolutePath()));
				ImageIcon imgProduto = ImagensUtil.redimensionarImagem(lblImagem, 230, 190);
				
				lblImagem.setIcon(imgProduto);
				
				File fDestinoImagem = new File(destino + fRemetenteImagem.getName());
				
				try {
					
					if(Files.exists(fDestinoImagem.toPath())) {
						
						ModalAlerta modalAlerta = new ModalAlerta("Essa imagem já existe no sistema!", ModalAlertaEnum.ALERTA);

						ModalUtil.MovimentacaoModal(modalAlerta);
						modalAlerta.setLocationRelativeTo(null);
						modalAlerta.setVisible(true);
					}
					else {
						
						Files.copy(fRemetenteImagem.toPath(), fDestinoImagem.toPath());
					}
				}
				catch (IOException e1) {

					e1.printStackTrace();
					
					ModalAlerta modalAlerta = new ModalAlerta("Erro ao copiar a imagem!", ModalAlertaEnum.ERRO);

					ModalUtil.MovimentacaoModal(modalAlerta);
					modalAlerta.setLocationRelativeTo(null);
					modalAlerta.setVisible(true);
					
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
		lblNome.setBounds(58, 26, 182, 20);
		panelNome.add(lblNome);

		txtNome = new JTextField();
		txtNome.setSize(new Dimension(0, 60));
		txtNome.setMinimumSize(new Dimension(7, 60));
		txtNome.setPreferredSize(new Dimension(0, 60));
		txtNome.setColumns(10);
		txtNome.setBounds(58, 53, 438, 30);
		panelNome.add(txtNome);

		JPanel panelDescricao = new JPanel();
		panelDescricao.setBounds(555, 2, 395, 431);
		panelDescricao.setLayout(null);
		panelDadosProdutos.add(panelDescricao);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o do produto:");
		lblDescricao.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblDescricao.setBounds(10, 11, 193, 20);
		panelDescricao.add(lblDescricao);

		txtDescricao = new JTextField();
		txtDescricao.setSize(new Dimension(0, 60));
		txtDescricao.setMinimumSize(new Dimension(7, 60));
		txtDescricao.setPreferredSize(new Dimension(0, 60));
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(10, 42, 375, 378);
		panelDescricao.add(txtDescricao);

		JPanel panelValor = new JPanel();
		panelValor.setBounds(0, 432, 395, 107);
		panelValor.setLayout(null);
		panelDadosProdutos.add(panelValor);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblValor.setBounds(58, 25, 55, 20);
		panelValor.add(lblValor);

		txtValor = new JTextField();
		txtValor.setSize(new Dimension(0, 60));
		txtValor.setMinimumSize(new Dimension(7, 60));
		txtValor.setPreferredSize(new Dimension(0, 60));
		txtValor.setColumns(10);
		txtValor.setBounds(58, 53, 185, 30);
		panelValor.add(txtValor);

		JPanel panelQuantidade = new JPanel();
		panelQuantidade.setBounds(394, 432, 201, 107);
		panelQuantidade.setLayout(null);
		panelDadosProdutos.add(panelQuantidade);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblQuantidade.setBounds(58, 25, 103, 20);
		panelQuantidade.add(lblQuantidade);

		txtQuantidade = new JTextField();
		txtQuantidade.setSize(new Dimension(0, 60));
		txtQuantidade.setMinimumSize(new Dimension(7, 60));
		txtQuantidade.setPreferredSize(new Dimension(0, 60));
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(58, 53, 95, 30);
		panelQuantidade.add(txtQuantidade);
		
		JPanel panelCategoria = new JPanel();
		panelCategoria.setBounds(594, 432, 356, 107);
		panelDadosProdutos.add(panelCategoria);
		panelCategoria.setLayout(null);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblCategoria.setBounds(58, 25, 94, 20);
		panelCategoria.add(lblCategoria);
		
		cbxCategoria = new JComboBox<>();
		cbxCategoria.setModel(new DefaultComboBoxModel<Object>(produtoDao.listarCategorias().toArray()));
		cbxCategoria.setSelectedIndex(0);
		cbxCategoria.setBounds(58, 51, 185, 30);
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
					produto.setValor(Double.valueOf(txtValor.getText()));
					produto.setQuantidade(Integer.valueOf(txtQuantidade.getText()));
					produto.setCategoria((Categoria) cbxCategoria.getSelectedItem());
					
					produtosTableModel.adicionarProduto(produto);
				}
				else {
					
					produto.setImagem(txtCaminhoImagem.getText());
					produto.setNome(txtNome.getText());
					produto.setDescricao(txtDescricao.getText());
					produto.setValor(Double.valueOf(txtValor.getText()));
					produto.setQuantidade(Integer.valueOf(txtQuantidade.getText()));
					produto.setCategoria((Categoria) cbxCategoria.getSelectedItem());
					
					produtosTableModel.alterarProduto(produto);
				}
				
				produtosTableModel.fireTableDataChanged();
				
				txtNome.setText("");
				txtNome.setText("");
				txtDescricao.setText("");
				txtValor.setText("");
				txtQuantidade.setText("");
				
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

	protected void capturarDados(Produto produto) {

		txtCaminhoImagem.setText(produto.getImagem());
		lblImagem.setIcon(new ImageIcon(destino + produto.getImagem()));
		ImageIcon imgProduto = ImagensUtil.redimensionarImagem(lblImagem, 230, 190);
		lblImagem.setIcon(imgProduto);
		txtNome.setText(produto.getNome());
		txtDescricao.setText(produto.getDescricao());
		txtValor.setText(String.valueOf(produto.getValor()));
		txtQuantidade.setText(String.valueOf(produto.getQuantidade()));
		cbxCategoria.setSelectedItem(produto.getCategoria());
	}
}
