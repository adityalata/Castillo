import java.awt.Rectangle;

public class walker extends Enemy
{
	public int path,start,rate,rate1,fire_dir,top,bot; 
	public boolean go_right,go_left;
	protected int bullet_fire=20;
	int start_pos,final_right,final_left;
	boolean left=false,right=true;
	int count=0,c=5;
	

	public walker(int x, int y) 
	{
		super(x, y);
		sprite=Sprite.player_right1;
		path=x+(16*4);
		top=y+1;
		bot=y-1;
		System.out.println(y+"|"+top+"|"+bot);
		//start=x;
		start_pos=x;
		final_right=start_pos+(16*1);
		final_left=start_pos-(16*4);
	}
	 
	public void  update()
	{		
		if(ex<final_right&&!left)
		{
			right=true;
		}
		
		if(right)
		{
			if(ex<final_right)
			{
				ex++;
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
						sprite=Sprite.walker_right1;
					else
						sprite=Sprite.walker_right2;
				}
			}
		}
		
		if(left)
		{
			if(ex>final_left)
			ex--;
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
					sprite=Sprite.walker_left1;
				else
					sprite=Sprite.walker_left2;
			}
		}
		
		if(ex==final_right)
		{
			left=true;
			right=false;
			
		}
		
		if(ex==final_left)
		{
			left=false;
			right=true;
		}
		
		int distance=ex-level.player_x;
		
		if(Math.abs(distance)<100&&level.player_y<top&&level.player_y>bot)
		{	
			if(bullet_fire>0)bullet_fire--;
			
			if(distance<0)
				fire_dir=1;
			if(distance>0)
				fire_dir=-1;
			if(bullet_fire<2)
			{
			Bullet b=new shootbullet(ex,ey,fire_dir);
			level.addbullet(b);
			bullet_fire=20;
			}
		}
		
		Rectangle w,b;
		w=draw_walker();
		for(int i=0;i<level.projectiles.size();i++)
		{
			Projectile p= level.projectiles.get(i);
			b=p.draw_bullet();
			if(w.intersects(b))
			{		
				System.out.println("enemy dead*************************");
				remove();
			}
		}
		clear();
	}
	public void render(Screen screen)
	{
		screen.renderTile(ex, ey, sprite);
	}
	public Rectangle draw_walker()
	{
		return new Rectangle(ex,ey,16,16);
	}
	public void clear()
	{
		for(int i=0;i<level.walker.size();i++)
		{
			Enemy p=level.walker.get(i);
			if(p.isRemoved())level.walker.remove(i);
		}
	}
		
}
