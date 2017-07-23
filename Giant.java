import java.awt.Rectangle;

public class Giant extends Entity 
{

	protected int x,y;
	protected Sprite sprite;
	int start_pos,final_right,final_left;
	boolean left=false,right=true;
	
	public Giant(int x,int y)
	{
		this.x=x-32;
		this.y=y-32;
		start_pos=x;
		
		final_right=start_pos+(16*1);
		final_left=start_pos-(16*4);
		sprite=Sprite.ghost1;
	}
	
	public void update(int check)
	{
		if(x<final_right&&!left)
		{
			right=true;
		}
		
		if(right)
		{
			if(x<final_right)x++;
			sprite=Sprite.ghost1;
		}
		
		if(left)
		{
			if(x>final_left)
			x--;
			sprite=Sprite.ghost2;
		}
		
		if(x==final_right)
		{
			left=true;
			right=false;
		}
		
		if(x==final_left)
		{
			left=false;
		
			right=true;
		}
		
		int dx,dy;
		dx=(Math.abs(level.player_x-x));
		dy=(-(level.player_y-y));
		
		if(check==0)
		{	
			if(dy<17)
			{
				if(dx<100)
				{
					level.giant_collision=true;	
					
					level.life-=1;
					if(level.life==0)
					{
						level.gameover=true;
					}
				}
			}
		}
		clear();
	}
	
	public Rectangle draw_giant()
	{
		return new Rectangle(x+16,y+32,sprite.width-16,sprite.height-32);
	}
	
	public void render(Screen screen)
	{
		screen.renderTile(x, y, sprite);
	}
	
	public void clear()
	{
		for(int i=0;i<level.giant.size();i++)
		{
			Giant f=level.giant.get(i);
			if(f.isRemoved())level.giant.remove(i);
	
		}	
	}
}
