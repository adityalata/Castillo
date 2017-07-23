import java.awt.Rectangle;

public class fire extends Entity
{
	public int fx,fy;
	public Sprite sprite;
	public int change_rate=5,anim=1;
	
	public fire(int x,int y)
	{	
		fx=x;
		fy=y;
		sprite=Sprite.fire1;
	}

	public void update()
	{	
		
		if(change_rate<=0)change_rate=5;
		else change_rate-=1;
		if(change_rate==2)
		{			
			if(anim==7)anim=1;
			else anim+=1;
			if(anim==1) sprite=Sprite.fire1;
			if(anim==2) sprite=Sprite.fire2;
			if(anim==3) sprite=Sprite.fire3;
			if(anim==4) sprite=Sprite.fire4;
			if(anim==5) sprite=Sprite.fire5;
			if(anim==6) sprite=Sprite.fire6;
			if(anim==7) sprite=Sprite.fire7;
			
		}
		
		clear();
	}
	
	public void render(Screen screen)
	{
			screen.renderTile(fx, fy, sprite);
	}
	
	public Rectangle drawfire()
	{
		return new Rectangle (fx,fy,16,16);
	}

	public void clear()
	{
		for(int i=0;i<level.fire.size();i++)
		{
			fire f=level.fire.get(i);
			if(f.isRemoved())level.fire.remove(i);
		}
	}

}
