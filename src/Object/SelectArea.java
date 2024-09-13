package Object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JComponent;

public class SelectArea extends JComponent{
	private Point startPoint;
	private Point endPoint;
	
    public SelectArea(int startX, int startY, int endX, int endY) {
    	this.startPoint = new Point(startX, startY);
    	this.endPoint = new Point(endX, endY);
    	setArea(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }
    
    public SelectArea(Point startPoint, Point endPoint) {
    	this.startPoint = startPoint;
    	this.endPoint = endPoint;
    	setArea(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }
    
    public void setArea(int startX, int startY, int endX, int endY) {
    	int x = Math.min(startX, endX);
    	int y = Math.min(startY, endY);
    	setLocation(x, y);
    	
    	int w = Math.abs(startX - endX);
    	int h = Math.abs(startY - endY);
    	setSize(w, h);
    }
    
    public void setLocation(int x, int y) {
    	super.setLocation(x, y); 
    }
    
    public void setSize(int w, int h) {
    	super.setSize(w, h);
    }
	
    public boolean isObjectInside(ShapeObject obj) {
    	Point objMin = obj.getLocation();
    	Point objMax = obj.getLocation();
    	objMax.setLocation(objMax.x+obj.getWidth(), objMax.y+obj.getHeight());
    	
    	return (inXRange(objMin.x) && inXRange(objMax.x) && inYRange(objMin.y) && inYRange(objMax.y));
    }
    
    private boolean inXRange(int x) {
        return x >= getX() && x <= getX() + getWidth();
    }
    
    private boolean inYRange(int y) {
    	return y >= getY() && y <= getY() + getHeight();
    }
    
    
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(new Color(100, 100, 100));
        g2.fillRect(0, 0, getWidth(), getHeight());
        
    }
}
