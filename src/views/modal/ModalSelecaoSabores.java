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
import model.table.PizzasDocesTableModel;
import model.table.PizzasSalgadasTableModel;
import model.util.ImagensUtil;
import model.util.ModalUtil;
import model.util.TableModelUtil;

public class ModalSelecaoSabores extends ModalCustom {

	private static final long serialVersionUID = 1L;

	private JTable tablePizzasSalgadas;
	private JTable tablePizzasDoces;

	private PizzasSalgadasTableModel pizzasSalgadasTableModel = null;
	private PizzasDocesTableModel pizzasDocesTableModel = null;
	
	private Produto produto;

	private JPanel panelCabecalho;
	private JPanel panelCabecalhoSalgada;
	private JPanel panelCabecalhoDoce;
	private JPanel panelPesquisarPizzaSalgada;
	private JPanel panelPesquisarPizzaDoce;
	private JPanel panelSelecaoSabores;
	private JPanel panelPizzasSalgadas;
	private JPanel panelPizzasDoces;
	
	private JScrollPane spPizzasSalgadas;
	private JScrollPane spPizzasDoces;
	private JTextField txtPesquisarPizzaSalgada;
	private JTextField txtPesquisarPizzaDoce;
	private JLabel lblPizzasSalgadas;
	private JLabel lblPizzasDoces;
	private JLabel lblPesquisarSalgada;
	private JLabel lblPesquisarDoce;

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

	public ModalSelecaoSabores() {

		setBounds(100, 100, 1024, 738);
		
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
		
		panelCabecalhoSalgada = new JPanel();
		panelCabecalho.add(panelCabecalhoSalgada);
		panelCabecalhoSalgada.setLayout(new BorderLayout());

		lblPesquisarSalgada = new JLabel("Pesquisar pizza salgada:");
		lblPesquisarSalgada.setBorder(new EmptyBorder(0, 0, 0, 100));
		lblPesquisarSalgada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesquisarSalgada.setFont(new Font("Leelawadee UI", Font.BOLD, 11));
		panelCabecalhoSalgada.add(lblPesquisarSalgada, BorderLayout.NORTH);

		panelPesquisarPizzaSalgada = new JPanel();
		panelPesquisarPizzaSalgada.setPreferredSize(new Dimension(230, 10));
		panelCabecalhoSalgada.add(panelPesquisarPizzaSalgada, BorderLayout.EAST);
		
		txtPesquisarPizzaSalgada = new JTextField();
		txtPesquisarPizzaSalgada.setPreferredSize(new Dimension(220, 25));
		txtPesquisarPizzaSalgada.addKeyListener(new KeyAdapter() {

			private void doClick() {

				@SuppressWarnings("unchecked")
				final TableRowSorter<PizzasSalgadasTableModel> sorter = (TableRowSorter<PizzasSalgadasTableModel>) TableModelUtil
						.filtrarTabela(tablePizzasSalgadas, txtPesquisarPizzaSalgada.getText(), 1);
				tablePizzasSalgadas.setRowSorter(sorter);
			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (txtPesquisarPizzaSalgada.getText().length() - 1 == 0) {

						tablePizzasSalgadas.setRowSorter(null);
						tablePizzasSalgadas.revalidate();
					}
				}
				else if (txtPesquisarPizzaSalgada.getText().length() + 1 > 0)
					doClick();
			}
		});
		txtPesquisarPizzaSalgada.setBorder(null);
		txtPesquisarPizzaSalgada.setToolTipText("Pesquise pelo nome da pizza salgada!");
		panelPesquisarPizzaSalgada.add(txtPesquisarPizzaSalgada);
		
		lblPizzasSalgadas = new JLabel("Salgadas");
		lblPizzasSalgadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPizzasSalgadas.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPizzasSalgadas.setFont(new Font("Leelawadee UI", Font.BOLD, 19));
		panelCabecalhoSalgada.add(lblPizzasSalgadas, BorderLayout.SOUTH);

		panelCabecalhoDoce = new JPanel();
		panelCabecalho.add(panelCabecalhoDoce);
		panelCabecalhoDoce.setLayout(new BorderLayout());
		
		lblPesquisarDoce = new JLabel("Pesquisar pizza doce:");
		lblPesquisarDoce.setBorder(new EmptyBorder(0, 0, 0, 115));
		lblPesquisarDoce.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesquisarDoce.setFont(new Font("Leelawadee UI", Font.BOLD, 11));
		panelCabecalhoDoce.add(lblPesquisarDoce, BorderLayout.NORTH);

		panelPesquisarPizzaDoce = new JPanel();
		panelPesquisarPizzaDoce.setPreferredSize(new Dimension(230, 10));
		panelCabecalhoDoce.add(panelPesquisarPizzaDoce, BorderLayout.EAST);
		
