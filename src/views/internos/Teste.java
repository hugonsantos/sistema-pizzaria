package views.internos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class Teste extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	public Teste() {
		
		JInternalFrame internalFrame = new JInternalFrame();
		BasicInternalFrameUI basicUI = (BasicInternalFrameUI) internalFrame.getUI();
		basicUI.setNorthPane(null);
		internalFrame.setBorder(null);
		
		JPanel jifPanelTopo = new JPanel();
		jifPanelTopo.setPreferredSize(new Dimension(10, 28));
		jifPanelTopo.setBackground(Color.GRAY);
		internalFrame.getContentPane().add(jifPanelTopo, BorderLayout.NORTH);
		
		JButton btnExit = new JButton("X");
		btnExit.setVerticalAlignment(SwingConstants.TOP);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				btnExit.setBackground(Color.DARK_GRAY);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0);
			}
		});
		jifPanelTopo.setLayout(new BorderLayout(0, 0));
		btnExit.setFocusable(false);
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setBorder(null);
		btnExit.setPreferredSize(new Dimension(60, 28));
		btnExit.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExit.setFont(new Font("Leelawadee", Font.BOLD, 20));
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jifPanelTopo.add(btnExit, BorderLayout.EAST);
	}
}
