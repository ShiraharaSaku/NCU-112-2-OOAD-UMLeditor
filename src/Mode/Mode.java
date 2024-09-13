package Mode;

import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;

import Object.ShapeObject;

public class Mode{
	
	protected String name;
	protected JPanel panel;
	protected List<ShapeObject> objectList;
	protected boolean isChosen;

	public Mode() {
	}
	
	
	public Mode(JPanel panel, List<ShapeObject> objectList) {
		this.panel = panel;
		this.objectList = objectList;
	}
	
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}

   
    public List<ShapeObject> getObjectList() {
    	return objectList;
    }
    public String getName() {
    	return name;
    }

    public void changeChosenState(boolean isChosen) {
    	this.isChosen = isChosen;
    }

    public boolean isChosen() {
    	return isChosen;
    }

}
