
public class VoidTile extends Tile
{
	public static int tilenumber=10; 
	public VoidTile(Sprite sprite)
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
		return false;                    // GIVES ERROR IF NOT RETURNED ANYTHING 
										// IS FALSE SO WONT COLLIDE JUST PASS THROUGH AND IS TO BE OVERWRITTEN WHEN CERTAIN TILES WHICH ARE SOLID 
	}
}
