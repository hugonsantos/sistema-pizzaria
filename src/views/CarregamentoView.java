package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class CarregamentoView extends JWindow {

	private static final long serialVersionUID = 1L;
	
	public CarregamentoView() {
		
	}
	
	public CarregamentoView(String texto, Color cor) {
		
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		setBackground(new Color(0, 0, 0, 0f));
		getContentPane().setLayout(new GridLayout(2, 1));
		
		JLabel lblCarregamentoImagem = new JLabel();
		lblCarregamentoImagem.setIcon(new ImageIcon(getClass().getResource("/imagens/loads.gif")));
		lblCarregamentoImagem.setHorizontalAlignment(SwingUtilities.CENTER);
		lblCarregamentoImagem.setOpaque(false);
		getContentPane().add(lblCarregamentoImagem);
		
		JLabel lblCarregamentoTexto = new JLabel();
		lblCarregamentoTexto.setHorizontalAlignment(SwingUtilities.CENTER);
		lblCarregamentoTexto.setText(texto);
		lblCarregamentoTexto.setFont(new Font("Leelawadee UI", Font.BOLD, 20));
		lblCarregamentoTexto.setForeground(cor);
		lblCarregamentoTexto.setOpaque(false);
		getContentPane().add(lblCarregamentoTexto);
		
		this.pack();
	}
	
	public void close() {
		
		this.setVisible(false);
		this.dispose();
	}
}
