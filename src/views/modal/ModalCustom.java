package views.modal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public abstract class ModalCustom extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	public ModalCustom() {
		
		setUndecorated(true);
		setBounds(100, 100, 950, 600);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.SOUTH);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTopo = new JPanel();
		panelTopo.setBackground(Color.DARK_GRAY);
		getContentPane().add(panelTopo, BorderLayout.NORTH);
		panelTopo.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		JButton btnExit = new JButton("X");
		btnExit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {

				btnExit.setBackground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				btnExit.setBackground(Color.DARK_GRAY);
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnExit.setBackground(Color.DARK_GRAY);
				dispose();
			}
		});
		btnExit.setFocusable(false);
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setBorder(null);
		btnExit.setPreferredSize(new Dimension(50, 28));
		btnExit.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExit.setFont(new Font("Leelawadee", Font.BOLD, 14));
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelTopo.add(btnExit);
	}
}
