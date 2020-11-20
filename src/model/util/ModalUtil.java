package model.util;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import views.modal.ModalCustom;

public final class ModalUtil {

	private static Point point = new Point();
	
	public final void MovimentacaoModal(ModalCustom modal) {

		try {

			modal.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					point.x = e.getX();
					point.y = e.getY();
				}
			});

			modal.addMouseMotionListener(new MouseMotionAdapter() {

				@Override
				public void mouseDragged(MouseEvent e) {

					Point p = modal.getLocation();
					modal.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
