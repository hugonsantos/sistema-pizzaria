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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import model.entities.Produto;
import model.table.PizzasSalgadasTableModel;
import model.util.ImagensUtil;
import model.util.ModalUtil;
import model.util.TableModelUtil;

public class ModalSelecaoCliente extends ModalCustom {

	private static final long serialVersionUID = 1L;

	private JTable tableClientes;

	private PizzasSalgadasTableModel pizzasSalgadasTableModel = new PizzasSalgadasTableModel();
	
	private Produto produto;

	private JPanel panelCabecalho;
	private JPanel panelCabecalhoCliente;
	private JPanel panelPesquisarCliente;
	private JPanel panelSelecaoCliente;
	private JPanel panelClientes;
	
	private JScrollPane spCliente;
	private JTextField txtPesquisarCliente;
	private JLabel lblClientes;
	private JLabel lblPesquisarCliente;

	private static Boolean confirmacao = false;

	private Boolean selecaoSabor;

	private Integer quantSabores;

	private String catSabor1 = "";
	private String catSabor2 = "";
	private String catSabor3 = "";
	private String catSabor4 = "";

	public static void main(String[] args) {

		ModalSelecaoSabores ss = new ModalSelecaoSabores();

		ModalUtil.MovimentacaoModal(ss);
		ss.setLocationRelativeTo(null);
		ss.setVisible(true);
	}

	public ModalSelecaoCliente() {

		setBounds(100, 100, 800, 600);
		
		JPanel panelSelecao = new JPanel();
		panelSelecao.setBackground(Color.WHITE);
		getContentPane().add(panelSelecao, BorderLayout.CENTER);
		panelSelecao.setLayout(new BorderLayout(0, 0));

		panelCabecalho = new JPanel();
		panelCabecalho.setPreferredSize(new Dimension(10, 130));
		panelCabecalho.setBounds(new Rectangle(0, 0, 0, 100));
		panelCabecalho.setMinimumSize(new Dimension(10, 100));
		panelSelecao.add(panelCabecalho, BorderLayout.NORTH);
		panelCabecalho.setLayout(new BoxLayout(panelCabecalho, BoxLayout.X_AXIS));
		
		panelCabecalhoCliente = new JPanel();
		panelCabecalho.add(panelCabecalhoCliente);
		panelCabecalhoCliente.setLayout(new BorderLayout());

		lblPesquisarCliente = new JLabel("Pesquisar cliente:");
		lblPesquisarCliente.setBorder(new EmptyBorder(0, 0, 0, 130));
		lblPesquisarCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesquisarCliente.setFont(new Font("Leelawadee UI", Font.BOLD, 11));
		panelCabecalhoCliente.add(lblPesquisarCliente, BorderLayout.NORTH);

		panelPesquisarCliente = new JPanel();
		panelPesquisarCliente.setPreferredSize(new Dimension(230, 10));
		panelCabecalhoCliente.add(panelPesquisarCliente, BorderLayout.EAST);
		
		txtPesquisarCliente = new JTextField();
		txtPesquisarCliente.setPreferredSize(new Dimension(220, 25));
		txtPesquisarCliente.addKeyListener(new KeyAdapter() {

			private void doClick() {

				@SuppressWarnings("unchecked")
				final TableRowSorter<PizzasSalgadasTableModel> sorter = (TableRowSorter<PizzasSalgadasTableModel>) TableModelUtil
						.filtrarTabela(tableClientes, txtPesquisarCliente.getText(), 1);
				tableClientes.setRowSorter(sorter);
			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (txtPesquisarCliente.getText().length() - 1 == 0) {

						tableClientes.setRowSorter(null);
						tableClientes.revalidate();
					}
				}
				else if (txtPesquisarCliente.getText().length() + 1 > 0)
					doClick();
			}
		});
		txtPesquisarCliente.setBorder(null);
		txtPesquisarCliente.setToolTipText("Pesquise pelo nome da pizza salgada!");
		panelPesquisarCliente.add(txtPesquisarCliente);
		
		lblClientes = new JLabel("Clientes");
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblClientes.setFont(new Font("Leelawadee UI", Font.BOLD, 19));
		panelCabecalhoCliente.add(lblClientes, BorderLayout.SOUTH);

		panelSelecaoCliente = new JPanel();
		panelSelecaoCliente.setBorder(null);
		panelSelecaoCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelSelecaoCliente.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelSelecaoCliente.setLayout(new BoxLayout(panelSelecaoCliente, BoxLayout.X_AXIS));
		panelSelecao.add(panelSelecaoCliente);
		
		panelClientes = new JPanel();
		panelSelecaoCliente.add(panelClientes);
		
