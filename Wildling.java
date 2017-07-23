import java.awt.Rectangle;

public class Wildling extends Entity
{

	protected int wx,wy;
	protected Sprite sprite;
	int start_pos,final_right,final_left;
	boolean left=false,right=true;
	int count=0,c=5;
	
	public Wildling(int x,int y)
	{
		wx=x;
		wy=y;
		start_pos=x;
		final_right=start_pos+(16*1);
		final_left=start_pos-(16*4);
		sprite=Sprite.jump;
	}
	
	public void update()
	{
		
		if(wx<final_right&&!left)
		{
			right=true;
		}
		
		if(right)
		{
			if(wx<final_right)
			{
				wx++;
				if(c>750)
					c=0;
				else
					c++;
				if(c%20==0)
				{
					if(count>750)
						count=0;
					else
						count++;
				
					if(count%2==0)
						sprite=Sprite.jump1;
					else
						sprite=Sprite.jump;
				}
			}
		}
		
		if(left)
		{
			if(wx>final_left)
			wx--;
			if(c>750)
				c=0;
			else
				c++;
			if(c%20==0)
			{
				if(count>750)
					count=0;
				else
					count++;
			
				if(count%2==0)
					sprite=Sprite.jump2;
				else
					sprite=Sprite.jump3;
			}
		}
		
		if(wx==final_right)
		{
			left=true;
			right=false;
			
		}
		
		if(wx==final_left)
		{
			left=false;
			right=true;
		}
		
		
		clear();
	}
	public void render(Screen screen)
	{
		screen.renderTile(wx, wy, sprite);
	}
	public Rectangle draw_top()
	{
		return new Rectangle(wx,wy,16,16);
	}
	public Rectangle draw_rest()
	{
		return new Rectangle(wx,wy,16,16);
	}
	public void clear()
	{
		for(int i=0;i<level.wildling.size();i++)
		{
			Wildling f=level.wildling.get(i);
			if(f.isRemoved())level.wildling.remove(i);
		}
	}
	
	


}
