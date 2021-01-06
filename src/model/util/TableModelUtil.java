package model.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.table.JTableHeader;

public class TableModelUtil {

	public static void customizarTable(JTableHeader header) {
		
		header.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		header.setBackground(Color.WHITE);
	}
}
