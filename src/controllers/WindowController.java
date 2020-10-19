package controllers;

import javax.swing.JFrame;

public class WindowController {

	
	public WindowController() {
		
	}
	
	public void maximizar(JFrame frame) {
		
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
	}
}
