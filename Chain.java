
public class Chain extends Entity
{

	protected int x,y;
	protected Sprite sprite;
	int start_pos,final_right,final_left;
	boolean left=false,right=true;
	protected Keyboard key;
	public Chain(int x,int y)
	{
		this.x=x;
		this.y=y;
		start_pos=x;
		final_right=start_pos+(16*3);
		final_left=start_pos-(16*4);
		sprite=Sprite.chain;
	}
	
	public void update(Keyboard key)
	{
		if(level.start_chain)
		{
			if(x<final_right&&!left)
			{
				right=true;
			}
		
			if(right)
			{
				if(x<final_right)x+=2;
			}

			if(left)
			{
				if(x>final_left)
					x-=2;
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
			
			if(key.w&&level.ball.size()==0&&level.giant.size()>0)
			{
				Ball b=new Ball(x,y);
				level.addball(b);
			}
		}
	}
	
	public void render(Screen screen)
	{
		screen.renderTile(x, y, sprite);
	}


}
