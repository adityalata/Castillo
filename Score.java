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

public class Score 
{
	public Keyboard key;	
	public long change=10;
	Font k = new Font("Ynnovatta", Font.BOLD, 20);
	Font h=new Font("ArcadeClassic", Font.BOLD,200);
	Font h1=new Font("ArcadeClassic", Font.BOLD,60);
	
	protected void draw_score(Graphics g,Keyboard key) 
	{	
		this.key=key;
		if(key.enter)
		{
			if(level.end||level.gameover)	
			{
				Game.running=false;
				System.exit(0);
			}
		}
		
		if(level.player_chain)
		{
		
			Font h = new Font("Ynnovatta", Font.PLAIN, 30);
			g.setFont(h);
			g.setColor(Color.orange);
			g.drawString("PRESS Z TO ACTIVATE THE CHAIN W TO THROW THE BALL ", 0, 60);
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(level.check_collision)
		{
			
			Font h = new Font("Zeroes Three", Font.PLAIN, 30);
			g.setFont(h);
			g.setColor(Color.green);
			g.drawString("CHECKPOINT REACHED YOU WILL RESPAWN TO THIS LOCATION ", 0, 60);
			
		}
		
		if(Game.menu==2)
		{
			try
			{
			//	BufferedImage image=ImageIO.read(Score.class.getResource("/score_coin1.png"));
				BufferedImage life=ImageIO.read(Score.class.getResource("/h1.png"));
				for(int i=0;i<level.life;i++)
				g.drawImage(life, 670+(i*19),13,20, 20, Color.CYAN, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("image error");
			}
	
			g.setColor(Color.blue);
			Font h = new Font("Zeroes Three", Font.PLAIN, 18);
			g.setFont(h);
			g.drawString("SCORE   "+level.score, 800, 30);
			g.drawString("HEALTH", 600, 30);
			g.setColor(Color.red);
			g.drawRect(480, 15, 60, 20);
			g.drawString((int)Game.min+":"+(int)Game.sec/100,498,32);
			
		}
	
		if(level.gameover||level.enmydead)
		{	
			
			try 
			{	
				//BufferedImage image=ImageIO.read(Score.class.getResource("/gameover.png"));
				BufferedImage image=ImageIO.read(Score.class.getResource("/game.png"));
				g.drawImage(image,0,0,Game.getWindowWidth(), Game.getWindowHeight(), Color.CYAN, null);	
			} catch (IOException e) 
			
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			Font k = new Font("Ynnovatta", Font.BOLD, 20);
			Font h=new Font("ArcadeClassic", Font.BOLD,200);
			Font h1=new Font("ArcadeClassic", Font.BOLD,60);
			g.setFont(h);
			
			g.setColor(Color.WHITE);
			if(level.gameover)
				if(change<=0)change=10;
				else change-=1;
			if(change==2||change==3||change==4||change==5||change==6)
			{
				g.drawString("GAME OVER",200, 300);
				g.setFont(h1);
				g.drawString(" PRESS ENTER", 480, 650);
				g.setFont(k);
				g.drawString("   SCORE  "+level.score, 580, 440);
			}
		
			if(level.enmydead)
			{
			
			}
		}
		
		if(level.end_game)
		{	
			Font h=new Font("ArcadeClassic", Font.BOLD, 60);
			g.setFont(h);
			g.setColor(Color.white);
			if(change<=0)change=10;
			else change-=1;
			if(change==2||change==3||change==4||change==5)
				g.drawString("PRESS ENTER", 530, 300);
		}
		
		if(level.end)// WIN CONDTION
		{
	
			try 
			{
				
				BufferedImage image=ImageIO.read(Score.class.getResource("/game.png"));
				g.drawImage(image,0,0,Game.getWindowWidth(), Game.getWindowHeight(), Color.CYAN, null);
				
			} catch (IOException e) 
			
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			g.setFont(h);
			g.setColor(Color.white);
			if(change<=0)change=10;
			else change-=1;
			if(change==2||change==3||change==4||change==5||change==6)
			{
				g.drawString("!!YOU WIN!!",150, 300);
				g.setFont(h1);
				g.drawString(" PRESS ENTER", 480, 650);
				g.setFont(k);
				g.drawString("   SCORE  "+level.score, 580, 440);
			}
		}
	}
}
