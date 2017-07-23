
public class StoneTile extends Tile
{
	public int tilenumber=4;
	
	public StoneTile(Sprite sprite) 
	{
		super(sprite);
		// TODO Auto-generated constructor stub
	}

	public void render(int x,int y,Screen screen)
	{
		 screen.renderTile(x<<4, y<<4, this);
		 
	}

}
