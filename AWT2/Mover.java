import java.awt.Graphics;

public interface Mover {

	public abstract void setMovementVector(int x, int y);

	public abstract void draw(Graphics g);

}
