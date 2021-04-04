package views.internos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class DemaisProdutosView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemaisProdutosView frame = new DemaisProdutosView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DemaisProdutosView() {
		
		setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
		bi.setNorthPane(null);
		
		setSize(new Dimension(900, 800));
	 	setPreferredSize(new Dimension(900, 800));
	 	setMinimumSize(new Dimension(600, 800));
		
	 	table = new JTable();
	 	
		JScrollPane scrollPaneLanches = new JScrollPane(table);
		getContentPane().add(scrollPaneLanches, BorderLayout.NORTH);
	}
}
