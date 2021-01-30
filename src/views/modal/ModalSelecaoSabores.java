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

	private PizzasSalgadasTableModel pizzasSalgadasTableModel = new PizzasSalgadasTableModel();
	private PizzasDocesTableModel pizzasDocesTableModel = new PizzasDocesTableModel();
	
	private Produto produto;

	private JPanel panelCabecalho;
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

		setBounds(100, 100, 1500, 738);
		
		JPanel panelSelecao = new JPanel();
		panelSelecao.setBackground(Color.WHITE);
		getContentPane().add(panelSelecao, BorderLayout.CENTER);
		panelSelecao.setLayout(new BorderLayout(0, 0));

		panelSelecaoSabores = new JPanel();
		panelSelecaoSabores.setBorder(null);
		panelSelecaoSabores.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelSelecaoSabores.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelSelecao.add(panelSelecaoSabores);

		panelCabecalho = new JPanel();
		panelCabecalho.setPreferredSize(new Dimension(10, 130));
		panelCabecalho.setBounds(new Rectangle(0, 0, 0, 100));
		panelCabecalho.setMinimumSize(new Dimension(10, 100));
		panelSelecao.add(panelCabecalho, BorderLayout.NORTH);
		panelCabecalho.setLayout(null);

		lblPizzasSalgadas = new JLabel("Salgadas");
		lblPizzasSalgadas.setFont(new Font("Leelawadee UI", Font.BOLD, 19));
		lblPizzasSalgadas.setBounds(333, 89, 84, 30);
		panelCabecalho.add(lblPizzasSalgadas);
		panelSelecaoSabores.setLayout(new BoxLayout(panelSelecaoSabores, BoxLayout.X_AXIS));

		panelPizzasSalgadas = new JPanel();
		panelSelecaoSabores.add(panelPizzasSalgadas);
		
		tablePizzasSalgadas = new JTable();
		tablePizzasSalgadas.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				if (tablePizzasDoces.getSelectedRow() != -1)
					tablePizzasDoces.clearSelection();
			}
		});
		tablePizzasSalgadas.setModel(pizzasSalgadasTableModel);
		tablePizzasSalgadas.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		tablePizzasSalgadas.setShowVerticalLines(false);
		tablePizzasSalgadas.setBorder(null);
		tablePizzasSalgadas.setFocusable(false);
		tablePizzasSalgadas.setRowHeight(180);
		tablePizzasSalgadas.getColumnModel().getColumn(0).setCellRenderer(new ImagensUtil());
		tablePizzasSalgadas.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablePizzasSalgadas.getColumnModel().getColumn(2).setPreferredWidth(10);
		TableModelUtil.customizarTable(tablePizzasSalgadas.getTableHeader());
		panelPizzasSalgadas.setLayout(new BoxLayout(panelPizzasSalgadas, BoxLayout.X_AXIS));

		spPizzasSalgadas = new JScrollPane(tablePizzasSalgadas);
		spPizzasSalgadas.setViewportBorder(null);
		spPizzasSalgadas.setBorder(null);
		panelPizzasSalgadas.add(spPizzasSalgadas);

		lblPizzasDoces = new JLabel("Doces");
		lblPizzasDoces.setFont(new Font("Leelawadee UI", Font.BOLD, 19));
		lblPizzasDoces.setBounds(1095, 89, 60, 30);
		panelCabecalho.add(lblPizzasDoces);

		panelPizzasDoces = new JPanel();
		panelSelecaoSabores.add(panelPizzasDoces);
		
		tablePizzasDoces = new JTable();
		tablePizzasDoces.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				if (tablePizzasSalgadas.getSelectedRow() != -1)
					tablePizzasSalgadas.clearSelection();
			}
		});
		tablePizzasDoces.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tablePizzasDoces.setModel(pizzasDocesTableModel);
		tablePizzasDoces.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
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
		spPizzasDoces.setViewportBorder(null);
		spPizzasDoces.setBorder(null);
		panelPizzasDoces.add(spPizzasDoces);

		lblPesquisarSalgada = new JLabel("Pesquisar pizza salgada:");
		lblPesquisarSalgada.setFont(new Font("Leelawadee UI", Font.BOLD, 11));
		lblPesquisarSalgada.setBounds(530, 11, 200, 14);
		panelCabecalho.add(lblPesquisarSalgada);

		txtPesquisarPizzaSalgada = new JTextField();
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
				} else if (txtPesquisarPizzaSalgada.getText().length() + 1 > 0)
					doClick();
			}
		});
		txtPesquisarPizzaSalgada.setBorder(null);
		txtPesquisarPizzaSalgada.setToolTipText("Pesquise pelo nome da pizza salgada!");
		txtPesquisarPizzaSalgada.setBounds(530, 31, 200, 24);
		panelCabecalho.add(txtPesquisarPizzaSalgada);
		txtPesquisarPizzaSalgada.setColumns(10);

		lblPesquisarDoce = new JLabel("Pesquisar pizza doce:");
		lblPesquisarDoce.setFont(new Font("Leelawadee UI", Font.BOLD, 11));
		lblPesquisarDoce.setBounds(1280, 11, 200, 14);
		panelCabecalho.add(lblPesquisarDoce);

		txtPesquisarPizzaDoce = new JTextField();
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
		txtPesquisarPizzaDoce.setColumns(10);
		txtPesquisarPizzaDoce.setBounds(1280, 31, 200, 24);
		panelCabecalho.add(txtPesquisarPizzaDoce);

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
			
			lblPesquisarDoce.setVisible(ativarTableDoce);
			txtPesquisarPizzaDoce.setVisible(ativarTableDoce);
			
			lblPizzasDoces.setBounds(1095, 89, 60, 30);
			lblPizzasDoces.setVisible(ativarTableDoce);
			
			spPizzasSalgadas.setVisible(ativarTableSalagada);
			
			lblPesquisarSalgada.setBounds(530, 11, 200, 14);
			lblPesquisarSalgada.setVisible(ativarTableSalagada);
			
			txtPesquisarPizzaSalgada.setBounds(530, 31, 200, 24);
			txtPesquisarPizzaSalgada.setVisible(ativarTableSalagada);
			
			lblPizzasSalgadas.setBounds(333, 89, 84, 30);
			lblPizzasSalgadas.setVisible(ativarTableSalagada);
			
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
		
		lblPesquisarDoce.setVisible(false);
		txtPesquisarPizzaDoce.setVisible(false);
		
		lblPizzasDoces.setVisible(false);
		
		lblPesquisarSalgada.setBounds(1280, 11, 200, 14);
		lblPesquisarSalgada.setVisible(true);
		
		txtPesquisarPizzaSalgada.setBounds(1280, 31, 200, 24);
		txtPesquisarPizzaSalgada.setVisible(true);
		
		lblPizzasSalgadas.setBounds(708, 89, 84, 30);
		lblPizzasSalgadas.setVisible(true);
		
		panelCabecalho.revalidate();
	}
	
	private void alinharCabecalhoDoce() {
		
		spPizzasDoces.setVisible(true);
		spPizzasSalgadas.setVisible(false);
		
		lblPesquisarDoce.setVisible(true);
		txtPesquisarPizzaDoce.setVisible(true);
		
		lblPizzasDoces.setBounds(708, 89, 84, 30);
		lblPizzasDoces.setVisible(true);
		
		lblPesquisarSalgada.setVisible(false);
		txtPesquisarPizzaSalgada.setVisible(false);
		
		lblPizzasSalgadas.setVisible(false);
		
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
