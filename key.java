import java.awt.Rectangle;

public class key extends Entity
{
	protected int kx,ky;
	protected Sprite sprite;
	int start_pos,final_down,final_up;
	boolean up=false,down=true;
	
	public key(int x,int y) 
	{
		kx=x;
		ky=y;
		System.out.println("pos"+kx+"|"+ky);
		sprite=Sprite.key;
		start_pos=y;
		
		final_down=start_pos+(16*1);
		final_up=start_pos-(16*4);
	}

	public void update()
	{
		if(ky<final_down&&!up)
		{
			down=true;
		}
		
		if(down)
		{
			if(ky<final_down)ky++;
		}
		
		if(up)
		{
			if(ky>final_up)
			ky--;	
		}
		
		if(ky==final_down)
		{
			up=true;
			down=false;
		}
		
		if(ky==final_up)
		{
			up=false;
			down=true;
		}
		
		Rectangle k,b;
		k=draw_key();
		
		for(int i=0;i<level.projectiles.size();i++)
		{
			Projectile p= level.projectiles.get(i);
			b=p.draw_bullet();

			if(k.intersects(b))
			{		
				remove();
				level.key_found=true;
				level.projectiles.get(i).remove();		
			}
		}
		clear();
	}
	
	public void render(Screen screen)
	{
		screen.renderTile(kx, ky, sprite);
	}
	
	public void clear()
	{
		for(int i=0;i<level.key.size();i++)
		{
			key k=level.key.get(i);
			if(k.isRemoved())level.key.remove(i);
		}
	}
	
	public Rectangle draw_key()
	{
		return new Rectangle(kx,ky,16,16);
	}

}
