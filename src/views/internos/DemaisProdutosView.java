package views.internos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DemaisProdutosView extends TelaInternaCustom {

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
		
	 	table = new JTable();
	 	
		JScrollPane scrollPaneLanches = new JScrollPane(table);
		getContentPane().add(scrollPaneLanches, BorderLayout.NORTH);
	}
}
