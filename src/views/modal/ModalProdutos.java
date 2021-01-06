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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.dao.FabricaDao;
import model.dao.ProdutosDao;
import model.entities.Categoria;
import model.entities.Produto;
import model.table.ProdutosTableModel;

public final class ModalProdutos extends ModalCustom {

	private static final long serialVersionUID = 1L;

	private JTextField txtImagem;
	private JTextField txtNome;
	private JTextArea txtDescricao;
	private JTextField txtValor;
	private JTextField txtQuantidade;
	private JComboBox<Object> cbxCategoria;
			
	private ProdutosDao produtoDao = FabricaDao.createProdutosDao();
	
	public ModalProdutos(ProdutosTableModel produtosTableModel, Produto produto) {
		
		JPanel panelDadosProdutos = new JPanel();
		getContentPane().add(panelDadosProdutos, BorderLayout.CENTER);
		panelDadosProdutos.setLayout(null);

		JPanel panelImagem = new JPanel();
		panelImagem.setBounds(0, 2, 475, 107);
		panelDadosProdutos.add(panelImagem);
		panelImagem.setLayout(null);

		JLabel lblImagem = new JLabel("Imagem:");
		lblImagem.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblImagem.setBounds(58, 25, 73, 20);
		panelImagem.add(lblImagem);

		txtImagem = new JTextField();
		txtImagem.setSize(new Dimension(0, 60));
		txtImagem.setMinimumSize(new Dimension(7, 60));
		txtImagem.setPreferredSize(new Dimension(0, 60));
		txtImagem.setBounds(58, 53, 358, 29);
		panelImagem.add(txtImagem);
		txtImagem.setColumns(10);

		JPanel panelNome = new JPanel();
		panelNome.setBounds(475, 2, 475, 107);
		panelNome.setLayout(null);
		panelDadosProdutos.add(panelNome);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblNome.setBounds(58, 25, 55, 20);
		panelNome.add(lblNome);

		txtNome = new JTextField();
		txtNome.setSize(new Dimension(0, 60));
		txtNome.setMinimumSize(new Dimension(7, 60));
		txtNome.setPreferredSize(new Dimension(0, 60));
		txtNome.setColumns(10);
		txtNome.setBounds(58, 53, 358, 29);
		panelNome.add(txtNome);

		JPanel panelDescricao = new JPanel();
		panelDescricao.setBounds(0, 109, 475, 107);
		panelDescricao.setLayout(null);
		panelDadosProdutos.add(panelDescricao);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblDescricao.setBounds(58, 25, 148, 20);
		panelDescricao.add(lblDescricao);

		txtDescricao = new JTextArea();
		txtDescricao.setSize(new Dimension(0, 60));
		txtDescricao.setMinimumSize(new Dimension(7, 60));
		txtDescricao.setPreferredSize(new Dimension(0, 60));
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(58, 53, 359, 43);
		panelDescricao.add(txtDescricao);

		JPanel panelValor = new JPanel();
		panelValor.setBounds(475, 109, 475, 107);
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
		txtValor.setBounds(58, 53, 185, 29);
		panelValor.add(txtValor);

		JPanel panelQuantidade = new JPanel();
		panelQuantidade.setBounds(0, 216, 475, 107);
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
		txtQuantidade.setBounds(58, 53, 264, 29);
		panelQuantidade.add(txtQuantidade);

		JPanel panelCategoria = new JPanel();
		panelCategoria.setBounds(475, 216, 475, 107);
		panelCategoria.setLayout(null);
		panelDadosProdutos.add(panelCategoria);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblCategoria.setBounds(58, 25, 94, 20);
		panelCategoria.add(lblCategoria);
		
		cbxCategoria = new JComboBox<>();
		cbxCategoria.setModel(new DefaultComboBoxModel<Object>(new String[] {"Selecione a categoria ...", "Pizza", "Lanche", "Esfiha", "Bebida"}));
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
					
					produto.setImagem(txtImagem.getText());
					produto.setNome(txtNome.getText());
					produto.setDescricao(txtDescricao.getText());
					produto.setValor(Double.valueOf(txtValor.getText()));
					produto.setQuantidade(Integer.valueOf(txtQuantidade.getText()));
					
					for(Categoria c : produtoDao.listarCategorias()) {
						
						if(cbxCategoria.getSelectedItem().equals(c.getCategoria())) {
							
							produto.setCategoria(new Categoria(c.getId(), c.getCategoria()));
						}
					}
					
					produtosTableModel.adicionarProduto(produto);
				}
				else {
					
					produto.setImagem(txtImagem.getText());
					produto.setNome(txtNome.getText());
					produto.setDescricao(txtDescricao.getText());
					produto.setValor(Double.valueOf(txtValor.getText()));
					produto.setQuantidade(Integer.valueOf(txtQuantidade.getText()));
					
					for(Categoria c : produtoDao.listarCategorias()) {
						
						if(cbxCategoria.getSelectedItem().equals(c.getCategoria())) {
							
							produto.setCategoria(new Categoria(c.getId(), c.getCategoria()));
						}
					}
					
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

		txtImagem.setText(produto.getImagem());
		txtNome.setText(produto.getNome());
		txtDescricao.setText(produto.getDescricao());
		txtValor.setText(String.valueOf(produto.getValor()));
		txtQuantidade.setText(String.valueOf(produto.getQuantidade()));
		cbxCategoria.setSelectedIndex(produto.getId());
	}
}
