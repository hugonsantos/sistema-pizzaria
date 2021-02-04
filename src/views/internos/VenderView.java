package views.internos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.util.MouseListenerUtil;
import views.internos.produtos.LanchesView;
import views.internos.produtos.PizzasView;

public class VenderView extends TelaInternaCustom {

	private static final long serialVersionUID = 1L;
	
	private static VenderView frame;
	private PizzasView pizzasView;
	private LanchesView lanchesView;
	private final List<JButton> listBotoesLaterais = new ArrayList<>();
	
	private JButton btnPizzas;
	private JButton btnPorcoes;
	private JButton btnLanches;
	private JButton btnEsfihas;
	private JButton btnFogazzas;
	private JButton btnPasteis;
	private JButton btnSobremesas;
	private JButton btnBebidas;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VenderView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VenderView() {
		
		JPanel panelProdutos = new JPanel();
		getContentPane().add(panelProdutos, BorderLayout.CENTER);
		panelProdutos.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLateral = new JPanel();
		panelLateral.setFocusable(false);
		panelLateral.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelLateral.setPreferredSize(new Dimension(120, 0));
		panelLateral.setBackground(Color.GRAY);
		panelLateral.setLayout(new GridLayout(9, 1));
		
		JScrollPane scrollPane = new JScrollPane(panelLateral);
		scrollPane.setBorder(null);
		getContentPane().add(scrollPane, BorderLayout.WEST);
		
		btnPizzas = new JButton("Pizzas");
		btnPizzas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				estadoButton(btnPizzas);
				
				panelProdutos.removeAll();
				
				pizzasView = new PizzasView();
				
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
		
		btnPorcoes = new JButton("Por��es");
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
		
		btnLanches = new JButton("Lanches");
		btnLanches.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				estadoButton(btnLanches);
				
				panelProdutos.removeAll();
				
				if(lanchesView == null) {
					lanchesView = new LanchesView();
				}
				panelProdutos.add(lanchesView);
				lanchesView.setVisible(true);
				
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
		
		btnEsfihas = new JButton("Esfihas");
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
		
		btnFogazzas = new JButton("Fogazzas");
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
		
		btnPasteis = new JButton("Pasteis");
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
		
		btnSobremesas = new JButton("Sobremesas");
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
		
		btnBebidas = new JButton("Bebidas");
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