		tableClientes = new JTable();
		tableClientes.setSelectionForeground(Color.WHITE);
		tableClientes.setSelectionBackground(Color.DARK_GRAY);
		tableClientes.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				
			}
		});
		tableClientes.setModel(pizzasSalgadasTableModel);
		tableClientes.setFont(new Font("Leelawadee UI", Font.BOLD, 12));
		tableClientes.setShowVerticalLines(false);
		tableClientes.setBorder(null);
		tableClientes.setFocusable(false);
		tableClientes.setRowHeight(180);
		tableClientes.getColumnModel().getColumn(0).setCellRenderer(new ImagensUtil());
		tableClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableClientes.getColumnModel().getColumn(2).setPreferredWidth(10);
		panelClientes.setLayout(new BoxLayout(panelClientes, BoxLayout.X_AXIS));

		spCliente = new JScrollPane(tableClientes);
		spCliente.setColumnHeaderView(tableClientes.getTableHeader());
		spCliente.getColumnHeader().setVisible(false);
		spCliente.getViewport().setBackground(Color.WHITE);
		spCliente.setViewportBorder(null);
		spCliente.setBorder(null);
		panelClientes.add(spCliente);

		JPanel panelAcoes = new JPanel();
		panelAcoes.setBorder(null);
		panelAcoes.setBackground(Color.DARK_GRAY);
		panelAcoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelAcoes, BorderLayout.SOUTH);

		JButton btnLimparSelecao = new JButton("Limpar sele\u00E7\u00E3o");
		btnLimparSelecao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (tableClientes.getSelectedRow() != -1) tableClientes.clearSelection();

				if ( ! txtPesquisarCliente.getText().equals("")) {
					
					txtPesquisarCliente.setText("");
					tableClientes.setRowSorter(null);
					tableClientes.revalidate();
				}

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

				if(tableClientes.getSelectedRow() != -1) {

					if (tableClientes.getRowSorter() != null) {

						produto = pizzasSalgadasTableModel.capturarSelecionado(tableClientes.getRowSorter()
								.convertRowIndexToModel(tableClientes.getSelectedRow()));
					}
					else {

						produto = pizzasSalgadasTableModel.capturarSelecionado(tableClientes.getSelectedRow());
					}
					
					confirmacao = true;
				}

				tableClientes.clearSelection();

				if (!txtPesquisarCliente.getText().equals("")) txtPesquisarCliente.setText(""); tableClientes.setRowSorter(null); tableClientes.revalidate();
				
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

				confirmacao = false;

				tableClientes.clearSelection();

				if (!txtPesquisarCliente.getText().equals("")) txtPesquisarCliente.setText(""); tableClientes.setRowSorter(null); tableClientes.revalidate();

				btnCancelar.setBackground(Color.DARK_GRAY);
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

	public Boolean getSelecaoSabor() {
		return selecaoSabor;
	}

	public void setSelecaoSabor(Boolean selecaoSabor) {
		this.selecaoSabor = selecaoSabor;
	}

	public Integer getQuantSabores() {
		return quantSabores;
	}

	public void setQuantSabores(Integer quantSabores) {
		this.quantSabores = quantSabores;
	}

	public String getCatSabor1() {
		return catSabor1;
	}

	public void setCatSabor1(String catSabor1) {
		this.catSabor1 = catSabor1;
	}

	public String getCatSabor2() {
		return catSabor2;
	}

	public void setCatSabor2(String catSabor2) {
		this.catSabor2 = catSabor2;
	}

	public String getCatSabor3() {
		return catSabor3;
	}

	public void setCatSabor3(String catSabor3) {
		this.catSabor3 = catSabor3;
	}

	public String getCatSabor4() {
		return catSabor4;
	}

	public void setCatSabor4(String catSabor4) {
		this.catSabor4 = catSabor4;
	}

	public void ativarTabelas(Boolean ativarTableSalagada, Boolean ativarTableDoce) {
		
		if(ativarTableSalagada && ativarTableDoce) {
			
			spCliente.setVisible(ativarTableSalagada);
			panelCabecalhoCliente.setVisible(ativarTableSalagada);
			
			panelCabecalho.revalidate();
		}
		else if(ativarTableSalagada) {
			
			alinharCabecalhoSalgada();
		}
		else {
			
			alinharCabecalhoDoce();
		}
	}
	
	public void controleTablePizzas(Boolean check) {
		
		if (check) {

			if (quantSabores == 4) {

				if ( ! catSabor1.equals("")) {

					if(catSabor1.equals("Pizza salgada") && catSabor2.equals("Pizza salgada") && catSabor3.equals("Pizza salgada")) {
						
						alinharCabecalhoDoce();
					}
					else if(catSabor1.equals("Pizza doce") && catSabor2.equals("Pizza doce") && catSabor3.equals("Pizza doce")) {
						
						alinharCabecalhoSalgada();
					}
				}
			}
			else if (quantSabores == 3 || quantSabores == 2) {

				if (catSabor1.equals("Pizza salgada")) {

					alinharCabecalhoDoce();
				}
				else if (catSabor1.equals("Pizza doce")) {

					alinharCabecalhoSalgada();
				}
			}
		}
		else if (catSabor1.equals("Pizza doce")) {

			alinharCabecalhoDoce();
		}
		else if (catSabor1.equals("Pizza salgada")) {

			alinharCabecalhoSalgada();
		}
	}
	
	private void alinharCabecalhoSalgada() {
		
		spCliente.setVisible(true);
		
		panelCabecalhoCliente.setVisible(true);
		
		panelCabecalho.revalidate();
	}
	
	private void alinharCabecalhoDoce() {
		
		spCliente.setVisible(false);
		
		panelCabecalhoCliente.setVisible(false);
		
		panelCabecalho.revalidate();
	}

	public void limparConfirmacao() {

		confirmacao = false;
	}

	public Boolean produtoSelecionado() {
		
		if (confirmacao) return confirmacao; else return false;
	}

	public Produto retornarProdutoSelecionado() {

		return produto;
	}
	
	public String verificarCategorias(Boolean check, Produto p) {
		
		String confirmacao = "";
		
		if(check) {
			
			if(p != null) {
				
				if(getCatSabor1().equals(p.getCategoria().getCategoria()) && getCatSabor2().equals(p.getCategoria().getCategoria()) && 
						getCatSabor3().equals(p.getCategoria().getCategoria()) && getCatSabor4().equals(p.getCategoria().getCategoria())) {
					
					if(p.getCategoria().getCategoria().equals("Pizza salgada")) {
						
						confirmacao = "Desculpe, pelo menos um sabor deve ser doce!";
					}
					else {
						
						confirmacao = "Desculpe, pelo menos um sabor deve ser salgada!";
					}
				}
			}
		}
		
		return confirmacao;
	}
}
