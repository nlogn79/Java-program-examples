import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {

	Bouncer movingSprite1, movingSprite2;
	StraightMover movingSprite3, movingSprite4;

	ArrayList<Mover> MoverList = new ArrayList<Mover>();

	/** Initializes this class for drawing. */
	public DrawGraphics() {
		Rectangle box1 = new Rectangle(15, 20, Color.RED);
		movingSprite1 = new Bouncer(100, 170, box1);
		movingSprite1.setMovementVector(3, 1);

		Oval oval1 = new Oval(20, 30, Color.BLUE);
		movingSprite2 = new Bouncer(30, 20, oval1);
		movingSprite2.setMovementVector(2, 1);

		Rectangle box2 = new Rectangle(10, 30, Color.YELLOW);
		movingSprite3 = new StraightMover(20, 10, box2);
		movingSprite3.setMovementVector(-2, 1);

		Oval oval2 = new Oval(15, 20, Color.GREEN);
		movingSprite4 = new StraightMover(30, 20, oval2);
		movingSprite4.setMovementVector(1, 3);

		MoverList.add(movingSprite1);
		MoverList.add(movingSprite2);
		MoverList.add(movingSprite3);
		MoverList.add(movingSprite4);

	}

	/** Draw the contents of the window on surface. */
	public void draw(Graphics surface) {

		for (Mover m : MoverList) {
			m.draw(surface);
		}

	}
}
