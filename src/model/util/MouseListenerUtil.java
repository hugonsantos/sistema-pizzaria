package model.util;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class MouseListenerUtil implements MouseListener {
	
	private JButton button;

	public MouseListenerUtil(JButton button) {
		
		this.button = button;
	}
	
	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		button.setForeground(Color.WHITE);
		button.setBackground(Color.GRAY);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {

		button.setForeground(Color.BLACK);
		button.setBackground(Color.WHITE);
	}
}
