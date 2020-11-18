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
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public final class PizzasView extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private final ButtonGroup grupoTamanhos = new ButtonGroup();
	private final ButtonGroup grupoQTDSabores = new ButtonGroup();
	private JTextField txtQuantidade;

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
		 
	 	setSize(new Dimension(900, 800));
	 	setPreferredSize(new Dimension(900, 800));
	 	setMinimumSize(new Dimension(600, 800));
		
		setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
		bi.setNorthPane(null);
		
		JPanel panelPizzas = new JPanel();
		getContentPane().add(panelPizzas, BorderLayout.CENTER);
		panelPizzas.setLayout(new BoxLayout(panelPizzas, BoxLayout.Y_AXIS));
		
		JPanel panelTamanho = new JPanel();
		panelTamanho.setPreferredSize(new Dimension(10, 120));
		panelTamanho.setBorder(new EmptyBorder(20, 0, 20, 0));
		panelPizzas.add(panelTamanho);
		panelTamanho.setLayout(new BoxLayout(panelTamanho, BoxLayout.X_AXIS));
		
		JRadioButton rdbtnBroto = new JRadioButton("Broto");
		rdbtnBroto.setContentAreaFilled(false);
		grupoTamanhos.add(rdbtnBroto);
		rdbtnBroto.setFocusable(false);
		rdbtnBroto.setBorder(new EmptyBorder(0, 0, 0, 60));
		rdbtnBroto.setFont(new Font("Leelawadee UI", Font.BOLD, 19));
		panelTamanho.add(rdbtnBroto);
		
		JRadioButton rdbtnTradicional = new JRadioButton("Tradicional");
		rdbtnTradicional.setContentAreaFilled(false);
		grupoTamanhos.add(rdbtnTradicional);
		rdbtnTradicional.setFocusable(false);
		rdbtnTradicional.setBorder(new EmptyBorder(0, 60, 0, 60));
		rdbtnTradicional.setFont(new Font("Leelawadee UI", Font.BOLD, 19));
		panelTamanho.add(rdbtnTradicional);
		
		JRadioButton rdbtnGrande = new JRadioButton("Grande");
		rdbtnGrande.setContentAreaFilled(false);
		grupoTamanhos.add(rdbtnGrande);
		rdbtnGrande.setFocusable(false);
		rdbtnGrande.setBorder(new EmptyBorder(0, 60, 0, 0));
		rdbtnGrande.setFont(new Font("Leelawadee UI", Font.BOLD, 19));
		panelTamanho.add(rdbtnGrande);
		
		JPanel panelQTDSabores = new JPanel();
		panelQTDSabores.setPreferredSize(new Dimension(10, 120));
		panelQTDSabores.setBorder(new EmptyBorder(20, 0, 20, 0));
		panelPizzas.add(panelQTDSabores);
		
		JLabel lblSelecionarSabores = new JLabel("Selecione o(s) sabor(es):");
		lblSelecionarSabores.setFont(new Font("Leelawadee UI", Font.BOLD, 19));
		lblSelecionarSabores.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecionarSabores.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelPizzas.add(lblSelecionarSabores);
		
		JPanel panelSelecionarSabor = new JPanel();
		panelSelecionarSabor.setPreferredSize(new Dimension(10, 500));
		panelPizzas.add(panelSelecionarSabor);
		panelSelecionarSabor.setLayout(new GridLayout(1, 4));
		
		JLabel lblSabor1 = new JLabel("Primeiro sabor");
		lblSabor1.setIconTextGap(20);
		lblSabor1.setIcon(new ImageIcon(PizzasView.class.getResource("/imagens/pizza-64.png")));
		lblSabor1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSabor1.setFont(new Font("Leelawadee", Font.BOLD, 16));
		
		JLabel lblSabor2 = new JLabel("Segundo sabor");
		lblSabor2.setIconTextGap(20);
		lblSabor2.setIcon(new ImageIcon(PizzasView.class.getResource("/imagens/pizza-64.png")));
		lblSabor2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSabor2.setFont(new Font("Leelawadee", Font.BOLD, 16));
		
		JLabel lblSabor3 = new JLabel("Terceiro sabor");
		lblSabor3.setIconTextGap(20);
		lblSabor3.setIcon(new ImageIcon(PizzasView.class.getResource("/imagens/pizza-64.png")));
		lblSabor3.setHorizontalAlignment(SwingConstants.CENTER);
		lblSabor3.setFont(new Font("Leelawadee", Font.BOLD, 16));
		
		JLabel lblSabor4 = new JLabel("Quarto sabor");
		lblSabor4.setIconTextGap(20);
		lblSabor4.setIcon(new ImageIcon(PizzasView.class.getResource("/imagens/pizza-64.png")));
		lblSabor4.setHorizontalAlignment(SwingConstants.CENTER);
		lblSabor4.setFont(new Font("Leelawadee", Font.BOLD, 16));
		
		JRadioButton rdbtnUmSabor = new JRadioButton("1 Sabor");
		rdbtnUmSabor.setContentAreaFilled(false);
		rdbtnUmSabor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelSelecionarSabor.removeAll();
				JLabel lblSabor1 = new JLabel("Sabor");
				lblSabor1.setIconTextGap(20);
				lblSabor1.setIcon(new ImageIcon(PizzasView.class.getResource("/imagens/pizza-64.png")));
				lblSabor1.setHorizontalAlignment(SwingConstants.CENTER);
				lblSabor1.setFont(new Font("Leelawadee", Font.BOLD, 16));
				panelSelecionarSabor.add(lblSabor1);
				panelSelecionarSabor.repaint();
				panelSelecionarSabor.validate();
			}
		});
		grupoQTDSabores.add(rdbtnUmSabor);
		rdbtnUmSabor.setFocusable(false);
		rdbtnUmSabor.setAlignmentX(Component.CENTER_ALIGNMENT);
		rdbtnUmSabor.setBorder(new EmptyBorder(0, 0, 0, 30));
		rdbtnUmSabor.setFont(new Font("Leelawadee UI", Font.BOLD, 19));
		panelQTDSabores.setLayout(new BoxLayout(panelQTDSabores, BoxLayout.X_AXIS));
		panelQTDSabores.add(rdbtnUmSabor);
		
		JRadioButton rdbtnDoisSabores = new JRadioButton("2 Sabores");
		rdbtnDoisSabores.setContentAreaFilled(false);
		rdbtnDoisSabores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelSelecionarSabor.removeAll();
				panelSelecionarSabor.add(lblSabor1);
				panelSelecionarSabor.add(lblSabor2);
				panelSelecionarSabor.repaint();
				panelSelecionarSabor.validate();
			}
		});
		grupoQTDSabores.add(rdbtnDoisSabores);
		rdbtnDoisSabores.setFocusable(false);
		rdbtnDoisSabores.setBorder(new EmptyBorder(0, 30, 0, 30));
		rdbtnDoisSabores.setFont(new Font("Leelawadee UI", Font.BOLD, 19));
		panelQTDSabores.add(rdbtnDoisSabores);
		
		JRadioButton rdbtnTresSabores = new JRadioButton("3 Sabores");
		rdbtnTresSabores.setContentAreaFilled(false);
		rdbtnTresSabores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelSelecionarSabor.removeAll();
				panelSelecionarSabor.add(lblSabor1);
				panelSelecionarSabor.add(lblSabor2);
				panelSelecionarSabor.add(lblSabor3);
				panelSelecionarSabor.repaint();
				panelSelecionarSabor.validate();
			}
		});
		grupoQTDSabores.add(rdbtnTresSabores);
		rdbtnTresSabores.setFocusable(false);
		rdbtnTresSabores.setBorder(new EmptyBorder(0, 30, 0, 30));
		rdbtnTresSabores.setFont(new Font("Leelawadee UI", Font.BOLD, 19));
		panelQTDSabores.add(rdbtnTresSabores);
		
		JRadioButton rdbtnQuatroSabores = new JRadioButton("4 Sabores");
		rdbtnQuatroSabores.setContentAreaFilled(false);
		rdbtnQuatroSabores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelSelecionarSabor.removeAll();
				panelSelecionarSabor.add(lblSabor1);
				panelSelecionarSabor.add(lblSabor2);
				panelSelecionarSabor.add(lblSabor3);
				panelSelecionarSabor.add(lblSabor4);
				panelSelecionarSabor.repaint();
				panelSelecionarSabor.validate();
			}
		});
		grupoQTDSabores.add(rdbtnQuatroSabores);
		rdbtnQuatroSabores.setFont(new Font("Leelawadee UI", Font.BOLD, 19));
		rdbtnQuatroSabores.setFocusable(false);
		rdbtnQuatroSabores.setBorder(new EmptyBorder(0, 30, 0, 0));
		panelQTDSabores.add(rdbtnQuatroSabores);
			
		JPanel panelInferior = new JPanel();
		panelInferior.setPreferredSize(new Dimension(10, 350));
		getContentPane().add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JPanel panelObservacoes = new JPanel();
		panelObservacoes.setMaximumSize(new Dimension(600, 32767));
		panelObservacoes.setLocation(new Point(600, 0));
		panelObservacoes.setSize(new Dimension(600, 0));
		panelObservacoes.setPreferredSize(new Dimension(600, 200));
		panelObservacoes.setMinimumSize(new Dimension(600, 10));
		panelInferior.add(panelObservacoes);
		panelObservacoes.setLayout(new BorderLayout(0, 0));
		
		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservacoes.setPreferredSize(new Dimension(67, 60));
		lblObservacoes.setFont(new Font("Leelawadee UI", Font.BOLD, 18));
		panelObservacoes.add(lblObservacoes,BorderLayout.NORTH);
		
		JTextArea textAreaObservacoes = new JTextArea();
		textAreaObservacoes.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		panelObservacoes.add(textAreaObservacoes, BorderLayout.CENTER);
		
		JPanel panelQuantidade = new JPanel();
		panelQuantidade.setSize(new Dimension(100, 0));
		panelQuantidade.setMaximumSize(new Dimension(100, 32767));
		panelQuantidade.setPreferredSize(new Dimension(300, 200));
		panelQuantidade.setMinimumSize(new Dimension(300, 300));
		panelInferior.add(panelQuantidade);
		panelQuantidade.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 45));
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setMinimumSize(new Dimension(60, 30));
		lblQuantidade.setHorizontalTextPosition(SwingConstants.CENTER);
		lblQuantidade.setFont(new Font("Leelawadee UI", Font.BOLD, 18));
		lblQuantidade.setPreferredSize(new Dimension(160, 30));
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
		txtQuantidade.setFont(new Font("Leelawadee UI", Font.BOLD, 24));
		txtQuantidade.setText("1");
		panelQuantidade.add(txtQuantidade);
		
		JPanel panel = new JPanel();
		panelQuantidade.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnQuantidade = new JButton("Adicionar no carrinho");
		btnQuantidade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuantidade.setBackground(Color.WHITE);
		btnQuantidade.setBorderPainted(false);
		btnQuantidade.setFocusable(false);
		btnQuantidade.setPreferredSize(new Dimension(250, 60));
		btnQuantidade.setMinimumSize(new Dimension(133, 60));
		btnQuantidade.setMargin(new Insets(0, 14, 0, 14));
		btnQuantidade.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuantidade.setFont(new Font("Leelawadee UI", Font.BOLD, 18));
		btnQuantidade.setBorder(null);
		panel.add(btnQuantidade);
	}
}
