package core;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GfxLoader {

	public final int columns = 13;
	public final int rows = 14;
	public final int sizeX = 16;
	public final int sizeY = 16;
	public BufferedImage arrow;
	private BufferedImage spriteSheet;
	private BufferedImage sprites[];
	
	public GfxLoader() {
		try{arrow = ImageIO.read(this.getClass().getClassLoader().getResource("images/arrow.png"));}
		catch(IOException e){e.printStackTrace();}
		
		try{spriteSheet = ImageIO.read(this.getClass().getClassLoader().getResource("images/ingredients.png"));}
		catch(IOException e){e.printStackTrace();}
		sprites = new BufferedImage[columns*rows];

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				sprites[j+(i*columns)] = spriteSheet.getSubimage(j*sizeX, i*sizeY, sizeX, sizeY);
	}
	
	public BufferedImage getSprite(int id) {
		return sprites[id];
	}
	
}