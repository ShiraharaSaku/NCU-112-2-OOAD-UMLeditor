package Object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class ClassObject extends BaseObject {
	int w = 120; 
	int h = 120; 
	
	
	public ClassObject(int x, int y){
        super(x, y);
        setSize(w, h);
        initialNameLabel();
    	for (PortDirection direction : PortDirection.values()) {
    		ports.add(new Port(this, direction)); 
        }
    }

    public ClassObject(Point p){
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
        
        int rectHeight = h/3-1;
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(new Color(255, 255, 255));
        for (int i=0; i<3; i++) {
            g2.drawRect(0, rectHeight*i, w-1, rectHeight);
        }
    }

}
