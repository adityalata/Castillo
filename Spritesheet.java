import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet
{
	private String path;
	public final int SIZE,width,height;
	public int[]pixels;

	public static Spritesheet hearts1=new Spritesheet("/cap.png",16);
	public static Spritesheet hearts2=new Spritesheet("/cap2.png",16);
	public static Spritesheet tiles=new Spritesheet("/2.png",16);
	public static Spritesheet Dirt=new Spritesheet("/back.png",16);
	public static Spritesheet player_bullet=new Spritesheet("/player_bullet.png",8);
	
	public static Spritesheet walker_right1=new Spritesheet("/q1.png",16);
	public static Spritesheet walker_right2=new Spritesheet("/q2.png",16);
	public static Spritesheet walker_left1=new Spritesheet("/q3.png",16);
	public static Spritesheet walker_left2=new Spritesheet("/q4.png",16);
	
	public static Spritesheet player_right1=new Spritesheet("/01PLAYER.png",16);
	public static Spritesheet player_right2=new Spritesheet("/PLAYER.png",16);
	public static Spritesheet player_left1=new Spritesheet("/PLAYER_LEFT1.png",16);
	public static Spritesheet player_left2=new Spritesheet("/PLAYER_LEFT2.png",16);
	public static Spritesheet coin1=new Spritesheet("/coin.png",16);
	public static Spritesheet coin2=new Spritesheet("/coin1.png",16);

	public static Spritesheet stone1=new Spritesheet("/check.png",30);
	
	public static Spritesheet pillar=new Spritesheet("/kp4.png",48);
	public static Spritesheet c1=new Spritesheet("/coin.png",16);
	public static Spritesheet c2=new Spritesheet("/coin1.png",16);
	 
	public static Spritesheet bullet1=new Spritesheet("/bullet1.png",16);
	public static Spritesheet bullet2=new Spritesheet("/bullet.png",16);
	
	public static Spritesheet jump=new Spritesheet("/jump1.png",16);
	public static Spritesheet jump1=new Spritesheet("/jump2.png",16);
	public static Spritesheet jump2=new Spritesheet("/jump3.png",16);
	public static Spritesheet jump3=new Spritesheet("/jump4.png",16);
	
	public static Spritesheet key=new Spritesheet("/key.png",16);
	
	public static Spritesheet door1=new Spritesheet("/door01.png",32);
	public static Spritesheet door2=new Spritesheet("/door02.png",64,32);
	
	public static Spritesheet chain=new Spritesheet("/chain.png",4);
	public static Spritesheet ball=new Spritesheet("/ball.png",16);
	public static Spritesheet ghost1=new Spritesheet("/ghost.png",48);
	public static Spritesheet ghost2=new Spritesheet("/ghost1.png",48);
	public static Spritesheet checkpoint=new Spritesheet("/checkpoint.png",16);
	///////////********************                    FIRE SPRITE
	public static Spritesheet fire1=new Spritesheet("/f1.png",20);
	public static Spritesheet fire2=new Spritesheet("/f2.png",20);
	public static Spritesheet fire3=new Spritesheet("/f3.png",20);
	public static Spritesheet fire4=new Spritesheet("/f4.png",20);
	public static Spritesheet fire5=new Spritesheet("/f5.png",20);
	public static Spritesheet fire6=new Spritesheet("/f6.png",20);
	public static Spritesheet fire7=new Spritesheet("/f7.png",20);
	
	public Spritesheet(String path,int size)
	{
		this.path=path;
		SIZE=size;
		width=size;
		height=size;
		pixels=new int[SIZE*SIZE];
		load();
	}

	public Spritesheet(String path,int width,int height)
	{
		this.path=path;
		this.width=width;
		this.height=height;
		SIZE=width;
		pixels=new int[width*height];
		load();
	}
	
	private void load()
	{
		try 
		{
			BufferedImage image=ImageIO.read(Spritesheet.class.getResource(path));
			int w=image.getWidth();
			int h=image.getHeight();
			image.getRGB(0, 0,w,h,pixels,0,w);//Scans image horizontlly
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
