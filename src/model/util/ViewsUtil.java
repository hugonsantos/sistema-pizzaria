package model.util;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import views.internos.produtos.PizzasView;

public class ViewsUtil {

	public static void desabilitarBotoes(JButton botao, MouseListener mouseListener) {
		
		botao.setEnabled(false);
		botao.addActionListener(null);
		botao.removeMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {

				botao.setForeground(Color.BLACK);
				botao.setBackground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {

				botao.setForeground(Color.BLACK);
				botao.setBackground(Color.WHITE);
			}
		});
	}
	
	public static MouseListener adicionarAcaoMouse(JButton botao, Color corTexto, Color corFundo) {
		
		MouseListener m = new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {

				botao.setForeground(Color.BLACK);
				botao.setBackground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {

				botao.setForeground(corTexto);
				botao.setBackground(corFundo);
			}
		};
		
		return m;
	}
	
	public static void limparSelecao(JLabel label, String texto) {
		
		label.setIcon(new ImageIcon(PizzasView.class.getResource("/imagens/pizza-64.png")));
		label.setText(texto);
	}
	
	public static Boolean limparSelecao(Integer tamanho, Integer subTamanho) {
		
		if(tamanho >= subTamanho) return true; else return false;
	}
}
