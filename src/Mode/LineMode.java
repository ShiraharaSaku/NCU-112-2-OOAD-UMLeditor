package Mode;

import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JPanel;

import Object.ShapeObject;
import Object.Port;

abstract class LineMode extends Mode {
	protected Port startPort;
	protected Port endPort;
	protected ShapeObject startObject;
	protected ShapeObject endObject;
	abstract public void createObject();
	
	
	public LineMode(JPanel panel, List<ShapeObject> objectList) {
		super(panel, objectList);
	}

    public void mousePressed(MouseEvent e) {
    	int mouseX = e.getX();
        int mouseY = e.getY();
        startObject = selectObject(mouseX, mouseY);
        if (startObject != null) {
            startPort = startObject.choosePort(mouseX, mouseY);
        }
    }

    
    public void mouseReleased(MouseEvent e) {
    	int mouseX = e.getX();
        int mouseY = e.getY();
    	endObject = selectObject(mouseX, mouseY, startObject);
        if (endObject != null) {
            endPort = endObject.choosePort(mouseX, mouseY);
        }
        
        if (startPort != null && endPort != null) {
        	createObject();
        }
        resetNull();
    }
	
    private void resetNull() {
    	startObject = null;
        endObject = null;
        startPort = null;
    	endPort = null;
    }
    
    private ShapeObject selectObject(int mouseX, int mouseY) {
        for (int i = objectList.size()-1; i>=0; i--) {
        	ShapeObject obj = objectList.get(i);
            if (obj.isMouseInside(mouseX, mouseY)) {
                return obj;
            }
        }
        return null;
    }
    
    private ShapeObject selectObject(int mouseX, int mouseY, ShapeObject excludeObj) {
        for (int i = objectList.size()-1; i>=0; i--) {
        	ShapeObject obj = objectList.get(i);
            if (obj != excludeObj && obj.isMouseInside(mouseX, mouseY)) {
                return obj;
            }
        }
        return null;
    }
     
    
}
