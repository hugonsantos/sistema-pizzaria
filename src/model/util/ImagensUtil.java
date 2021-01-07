package model.util;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImagensUtil {

	public static ImageIcon redimensionarImagem(JLabel jLabel, int xLargura, int yAltura){
	       
        ImageIcon img = new ImageIcon (jLabel.getIcon().toString());  
        img.setImage(img.getImage().getScaledInstance(xLargura, yAltura, 100));
       
        return img;
    }
}
