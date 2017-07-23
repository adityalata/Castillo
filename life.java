import java.awt.Rectangle;

public class life extends Entity
{
	
	int anim,change_rate=10;
	protected int x,y;
	Sprite sprite;
	public life(int x,int y)
	{
		this.x=x;
		this.y=y;
		sprite=Sprite.hearts1;
	}

	public void update()
	{
		if(change_rate<=0)change_rate=10;
		else change_rate-=1;
		if(change_rate==2)
		{
			if(anim>750)anim=0;
			else anim+=1;
			if(anim%2==0) sprite=Sprite.hearts1;
			else sprite=Sprite.hearts2;			
		}
		clear();
	}

	public void render(Screen screen)
	{
		screen.renderTile(x, y, sprite);	
	}
	
	public void clear()
	{
		for(int i=0;i<level.hearts.size();i++)
		{
			life f=level.hearts.get(i);
			if(f.isRemoved())level.hearts.remove(i);
		}	
	}
	
	public Rectangle draw_life()
	{
		return new Rectangle (x,y,16,16);
	}	
}