		txtPesquisarPizzaDoce = new JTextField();
		txtPesquisarPizzaDoce.setPreferredSize(new Dimension(220, 25));
		txtPesquisarPizzaDoce.addKeyListener(new KeyAdapter() {

			private void doClick() {

				@SuppressWarnings("unchecked")
				final TableRowSorter<PizzasDocesTableModel> sorter = (TableRowSorter<PizzasDocesTableModel>) TableModelUtil
						.filtrarTabela(tablePizzasDoces, txtPesquisarPizzaDoce.getText(), 1);
				tablePizzasDoces.setRowSorter(sorter);
			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (txtPesquisarPizzaDoce.getText().length() - 1 == 0) {

						tablePizzasDoces.setRowSorter(null);
						tablePizzasDoces.revalidate();
					}
				} else if (txtPesquisarPizzaDoce.getText().length() > 0)
					doClick();
			}
		});
		txtPesquisarPizzaDoce.setBorder(null);
		txtPesquisarPizzaDoce.setToolTipText("Pesquise pelo nome da pizza doce!");
		panelPesquisarPizzaDoce.add(txtPesquisarPizzaDoce);
		
		lblPizzasDoces = new JLabel("Doces");
		lblPizzasDoces.setHorizontalAlignment(SwingConstants.CENTER);
		lblPizzasDoces.setFont(new Font("Leelawadee UI", Font.BOLD, 19));
		panelCabecalhoDoce.add(lblPizzasDoces, BorderLayout.SOUTH);

		panelSelecaoSabores = new JPanel();
		panelSelecaoSabores.setBorder(null);
		panelSelecaoSabores.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelSelecaoSabores.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelSelecaoSabores.setLayout(new BoxLayout(panelSelecaoSabores, BoxLayout.X_AXIS));
		panelSelecao.add(panelSelecaoSabores);
		
		panelPizzasSalgadas = new JPanel();
		panelSelecaoSabores.add(panelPizzasSalgadas);
		
		pizzasSalgadasTableModel = new PizzasSalgadasTableModel();
		
		tablePizzasSalgadas = new JTable();
		tablePizzasSalgadas.setSelectionForeground(Color.WHITE);
		tablePizzasSalgadas.setSelectionBackground(Color.DARK_GRAY);
		tablePizzasSalgadas.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				if (tablePizzasDoces.getSelectedRow() != -1)
					tablePizzasDoces.clearSelection();
			}
		});
		pizzasSalgadasTableModel.atualizar();
		tablePizzasSalgadas.setModel(pizzasSalgadasTableModel);
		tablePizzasSalgadas.setFont(new Font("Leelawadee UI", Font.BOLD, 12));
		tablePizzasSalgadas.setShowVerticalLines(false);
		tablePizzasSalgadas.setBorder(null);
		tablePizzasSalgadas.setFocusable(false);
		tablePizzasSalgadas.setRowHeight(180);
		tablePizzasSalgadas.getColumnModel().getColumn(0).setCellRenderer(new ImagensUtil());
		tablePizzasSalgadas.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablePizzasSalgadas.getColumnModel().getColumn(2).setPreferredWidth(10);
		panelPizzasSalgadas.setLayout(new BoxLayout(panelPizzasSalgadas, BoxLayout.X_AXIS));

		spPizzasSalgadas = new JScrollPane(tablePizzasSalgadas);
		spPizzasSalgadas.setColumnHeaderView(tablePizzasSalgadas.getTableHeader());
		spPizzasSalgadas.getColumnHeader().setVisible(false);
		spPizzasSalgadas.getViewport().setBackground(Color.WHITE);
		spPizzasSalgadas.setViewportBorder(null);
		spPizzasSalgadas.setBorder(null);
		panelPizzasSalgadas.add(spPizzasSalgadas);

		panelPizzasDoces = new JPanel();
		panelSelecaoSabores.add(panelPizzasDoces);
		
		pizzasDocesTableModel = new PizzasDocesTableModel();
		
		tablePizzasDoces = new JTable();
		tablePizzasDoces.setSelectionForeground(Color.WHITE);
		tablePizzasDoces.setSelectionBackground(Color.DARK_GRAY);
		tablePizzasDoces.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				if (tablePizzasSalgadas.getSelectedRow() != -1)
					tablePizzasSalgadas.clearSelection();
			}
		});
		pizzasDocesTableModel.atualizar();
		tablePizzasDoces.setModel(pizzasDocesTableModel);
		tablePizzasDoces.setFont(new Font("Leelawadee UI", Font.BOLD, 12));
		tablePizzasDoces.setShowVerticalLines(false);
		tablePizzasDoces.setBorder(null);
		tablePizzasDoces.setFocusable(false);
		tablePizzasDoces.setRowHeight(180);
		tablePizzasDoces.getColumnModel().getColumn(0).setCellRenderer(new ImagensUtil());
		tablePizzasDoces.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablePizzasDoces.getColumnModel().getColumn(2).setPreferredWidth(10);
		TableModelUtil.customizarTable(tablePizzasDoces.getTableHeader());
		panelPizzasDoces.setLayout(new BoxLayout(panelPizzasDoces, BoxLayout.X_AXIS));

		spPizzasDoces = new JScrollPane(tablePizzasDoces);
		spPizzasDoces.setColumnHeaderView(tablePizzasDoces.getTableHeader());
		spPizzasDoces.getColumnHeader().setVisible(false);
		spPizzasDoces.getViewport().setBackground(Color.WHITE);
		spPizzasDoces.setViewportBorder(null);
		spPizzasDoces.setBorder(null);
		panelPizzasDoces.add(spPizzasDoces);

		JPanel panelAcoes = new JPanel();
		panelAcoes.setBorder(null);
		panelAcoes.setBackground(Color.DARK_GRAY);
		panelAcoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelAcoes, BorderLayout.SOUTH);

		JButton btnLimparSelecao = new JButton("Limpar sele\u00E7\u00E3o");
		btnLimparSelecao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (tablePizzasSalgadas.getSelectedRow() != -1) tablePizzasSalgadas.clearSelection(); else tablePizzasDoces.clearSelection();

				if ( ! txtPesquisarPizzaSalgada.getText().equals("")) {
					
					txtPesquisarPizzaSalgada.setText("");
					tablePizzasSalgadas.setRowSorter(null);
					tablePizzasSalgadas.revalidate();
				}
				
				if ( ! txtPesquisarPizzaDoce.getText().equals("")) {
					
					txtPesquisarPizzaDoce.setText("");
					tablePizzasDoces.setRowSorter(null);
					tablePizzasDoces.revalidate();
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

				if(tablePizzasSalgadas.getSelectedRow() != -1) {

					if (tablePizzasSalgadas.getRowSorter() != null) {

						produto = pizzasSalgadasTableModel.capturarSelecionado(tablePizzasSalgadas.getRowSorter()
								.convertRowIndexToModel(tablePizzasSalgadas.getSelectedRow()));
					}
					else {

						produto = pizzasSalgadasTableModel.capturarSelecionado(tablePizzasSalgadas.getSelectedRow());
					}
					
					confirmacao = true;
				}
				else if (tablePizzasDoces.getSelectedRow() != -1) {

					if (tablePizzasDoces.getRowSorter() != null) {

						produto = pizzasDocesTableModel.capturarSelecionado(
								tablePizzasDoces.getRowSorter().convertRowIndexToModel(tablePizzasDoces.getSelectedRow()));
					}
					else {

						produto = pizzasDocesTableModel.capturarSelecionado(tablePizzasDoces.getSelectedRow());
					}
					
					confirmacao = true;
				}
				else {

					produto = null;
				}

				tablePizzasSalgadas.clearSelection();
				tablePizzasDoces.clearSelection();

				if (!txtPesquisarPizzaSalgada.getText().equals("")) txtPesquisarPizzaSalgada.setText(""); tablePizzasSalgadas.setRowSorter(null); tablePizzasSalgadas.revalidate();
				if (!txtPesquisarPizzaDoce.getText().equals("")) txtPesquisarPizzaDoce.setText(""); tablePizzasDoces.setRowSorter(null); tablePizzasDoces.revalidate();
				
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

				tablePizzasSalgadas.clearSelection();
				tablePizzasDoces.clearSelection();

				if (!txtPesquisarPizzaSalgada.getText().equals("")) txtPesquisarPizzaSalgada.setText(""); tablePizzasSalgadas.setRowSorter(null); tablePizzasSalgadas.revalidate();
				if (!txtPesquisarPizzaDoce.getText().equals("")) txtPesquisarPizzaDoce.setText(""); tablePizzasDoces.setRowSorter(null); tablePizzasDoces.revalidate();

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
			
			spPizzasDoces.setVisible(ativarTableDoce);
			panelCabecalhoDoce.setVisible(ativarTableDoce);
			
			spPizzasSalgadas.setVisible(ativarTableSalagada);
			panelCabecalhoSalgada.setVisible(ativarTableSalagada);
			
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
		
		spPizzasDoces.setVisible(false);
		spPizzasSalgadas.setVisible(true);
		
		panelCabecalhoDoce.setVisible(false);
		panelCabecalhoSalgada.setVisible(true);
		
		panelCabecalho.revalidate();
	}
	
	private void alinharCabecalhoDoce() {
		
		spPizzasDoces.setVisible(true);
		spPizzasSalgadas.setVisible(false);
		
		panelCabecalhoDoce.setVisible(true);
		panelCabecalhoSalgada.setVisible(false);
		
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
	
	private void popularTables() {
		
		pizzasSalgadasTableModel.atualizar();
		tablePizzasSalgadas.setModel(pizzasSalgadasTableModel);
		
		pizzasDocesTableModel.atualizar();
		tablePizzasDoces.setModel(pizzasDocesTableModel);
	}
}
