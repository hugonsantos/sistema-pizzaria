package model.util;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

public class TableCelulasCustomizadas extends JTextArea implements TableCellRenderer {
	
	private static final long serialVersionUID = 1L;

	public TableCelulasCustomizadas() {
		
		setLineWrap(true);
        setWrapStyleWord(true);
        setFont(new Font("Leelawadee UI", Font.BOLD, 12));
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		this.setText(value.toString());

        setText((value == null) ? "" : value.toString());
        setSize(table.getColumnModel().getColumn(column).getWidth(),
                getPreferredSize().height);

        if (table.getRowHeight(row) < getPreferredSize().height) {
            table.setRowHeight(row, getPreferredSize().height );
        }

        return this;
	}
}
