import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable 
{
	public static  long time,timer;
	public static boolean gameover,start=true,escape=false;
	public static  double sec,min;
	public static final long time_last=3000;
	public static int width=500,z=0;
	public static int height=width/16*9;
	public static int scale =3;     								// SCALES THE IMAGE THREE TIMES ITS INITIAL 
	public static String title ="Game";
	private static Thread thread;
	protected static JFrame frame;
	private Keyboard key;
	private static Keyboard Key;
	public M k;
	public Menustate r;
	public Options o;
	public int levelno;
	public static int menu=0;
	public Entity Entity;
	protected int coins_score;
	protected static int run;
	
	Mouse mouse;
	
	public  level level;
	protected Score score;
	protected int flag=0;
	private Player player;
	public Projectile pj;
	protected static boolean  running =false;
	
	public boolean m=true;
	Rectangle[]  r1 = new Rectangle[20];
	
	private Screen screen;
	int x=0,y=0;
	Graphics g2;
	private BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	private int[] pixels=((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	//Converting image object into array of INTEGER 
	// RASTER RECTANGULAR ARRAY OF PIXELS WHICH IS WRITEABLE															 
	//  A Raster encapsulates a DataBuffer that stores the sample values and a SampleModel that describes how to locate a given sample value in a DataBuffer.
	// Constructor called only once
	
	public Game(int x)
	{
		
	}
	
	public Game()
	{	
		Dimension size=new Dimension(width*scale,height*scale);
		setPreferredSize(size);
		frame=new JFrame();
		screen = new Screen(width,height);
		key=new Keyboard();
		addKeyListener(key);
		
		score=new Score();
		level=level.spawn;
		
		k=new M(key);
		r=new Menustate(key);
		o=new Options(key);
		
		player=new Player(30,200,key,screen);
		player.init(level);
		
		r.minit(frame);
		o.minit(frame);
		
		mouse=new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
			
	}
	
	public static int getWindowWidth()
	{
		return width*scale;
	}
	
	public static int getWindowHeight()
	{
		return height*scale;
	}
	
	public synchronized void start() 
	{
		running =true;
		thread=new Thread(this,"Display");
		thread.start();
		sound();
	}
	public  void sound()
	{
		try
		{
	         
			// Open an audio input stream.
			 URL url = this.getClass().getClassLoader().getResource("m2.wav");
	         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	         // Get a sound clip resource.
	         Clip clip = AudioSystem.getClip();
	         //ContinuousAudioDataStream loop = null;
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         clip.start();
	         //clip.loop(4);
	         	//while()
	         	//clip.start();
		       //if(running)
	         //	clip.loop(1);
	         //	clip.l;
				
			} catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
		//Clip.LOOP_CONTINUOUSLY;
	}
	public  synchronized static void stop()
	{
		running =false;
		try
		{
			menu=4;
			thread.join();
	    } catch(InterruptedException e)
		
		{
	    	e.printStackTrace();
		}
	}
	
	public void run()
	{ 	
		run++;
		long lastTime=System.nanoTime();
		timer=System.currentTimeMillis();
		time=System.currentTimeMillis()/1000;
		final double ns=1000000000.0/90.0; //running 60 times a second
		double delta=0;//
		int frames=0;
		int updates=0;
		requestFocus();	
			
		while(running)
		{	
			long now=System.nanoTime();
			
			delta+=(now-lastTime)/ns;
			lastTime=now;
			while(delta>=1)
			{
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis()-timer>1000)
			{
				timer+=1000;
				//System.out.println(updates+"ups,"+frames+"fps");
				frame.setTitle(title+"|"+frames +"fps"+"|updates"+updates);
				updates=0;
				frames=0;
			}
		}
	}

	public void update()
	{
		if(menu==0)	
		{
			k.update();
		}
		
		if(menu==2)
			sec+=1.5;
		if(sec/100==60)
		{
			sec=0.0;
			min+=1;
			if(min==5)
			{
				level.gameover=true;
			}
				
		}
		
		if(sec/100>10)
			{
	
			}
	
		if(time==time_last)
		{
			running =false;
		}
		
		key.update();
		
		if(key.esc&&!start)
			menu=3;
		
		if(menu==2)
		{		
			player.update(); 
			level.update(key);
		}
		
		if(menu==3)
		{
			r.update();
		}
		
 		if(menu==1)// start options exit
			r.update();
		
		if(menu==5)	//options
			o.update();
	
	}
	
	public void render()
	{
		BufferStrategy bs = getBufferStrategy(); 
		if(bs==null)
		{                                     			  /*SAME AS DOUBLE BUFFERING CREATES AN OFFSCREEN IMAGEH
																SO AS TO HAVE THE NEXT SCREEN PRINTED ONTO DIRECTELY 
																RATHER THAN HAVING IT APPEAR PIXEL BY PIXEL
			 												  */
			createBufferStrategy(3);                        // TWO OFF SCREENS BEHIND THE CURRENT
			return;
		}
		Graphics g=bs.getDrawGraphics();	
		screen.clear();
		
		if(menu==0)
		{
			k.render(screen);
		}
		
		if(menu==5)
		{
			o.render(screen);
		}
		
		if(menu==2)
		{
			int xScroll=player.x-screen.width/4;
			int yScroll=player.y-screen.height/2;
			level.render(xScroll,yScroll,screen);
			player.render(screen);
		}
		
		
		if(menu==2)
			System.arraycopy(screen.r1,0, r1, 0, r1.length);
		
		System.arraycopy(screen.pixels,0, pixels, 0, pixels.length);
			 //Creating a link b/w Graphics and bufferstrategy
			// All Graphics to be displayed on screen
		{
			g.setColor(Color.CYAN);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.drawImage(image,0,0,getWidth(),getHeight(),null);                  //???????????????????????????????????
			score.draw_score(g,key);
			player.draw(g);
			if(menu==0)
				k.drawscreen(g);
			if(menu==5)
			{
			o.drawscreen(g);	
			}
		
			if(menu==1||menu==3)
				r.drawscreen(g); 
			
			g.setColor(Color.GREEN);	
		}
			
		g.dispose(); // Releases all system resources/graphics
		bs.show();
		
	}
	//Entry point of program
	public static void main(String args[])
	{
		Game game=new Game();
		game.frame.setResizable(true);
		game.frame.setFocusable(true);
		game.frame.setTitle(game.title);
		game.frame.add(game);
		game.frame.pack();// sets the size of frame as the component
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.start();
	}
}
 