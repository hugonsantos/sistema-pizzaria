package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarregamentoView extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarregamentoView frame = new CarregamentoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CarregamentoView() {
		
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(null);
		contentPane.setOpaque(false);
		contentPane.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		setContentPane(contentPane);
		
		JLabel lblCarregamento = new JLabel();
		lblCarregamento.setIcon(new ImageIcon(getClass().getResource("/imagens/loads.gif")));
		lblCarregamento.setOpaque(false);
		contentPane.add(lblCarregamento, BorderLayout.CENTER);
	}

	@Override
	public void run() {

		CarregamentoView.main(null);
	}
}
