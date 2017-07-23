
public class GrassTile extends Tile
{
	public int tilenumber=8;
	public GrassTile(Sprite sprite)
	{
		super(sprite);
		// TODO Auto-generated constructor stub
	}

	public void render(int x,int y,Screen screen)
	{
		screen.renderTile(x<<4, y<<4, this);
	}
 
	public boolean solid()
	{
	 return true;
	}
 
}
