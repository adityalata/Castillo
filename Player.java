import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Mob
{		
	private Keyboard input;
	private Sprite sprite;
	protected boolean jumping=false;
	protected boolean falling=true;
	protected double gravity=0.0;
	private int anim=0;
	public boolean walking =false;
	public int fire=0;
	protected Screen screen;
	int h=1;
	int last_pos=1;
	int pos_x,pos_y;
	boolean foot_collision=false;
	int change_rate1=4,change_sprite=2;
	int change_rate2=2;	
	
	public Player(Keyboard input)
	{
		this.input=input;
		sprite=Sprite.player_right1;
		fire=WizardProjectile.fire_rate;
	}
	
	public Player(int x,int y,Keyboard input,Screen sc)
	{
		this.x=x;
		this.y=y;
		screen=sc;
		this.input=input;
		
		sprite=Sprite.player_right1;
		fire=WizardProjectile.fire_rate;
	}
	
	public void  update()
	{	
		level.check_collision=false;
	
		int xa=0,ya=0;
		if(fire>0)
			fire--;
		if(anim<7500)
			anim++;
		else 
			anim=0; 
		
		if(input.down)
			ya++;
		
		if(input.left)
		{
			xa--;
			last_pos=-1;
		}
		if(input.right)
		{
			xa++;
			last_pos=1;
		}

		{
			
			getlife();
			getCoin();
			getfire();
			getBlock();
			getDoor();
			getwildling();
			getcheck();
			Rectangle r,r1,bullet,block,r2,wildling_top,wildling_rest,chain,check;
			
			r1=draw_player(); 
			r2=draw_player_foot();
			boolean coin_collision=false;
			boolean fire_collision=false;
			boolean chain_collision=false;
			boolean giant_collision=false;
			level.end_game=false;
	////******************************************** 	CHAIN COLLISION		
	
			for(int i=0;i<level.chain.size();i++)
			{
				chain=level.chains[i];
				
				if(r1.intersects(chain))
				{
					if(input.z)
					level.start_chain=true;
					chain_collision=true;
					level.chain_no=i;
					level.chain_update=true;
				}
			}
			level.player_chain=chain_collision;
			
			if(!chain_collision)
				level.start_chain=false;
			
			
// *********************************     COINS COLLISION	*************************************************//	
			for(int i=0;i<level.coins.size();i++)
			{
				if(!coin_collision)
				{
					if(r1.intersects(level.coin[i]))
					{
						level.score++;
						coin_collision=true;
						level.coins.get(i).remove();
					}
				}	
			}
			
/////***********************************     giant colllsion
			if(level.giant_collision)
			{
				x=level.checkpoint_x;
				y=level.checkpoint_y;
				level.giant_collision=false;
				level.giant_collision=false;
				
			}
			
///***********************************   FIRE COLLISION		***********************************************************//
			for(int i=0;i<level.fire.size();i++)
			{
				if(!fire_collision)
				{
					if(r1.intersects(level.flame[i]))
					{	
						fire_collision=true;
						{
							level.life-=1;
							
							if(level.life==0)
							{
								level.gameover=true;
							}
							x=level.checkpoint_x;
							y=level.checkpoint_y;
						}
					}
				}	
			}
			
	///***************************************   ENEMY BULLET COLLISION		****************************************************//	
			
			for(int i=0;i<level.bullets.size();i++)
			{
				bullet=level.bullets.get(i).draw_bullet();
				if(r1.intersects(bullet))
				{
					
					level.life-=1;
					
					if(level.life==0)
					{
						Game.running=false;
						level.gameover=true;
					}
						
						try 
						{
							Thread.sleep(1000);
						} catch (InterruptedException e)
						{
							e.printStackTrace();
						}
						
					x=level.checkpoint_x;
					y=level.checkpoint_y; 
				}
			}
	/////******************************************		LIFE COLLISION
			for(int i=0;i<level.hearts.size();i++)
			{
				bullet=level.lifes[i];
				if(r1.intersects(bullet))
				{
					
					if(level.life==3)
						break;
					if(level.life<3)
					{
					level.life+=1;
					level.hearts.get(i).remove();
					}
				}
			}
///////********************************************				 CHECKPOINT			
			for(int i=0;i<level.check.size();i++)
			{
				{
					if(r1.intersects(level.cp[i]))
					{
						level.checkpoint_x=level.cp[i].x;
						level.checkpoint_y=level.cp[i].y;
						level.check_collision=true;
					}
				}	
			}

			
	///************************************************ WILDLING COLLISION WILDLING DEFEATED
			for(int i=0;i<level.wildling.size();i++)
			{
				wildling_top=level.wildling_top[i];
				
				if(r1.intersects(wildling_top))
				{
					if(r2.intersects(wildling_top))
					{
						level.wildling.get(i).remove();
					}
					else
					{
					
						level.life-=1;
						x=level.checkpoint_x;
						y=level.checkpoint_y;
						
						if(level.life==0)
						{
							level.gameover=true;
						}
		
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
			
	///****************************************************  DOOR COLLISION		
			for(int i=0;i<level.door.size();i++)
			{
				block=level.door.get(i).draw_door();
				if(r1.intersects(block))
				{
					if(level.key_found)
					{
						level.end_game=true;
						if(input.s)
						{
							System.out.println("hi");
							level.end=true;
							level.end_game=false;
						}
					}
				}
			}
		}
	
		if(jumping)
		{	
			if(collision(xa,-1))
			{
				jumping=false;
				gravity=0.0;
				falling=true;
			}
		
			else
			{
				gravity-=.1;
				
				move(0,(int)-gravity);
				if(gravity<=0.0)
				{	
					jumping=false;
					falling=true;
				}
			}
		}
		
		
		if(falling)
		{
			if(!collision(xa,3))
			{
				if(gravity>10.0) gravity=0.0;
				gravity+=0.1;
				move(0,(int)gravity);
			}
		}
		
		if(xa!=0||ya!=0)
		{
			move(xa,ya);	
			walking=true;
		}
			else walking=false;

		updateShooting();
		jump();
		getPlayer();
		clear();
		level.player_x=x;
		level.player_y=y;
	}
	
	private void getPlayer()
	{
		
		
	}
	
	protected void clear()
	{
		for(int i=0;i<level.projectiles.size();i++)
		{
			Projectile p=level.projectiles.get(i);
			if(p.isRemoved()) level.projectiles.remove(i);
		}
		for(int i=0;i<level.bullets.size();i++)
		{
			Bullet p=level.bullets.get(i);
			if(p.isRemoved())level.bullets.remove(i);
		}
		
	}
	
	public void jump()
	{
		if(input.jump && collision(0,3))
		{
			if(!jumping)
			{
				jumping=true;
				falling=false;
				gravity=5.0;
			}
		}
	}
	
	private void updateShooting()
	{	
		if(input.shoot && fire<=0)
		{ 
			shoot(x,y,last_pos);
			fire=WizardProjectile.fire_rate;
		}
	}

	public void  render(Screen screen)
	{
		if(dir==1)
		{
			sprite=Sprite.player_right1;
			if(walking)
			{
				if(anim%20>10) sprite=Sprite.player_right1;
				else sprite=Sprite.player_right2;
			}
		}
		else if(dir==3)
		{
			sprite=Sprite.player_left1;
			if(walking)
			{
				if(anim%20>10) sprite=Sprite.player_left1;
				else sprite=Sprite.player_left2;
			}
		}
		else
			if(last_pos==-1)
				sprite=Sprite.player_left1;
			else
				sprite=Sprite.player_right1;
			screen.renderPlayer(x, y, sprite);
	
	}
	public void getCoin()
	{
		for(int i =0;i<level.coins.size();i++)
		{
			 level.coin[i]=level.coins.get(i).drawcoin();
		}
	}
	public void getfire()
	{
		for(int i =0;i<level.fire.size();i++)
		{
			 level.flame[i]=level.fire.get(i).drawfire();
		}
	}
	
	public Rectangle draw_player()
	{
		return new Rectangle (x,y,16,16);
	}
	
	protected void getBlock()
	{
		for(int i =0;i<level.block.size();i++)
		{
			 level.blocks[i]=level.block.get(i).draw_block();
		}
	}
	
	protected Rectangle draw_player_foot()
	{
		return new Rectangle(x+2,y+14,16-4,2);
	}
	
	protected void getDoor()
	{
		for(int i =0;i<level.door.size();i++)
		{
			 level.doors[i]=level.door.get(i).draw_door();
		}
	}
	protected void getwildling()
	{
		for(int i =0;i<level.wildling.size();i++)
		{
			 level.wildling_top[i]=level.wildling.get(i).draw_top();
		}
	}
	protected void getcheck()
	{
		for(int i =0;i<level.check.size();i++)
		{
			 level.cp[i]=level.check.get(i).draw_check();
		}
	}
	protected void getlife()
	{
		for(int i =0;i<level.hearts.size();i++)
		{
			 level.lifes[i]=level.hearts.get(i).draw_life();
		}
	}
	protected Rectangle chain()
	{
		return new Rectangle(53*16,42*16,16,16);
	}

	public void draw(Graphics g)
	{
		
	}
	
}
