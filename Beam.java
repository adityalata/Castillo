
public class Beam 
{
	protected int x,y;
	protected Sprite sprite;

	public Beam(int x,int y)
	{
		this.x=x;
		this.y=y;
		sprite=Sprite.pillar;
		// TODO Auto-generated constructor stub
	}
	
	public void render(Screen screen)
	{
		screen.renderTile(x, y, sprite);
	}

}
