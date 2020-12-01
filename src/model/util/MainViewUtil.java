package model.util;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class MainViewUtil {

public void desabilitarBotoes(JButton botao, MouseListener mouseListener) {
		
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
	
	public MouseListener adicionarAcaoMouse(JButton botao, Color corTexto, Color corFundo) {
		
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
}
