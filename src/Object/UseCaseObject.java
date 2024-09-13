package Object;

import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class UseCaseObject extends BaseObject {
	int w = 120;
	int h = 70;

    public UseCaseObject(int x, int y){
        super(x, y);
        setSize(w, h);
        initialNameLabel();
    	for (PortDirection direction : PortDirection.values()) {
    		ports.add(new Port(this, direction)); 
        }
    }

    public UseCaseObject(Point p){
        super(p);
        setSize(w, h);
        initialNameLabel();
    	for (PortDirection direction : PortDirection.values()) {
    		ports.add(new Port(this, direction)); 
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(new Color(255, 255, 255));
        g2.drawOval(0, 0, getWidth()-1, getHeight()-1);
    }
}
