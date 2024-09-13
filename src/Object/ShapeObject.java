package Object;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

public class ShapeObject extends JComponent{
	
	protected int inCompositeX;
	protected int inCompositeY;
	
	public ShapeObject() {
		
    }
	
	public ShapeObject(int x, int y) {
        setLocation(x, y); 
    }

    public ShapeObject(Point p) {
        setLocation(p);
    }
    

    public boolean isMouseInside(int mouseX, int mouseY) {
        return (inXRange(mouseX) && inYRange(mouseY));
    }
    
    private boolean inXRange(int mouseX) {
        return mouseX >= getX() && mouseX <= getX() + getWidth();
    }
    
    private boolean inYRange(int mouseY) {
    	return mouseY >= getY() && mouseY <= getY() + getHeight();
    }
    
    public void moveObject(int deltaX, int deltaY) {
        setLocation(getX() + deltaX, getY() + deltaY);
    }
    
    public Port choosePort(int mouseX, int mouseY) {
    	return null;
    }
    

    public void displayPorts(JPanel panel) {
    	// 繼承時實作
    }  
    
    public void undisplayPorts(JPanel panel) {
    	// 繼承時實作
    }  
    
    // composite 物件 unGroup
    public void unGroup(List<ShapeObject> objectList, JPanel panel) {

    } 

}
