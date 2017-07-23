import java.awt.Rectangle;

public class Ball extends Entity
{
protected int x, y;
protected Sprite sprite;
	public Ball(int x,int y) 
	{
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		sprite=Sprite.ball;
	}
	public void update()
	{
		
		y+=5;
		Rectangle ball,giant;
		gaint();
		ball=draw_ball();
		
		for(int i=0;i<level.giant.size();i++)
		{
			giant=level.giant.get(i).draw_giant();
			if(ball==null||giant==null)
			{
				
			}
			if(ball.intersects(giant))
			{
				level.giant.get(i).remove();
				remove();
			}
		}
		
		if(level.getcollision(0, 3, x, y)) remove();
			clear();
	}
	
	public void gaint()
	{
		for(int i=0;i<level.giant.size();i++)
		{
			level.giants[i]=level.giant.get(i).draw_giant();
		}
	}
	
	public void render(Screen screen)
	{
		screen .renderTile(x, y, sprite);
	}
	
	public Rectangle draw_ball()
	{
		return new Rectangle(x+7,y+15,6,1);
	}
	
	public void clear()
	{
		for(int i=0;i<level.ball.size();i++)
		{
			Ball f=level.ball.get(i);
			if(f.isRemoved())level.ball.remove(i);
		}
	}
}
