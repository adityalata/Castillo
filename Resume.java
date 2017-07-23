import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Resume
{
	private Keyboard key;
	private JFrame frame,frame1;
	
	Resume(Keyboard key)
	{
		this.key=key;
		frame1.setSize(200, 200);
	}
	
	public void minit(JFrame frame)
	{
		this.frame=frame;
	}
	
	public void drawscreen(Graphics g)
	{
		if(Game.menu==3)
		{
			try
			{
				BufferedImage image=ImageIO.read(Spritesheet.class.getResource("/bg1.png"));
				g.drawImage(image,0,0,Game.getWindowWidth(), Game.getWindowHeight(), Color.gray, null);    //Color.gray??????????????????
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
	public void update()
	{	
		frame1.setVisible(true);
	}
	
	public void render(Screen screen)
	{
	
	}

}
