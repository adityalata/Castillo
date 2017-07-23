import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Menustate
{

	private JFrame frame;
	private JButton button;
	public Keyboard key;
	private Game game;
	private int x;
	private Mouse mouse;
	
	private int s=Game.getWindowWidth();
	private int t=Game.getWindowHeight();
	
	Menustate(Keyboard key)
	{
		this.key=key;
	}
	
	public void minit(JFrame frame)
	{
		this.frame=frame;
	}
	
	public void drawscreen(Graphics g)
	{
		try
		{
			
			BufferedImage image=ImageIO.read(Spritesheet.class.getResource("/bg1.png"));
			g.drawImage(image,0,0,Game.getWindowWidth(), Game.getWindowHeight(), Color.gray, null);    //Color.gray??????????????????
			
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Game.menu==1||Game.menu==3)
		{

			Font h = new Font("Zeroes Three", Font.PLAIN, 18);
			g.setFont(h);
			g.setColor(Color.WHITE);
			g.drawRect(s/2-s/10, t/5, 150, 50);
			g.drawString("PLAY", s/2-s/10+53, t/5+30);
			g.drawRect(s/2-s/10, t/3+t/50, 150, 50);
			g.drawString("OPTIONS", s/2-s/10+48-5, t/3+t/50+30);	
			
			g.drawRect(s/2-s/10, t/2, 150, 50);
			g.drawString(" EXIT", s/2-s/10+53, t/2+30);
		}
	}
	
	public void update()
	{
		if(mouse.getX()>s/2-s/10 && mouse.getY()> t/5 && mouse.getX()<s/2-s/10+150 && mouse.getY()< t/5+50)
		{
			int b= mouse.getButton();
			if(b==1)
				
				
					Game.menu=2;
				
		}
		
		if(mouse.getX()>s/2-s/10 && mouse.getY()> t/3+t/50 && mouse.getX()<s/2-s/10+150 && mouse.getY()< t/3+t/50+50)
		{
			int b= mouse.getButton();
			if(b==1)
				Game.menu=5;
		}
		
		if(mouse.getX()>s/2-s/10 && mouse.getY()> t/2 && mouse.getX()<s/2-s/10+150 && mouse.getY()< t/2+50)
		{
			int b= mouse.getButton();
			if(b==1)
			{
				System.exit(0);
			}
		}
	}
	
	public void render(Screen screen,Graphics g)
	{
		if(Game.menu==5)
		{
		
		}
	}

}
