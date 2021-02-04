package views.internos.produtos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import org.apache.tomcat.util.codec.binary.Base64;

import controllers.CarrinhoController;
import model.dao.BordaDao;
import model.dao.FabricaDao;
import model.entities.Borda;
import model.entities.ItemPedido;
import model.entities.Produto;
import model.util.ImagensUtil;
import model.util.ModalUtil;
import model.util.ViewsUtil;
import views.modal.ModalAlerta;
import views.modal.ModalSelecaoSabores;
import views.modal.enums.ModalAlertaEnum;

public final class PizzasView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private ButtonGroup grupoTamanhos = new ButtonGroup();
	private ButtonGroup grupoQTDSabores = new ButtonGroup();
	private ButtonGroup grupoBordas = new ButtonGroup();

	private BordaDao bordaDao = FabricaDao.createBordaDao();
	
	private ModalAlerta modalAlerta;
	private ModalSelecaoSabores modalSelecaoSabores = new ModalSelecaoSabores();
	
	private CarrinhoView carrinhoView = new CarrinhoView();
	
	private ItemPedido item = new ItemPedido();
	private Produto produto;

	private JPanel panelCentro;
	private JPanel panelLateral;
	private JPanel panelPizzas;
	private JPanel panelConfigPizza;
	private JPanel panelTamanho;
	private JPanel panelBorda;
	private JPanel panelSelecaoBorda;
	private JPanel panelObersavacaoTresSabores;
	private JPanel panelQTDSabores;
	private JPanel panelSelecionarSabor;
	private JPanel panelInferior;
	private JPanel panelObservacoes;
	private JPanel panelQuantidade;
	private JPanel panelAddCarrinho;
	private JLabel lblSabor1;
	private JLabel lblSabor2;
	private JLabel lblSabor3;
	private JLabel lblSabor4;
	private JTextField txtQuantidade;
	private JTextArea txtAreaObservacoes;
	private JRadioButton rdbtnBroto;
	private JRadioButton rdbtnTradicional;
	private JRadioButton rdbtnGrande;
	private JRadioButton rdbtnExtraGrande;
	private JRadioButton rdbtnSemBorda;
	private JRadioButton rdbtnComBorda;
	private JRadioButton rdbtnUmSabor;
	private JRadioButton rdbtnDoisSabores;
	private JRadioButton rdbtnTresSabores;
	private JRadioButton rdbtnQuatroSabores;
	private JComboBox<Object> cbxBordaSalgada;
	private JComboBox<Object> cbxBordaDoce;
	private JCheckBox checkboxConfigPizza;
	private JPanel panelBordaSalgada;
	private JPanel panelBordaDoce;
	private JLabel lblBordaSalgada;
	private JLabel lblBordaDoce;
	private JLabel lblObsTresSabores;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PizzasView frame = new PizzasView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PizzasView() {
		
		setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
		bi.setNorthPane(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panelCentro = new JPanel();
		panelCentro.setAutoscrolls(true);
		panelCentro.setLayout(new BorderLayout());
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		panelPizzas = new JPanel();
		panelPizzas.setLayout(new BoxLayout(panelPizzas, BoxLayout.Y_AXIS));
		panelCentro.add(panelPizzas, BorderLayout.CENTER);
		
		panelConfigPizza = new JPanel();
		panelConfigPizza.setPreferredSize(new Dimension(10, 80));
		panelConfigPizza.setBorder(new EmptyBorder(20, 0, 20, 0));
		panelConfigPizza.setLayout(new BoxLayout(panelConfigPizza, BoxLayout.X_AXIS));
		panelPizzas.add(panelConfigPizza);
		
		checkboxConfigPizza = new JCheckBox("** Marque essa opção caso a pizza seja metade doce e metade salgada **");
		checkboxConfigPizza.addActionListener(new ActionListener() {
			
			private void doClick() {
				
				if(checkboxConfigPizza.isSelected()) {
					
					if(rdbtnUmSabor.isSelected()) rdbtnDoisSabores.doClick();
					else if(rdbtnDoisSabores.isSelected()) rdbtnDoisSabores.doClick();
					else if(rdbtnTresSabores.isSelected()) rdbtnTresSabores.doClick();
					else rdbtnQuatroSabores.doClick();
					
					rdbtnUmSabor.setEnabled(false);
					
					modalSelecaoSabores.setCatSabor1("");
					modalSelecaoSabores.setCatSabor2("");
					modalSelecaoSabores.setCatSabor3("");
					modalSelecaoSabores.setCatSabor4("");
				}
				else {
					
					rdbtnUmSabor.setEnabled(true);
					panelSelecaoBorda.repaint();
					panelSelecaoBorda.validate();
					
					if(rdbtnUmSabor.isSelected()) rdbtnDoisSabores.doClick();
					else if(rdbtnDoisSabores.isSelected()) rdbtnDoisSabores.doClick();
					else if(rdbtnTresSabores.isSelected()) rdbtnTresSabores.doClick();
					else rdbtnQuatroSabores.doClick();
					
					modalSelecaoSabores.ativarTabelas(true, true);

					modalSelecaoSabores.setCatSabor1("");
					modalSelecaoSabores.setCatSabor2("");
					modalSelecaoSabores.setCatSabor3("");
					modalSelecaoSabores.setCatSabor4("");
				}
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				doClick();
			}
		});
		checkboxConfigPizza.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		checkboxConfigPizza.setBounds(10, 459, 451, 38);
		panelConfigPizza.add(checkboxConfigPizza);
		
		panelTamanho = new JPanel();
		panelTamanho.setPreferredSize(new Dimension(10, 80));
		panelTamanho.setBorder(new EmptyBorder(20, 0, 20, 0));
		panelPizzas.add(panelTamanho);
		panelTamanho.setLayout(new BoxLayout(panelTamanho, BoxLayout.X_AXIS));
		
		rdbtnBroto = new JRadioButton("Broto");
		rdbtnBroto.setContentAreaFilled(false);
		grupoTamanhos.add(rdbtnBroto);
		rdbtnBroto.setFocusable(false);
		rdbtnBroto.setBorder(new EmptyBorder(0, 0, 0, 60));
		rdbtnBroto.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		panelTamanho.add(rdbtnBroto);
		
		rdbtnTradicional = new JRadioButton("Tradicional");
		rdbtnTradicional.setContentAreaFilled(false);
		grupoTamanhos.add(rdbtnTradicional);
		rdbtnTradicional.setFocusable(false);
		rdbtnTradicional.setBorder(new EmptyBorder(0, 60, 0, 60));
		rdbtnTradicional.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		panelTamanho.add(rdbtnTradicional);
		
		rdbtnGrande = new JRadioButton("Grande");
		rdbtnGrande.setContentAreaFilled(false);
		grupoTamanhos.add(rdbtnGrande);
		rdbtnGrande.setFocusable(false);
		rdbtnGrande.setBorder(new EmptyBorder(0, 60, 0, 0));
		rdbtnGrande.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		panelTamanho.add(rdbtnGrande);
		
		rdbtnExtraGrande = new JRadioButton("Extra grande");
		rdbtnExtraGrande.setContentAreaFilled(false);
		grupoTamanhos.add(rdbtnExtraGrande);
		rdbtnExtraGrande.setFocusable(false);
		rdbtnExtraGrande.setBorder(new EmptyBorder(0, 60, 0, 0));
		rdbtnExtraGrande.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		panelTamanho.add(rdbtnExtraGrande);
		
		grupoTamanhos.setSelected(rdbtnBroto.getModel(), true);
		
		panelBorda = new JPanel();
		panelBorda.setPreferredSize(new Dimension(10, 80));
		panelBorda.setLayout(new BoxLayout(panelBorda, BoxLayout.X_AXIS));
		panelPizzas.add(panelBorda);
		
		rdbtnSemBorda = new JRadioButton("Sem borda");
		rdbtnSemBorda.addActionListener(new ActionListener() {

			private void doClick() {
				
				if(cbxBordaSalgada.isVisible()) {
					
					cbxBordaSalgada.setSelectedIndex(0);
					cbxBordaDoce.setSelectedIndex(0);
					
					lblBordaSalgada.setVisible(false);
					cbxBordaSalgada.setVisible(false);
					
					lblBordaDoce.setVisible(false);
					cbxBordaDoce.setVisible(false);
					
					panelSelecaoBorda.repaint();
					panelSelecaoBorda.validate();
				}
				
				if(item.getBordas().size() != 0) {
					
					item.removerBordas();
				}
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				doClick();
			}
		});
		rdbtnSemBorda.setContentAreaFilled(false);
		grupoBordas.add(rdbtnSemBorda);
		rdbtnSemBorda.setFocusable(false);
		rdbtnSemBorda.setBorder(new EmptyBorder(0, 0, 0, 60));
		rdbtnSemBorda.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		panelBorda.add(rdbtnSemBorda);
		
		rdbtnComBorda = new JRadioButton("Com borda");
		rdbtnComBorda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if( ! cbxBordaSalgada.isVisible()) {
					
					lblBordaSalgada.setVisible(true);
					cbxBordaSalgada.setVisible(true);
					
					lblBordaDoce.setVisible(true);
					cbxBordaDoce.setVisible(true);
					
					panelSelecaoBorda.repaint();
					panelSelecaoBorda.validate();
				}
			}
		});
		rdbtnComBorda.setContentAreaFilled(false);
		grupoBordas.add(rdbtnComBorda);
		rdbtnComBorda.setFocusable(false);
		rdbtnComBorda.setBorder(new EmptyBorder(0, 60, 0, 60));
		rdbtnComBorda.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		panelBorda.add(rdbtnComBorda);
		
		panelSelecaoBorda = new JPanel();
		panelPizzas.add(panelSelecaoBorda);
		panelSelecaoBorda.setLayout(new GridLayout(2, 0));
		
		panelBordaSalgada = new JPanel();
		panelSelecaoBorda.add(panelBordaSalgada);
		
		panelBordaDoce = new JPanel();
		panelSelecaoBorda.add(panelBordaDoce);
		
		lblBordaSalgada = new JLabel("Borda salgada:");
		lblBordaSalgada.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblBordaSalgada.setVisible(false);
		panelBordaSalgada.add(lblBordaSalgada);
		
		cbxBordaSalgada = new JComboBox<>();
		cbxBordaSalgada.setPreferredSize(new Dimension(200, 32));
		cbxBordaSalgada.setBorder(null);
		cbxBordaSalgada.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Borda borda = (Borda) cbxBordaSalgada.getSelectedItem();
				
				if(item.getBordas().size() < 2) {
					
					if(cbxBordaSalgada.getSelectedIndex() != 0) {
						
						item.addBorda(borda);
					}
				}
				else if(item.getBordas().size() >= 2) {
					
					for(Borda b : item.getBordas()) {
						
						if(cbxBordaSalgada.getSelectedIndex() != 0) {
						
							if(b.getTipoBorda().equals(borda.getTipoBorda())) {
								
								item.removerBorda(b);
								item.addBorda(borda);
							}
						}
						else {
							
							item.removerBorda(b);
						}
					}
				}
			}
		});
		cbxBordaSalgada.setFocusable(false);
		cbxBordaSalgada.setVisible(false);
		cbxBordaSalgada.setModel(new DefaultComboBoxModel<Object>(bordaDao.listarBordasSalgadas().toArray()));
		panelBordaSalgada.add(cbxBordaSalgada);
		
		lblBordaDoce = new JLabel("Borda doce:");
		lblBordaDoce.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblBordaDoce.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblBordaDoce.setVisible(false);
		panelBordaDoce.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelBordaDoce.add(lblBordaDoce);
		
		cbxBordaDoce = new JComboBox<Object>();
		cbxBordaDoce.setPreferredSize(new Dimension(200, 32));
		cbxBordaDoce.setBorder(null);
		cbxBordaDoce.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Borda borda = (Borda) cbxBordaDoce.getSelectedItem();
				
				if(item.getBordas().size() < 2) {
					
					if(cbxBordaDoce.getSelectedIndex() != 0) {
						
						item.addBorda(borda);
					}
				}
				else if(item.getBordas().size() >= 2) {
					
					for(int i = 0; i < item.getBordas().size(); i++) {
						
						if(cbxBordaDoce.getSelectedIndex() != 0) {
						
							if(item.getBordas().get(i).getTipoBorda().equals(borda.getTipoBorda())) {
								
								item.removerBorda(item.getBordas().get(i));
								item.addBorda(borda);
							}
						}
						else {
							
							item.removerBorda(item.getBordas().get(i));
						}
					}
				}
			}
		});
		cbxBordaDoce.setMinimumSize(new Dimension(28, 30));
		cbxBordaDoce.setMaximumSize(new Dimension(200, 30));
		cbxBordaDoce.setFocusable(false);
		cbxBordaDoce.setVisible(false);
		cbxBordaDoce.setModel(new DefaultComboBoxModel<Object>(bordaDao.listarBordasDoces().toArray()));
		panelBordaDoce.add(cbxBordaDoce);

		rdbtnSemBorda.doClick();
		
		panelQTDSabores = new JPanel();
		panelQTDSabores.setPreferredSize(new Dimension(10, 80));
		panelQTDSabores.setBorder(new EmptyBorder(20, 0, 20, 0));
		panelPizzas.add(panelQTDSabores);
		
		rdbtnUmSabor = new JRadioButton("1 Sabor");
		rdbtnUmSabor.setContentAreaFilled(false);
		rdbtnUmSabor.addActionListener(new ActionListener() {
			
			private void doClick() {
				
				if(item.getProdutos().size() > 0) {
					
					item.removerProdutos();
				}
				
				ViewsUtil.limparSelecao(lblSabor1, "Selecione o sabor");
				ViewsUtil.limparSelecao(lblSabor2, "O segundo sabor");
				ViewsUtil.limparSelecao(lblSabor3, "O terceiro sabor");
				ViewsUtil.limparSelecao(lblSabor4, "O último sabor");
				
				modalSelecaoSabores.setCatSabor1("");
				modalSelecaoSabores.setCatSabor2("");
				modalSelecaoSabores.setCatSabor3("");
				modalSelecaoSabores.setCatSabor4("");
				
				lblSabor2.setEnabled(false);
				lblSabor3.setEnabled(false);
				lblSabor4.setEnabled(false);
				
				modalSelecaoSabores.ativarTabelas(true, true);
				
				if(lblObsTresSabores.isVisible()) {
					
					lblObsTresSabores.setVisible(false);
				}
				
				panelSelecionarSabor.removeAll();
				panelSelecionarSabor.setLayout(new GridLayout(1, 4));
				panelSelecionarSabor.add(lblSabor1);
				panelSelecionarSabor.repaint();
				panelSelecionarSabor.validate();
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				doClick();
			}
		});
		grupoQTDSabores.add(rdbtnUmSabor);
		rdbtnUmSabor.setFocusable(false);
		rdbtnUmSabor.setAlignmentX(Component.CENTER_ALIGNMENT);
		rdbtnUmSabor.setBorder(new EmptyBorder(0, 0, 0, 30));
		rdbtnUmSabor.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		panelQTDSabores.setLayout(new BoxLayout(panelQTDSabores, BoxLayout.X_AXIS));
		panelQTDSabores.add(rdbtnUmSabor);
		
		rdbtnDoisSabores = new JRadioButton("2 Sabores");
		rdbtnDoisSabores.setContentAreaFilled(false);
		rdbtnDoisSabores.addActionListener(new ActionListener() {
			
			private void doClick() {
				
				if(item.getProdutos().size() > 0) {
					
					item.removerProdutos();
					
					ViewsUtil.limparSelecao(lblSabor1, "Selecione o sabor");
					ViewsUtil.limparSelecao(lblSabor2, "O segundo sabor");
					ViewsUtil.limparSelecao(lblSabor3, "O terceiro sabor");
					ViewsUtil.limparSelecao(lblSabor4, "O último sabor");
					
					modalSelecaoSabores.setCatSabor1("");
					modalSelecaoSabores.setCatSabor2("");
					modalSelecaoSabores.setCatSabor3("");
					modalSelecaoSabores.setCatSabor4("");
					
					lblSabor2.setEnabled(false);
					lblSabor3.setEnabled(false);
					lblSabor4.setEnabled(false);
				}
				
				modalSelecaoSabores.setQuantSabores(2);
				modalSelecaoSabores.ativarTabelas(true, true);
				
				if(lblObsTresSabores.isVisible()) {
					
					lblObsTresSabores.setVisible(false);
				}
				
				panelSelecionarSabor.removeAll();
				panelSelecionarSabor.setLayout(new GridLayout(1, 4));
				panelSelecionarSabor.add(lblSabor1);
				panelSelecionarSabor.add(lblSabor2);
				panelSelecionarSabor.repaint();
				panelSelecionarSabor.validate();
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {

				doClick();
			}
		});
		grupoQTDSabores.add(rdbtnDoisSabores);
		rdbtnDoisSabores.setFocusable(false);
		rdbtnDoisSabores.setBorder(new EmptyBorder(0, 30, 0, 30));
		rdbtnDoisSabores.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		panelQTDSabores.add(rdbtnDoisSabores);
		
		rdbtnTresSabores = new JRadioButton("3 Sabores");
		rdbtnTresSabores.setContentAreaFilled(false);
		rdbtnTresSabores.addActionListener(new ActionListener() {
			
			private void doClick() {
				
				if(item.getProdutos().size() > 0) {
					
					item.removerProdutos();
					
					ViewsUtil.limparSelecao(lblSabor1, "Selecione o sabor");
					ViewsUtil.limparSelecao(lblSabor2, "O segundo sabor");
					ViewsUtil.limparSelecao(lblSabor3, "O terceiro sabor");
					ViewsUtil.limparSelecao(lblSabor4, "O último sabor");
					
					modalSelecaoSabores.setCatSabor1("");
					modalSelecaoSabores.setCatSabor2("");
					modalSelecaoSabores.setCatSabor3("");
					modalSelecaoSabores.setCatSabor4("");
					
					lblSabor2.setEnabled(false);
					lblSabor3.setEnabled(false);
					lblSabor4.setEnabled(false);
				}
				
				modalSelecaoSabores.setQuantSabores(3);
				modalSelecaoSabores.ativarTabelas(true, true);
				
				if( ! lblObsTresSabores.isVisible()) {
					
					lblObsTresSabores.setVisible(true);
				}
				
				panelSelecionarSabor.removeAll();
				panelSelecionarSabor.setLayout(new GridLayout(2, 2));
				panelSelecionarSabor.add(lblSabor1);
				panelSelecionarSabor.add(lblSabor2);
				panelSelecionarSabor.add(lblSabor3);
				panelSelecionarSabor.repaint();
				panelSelecionarSabor.validate();
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {

				doClick();
			}
		});
		grupoQTDSabores.add(rdbtnTresSabores);
		rdbtnTresSabores.setFocusable(false);
		rdbtnTresSabores.setBorder(new EmptyBorder(0, 30, 0, 30));
		rdbtnTresSabores.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		panelQTDSabores.add(rdbtnTresSabores);
		
		rdbtnQuatroSabores = new JRadioButton("4 Sabores");
		rdbtnQuatroSabores.setContentAreaFilled(false);
		rdbtnQuatroSabores.addActionListener(new ActionListener() {
			
			private void doClick() {
				
				if(item.getProdutos().size() > 0) {
					
					item.removerProdutos();
					
					ViewsUtil.limparSelecao(lblSabor1, "Selecione o sabor");
					ViewsUtil.limparSelecao(lblSabor2, "O segundo sabor");
					ViewsUtil.limparSelecao(lblSabor3, "O terceiro sabor");
					ViewsUtil.limparSelecao(lblSabor4, "O último sabor");
					
					modalSelecaoSabores.setCatSabor1("");
					modalSelecaoSabores.setCatSabor2("");
					modalSelecaoSabores.setCatSabor3("");
					modalSelecaoSabores.setCatSabor4("");
					
					lblSabor2.setEnabled(false);
					lblSabor3.setEnabled(false);
					lblSabor4.setEnabled(false);
				}
				
				modalSelecaoSabores.setQuantSabores(4);
				modalSelecaoSabores.ativarTabelas(true, true);
				
				if(lblObsTresSabores.isVisible()) {
					
					lblObsTresSabores.setVisible(false);
				}
				
				panelSelecionarSabor.removeAll();
				panelSelecionarSabor.setLayout(new GridLayout(2, 2));
				panelSelecionarSabor.add(lblSabor1);
				panelSelecionarSabor.add(lblSabor2);
				panelSelecionarSabor.add(lblSabor3);
				panelSelecionarSabor.add(lblSabor4);
				panelSelecionarSabor.repaint();
				panelSelecionarSabor.validate();
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {

				doClick();
			}
		});
		grupoQTDSabores.add(rdbtnQuatroSabores);
		rdbtnQuatroSabores.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		rdbtnQuatroSabores.setFocusable(false);
		rdbtnQuatroSabores.setBorder(new EmptyBorder(0, 30, 0, 0));
		panelQTDSabores.add(rdbtnQuatroSabores);
		
		panelObersavacaoTresSabores = new JPanel();
		panelPizzas.add(panelObersavacaoTresSabores);
		panelObersavacaoTresSabores.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblObsTresSabores = new JLabel("<html>*OBS.: Na pizza de 3 sabores, o primeiro sabor selecionado será sempre a metade da pizza, <br> a outra metade será dividida entre os outros dois sabores!</html>");
		lblObsTresSabores.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		panelObersavacaoTresSabores.add(lblObsTresSabores);
		
		JLabel lblSelecionarSabores = new JLabel("Selecione o(s) sabor(es):");
		lblSelecionarSabores.setPreferredSize(new Dimension(120, 80));
		lblSelecionarSabores.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		lblSelecionarSabores.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecionarSabores.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelPizzas.add(lblSelecionarSabores);
		
		panelSelecionarSabor = new JPanel();
		panelSelecionarSabor.setMaximumSize(new Dimension(900, 32767));
		panelSelecionarSabor.setPreferredSize(new Dimension(10, 300));
		panelPizzas.add(panelSelecionarSabor);
		panelSelecionarSabor.setLayout(new GridLayout(1, 4));
		
		lblSabor1 = new JLabel("Selecione o sabor");
		lblSabor1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				modalSelecaoSabores.ativarTabelas(true, true);
				
				modalSelecaoSabores.setLocationRelativeTo(null);
				modalSelecaoSabores.setVisible(true);
				
				if(modalSelecaoSabores.produtoSelecionado()) {

					produto = modalSelecaoSabores.retornarProdutoSelecionado();
					
					if(produto != null) {
						
						if( ! checkboxConfigPizza.isSelected() || ! rdbtnQuatroSabores.isSelected()) {
							
							if( ! produto.getCategoria().getCategoria().equals(modalSelecaoSabores.getCatSabor1())) {
								
								ViewsUtil.limparSelecao(lblSabor2, "O segundo sabor");
								ViewsUtil.limparSelecao(lblSabor3, "O terceiro sabor");
								ViewsUtil.limparSelecao(lblSabor4, "O último sabor");
								
								lblSabor2.setEnabled(false);
								lblSabor3.setEnabled(false);
								lblSabor4.setEnabled(false);
								
								modalSelecaoSabores.setCatSabor2("");
								modalSelecaoSabores.setCatSabor3("");
								modalSelecaoSabores.setCatSabor4("");
							}
						}
						
						modalSelecaoSabores.setCatSabor1(produto.getCategoria().getCategoria());
						
						if(modalSelecaoSabores.verificarCategorias(checkboxConfigPizza.isSelected(), produto) != "") {
							
							String texto = modalSelecaoSabores.verificarCategorias(checkboxConfigPizza.isSelected(), produto);
							
							modalAlerta = new ModalAlerta(texto, ModalAlertaEnum.ALERTA);
							ModalUtil.MovimentacaoModal(modalAlerta);
							modalAlerta.setLocationRelativeTo(null);
							modalAlerta.setVisible(true);
							
							return;
						}
						
						if(item.getProdutos().size() != 0) {
							
							if(item.getProdutos().size() >= 1) {
								
								item.getProdutos().remove(0);
								item.addProduto(0, produto);
							}
							else {
								
								item.addProduto(0, produto);
							}
						}
						else {
							
							item.addProduto(0, produto);
						}
						
						byte[] bytesImagem = Base64.decodeBase64(produto.getMiniaturaBase64());
						
						lblSabor1.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(bytesImagem), 150, 150));
						lblSabor1.setText(produto.getNome());
						
						checkboxConfigPizza.updateUI();
						
						modalSelecaoSabores.controleTablePizzas(checkboxConfigPizza.isSelected());
						
						modalSelecaoSabores.limparConfirmacao();
						
						lblSabor2.setEnabled(true);
					}
					else {
						
						ViewsUtil.limparSelecao(lblSabor1, "Selecione o sabor");
					}
				}
			}
		});
		lblSabor1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSabor1.setIconTextGap(20);
		lblSabor1.setIcon(new ImageIcon(PizzasView.class.getResource("/imagens/pizza-64.png")));
		lblSabor1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSabor1.setFont(new Font("Leelawadee", Font.BOLD, 16));
		
		lblSabor2 = new JLabel("O segundo sabor");
		lblSabor2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(lblSabor2.isEnabled()) {
					
					if(checkboxConfigPizza.isSelected()) {
						
						if(rdbtnQuatroSabores.isSelected()) {
							
							modalSelecaoSabores.ativarTabelas(true, true);
						}
					}
					else if( ! modalSelecaoSabores.getCatSabor2().equals("")) {
						
						if(modalSelecaoSabores.getCatSabor2().equals("Pizza salgada")) modalSelecaoSabores.ativarTabelas(true, false);
						else if(modalSelecaoSabores.getCatSabor2().equals("Pizza doce")) modalSelecaoSabores.ativarTabelas(false, true);
					}
					
					modalSelecaoSabores.setLocationRelativeTo(null);
					modalSelecaoSabores.setVisible(true);
					
					if(modalSelecaoSabores.produtoSelecionado()) {

						produto = modalSelecaoSabores.retornarProdutoSelecionado();
						
						if(produto != null) {
							
							modalSelecaoSabores.setCatSabor2(produto.getCategoria().getCategoria());
							
							if(modalSelecaoSabores.verificarCategorias(checkboxConfigPizza.isSelected(), produto) != "") {
								
								String texto = modalSelecaoSabores.verificarCategorias(checkboxConfigPizza.isSelected(), produto);
								
								modalAlerta = new ModalAlerta(texto, ModalAlertaEnum.ALERTA);
								ModalUtil.MovimentacaoModal(modalAlerta);
								modalAlerta.setLocationRelativeTo(null);
								modalAlerta.setVisible(true);
								
								return;
							}
							
							if(item.getProdutos().size() >= 2) {
								
								item.getProdutos().remove(1);
								item.addProduto(1, produto);
							}
							else {
								
								item.addProduto(1, produto);
							}
							
							byte[] bytesImagem = Base64.decodeBase64(produto.getMiniaturaBase64());
							
							lblSabor2.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(bytesImagem), 120, 140));
							lblSabor2.setText(produto.getNome());
							
							checkboxConfigPizza.updateUI();
							
							modalSelecaoSabores.controleTablePizzas(checkboxConfigPizza.isSelected());
							modalSelecaoSabores.limparConfirmacao();
							
							lblSabor3.setEnabled(true);
						}
						else {
							
							ViewsUtil.limparSelecao(lblSabor2, "O segundo sabor");
						}
					}
				}
			}
		});
		lblSabor2.setEnabled(false);
		lblSabor2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSabor2.setIconTextGap(20);
		lblSabor2.setIcon(new ImageIcon(PizzasView.class.getResource("/imagens/pizza-64.png")));
		lblSabor2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSabor2.setFont(new Font("Leelawadee", Font.BOLD, 16));
		
		lblSabor3 = new JLabel("O terceiro sabor");
		lblSabor3.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(lblSabor3.isEnabled()) {
					
					if(checkboxConfigPizza.isSelected()) {
						
						if(rdbtnQuatroSabores.isSelected()) {
							
							modalSelecaoSabores.ativarTabelas(true, true);
						}
					} 
					else if( ! modalSelecaoSabores.getCatSabor3().equals("")) {
						
						if(modalSelecaoSabores.getCatSabor3().equals("Pizza salgada")) modalSelecaoSabores.ativarTabelas(true, false);
						else if(modalSelecaoSabores.getCatSabor3().equals("Pizza doce")) modalSelecaoSabores.ativarTabelas(false, true);
					}
					
					modalSelecaoSabores.setLocationRelativeTo(null);
					modalSelecaoSabores.setVisible(true);
					
					if(modalSelecaoSabores.produtoSelecionado()) {

						produto = modalSelecaoSabores.retornarProdutoSelecionado();
						
						if(produto != null) {
							
							modalSelecaoSabores.setCatSabor3(produto.getCategoria().getCategoria());
							
							if(modalSelecaoSabores.verificarCategorias(checkboxConfigPizza.isSelected(), produto) != "") {
								
								String texto = modalSelecaoSabores.verificarCategorias(checkboxConfigPizza.isSelected(), produto);
								
								modalAlerta = new ModalAlerta(texto, ModalAlertaEnum.ALERTA);
								ModalUtil.MovimentacaoModal(modalAlerta);
								modalAlerta.setLocationRelativeTo(null);
								modalAlerta.setVisible(true);
								
								return;
							}
							
							if(item.getProdutos().size() >= 3) {
								
								item.getProdutos().remove(2);
								item.addProduto(2, produto);
							}
							else {
								
								item.addProduto(2, produto);
							}
							
							byte[] bytesImagem = Base64.decodeBase64(produto.getMiniaturaBase64());
							
							lblSabor3.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(bytesImagem), 120, 140));
							lblSabor3.setText(produto.getNome());
							
							checkboxConfigPizza.updateUI();
							
							modalSelecaoSabores.controleTablePizzas(checkboxConfigPizza.isSelected());
							modalSelecaoSabores.limparConfirmacao();
							lblSabor4.setEnabled(true);
						}
						else {
							
							ViewsUtil.limparSelecao(lblSabor3, "O terceiro sabor");
						}
					}
				}
			}
		});
		lblSabor3.setEnabled(false);
		lblSabor3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSabor3.setIconTextGap(20);
		lblSabor3.setIcon(new ImageIcon(PizzasView.class.getResource("/imagens/pizza-64.png")));
		lblSabor3.setHorizontalAlignment(SwingConstants.CENTER);
		lblSabor3.setFont(new Font("Leelawadee", Font.BOLD, 16));
		
		lblSabor4 = new JLabel("O último sabor");
		lblSabor4.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(lblSabor4.isEnabled()) {
					
					if(checkboxConfigPizza.isSelected()) {
					
						modalSelecaoSabores.ativarTabelas(true, true);
					}
					else if( ! modalSelecaoSabores.getCatSabor3().equals("")) {
						
						if(modalSelecaoSabores.getCatSabor4().equals("Pizza salgada")) modalSelecaoSabores.ativarTabelas(true, false);
						else if(modalSelecaoSabores.getCatSabor4().equals("Pizza doce")) modalSelecaoSabores.ativarTabelas(false, true);
					}
					
					modalSelecaoSabores.setLocationRelativeTo(null);
					modalSelecaoSabores.setVisible(true);
					
					if(modalSelecaoSabores.produtoSelecionado()) {

						produto = modalSelecaoSabores.retornarProdutoSelecionado();
						
						if(produto != null) {
							
							modalSelecaoSabores.setCatSabor4(produto.getCategoria().getCategoria());
							
							if(modalSelecaoSabores.verificarCategorias(checkboxConfigPizza.isSelected(), produto) != "") {
								
								String texto = modalSelecaoSabores.verificarCategorias(checkboxConfigPizza.isSelected(), produto);
								
								modalAlerta = new ModalAlerta(texto, ModalAlertaEnum.ALERTA);
								ModalUtil.MovimentacaoModal(modalAlerta);
								modalAlerta.setLocationRelativeTo(null);
								modalAlerta.setVisible(true);
								
								return;
							}
							
							if(item.getProdutos().size() >= 4) {
								
								item.getProdutos().remove(3);
								item.addProduto(3, produto);
							}
							else {
								
								item.addProduto(3, produto);
							}
							
							byte[] bytesImagem = Base64.decodeBase64(produto.getMiniaturaBase64());
							
							lblSabor4.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(bytesImagem), 120, 140));
							lblSabor4.setText(produto.getNome());
							
							checkboxConfigPizza.updateUI();
							
							modalSelecaoSabores.controleTablePizzas(checkboxConfigPizza.isSelected());
							modalSelecaoSabores.limparConfirmacao();
						}
						else {
							
							ViewsUtil.limparSelecao(lblSabor4, "O último sabor");
						}
					}
				}
			}
		});
		lblSabor4.setEnabled(false);
		lblSabor4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSabor4.setIconTextGap(20);
		lblSabor4.setIcon(new ImageIcon(PizzasView.class.getResource("/imagens/pizza-64.png")));
		lblSabor4.setHorizontalAlignment(SwingConstants.CENTER);
		lblSabor4.setFont(new Font("Leelawadee", Font.BOLD, 16));
		rdbtnUmSabor.doClick();
		
		panelInferior = new JPanel();
		panelInferior.setPreferredSize(new Dimension(10, 200));
		panelCentro.add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		panelObservacoes = new JPanel();
		panelObservacoes.setPreferredSize(new Dimension(380, 180));
		panelInferior.add(panelObservacoes);
		panelObservacoes.setLayout(new BorderLayout(0, 0));
		
		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservacoes.setPreferredSize(new Dimension(67, 60));
		lblObservacoes.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		panelObservacoes.add(lblObservacoes,BorderLayout.NORTH);
		
		txtAreaObservacoes = new JTextArea();
		txtAreaObservacoes.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		txtAreaObservacoes.setLineWrap(true);
		txtAreaObservacoes.setWrapStyleWord(true);
		panelObservacoes.add(txtAreaObservacoes, BorderLayout.CENTER);
		
		panelQuantidade = new JPanel();
		panelQuantidade.setSize(new Dimension(100, 0));
		panelQuantidade.setMaximumSize(new Dimension(100, 32767));
		panelQuantidade.setPreferredSize(new Dimension(280, 180));
		panelQuantidade.setMinimumSize(new Dimension(300, 180));
		panelInferior.add(panelQuantidade);
		panelQuantidade.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 45));
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setMinimumSize(new Dimension(60, 30));
		lblQuantidade.setHorizontalTextPosition(SwingConstants.CENTER);
		lblQuantidade.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		lblQuantidade.setPreferredSize(new Dimension(120, 30));
		lblQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		panelQuantidade.add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtQuantidade.setColumns(4);
		txtQuantidade.setName("Digite a quantidade...");
		txtQuantidade.setMaximumSize(new Dimension(2, 30));
		txtQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuantidade.setSize(new Dimension(5, 30));
		txtQuantidade.setMinimumSize(new Dimension(2, 30));
		txtQuantidade.setPreferredSize(new Dimension(5, 30));
		txtQuantidade.setBorder(null);
		txtQuantidade.setFont(new Font("Leelawadee UI", Font.BOLD, 22));
		txtQuantidade.setText("1");
		panelQuantidade.add(txtQuantidade);
		
		panelAddCarrinho = new JPanel();
		panelQuantidade.add(panelAddCarrinho);
		panelAddCarrinho.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnAddCarrinho = new JButton("Adicionar no carrinho");
		btnAddCarrinho.setMargin(new Insets(0, 0, 0, 0));
		btnAddCarrinho.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Verifica qual RadioButton do grupo dos tamanhos da pizza está selecionado
				if(rdbtnBroto.isSelected()) item.setTamanho(rdbtnBroto.getText());
				else if(rdbtnTradicional.isSelected()) item.setTamanho(rdbtnTradicional.getText());
				else if(rdbtnGrande.isSelected()) item.setTamanho(rdbtnGrande.getText());
				else item.setTamanho(rdbtnExtraGrande.getText());
				
				item.setObservacoes(txtAreaObservacoes.getText());
				item.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
				item.setPrecoTotal(item.calculoPrecoTotal());
				item.setTipoProduto("Pizza");
				
				CarrinhoController.addProduto(item);
				
				item = new ItemPedido();
				
				if(checkboxConfigPizza.isSelected()) {
					
					checkboxConfigPizza.updateUI();
					checkboxConfigPizza.doClick();
				}
				
				rdbtnBroto.setSelected(true);
				
				rdbtnSemBorda.setSelected(true);
				rdbtnSemBorda.doClick();
				
				rdbtnUmSabor.setSelected(true);
				rdbtnUmSabor.doClick();
				
				cbxBordaSalgada.setSelectedIndex(0);
				cbxBordaDoce.setSelectedIndex(0);
				
				txtAreaObservacoes.setText("");
				txtQuantidade.setText("1");
				
				carrinhoView.AtualizarLista();
			}
		});
		btnAddCarrinho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddCarrinho.setBackground(Color.WHITE);
		btnAddCarrinho.setBorderPainted(false);
		btnAddCarrinho.setFocusable(false);
		btnAddCarrinho.setPreferredSize(new Dimension(220, 55));
		btnAddCarrinho.setMinimumSize(new Dimension(133, 60));
		btnAddCarrinho.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddCarrinho.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		btnAddCarrinho.setBorder(null);
		panelAddCarrinho.add(btnAddCarrinho);
		
		Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
		
		if(tamanhoTela.getWidth() >= 1366) {
			
			panelLateral = new JPanel();
			panelLateral.setLayout(new BorderLayout());
			getContentPane().add(panelLateral, BorderLayout.EAST);
			
			panelLateral.add(carrinhoView, BorderLayout.CENTER);
			carrinhoView.setVisible(true);
		}
	}
}
