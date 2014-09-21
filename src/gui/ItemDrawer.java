package gui;

import javax.swing.*;
import java.awt.*; 

public class ItemDrawer extends JComponent
{
	public void paint(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;

	    Image img = Toolkit.getDefaultToolkit().getImage("img/pig.png");
	    int imgX = getSize ().width/2 - img.getWidth (this); 
	    int imgY = getSize ().height/2 - img.getHeight (this);
	    g2.drawImage(img, imgX, imgY, this);
	}
}