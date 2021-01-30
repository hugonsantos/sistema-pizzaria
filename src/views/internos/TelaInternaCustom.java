package views.internos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import java.awt.Component;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

public abstract class TelaInternaCustom extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	public TelaInternaCustom() {
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(new Dimension(1000, 768));
		setMinimumSize(new Dimension(1000, 768));
		
		setAutoscrolls(true);
		setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
		bi.setNorthPane(null);
		
		JPanel jifPanelTopo = new JPanel();
		jifPanelTopo.setAlignmentY(Component.TOP_ALIGNMENT);
		jifPanelTopo.setAlignmentX(Component.LEFT_ALIGNMENT);
		jifPanelTopo.setMinimumSize(new Dimension(0, 0));
		jifPanelTopo.setPreferredSize(new Dimension(10, 20));
		jifPanelTopo.setBackground(Color.GRAY);
		jifPanelTopo.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		jifPanelTopo.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(jifPanelTopo, BorderLayout.NORTH);
		
		JButton btnExit = new JButton("X");
		btnExit.setBorderPainted(false);
		btnExit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnExit.setBackground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				btnExit.setBackground(Color.GRAY);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				dispose();
			}
		});
		btnExit.setFocusable(false);
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.GRAY);
		btnExit.setMargin(new Insets(0, 0, 0, 0));
		btnExit.setBorder(null);
		btnExit.setPreferredSize(new Dimension(50, 20));
		btnExit.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExit.setFont(new Font("Leelawadee", Font.BOLD, 14));
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jifPanelTopo.add(btnExit);
	}
}
