import java.awt.Graphics;

public class GraphicObj {
	protected int x;
	protected int y;
	protected int xDirection;
	protected int yDirection;
	protected Sprite sprite;

	/** Starts moving the object in the direction (xIncrement, yIncrement). */
	public void setMovementVector(int xIncrement, int yIncrement) {
		xDirection = xIncrement;
		yDirection = yIncrement;
	}

	public void draw(Graphics graphics) {
		sprite.draw(graphics, x, y);

		// Move the center of the object each time we draw it
		x += xDirection;
		y += yDirection;
	}

}
