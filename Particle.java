import java.util.ArrayList;
import java.util.List;

public class Particle extends Entity
{
	protected double xx,yy, xa , ya;
	
	public Sprite sprite;
	private int life;
	public Particle(int x,int y,int life)
	{
		this.x=x;
		this.y=y;
		xx=x;
		yy=y;
		this.life=life;
		sprite = Sprite.particle_normal;
		this.xa=random.nextGaussian();
		this.ya=random.nextGaussian();
	}
	
	public Particle(int x,int y,int life,int amount)
	{
		this(x,y,life);
		for(int i =0;i<amount -1;i++)
		{
			level.add(new Particle(x,y,life));
		}
		level.add(this);
	}
	
	public void update()
	{
		xx+=xa;
		yy+=ya;	
	}
	public void render(Screen screen)
	{
		screen.renderSprite((int)xx, (int)yy, sprite, true);
	
	}
}
