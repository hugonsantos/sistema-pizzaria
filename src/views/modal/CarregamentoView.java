package views.modal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CarregamentoView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private static CarregamentoView frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frame = new CarregamentoView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CarregamentoView() {
		
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBackground(new Color(0, 0, 0, 0));
		
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblCarregamento = new JLabel("");
		lblCarregamento.setIcon(new ImageIcon(CarregamentoView.class.getResource("/imagens/carregamento.gif")));
		lblCarregamento.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCarregamento, BorderLayout.CENTER);
		
	}

}
