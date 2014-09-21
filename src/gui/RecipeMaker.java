package gui;

import gui.CodeWriter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.*;

import core.Start;


public class RecipeMaker extends JPanel
						implements PropertyChangeListener, ActionListener {
	
	public int ID = 2258;
	private JFormattedTextField IDField;
	private JButton writeButton;
	public String name = "";
	private JTextField nameField;
	public FileChoser audioFile;
	
	public RecipeMaker() {
		super(new GridLayout(1, 1));
		
//		ArrayList<ItemChoser> slots = new ArrayList<ItemChoser>();
//		for(int i=0;i<9;i++)
//			slots.add(new ItemChoser());
		
		JPanel craftPane = new JPanel(new GridLayout(0,3));
//		for(int i=0;i<9;i++)
//			craftPane.add(slots.get(i));
		
		craftPane.setBorder(BorderFactory.createEmptyBorder(0,5,0,0));
		
		JPanel guiPane = new JPanel(new GridBagLayout());
		//guiPane.setPreferredSize(new Dimension(400,200));
		guiPane.add(craftPane);
		ImageIcon arrowIco = new ImageIcon(Start.gfx.arrow);
		JLabel arrowLab = new JLabel(arrowIco);
		JPanel arrowPane = new JPanel(new GridLayout(0,1));
		arrowPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		arrowPane.add(arrowLab);
		guiPane.add(arrowPane);
		guiPane.add(new CraftResult());
		
		NumberFormat IDFormat = NumberFormat.getNumberInstance();
	    IDField = new JFormattedTextField(IDFormat);
	    IDField.setValue(ID);
	    IDField.setColumns(10);
	    IDField.addPropertyChangeListener("value", this);
	    
	    JLabel IDLabel = new JLabel("ID: ");
	    IDLabel.setOpaque(true);
	    IDLabel.setLabelFor(IDField);
	    
	    JPanel lowerPane =  new JPanel(new GridBagLayout());
	    IDField.setToolTipText("Enter a unique item ID.");
	    lowerPane.add(IDLabel);
	    lowerPane.add(IDField);
	    
	    nameField = new JTextField(20);
	    JLabel nameLabel = new JLabel("Name: ");
	    nameLabel.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
	    nameLabel.setOpaque(true);
	    nameLabel.setLabelFor(nameField);	    
	    lowerPane.add(nameLabel);
	    lowerPane.add(nameField);
	    nameField.setToolTipText("Enter the name that appears on mouseover.");
	    
	    writeButton = new JButton("Write");
        writeButton.addActionListener(this);

        JPanel audioPane =  new JPanel(new GridBagLayout());
        JLabel audioLabel = new JLabel("Pick audio file: ");
        audioPane.add(audioLabel);
        audioPane.add(audioFile = new FileChoser());
		
	    JPanel contentPane =  new JPanel(new GridLayout(0,1));
		contentPane.add(guiPane);
		contentPane.add(lowerPane);
		contentPane.add(audioPane);
		contentPane.add(new WriteBlockFile(0, 0, 0, "0", "0", "0"), BorderLayout.CENTER);
//		contentPane.add(new ItemDrawer());
		
		add(contentPane);
		
	}

	public void propertyChange(PropertyChangeEvent e) {
        Object source = e.getSource();
        if (source == IDField) {
        	ID = ((Number)IDField.getValue()).intValue();
        }
    }
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		name = nameField.getText();
		JFrame frame = null;
//		if (source == writeButton && !(saveFile.fileName.equals("")))
//		{
//			try {
//				new CodeWriter(ID, hardness, resistance, name, imageFile.fileName, saveFile.fileName);
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//			JOptionPane.showMessageDialog(frame, "Files created successfully at " + saveFile.fileName + ".");
//		} else if (source == writeButton && saveFile.fileName.equals("")) {
//			JOptionPane.showMessageDialog(frame, "Please chose a directory to save to first.");
//		}
    }
	
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = RecipeMaker.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
