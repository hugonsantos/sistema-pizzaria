package model.util;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
	
	public static ImageIcon redimensionarImagem(ImageIcon img, double novaLargura, double novaAltura) {
		
		int larguraFinal = 0;
		int alturaFinal = 0;
		
		if(img.getIconWidth() > img.getIconHeight()) {
			
			double calculo = novaLargura / img.getIconWidth();
			
			larguraFinal = (int) novaLargura;
			alturaFinal = (int) (calculo * img.getIconHeight());
		}
		else if(img.getIconHeight() > img.getIconWidth()) {
			
			double calculo = novaAltura / img.getIconHeight();
			
			larguraFinal = (int) novaAltura;
			alturaFinal = (int) (calculo * img.getIconWidth());
		}
		else {
			
			larguraFinal = (int) novaAltura;
			alturaFinal = (int) novaAltura;
		}
		
		Image imagem = img.getImage().getScaledInstance(larguraFinal, alturaFinal, 100);
		
        return new ImageIcon(imagem);
    }
	
	public static byte[] converteInputStream(InputStream inputStream) throws IOException {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int reads = inputStream.read();
		
		while(reads != -1) {
			
			baos.write(reads);
			reads = inputStream.read();
		}
		
		return baos.toByteArray();
	}
}
