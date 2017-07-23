import java.awt.Rectangle;

public abstract class Projectile  extends Entity
{
  protected final int xOrigin,yOrigin;
  protected int angle;
  protected Sprite sprite;
 
  protected double speed,nx,ny,range,damage;
  
	public Projectile(int x, int y, int dir)
	{
	 xOrigin=x;
	 yOrigin=y;
	 angle=dir;
	 System.out.println(angle);
	 this.x=x;
	 this.y=y;
	}
	
	protected void move()
	{
		
	}
	
	public  Rectangle draw_bullet()
	{
		return null;
	}
}
