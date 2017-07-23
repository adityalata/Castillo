
public class coin extends Tile
{
	public int tilenumber=100;
	
	public coin(Sprite sprite)
	{
		super(sprite);
		// TODO Auto-generated constructor stub
	}

	public void render(int x,int y,Screen screen)
	{
		screen.renderPlayer(x<<4, y<<4, this.sprite);
	}
	 
}

