package views.internos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.util.ImagensUtil;
import model.util.MouseListenerUtil;

public class VenderView extends TelaInternaCustom {

	private static final long serialVersionUID = 1L;
	
	private PizzasView pizzasView;
	private DemaisProdutosView demaisProdutosView;
	private final List<JButton> listBotoesLaterais = new ArrayList<>();
	
	private JButton btnPizzas;
	private JButton btnPorcoes;
	private JButton btnLanches;
	private JButton btnEsfihas;
	private JButton btnFogazzas;
	private JButton btnPasteis;
	private JButton btnSobremesas;
	private JButton btnBebidas;

	public VenderView() {
		
		JPanel panelProdutos = new JPanel();
		getContentPane().add(panelProdutos, BorderLayout.CENTER);
		panelProdutos.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLateral = new JPanel();
		panelLateral.setFocusable(false);
		panelLateral.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelLateral.setPreferredSize(new Dimension(60, 0));
		panelLateral.setBackground(Color.GRAY);
		panelLateral.setLayout(new GridLayout(9, 1));
		
		JScrollPane scrollPane = new JScrollPane(panelLateral);
		scrollPane.setBorder(null);
		getContentPane().add(scrollPane, BorderLayout.WEST);
		
		btnPizzas = new JButton("");
		btnPizzas.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(getClass().getResource("/imagens/pedaco-pizza-64.png")), 34, 34));
		btnPizzas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				estadoButton(btnPizzas);
				
				panelProdutos.removeAll();
				
				if(pizzasView == null) {
					pizzasView = new PizzasView();
				}
				
				panelProdutos.add(pizzasView);
				pizzasView.setVisible(true);
				
				panelProdutos.repaint();
				panelProdutos.validate();
			}
		});
		listBotoesLaterais.add(btnPizzas);
		btnPizzas.setForeground(Color.WHITE);
		btnPizzas.setFont(new Font("Leelawadee", Font.BOLD, 16));
		btnPizzas.setBackground(Color.GRAY);
		btnPizzas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPizzas.setFocusable(false);
		btnPizzas.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnPizzas.setMargin(new Insets(0, 0, 0, 0));
		panelLateral.add(btnPizzas);
		
		btnPorcoes = new JButton("");
		btnPorcoes.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(getClass().getResource("/imagens/porcao-64.png")), 34, 34));
		btnPorcoes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				demaisProdutosView = null;
				
				estadoButton(btnPorcoes);
				panelProdutos.removeAll();
				
				demaisProdutosView = new DemaisProdutosView();
				
				panelProdutos.add(demaisProdutosView);
				demaisProdutosView.setVisible(true);
				
				panelProdutos.repaint();
				panelProdutos.validate();
			}
		});
		listBotoesLaterais.add(btnPorcoes);
		btnPorcoes.setBorderPainted(false);
		btnPorcoes.setForeground(Color.WHITE);
		btnPorcoes.setFont(new Font("Leelawadee", Font.BOLD, 16));
		btnPorcoes.setBackground(Color.GRAY);
		btnPorcoes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPorcoes.setFocusable(false);
		btnPorcoes.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnPorcoes.setMargin(new Insets(0, 0, 0, 0));
		panelLateral.add(btnPorcoes);
		
		btnLanches = new JButton("");
		btnLanches.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(getClass().getResource("/imagens/lanche-64.png")), 34, 34));
		btnLanches.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				demaisProdutosView = null;
				
				estadoButton(btnLanches);
				panelProdutos.removeAll();
				
				demaisProdutosView = new DemaisProdutosView();
				
				panelProdutos.add(demaisProdutosView);
				demaisProdutosView.setVisible(true);
				
				panelProdutos.repaint();
				panelProdutos.validate();
			}
		});
		listBotoesLaterais.add(btnLanches);
		btnLanches.setBorderPainted(false);
		btnLanches.setForeground(Color.WHITE);
		btnLanches.setFont(new Font("Leelawadee", Font.BOLD, 16));
		btnLanches.setBackground(Color.GRAY);
		btnLanches.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLanches.setFocusable(false);
		btnLanches.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnLanches.setMargin(new Insets(0, 0, 0, 0));
		panelLateral.add(btnLanches);
		
		btnEsfihas = new JButton("");
		btnEsfihas.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(getClass().getResource("/imagens/esfiha-64.png")), 34, 34));
		btnEsfihas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		listBotoesLaterais.add(btnEsfihas);
		btnEsfihas.setBorderPainted(false);
		btnEsfihas.setForeground(Color.WHITE);
		btnEsfihas.setFont(new Font("Leelawadee", Font.BOLD, 16));
		btnEsfihas.setBackground(Color.GRAY);
		btnEsfihas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEsfihas.setFocusable(false);
		btnEsfihas.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnEsfihas.setMargin(new Insets(0, 0, 0, 0));
		panelLateral.add(btnEsfihas);
		
		btnFogazzas = new JButton("");
		btnFogazzas.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(getClass().getResource("/imagens/fogazza-64.png")), 34, 34));
		btnFogazzas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		listBotoesLaterais.add(btnFogazzas);
		btnFogazzas.setBorderPainted(false);
		btnFogazzas.setForeground(Color.WHITE);
		btnFogazzas.setFont(new Font("Leelawadee", Font.BOLD, 16));
		btnFogazzas.setBackground(Color.GRAY);
		btnFogazzas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFogazzas.setFocusable(false);
		btnFogazzas.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnFogazzas.setMargin(new Insets(0, 0, 0, 0));
		panelLateral.add(btnFogazzas);
		
		btnPasteis = new JButton("");
		btnPasteis.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(getClass().getResource("/imagens/salgado-64.png")), 34, 34));
		btnPasteis.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		listBotoesLaterais.add(btnPasteis);
		btnPasteis.setBorderPainted(false);
		btnPasteis.setForeground(Color.WHITE);
		btnPasteis.setFont(new Font("Leelawadee", Font.BOLD, 16));
		btnPasteis.setBackground(Color.GRAY);
		btnPasteis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPasteis.setFocusable(false);
		btnPasteis.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnPasteis.setMargin(new Insets(0, 0, 0, 0));
		panelLateral.add(btnPasteis);
		
		btnSobremesas = new JButton("");
		btnSobremesas.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(getClass().getResource("/imagens/sobremesa-64.png")), 34, 34));
		btnSobremesas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		listBotoesLaterais.add(btnSobremesas);
		btnSobremesas.setBorderPainted(false);
		btnSobremesas.setForeground(Color.WHITE);
		btnSobremesas.setFont(new Font("Leelawadee", Font.BOLD, 16));
		btnSobremesas.setBackground(Color.GRAY);
		btnSobremesas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobremesas.setFocusable(false);
		btnSobremesas.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnSobremesas.setMargin(new Insets(0, 0, 0, 0));
		panelLateral.add(btnSobremesas);
		
		btnBebidas = new JButton("");
		btnBebidas.setIcon(ImagensUtil.redimensionarImagem(new ImageIcon(getClass().getResource("/imagens/bebida-64.png")), 34, 34));
		listBotoesLaterais.add(btnBebidas);
		btnBebidas.setBorderPainted(false);
		btnBebidas.setForeground(Color.WHITE);
		btnBebidas.setFont(new Font("Leelawadee", Font.BOLD, 16));
		btnBebidas.setBackground(Color.GRAY);
		btnBebidas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBebidas.setFocusable(false);
		btnBebidas.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnBebidas.setMargin(new Insets(0, 0, 0, 0));
		panelLateral.add(btnBebidas);
		
		pizzasView = new PizzasView();
		
		panelProdutos.add(pizzasView);
		pizzasView.setVisible(true);
		
		estadoButton(btnPizzas);
	}
	
	private void estadoButton(JButton button) {
		
		for(JButton b : listBotoesLaterais) {
			
			MouseListenerUtil ms = new MouseListenerUtil(b);
			
			MouseListener[] ma = b.getMouseListeners();
			
			if(b.equals(button)) {
				
				b.setSelected(true);
				
				b.setForeground(Color.BLACK);
				b.setBackground(Color.WHITE);
				
				if(ma.length >= 2) {
					
					b.removeMouseListener(ma[1]);
				}
			}
			else {
				
				b.setSelected(false);
				
				b.setForeground(Color.WHITE);
				b.setBackground(Color.GRAY);
				
				if(ma.length == 1) {
					
					b.addMouseListener(ms);
				}
			}
		}
	}
}
