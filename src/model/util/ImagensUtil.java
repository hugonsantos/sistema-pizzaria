package model.util;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;

public class ImagensUtil extends DefaultTableCellRenderer {
	
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void setValue(Object value) {
		
        ImageIcon icon = ImagensUtil.redimensionarImagem((ImageIcon) value, 150, 150);
        setIcon(icon);
        setHorizontalAlignment(CENTER);
    }
	
	public static ImageIcon redimensionarImagem(ImageIcon img, int xLargura, int yAltura){
	       
        ImageIcon imgIcon = new ImageIcon();  
        imgIcon.setImage(img.getImage().getScaledInstance(xLargura, yAltura, 100));
       
        return imgIcon;
    }
}
