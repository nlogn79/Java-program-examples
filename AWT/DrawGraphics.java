import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
	BouncingBox box1, box2, box3;
	BouncingOval oval1, oval2, oval3;

	ArrayList<BouncingBox> boxes = new ArrayList<BouncingBox>();
	ArrayList<BouncingOval> ovals = new ArrayList<BouncingOval>();

	/** Initializes this class for drawing. */
	public DrawGraphics() {

		box1 = new BouncingBox(30, 50, Color.DARK_GRAY);
		box1.setMovementVector(1, -1);

		box2 = new BouncingBox(120, 160, Color.cyan);
		box2.setMovementVector(-1, 2);

		box3 = new BouncingBox(70, 90, Color.RED);
		box3.setMovementVector(0, -1);

		boxes.add(box1);
		boxes.add(box2);
		boxes.add(box3);

		oval1 = new BouncingOval(20, 90, Color.BLACK);
		oval1.setMovementVector(3, -2);

		oval2 = new BouncingOval(200, 30, Color.BLUE);
		oval2.setMovementVector(1, 0);

		oval3 = new BouncingOval(70, 90, Color.GRAY);
		oval3.setMovementVector(-1, -1);

		ovals.add(oval1);
		ovals.add(oval2);
		ovals.add(oval3);

	}

	/**
	 * Draw the contents of the window on surface. Called 20 times per second.
	 */
	public void draw(Graphics surface) {
		surface.drawOval(80, 80, 50, 40);
		surface.drawRect(180, 180, 60, 50);
		surface.drawArc(100, 100, 120, 120, 0, 100);

		for (BouncingBox b : boxes) {
			b.draw(surface);
		}

		for (BouncingOval o : ovals) {
			o.draw(surface);
		}
	}
}