import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpawnLevel extends level
{
	private int[] levelPixels;

	public SpawnLevel(String path) 
	{
		super(path);	
	}
    
	protected void loadlevel(String path)
	{ 
		try {
			BufferedImage image=ImageIO.read(SpawnLevel.class.getResource(path));
			int w=width=image.getWidth();
			int h=height=image.getHeight();
			System.out.println(path);
			System.out.println(width +" |"+height);
			tiles=new int[w*h];
			image.getRGB(0, 0, w, h,tiles, 0, w);
			} 
			catch (IOException e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("LEVEL ERROR");
		    }
			
		
	}
// converts level pixles array of integers into array of tiles

   protected void generatelevel()
   {	

   }

}
