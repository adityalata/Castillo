
public class STile extends Tile
{
	public int tilenumber=3;
	public STile(Sprite sprite)
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
