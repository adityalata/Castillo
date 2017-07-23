import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener
{
	private boolean[] keys=new boolean[120];
	public boolean up,down,left,right,shoot,jump,z,esc,enter,w,s;

	public void update()
	{
		down=keys[KeyEvent.VK_DOWN]||keys[KeyEvent.VK_S];
		esc=keys[KeyEvent.VK_ESCAPE];
		right=keys[KeyEvent.VK_RIGHT]||keys[KeyEvent.VK_D];		
		left=keys[KeyEvent.VK_LEFT]||keys[KeyEvent.VK_A];
		shoot=keys[KeyEvent.VK_SPACE];
		jump=keys[KeyEvent.VK_UP];
		w=keys[KeyEvent.VK_W];
		z=keys[KeyEvent.VK_Z];
		s=keys[KeyEvent.VK_S];
		enter=keys[KeyEvent.VK_ENTER];
	}
	
	public void keyPressed(KeyEvent e)
	{
		keys[e.getKeyCode()]=true;
	}

	public void keyReleased(KeyEvent e)
	{
		keys[e.getKeyCode()]=false;
	}

	public void keyTyped(KeyEvent e)
	{
	
		
	}

}
