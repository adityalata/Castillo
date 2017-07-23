import java.awt.Rectangle;

public class Block extends Entity
{
	protected int x,y;
	protected Sprite sprite;
	int start_pos,final_down,final_up;
	boolean up=false,down=true;

	public Block(int x,int y)
	{
		this.x=x-16;
		this.y=y-16;
		start_pos=y;
		
		final_down=start_pos+(16*1);
		final_up=start_pos-(16*4);
		sprite=Sprite.pillar;
		System.out.println(start_pos);
		System.out.println(final_up);
		System.out.println(final_down);
	}
	
	public void update()
	{
		
	}
	
	public void render(Screen screen)
	{
			screen.renderTile(x, y, sprite);
	}
	
	public Rectangle draw_block()
	{	
		return new Rectangle(x+20,y+16,16,16);
	}
	
	protected int block_y()
	{
		return y;
	}

}
