import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Options
{
	private Keyboard key;
	private JFrame frame;
	int x=10;
	
	Options(Keyboard key)
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
			BufferedImage bullet=ImageIO.read(Score.class.getResource("/q10.png"));
			
			BufferedImage jump=ImageIO.read(Score.class.getResource("/jump10.png"));
			BufferedImage ghost=ImageIO.read(Score.class.getResource("/ghost.png"));
			g.drawImage(bullet, x,360,50, 50, Color.CYAN, null);
			g.drawImage(jump, x+70,360,50, 50, Color.CYAN, null);
			g.drawImage(ghost, x+140,360,50, 50, Color.CYAN, null);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("image error");
		}
		g.setColor(Color.green);
		Font h = new Font("Zeroes Three", Font.PLAIN, 16);
		g.setFont(h);
		g.drawString("Instructions :", x, 200);
		g.drawString("1.Use arrow keys to navigate player through the map.",x,230);
		g.drawString("2.Use up arrow key to jump over obstacles.", x, 250);
		g.drawString("3.Player's remaining health,score and time is displayed at the top.", x, 270);
		g.drawString("4.Avoid fire and enemies.A collision would result in a loss of unit remaining life.", x, 290);
		g.drawString("5.A flag represents a checkpoint.Ensure that you touch these flags so that you respawn at the last checkpoint occured if lives remain.",x, 310);
		g.drawString("6.on touching a healthbox,one life will be increased in case a player has lost live/s previously", x, 330);
		g.drawString("7.3 types of enemies will be encountered during gameplay :", x, 350);
		g.drawString("  IST       LAB      ESE  ", x, 430);
		
		g.drawString("	a)IST.This enemy can be killed by shooting bullets using spacebar.",x, 470);
		g.drawString("	b)LAB.This enemy can be killed by jumping over it.",x, 490+20);
		g.drawString("	c)ESE.This tough enemy can only be killed using the special weapons indicated by triggers on map.Follow instructions carefully to kill and win.",x, 510+20);
		g.drawString("8.The level ends by unlocking the final door which unlocks only after the player collects the Mystery Key.",x, 530+20);
		g.drawString("9.The Mystery Key can be found oscillating and can be collected by hitting it with a bullet exactly.",x, 550+20);
		g.drawString("sirf padhta rhega ya khelega bhi yede.ache se khel bhut mehnat se banaya hai.lag hota hai toh tera device problem hai.chal ab atb.",x, 570+20);
	}
	
	public void update()
	{
		
	}
	
	public void render(Screen screen)
	{
	
	}

}
