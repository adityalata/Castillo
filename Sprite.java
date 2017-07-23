
public class Sprite
{
	public  final int SIZE;
	public int x,y;
	public int[] pixels;
	public Spritesheet sheet;
	public int code;
	public int width,height;
	
	public static Sprite hearts1=new Sprite(16,Spritesheet.hearts1);
	public static Sprite hearts2=new Sprite(16,Spritesheet.hearts2);
	public static Sprite grass=new Sprite(16,Spritesheet.tiles);
	public static Sprite voidSprite =new Sprite(16,Spritesheet.Dirt);

	public static Sprite stone1 =new Sprite(30,Spritesheet.stone1);
	public static Sprite coin =new Sprite(16,Spritesheet.coin1);
	public static Sprite coin1 =new Sprite(16,Spritesheet.c1);
	public static Sprite coin2 =new Sprite(16,Spritesheet.c2);
	public static Sprite checkpoint =new Sprite(16,Spritesheet.checkpoint);
	public static Sprite player_bullet =new Sprite(8,Spritesheet.player_bullet);
	
	public static Sprite player_right1 = new Sprite(16,Spritesheet.player_right1);
	public static Sprite player_right2 = new Sprite(16,Spritesheet.player_right2);
	public static Sprite player_left1 = new Sprite(16,Spritesheet.player_left1);
	public static Sprite player_left2 = new Sprite(16,Spritesheet.player_left2);
	
	public static Sprite walker_right1 = new Sprite(16,Spritesheet.walker_right1);
	public static Sprite walker_right2 = new Sprite(16,Spritesheet.walker_right2);
	public static Sprite walker_left1 = new Sprite(16,Spritesheet.walker_left1);
	public static Sprite walker_left2 = new Sprite(16,Spritesheet.walker_left2);
	public static Sprite pillar =new Sprite(48,Spritesheet.pillar);
	
	public static Sprite bullet1 =new Sprite(16,Spritesheet.bullet1);
	public static Sprite bullet2 =new Sprite(16,Spritesheet.bullet2);
	
	public static Sprite jump =new Sprite(16,Spritesheet.jump);
	public static Sprite jump1 =new Sprite(16,Spritesheet.jump1);
	public static Sprite jump2 =new Sprite(16,Spritesheet.jump2);
	public static Sprite jump3 =new Sprite(16,Spritesheet.jump3);
	
	public static Sprite key =new Sprite(16,Spritesheet.key);
	
	public static Sprite door1 =new Sprite(32,Spritesheet.door1);
	public static Sprite door2 =new Sprite(64,32,Spritesheet.door2);
	
	public static Sprite chain =new Sprite(4,Spritesheet.chain);
	public static Sprite ball =new Sprite(16,Spritesheet.ball);
	public static Sprite ghost1 =new Sprite(48,Spritesheet.ghost1);
	public static Sprite ghost2 =new Sprite(48,Spritesheet.ghost2);
	public static Sprite particle_normal = new Sprite(3,0xAAAAAA);	
	
	///////************ FIRE SPRITE
	
	public static Sprite fire1 =new Sprite(20,Spritesheet.fire1);
	public static Sprite fire2 =new Sprite(20,Spritesheet.fire2);
	public static Sprite fire3 =new Sprite(20,Spritesheet.fire3);
	public static Sprite fire4 =new Sprite(20,Spritesheet.fire4);
	public static Sprite fire5 =new Sprite(20,Spritesheet.fire5);
	public static Sprite fire6 =new Sprite(20,Spritesheet.fire6);
	public static Sprite fire7 =new Sprite(20,Spritesheet.fire7);

	public Sprite(int size,Spritesheet sheet)
	{
		SIZE=size;
		width=size;
		height=size;
		pixels=new int [SIZE*SIZE];
		this.sheet=sheet;
		load();
	}
	
	public Sprite(int width,int height,Spritesheet sheet)
	{
		SIZE=width*height;
		this.width=width;
		this.height=height;
		pixels=new int [SIZE];
		this.sheet=sheet;
		load(width,height);
	}
	
	public Sprite(int size,int colour)
	{
		SIZE=size;
		this.width=size;
		//this.height=height;
		this.height=size;
		pixels=new int[SIZE*SIZE];
		setColour(colour);
	
	}
	
	private void setColour(int colour)
	{
		for(int i=0;i<SIZE*SIZE;++i)
		{
			pixels[i]=colour;
		}
	}
	
	private void load()
	{
		for(int y=0;y<SIZE;y++)
		{
			for(int x=0;x<SIZE;x++)
			{
				pixels[x+y*SIZE]=sheet.pixels[(x)+(y)*sheet.SIZE];
			}
		}
	}

	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}

	private void load(int width,int height)
	{
		for(int y=0;y<height;y++)
		{
			for(int x=0;x<width;x++)
			{
				pixels[x+y*width]=sheet.pixels[(x)+(y)*sheet.width];
			}
		}
	}
}
