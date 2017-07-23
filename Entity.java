import java.util.Random;

public abstract class Entity
{
	public int x,y;
	protected boolean removed=false;
	protected  static level level;
	protected final Random random=new Random();
	
	public void update()
	{
		
	}
	
	public void render(Screen screen)
	{
		
	}
	
	public void remove()
	{
		removed=true;
	}
	
	public boolean isRemoved()
	{
		return removed;
	}
	
	public void init(level level)
	{
		this.level=level;
	}

}
