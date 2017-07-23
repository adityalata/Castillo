import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Screen
{
	public  static int width,height;
	Graphics g;	
	public int[] pixels;
	public final int MAP_SIZE=64;
	public final int MAP_SIZE_MASK=MAP_SIZE-1;
	public int xoffset,yoffset;
	public int[] tiles=new int[64*64];

	private Random random=new Random();
	private Image bg;
	int time=0,counter=0;
	
	Rectangle[]  r1 = new Rectangle[20];
	
	public Screen(int width, int height)
	{
		this.width=width;
		this.height=height;
		pixels=new int[width*height];
		for(int i=0;i<64*64;i++)
		{
			tiles[i]=random.nextInt(0xffffff);
		}
		
	}
	
	public void clear()
	{
		for(int i=0;i<pixels.length;i++)
		{
			pixels[i]=0;
		}
	}
	
	public void renderSprite(int xp,int yp,Sprite sprite,boolean fixed)
	{
		if (fixed)
		{
			xp-=xoffset;
			yp-=yoffset;
		}
		System.out.println("++++++++++++++"+sprite.getHeight()+"++++"+sprite.getWidth());
		for(int y =0;y<sprite.getHeight();y++)
		{
			int ya=y+yp;
			for(int x=0;x<sprite.getWidth();x++)
			{
				int xa=x+xp;
				if(xa<0||xa>=width||ya<0||ya>=height)continue;
				pixels[xa+ya*width]=sprite.pixels[x+y*sprite.getWidth()];
			}
		}
		
	}
	public void render(int xoffset,int yoffset)
	{	
		for(int y=0;y<height;y++)
		{
			int yy=y+yoffset;
			if(yy<0||yy>=height) continue;
			
			for(int x=0;x<width;x++)
			{		
				int xx=x+xoffset;
				if(xx<0||xx>=width) continue;

				pixels[xx+yy*width]=Sprite.grass.pixels[(x&15)+(y&15)*Sprite.grass.SIZE];         
	
						/*
						 X+Y*WIDTH IS A SINGLE CO-ORDINNATE TRAVERSNG FROM A SINGLE ROW DOWN TO COLUMN IN TERMS OF THE 
						 PIXEL AS IN 51 SO IN TERMS OF X AND Y SAY (20,30)   THE PIXEL NUMBER IS WOULD BE 20 +30 * WIDTH
						 TO GET THE PIXEL NUMBER SAY 51 
						 */
			}
		}
	
	}

	public void renderTile(int xp,int yp,Sprite sprite)
	{
		xp-=xoffset;
		yp-=yoffset;
		for(int y=0;y<sprite.SIZE;y++)
		{
			int ya=y+yp;
			for(int x=0;x<sprite.SIZE;x++)
			{
				int xa=x+xp;
				// **map is infinte but render only those tiles which are visible
				// any tile exiting the screen stop rendering if not done will use not give out of bounds error but will use system resources
				if(xa<-sprite.SIZE||xa>=width||ya<0||ya>=height)break;
				
				if(xa<0)xa=0;
				//render tile on screen
				int c=sprite.pixels[x+y*sprite.SIZE];
				if(c!=-1)
				pixels[xa+ya*width]=c;
		//       which pixels on screen to be rendered= which pixels of sprite to be rendeed	
			}
		}
	}
	
	public void renderDoor(int xp,int yp,int s_width,int s_height,Sprite sprite)
	{
		xp-=xoffset;
		yp-=yoffset;
		for(int y=0;y<sprite.getHeight();y++)
		{
			int ya=y+yp;
			for(int x=0;x<sprite.getWidth();x++)
			{
				int xa=x+xp;
				// **map is infinte but render only those tiles which are visible
				// any tile exiting the screen stop rendering if not done will use not give out of bounds error but will use system resources
				if(xa<-sprite.SIZE||xa>=width||ya<0||ya>=height)break;
				
				if(xa<0)xa=0;
				//render tile on screen
				int c=sprite.pixels[x+y*s_width];
				if(c!=-1)
				pixels[xa+ya*width]=c;
		//       which pixels on screen to be rendered= which pixels of sprite to be rendeed	
			}
		}
	}
	
	public void renderTile(int xp,int yp,Tile tile)
	{
		xp-=xoffset;
		yp-=yoffset;
		for(int y=0;y<tile.sprite.SIZE;y++)
		{
			int ya=y+yp;
			for(int x=0;x<tile.sprite.SIZE;x++)
			{
				int xa=x+xp;
				//xa will be its position on the screen
				// xp gives the actual position of the tile on the map  
				
				if(xa<-tile.sprite.SIZE||xa>=width||ya<0||ya>=height)break;
			
				if(xa<0)xa=0;

				int col2 = tile.sprite.pixels[x+y*tile.sprite.SIZE];

				if(col2!=-16777216)
				{
					if(col2!=-1)
						pixels[xa+ya*width]=tile.sprite.pixels[x+y*tile.sprite.SIZE];
				}
			     // which pixels on screen to be rendered= which pixels of sprite to be rendeed	
			}
		}
	}

	public void renderPlayer(int xp,int yp,Sprite sprite)
	{
		xp-=xoffset;
		yp-=yoffset;
		for(int y=0;y<sprite.getHeight();y++)
		{
			int ya=y+yp;
			for(int x=0;x<sprite.getWidth();x++)
			{
				int xa=x+xp;
				
				if(xa<-16 || xa>=width || ya<0 || ya>=height)break;
				if(xa<0)xa=0;
				int col=sprite.pixels[x+y*sprite.getWidth()];		
				if(col!=-1)
					pixels[xa+ya*width]=col;	
			}
		}
	}

	public void paint(int x,int y)
	{
		r1[0]=new Rectangle(x,y,16,16);
	}

	public void setoffset(int xoffset,int yoffset)
	{
		this.xoffset=xoffset;
		this.yoffset=yoffset;
	}
}





