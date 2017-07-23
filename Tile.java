
/*TILES NEED SPRITES FOR EASY DIAGNOSIIS AND GAME CRASHING */

public class Tile
{
	public int x,y;
	public Sprite sprite;                  // ASSOCIATING SPRITE WITH TILES 
	public int tilenumber=-1;
	public static Tile grass=new GrassTile(Sprite.grass);                        // STATIC SINCE TILES DO NOT CHANGE 
	public static Tile voidTile=new VoidTile(Sprite.voidSprite);
	public static Tile stone1=new STile(Sprite.stone1);
	public static Tile pillar=new pillar(Sprite.pillar);
	public static Tile coin=new coin(Sprite.coin);	
	
	public Tile(Sprite sprite)
	{                        // CREATING A CONSTRUCTOR IS NECESSARY WHICH IS NOT DEFAULT
		this.sprite=sprite;							/* CREATING AN OBJECT OR CONSTRUCTOR  OF TILE OR ANYOTHER CLASS WHICH EXTENDS TILES SAY GRASS/VOID TILE WHEN
	 											SAY	new GrassTile(SPRITE NEEDED) OR WONT WORK*/
	}

	public void render(int x,int y,Screen screen)
	{
		
	}

	public boolean solid()
	{
		return false;                    // GIVES ERROR IF NOT RETURNED ANYTHING 
									// IS FALSE SO WONT COLLIDE JUST PASS THROUGH AND IS TO BE OVERWRITTEN WHEN CERTAIN TILES WHICH ARE SOLID 
	}
}
