import java.awt.Rectangle;

public class checkpoint extends Entity 
{
	protected int x,y;
	Sprite sprite;

	public checkpoint(int x,int y)
	{
		this.x=x;
		this.y=y;
		sprite=Sprite.checkpoint;
	}
	
	public void update()
	{
		clear();
	}
	
	public void render(Screen screen)
	{
		screen.renderTile(x, y, sprite);	
	}
	
	public void clear()
	{
		for(int i=0;i<level.check.size();i++)
		{
			checkpoint f=level.check.get(i);
			if(f.isRemoved())level.check.remove(i);
		}	
	}
	
	public Rectangle draw_check()
	{
		return new Rectangle (x,y,16,16);
	}

}
