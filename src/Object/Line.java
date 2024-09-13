package Object;

import java.awt.Point;

import javax.swing.JComponent;

public class Line extends JComponent{
	protected Port startPort;
	protected Port endPort;
    protected int width;
    protected int height;
    
    // 留空間給箭頭等圖案繪製
    int padding = 10;

    public Line(Port startP, Port endP) {
    	startPort = startP; 
    	endPort = endP; 
    	setLocation();
    	setSize();
    }
    
    public void setLocation() {
    	Point startPoint = startPort.getLocation();
    	Point endPoint = endPort.getLocation();

    	int locationX = Math.min(startPoint.x, endPoint.x);
    	int locationY = Math.min(startPoint.y, endPoint.y);
    	
    	locationX = locationX - padding;
    	locationY = locationY - padding;

    	super.setLocation(locationX, locationY); 
    }
    
    public void setSize() {
    	Point startPoint = startPort.getLocation();
    	Point endPoint = endPort.getLocation();
        
    	setWidth(Math.abs(startPoint.x - endPoint.x)+padding*2); 
    	setHeight(Math.abs(startPoint.y - endPoint.y)+padding*2); 
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }
    
}
