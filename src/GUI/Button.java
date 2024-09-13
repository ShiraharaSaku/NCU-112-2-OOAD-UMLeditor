package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import Mode.ModeType;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Button extends JToggleButton {
	private int x = 25;
	private int initial_y = 50;
	private int interval = 75;
    private int width = 50;
    private int height = 50;
    private Color selectedColor = new Color(0, 0, 0);
    private Color normalColor = new Color(50, 50, 50);
    public String name;
    private ModeType modeType;

    public Button(ModeType modeType) {
        //this.setBounds(x, y, width, height);
        this.modeType = modeType;
        initButton();
    }

    private void initButton() {
        setBackground(normalColor); 
        UIManager.put("ToggleButton.select", selectedColor);
        SwingUtilities.updateComponentTreeUI(this);
        
        String buttonName = modeType.pictureName();
    	String buttonImagePath = "src/Image/Button_" + buttonName + ".png";
        ImageIcon buttonImage = loadImage(buttonImagePath);
        if (buttonImage != null) {
        	setIcon(buttonImage);
        	setPosition();
        }
    }
    
    private void setPosition(){
    	int y = initial_y + interval * modeType.ordinal();
    	this.setBounds(x, y, width, height);
    }

    private ImageIcon loadImage(String imagePath) {
        try {
            return new ImageIcon(ImageIO.read(new File(imagePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    
}
