import java.awt.Rectangle;

public class Door extends Entity
{
	protected int x,y;
	protected Sprite sprite;
	int start_pos,final_down,final_up;
	boolean up=false,down=true;

	public Door(int x,int y)
	{
		this.x=x-16;
		this.y=y-16;
		start_pos=y;
		
		final_down=start_pos+(16*1);
		final_up=start_pos-(16*4);
		sprite=Sprite.door1;
	}
	
	public void update()
	{
		if(level.key_found)sprite=Sprite.door2;
	}
	
	public void render(Screen screen)
	{
		if(level.key_found)
			screen.renderDoor(x-32, y,sprite.getWidth(),sprite.getHeight(),sprite);
		else
			screen.renderTile(x, y, sprite);
	}
	
	public Rectangle draw_door()
	{	
		return new Rectangle(x+20,y+16,16,16);
	}

	protected int block_y()
	{
		return y;
	}
}
