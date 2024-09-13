package Object;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class CompositeObject extends ShapeObject{
    
    private List<ShapeObject> objectGroup = new ArrayList<ShapeObject>();
    
    // location 為最左上的點
    public CompositeObject(List<ShapeObject> list) {   
    	int minX = 1000;
        int minY = 1000;
        int maxX = 0;
        int maxY = 0;

    	for (ShapeObject obj : list) {
	    	objectGroup.add(obj);
	    	
	    	minX = Math.min(minX, obj.getX());
	    	minY = Math.min(minY, obj.getY());
	    	maxX = Math.max(maxX, obj.getX()+obj.getWidth());
	    	maxY = Math.max(maxY, obj.getY()+obj.getHeight());
	    }

    	setLocation(minX, minY);
    	setSize(maxX-minX, maxY-minY);
    }
    
    @Override
    public void unGroup(List<ShapeObject> objectList, JPanel panel) {
    	for (ShapeObject obj : objectGroup) {
    		objectList.add(obj);
	    }
		panel.remove(this);
		objectList.remove(this);
    } 
    
    @Override
    public void moveObject(int deltaX, int deltaY) {
        setLocation(getX() + deltaX, getY() + deltaY);

        for (ShapeObject obj : objectGroup) {
            obj.moveObject(deltaX, deltaY);
	    }
    }
    
    @Override
    public void displayPorts(JPanel panel) {
    	for (ShapeObject obj : objectGroup) {
    		obj.displayPorts(panel);
	    }
        panel.repaint();
    }      
    
    @Override
    public void undisplayPorts(JPanel panel) {
    	for (ShapeObject obj : objectGroup) {
    		obj.undisplayPorts(panel);
	    }
        panel.repaint();
    }  
}
