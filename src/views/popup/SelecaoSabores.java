package views.popup;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JLabel;

public class SelecaoSabores extends PopupCustom {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private static Point point = new Point();

	public static void main(String[] args) {
		
		PopupCustom popup = new SelecaoSabores();
		popup.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		popup.setVisible(true);
		
		try {
			
			popup.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mousePressed(MouseEvent e) {
					point.x = e.getX();
					point.y = e.getY();
				}
			});

			popup.addMouseMotionListener(new MouseMotionAdapter() {
				
				@Override
				public void mouseDragged(MouseEvent e) {
					
					Point p = popup.getLocation();
					popup.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SelecaoSabores() {
		
		JList<?> list = new JList<>();
		getContentPane().add(list, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("Imagem");
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		
		
	}
}
