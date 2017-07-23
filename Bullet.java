import java.awt.Rectangle;

public class Bullet extends Entity
{
	protected int bx,by,dir,start;
	protected Sprite sprite;

	public Bullet(int x,int y,int direction) 
	{
		bx=x;
		by=y;
		start=x;
		dir=direction;
	}
	
	public void update()
	{
		
	}
	
	public void render(Screen screen)
	{
		
	}
	public void remove()
	{
		removed=true;
	}
	
	public boolean isRemoved()
	{
		return removed;
	}
	
	public Rectangle draw_bullet()
	{
		return null;
	}
	public int distance()
	{
		return 0;
	}
}
