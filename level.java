import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class level
{
	public int spawnptx,spawnpty;
	protected int flag =0;
	protected int width,height;
	protected int[] tilesint;
	protected int coinx,coiny,count;
	protected Keyboard input; 
	protected static int score,life=3; 
	protected static boolean gameover=false,enmydead=false,foot,end,key_found=false,end_game,start_chain=false,player_chain,giant_collision,check_collision,chain_update=false;  
	Rectangle[] coin= new Rectangle[50];
	Rectangle[] flame=new Rectangle[50];
	Rectangle[] blocks=new Rectangle[50];
	Rectangle[] doors=new Rectangle[50];
	Rectangle[] wildling_top=new Rectangle[20];
	Rectangle[] wildling_rest=new Rectangle[20];
	Rectangle[] cp=new Rectangle[20];
	Rectangle[] lifes=new Rectangle[20];
	Rectangle[] giants=new Rectangle[20];
	Rectangle[] chains=new Rectangle[20];
	
	
	protected static int player_x,player_y,checkpoint_x=2*16,checkpoint_y=16*16; 
	protected int[] tiles;
	protected static int bullet_rate=100,chain_no;
	
	// will contain all the level tiles(all the colour of each pixel 
	//,will contain the tiles of the current level
	//******
	// arrayList array of all the entites in level
	// using arraylist instead of normal array bc it to be dynamic
	// size of the array as many entities there are
	
	private List<Entity>entities=new ArrayList<Entity>();
	public List<Projectile> projectiles=new ArrayList<Projectile>();
	public List<Enemy> walker=new ArrayList<Enemy>();
	public List<points> coins=new ArrayList <points>();
	public List<fire> fire=new ArrayList <fire>();
	public List<Bullet>bullets=new ArrayList<Bullet>();
	public List<Block>block=new ArrayList<Block>();
	public List<key>key=new ArrayList<key>();
	public List<Door>door=new ArrayList<Door>();
	public List<Wildling>wildling=new ArrayList<Wildling>();
	public List<Beam>beam=new ArrayList<Beam>();
	public List<Giant>giant=new ArrayList<Giant>();
	public List<Chain>chain=new ArrayList<Chain>();
	public List<checkpoint>check=new ArrayList<checkpoint>();
	public List<Ball>ball=new ArrayList<Ball>();
	public List<life>hearts=new ArrayList<life>();
	public static level spawn=new SpawnLevel("finalMap.png");
	/////////////////////////////////////////////////////////////////////////////
	public List<Particle> particles = new ArrayList <Particle>();
	
	public level(String path)
	{
		loadlevel(path);
		generatelevel();

		loadcoin();
		loadchain();

		loadspawnpt();
		//CONTAINS THR PATH OF THE LEVEL
	}
	
	protected void loadchain()
	{
		chains[0]=new Rectangle(40*16,29*16,16,16);
		chains[1]=new Rectangle(59*16,41*16,16,16);		
	}

	protected void loadcoin()
	{
		for(int i=0;i<width;i++)
		{
			for(int j=0;j<height;j++)
			{
				if(tiles[i+j*width]==-6075996)
				{
					
					life b=new life(i*16,j*16);
					addlife(b);
					
				}
				if(tiles[i+j*width]==-14066)
				{
					Beam b=new Beam(i*16,j*16);
					addbeam(b);
				}
				if(tiles[i+j*width]==-16735512)
				{
					Chain b=new Chain(i*16,j*16);
					addchain(b);
				}
				if(tiles[i+j*width]==-4621737)
				{
					checkpoint b=new checkpoint(i*16,j*16);
					addcheck(b);
				}
				if(tiles[i+j*width]==-256)
					{
						points p=new collectpoints(i*16,j*16);
						addcoin(p);
					}
				if(tiles[i+j*width]==-1237980||tiles[i+j*width]==-12629812||tiles[i+j*width]==-256||tiles[i+j*width]==-1||tiles[i+j*width]==-16777216)
				{
					
					
				}
				
				else
					System.out.println(tiles[i+j*width]+"||"+i+"|"+j);
			
				if(tiles[i+j*width]==-14503604)
				{
					Door d= new Door(i*16,j*16);
					adddoor(d);
				}
			
				if(tiles[i+j*width]==-12629812)
				{
					key k=new key(i*16,j*16);													
					addkey(k);
				}
				
				if(tiles[i+j*width]==-7864299)
				{
					Enemy e= new walker(i*16,j*16);
					addEnemy(e);
				}
				
				if(tiles[i+j*width]==-3947581)
				{	
					Wildling w=new Wildling(i*16,(j*16));
					addwildling(w);
				}
				
				if(tiles[i+j*width]==-1055568)
				{	
					Giant w=new Giant(i*16,(j*16));
					addgiant(w);
				}
				
				if(tiles[i+j*width]==-1237980)
				{
	
					fire f=new fire(i*16,j*16);
					addfire(f);
				}
				
			}
			
		}
		
		
	}

	protected void loadspawnpt()
	{
		for(int i=0;i<width;i++)
		{
			for(int j=0;j<height;j++)
			{
				if(tiles[i+j*width]==-65281)
				{
					spawnptx=i*16;
					spawnpty=j*16;
				}
			}
		}
	}
	
	protected void generatelevel()
	{
		
	}
	
	protected void loadlevel(String path)
	{
		
	}
	
	public void update(Keyboard input)
	{	
		if(chain_update)
		{
			chain.get(chain_no).update(input);
		}
	
		for(int i=0;i<projectiles.size();i++)
		{
			projectiles.get(i).update();
		}
		
		for(int i=0;i<check.size();i++)
		{
			check.get(i).update();
		}
		
		for(int i=0;i<hearts.size();i++)
		{
			hearts.get(i).update();
		}
		
		for(int i=0;i<coins.size();i++)
		{
			coins.get(i).update();
		}
		
		for(int i=0;i<walker.size();i++)
		{
			walker.get(i).update();
		}
		
		for(int i=0;i<ball.size();i++)
		{
			ball.get(i).update();
		}
		
		for(int i=0;i<fire.size();i++)
		{
			fire.get(i).update();
		}
		
		for(int i=0;i<bullets.size();i++)
		{
			bullets.get(i).update();
		}
		
		for(int i=0;i<block.size();i++)
		{
			block.get(i).update();
		}
		
		for(int i=0;i<key.size();i++)
		{
			key.get(i).update();
		}
		
		for(int i=0;i<door.size();i++)
		{
			door.get(i).update();
		}
		
		for(int i=0;i<wildling.size();i++)
		{
			wildling.get(i).update();
		}
		
		for(int i=0;i<giant.size();i++)
		{
			giant.get(i).update(i);
			
		}
		
		for(int i=0;i<particles.size();i++)
		{
			particles.get(i).update();
		}
		                                  // TO MOVE THE ENTITIES IN THE LEVEL MONSTERS / COINS 
	}

	public void render(int xScroll,int yScroll, Screen screen)
	{
		screen.setoffset(xScroll, yScroll);
		int x0=xScroll>>4;
		int x1=(xScroll+screen.width+16)>>4;
		int y0=yScroll>>4;
		int y1=(yScroll+screen.height+16)>>4;
		for(int y=y0;y<y1;y++)
		{
			for(int x=x0;x<x1;x++)
			{
			
				getTile(x,y).render(x, y,screen);// getTile returns a object of tile class so can use getTile 
				//it is returning a tile we dont know if grass or void 
				//after returning a grass/void it calls their own render method which overrides the render method in tile, it extends tile so a render method should be there in tile 
			}
		
			for(int i=0;i<beam.size();i++)
			{
				beam.get(i).render(screen);
			}
			
			for(int i=0;i<projectiles.size();i++)
			{
				projectiles.get(i).render(screen);
			}
		
			for(int i=0;i<ball.size();i++)
			{
				ball.get(i).render(screen);
			}	
		
			for(int i=0;i<coins.size();i++)
			{
				coins.get(i).render(screen);
			}
		
			for(int i=0;i<hearts.size();i++)
			{
				hearts.get(i).render(screen);
			}
		
			for(int i=0;i<chain.size();i++)
			{
				chain.get(i).render(screen);
			}
		
			for(int i=0;i<check.size();i++)
			{
				check.get(i).render(screen);
			}
		
			for(int i=0;i<walker.size();i++)
			{
				walker.get(i).render(screen);
			}
		
			for(int i=0;i<fire.size();i++)
			{
				fire.get(i).render(screen);
			}
		
			for(int i=0;i<bullets.size();i++)
			{
				bullets.get(i).render(screen);
			}
		
			for(int i=0;i<block.size();i++)
			{
				block.get(i).render(screen);
			}
		
			for(int i=0;i<key.size();i++)
			{
				key.get(i).render(screen);
			}
		
			for(int i=0;i<door.size();i++)
			{
				door.get(i).render(screen);
			}
		
			for(int i=0;i<wildling.size();i++)
			{
				wildling.get(i).render(screen);
			}
		
			for(int i=0;i<giant.size();i++)
			{
				giant.get(i).render(screen);
			}
		
			for(int i=0;i<particles.size();i++)
			{
				particles.get(i).render(screen);
			}
			
		}
	}
	
	//******  WITH MAP
	public void addgiant(Giant g)
	{
		giant.add(g);
	}
	
	public void addcheck(checkpoint c)
	{
		check.add(c);
	}
	
	public void addchain(Chain g)
	{
		chain.add(g);
	}
	
	public void addball(Ball e)
	{
		ball.add(e);
	}
	
	public void addlife(life l)
	{
		hearts.add(l);
	}
	
	public void add(Entity e)
	{
		entities.add(e);
	}
	
	public void addProjectile(Projectile p)
	{
		projectiles.add(p);
	}
	
	public void addcoin(points p)
	{
		coins.add(p);
	}
	
	public void addEnemy(Enemy e)
	{
		walker.add(e);
		
	}
	
	public void addfire(fire f)
	{
		fire.add(f);
		
	}
	
	public void addbullet(Bullet b)
	{
		bullets.add(b);
		
	}
	
	public void addblock(Block b)
	{
		block.add(b);
		
	}
	
	public void addkey(key k)
	{
		key.add(k);
		
	}
	
	public void adddoor(Door d)
	{
		door.add(d);
		
	}
	
	public void addwildling(Wildling w)
	{
		wildling.add(w);
		
	}
	
	public void addbeam(Beam b)
	{
		beam.add(b);
		
	}
	
	public void add(Particle e)
	{
		particles.add(e);
		
	}
	
	public Tile getTile(int x,int y)
	{
		if(x<0||y<0||x>=width||y>=height)return Tile.stone1;
		//Return void tiles if it goes out of bounds
 		int colour =tiles[x+y*width];
 		
		if(tiles[x+y*width]==-16777216)
		{
			return Tile.grass;
		}
		
		if(tiles[x+y*width]==-256)
		{	
			return Tile.voidTile;
		}
		
		else		 
			return Tile.voidTile;
	}

	protected boolean getcollision(int xa, int ya,int x,int y)
	{
		boolean solid=false;
		
		for(int c=0;c<4;c++)
		{
			int xt= ((x+xa)+c%2*12+3)/16;
			int yt= ((y+ya)+c/2*12+3)/16;
			if(getTile(xt,yt).solid())
				solid=true;
		}
		return solid;
	}
}
