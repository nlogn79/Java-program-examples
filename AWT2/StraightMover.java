public class StraightMover extends GraphicObj implements Mover {

	/** Create a Bouncer that positions sprite at (startX, startY). */
	public StraightMover(int startX, int startY, Sprite sprite) {
		x = startX;
		y = startY;
		this.sprite = sprite;
	}

}
