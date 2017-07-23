import java.awt.Rectangle;

public class WizardProjectile extends Projectile
{	
	public static final int fire_rate=10 ;
	int d;
	public WizardProjectile(int x, int y, int dir)
	{
	
		super(x, y, dir);
		range=100;
		damage=20;
		speed=4;
		angle=dir;
		
		sprite=Sprite.player_bullet;
		nx=speed*Math.cos(angle);
		ny=speed*Math.sin(angle);
			
	}
	
	public void  update()
	{ 	
		
		if(level==null)System.out.println("rstrfymry");
		
		if(level.getcollision(2,0,x, y))
		{ 
			//Particle p=new Particle((int)x,(int)y,50,500);
			Particle p=new Particle((int)x,(int)y,50,10);
			level.add(p);
			System.out.println("particle chahiye");
			remove();
		};
		
		if(angle==1)
			move_right();
		else 
			move_left();
		d=distance();
		if(d>100)remove();
		
	}
	protected boolean Pcollision(int xa, int ya)
	{
		boolean solid=false;
		for(int c=0;c<4;c++)
		{
			int xt= ((x+xa)+c%2*4)/16;
			int yt= ((y+ya)+c/2*4)/16;
			if(level.getTile(xt,yt).solid())
				solid=true;
		}
	
		return solid;
	}

	protected void move_right()
    {	
	  	x+=2;
    }
    
	protected void move_left()
	{
	   	x-=2;
	}
	
	protected int distance() 
	{
		int dist=0;
		dist=x-xOrigin;
		return dist;
	}

	public void render(Screen screen)
	{
	   	screen.renderTile(x,y,sprite);
	}
	
	public  Rectangle draw_bullet()
	{
		return new Rectangle (x,y,8,8);
	}
}
