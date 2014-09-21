package core;

import gui.*;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Start {

	public static Dimension appDim = new Dimension(400, 400);
	public static GfxLoader gfx = new GfxLoader();

	public static void main(String[] args) {
		JFrame frame = new JFrame("Record Maker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RecipeMaker gc = new RecipeMaker();
		frame.setSize(appDim);
		frame.setResizable(false);
		frame.getContentPane().add(gc);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}