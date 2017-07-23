import java.awt.Rectangle;

public class collectpoints extends points
{
	public int anim;
		
	public collectpoints(int x, int y)
	{
		super(x, y);
		sprite =Sprite.coin1;
		//sprite=Sprite.coin;
		
	}
	
	public void update()
	{
		if(anim>7500)
			anim=0;
		else
			anim++;
		if(anim%20>10)
			sprite=Sprite.coin1;
		else 
			sprite=Sprite.coin2;
		Rectangle r;
		
		clear();
	}
	
	public void render(Screen screen)
	{
		screen.renderTile(cx,cy,sprite);
	}
	
	public void clear()
	{
		for(int i=0;i<level.coins.size();i++)
		{
			points p=level.coins.get(i);
			if(p.isRemoved())level.coins.remove(i);
		}
	}
	
	public Rectangle drawcoin()
	{
		return new Rectangle (cx,cy,16,16);
	}

}
