import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public abstract class Mob extends Entity
{
	protected Sprite sprite;
	int f=0;
	public Screen screen;
	protected int dir=0;
	protected boolean moving =false;
	protected boolean walking =false;
	
	private Game game;
	public void move(int xa,int ya)
	{
		if(xa!=0 && ya!=0)
		{
			
			move(xa,0);
			move(0,ya);
			return;
			
		}
		if(xa>0 )dir=1;
		if(xa<0 )dir=3;
		if(ya>0 )dir=2;
		if(ya<0 )dir=0;

		if(!collision(xa,ya))
		{
			x+=xa;
			y+=ya;
		}
	
	}
	public void update()
	{
		
		
	}
	
	protected void shoot(int x, int y,int pos)
	{
		Projectile p=new WizardProjectile(x,y,pos);
		level.addProjectile(p);
	}
	
	protected boolean collision(int xa, int ya)
	{
		
		boolean solid=false;
		
		for(int c=0;c<4;c++)
		{	
			int xt= ((x+xa)+c%2*12+3)/16;
			int yt= ((y+ya)+c/2*12+3)/16;
			
			if(level.getTile(xt,yt).solid())
				solid=true;
		}
		
		return solid;
	}
	
	public void render()
	{
		
	}

}
