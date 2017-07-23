import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class M 
{
	public Sprite sprite=Sprite.pillar;
	public Keyboard key;
	private JButton button;
	int change=10;
	
	M(Keyboard key)
	{
		this.key=key;
	}
	public void update()
	{
		if(key.enter)
		{
		Game.menu=1;
		Game.start=false;
		}
	}
	public void render(Screen screen)
	{
		screen.clear();
	}
	
	public void drawscreen(Graphics g)
	{
		if(Game.menu==0)
		{
			try
			{
				//BufferedImage image=ImageIO.read(Spritesheet.class.getResource("/bc.png"));
				BufferedImage image=ImageIO.read(Spritesheet.class.getResource("/start.png"));
				g.drawImage(image,0,0,Game.getWindowWidth(), Game.getWindowHeight(), Color.gray, null);    //Color.gray??????????????????
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("image error");
			}
			g.setColor(Color.white);
			Font h=new Font("ArcadeClassic", Font.BOLD, 60);
			g.setFont(h);
			if(change<=0)change=10;
			else change-=1;
			if(change==2||change==3||change==4||change==5)
				
			g.drawString("PRESS ENTER", 480, 650);
				
		}
	}
}
