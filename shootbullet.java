import java.awt.Rectangle;

public class shootbullet extends Bullet
{
		int d;
	public shootbullet(int x, int y, int direction)
	{		
		super(x, y, direction);
	}
	public void update()
	{
		if(dir==-1)
		{
			bx-=2;
			sprite=Sprite.bullet1;
		}
		
		if(dir==1)
		{
			bx+=2;
			sprite=Sprite.bullet2;
		}
		
		d=Math.abs(distance());
		if(dir==1)
		System.out.println(d);
		if(d>100) remove();
		
	}
	
	public void render(Screen screen)
	{
		screen.renderTile(bx, by, sprite);	 
	}
	
	public Rectangle draw_bullet()
	{
		return new Rectangle(bx+10,by+10,10,10);
	}
	
	public int distance()
	{
		int dis= bx-start;
		return dis;
	}

}
