package Object;

import javax.swing.JPanel;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Font;


import java.util.ArrayList;
import java.util.List;

public class BaseObject extends ShapeObject{
	protected JLabel nameLabel;

    protected List<Port> ports = new ArrayList<Port>(); //NSEW

    public BaseObject(int x, int y) {
        super(x, y); 
    }

    public BaseObject(Point p) {
    	super(p);
    }

    public void initialNameLabel() {
    	nameLabel = new JLabel("");
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setVerticalAlignment(JLabel.CENTER); 
        nameLabel.setForeground(Color.WHITE);

        nameLabel.setSize(getWidth(), getHeight()); 
        
        nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        this.add(nameLabel);
    }

    public JLabel getNameLabel() {
    	return nameLabel;
    }
    
    @Override
    public void setName(String newName) {
    	super.setName(newName);
    	nameLabel.setText(newName);
    }    
    
    @Override
    public Port choosePort(int mouseX, int mouseY) {
		Point mouseP = new Point(mouseX, mouseY);

	    double minDistance = Double.POSITIVE_INFINITY;
	    Port returnPort = null;
		for (Port port: ports) {
			Point portLocation = port.getLocation();
			double distance = getDistance(portLocation, mouseP);
			if (distance < minDistance) {
				returnPort = port;
	            minDistance = distance;
	        }
	    }
    	return returnPort;
    }
    
	private double getDistance(Point p1, Point p2) {
		double distance = Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
		return distance;
	}

	public void moveAllPorts(int deltaX, int deltaY) {
		for (Port port : ports) {
			port.movePort(deltaX, deltaY);
		}

	}
	
    public List<Port> getAllPorts() {
    	return ports;
    }   
    
    @Override
    public void moveObject(int deltaX, int deltaY) {
        setLocation(getX() + deltaX, getY() + deltaY);
        moveAllPorts(deltaX, deltaY); 
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
    }    
    @Override
    public void displayPorts(JPanel panel) {
    	for (Port port : ports) {
    		panel.add(port);
		}
        panel.repaint();
    }      
    
    @Override
    public void undisplayPorts(JPanel panel) {
    	for (Port port : ports) {
    		panel.remove(port);
		}
        panel.repaint();
    }  
    
}

