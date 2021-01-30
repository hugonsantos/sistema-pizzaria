package model.util;

import java.awt.Color;
import java.awt.Font;
import java.util.regex.PatternSyntaxException;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class TableModelUtil {

	public static void customizarTable(JTableHeader header) {
		
		header.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		header.setBackground(Color.WHITE);
	}
	
	public static TableRowSorter<?> filtrarTabela(JTable table, String texto, Integer indice) {
		
		AbstractTableModel tableModel = (AbstractTableModel) table.getModel();
		
		final TableRowSorter<?> sorter = new TableRowSorter<>(tableModel);
	    
		String nomePizza = "(?i)" + texto;
		
	    if (nomePizza.length() == 0){
	    	
	        sorter.setRowFilter(null);
	    }
	    else {
	    	
	        try{
	        	
	            sorter.setRowFilter(RowFilter.regexFilter(nomePizza, 1));
	        }
	        catch (PatternSyntaxException pse){
	        	pse.printStackTrace();
	            System.out.print("Erro ao filtrar!");
	        }
	    }
	    
	    return sorter;
	}
}
