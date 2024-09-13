package Mode;

import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;

import Object.ShapeObject;
import Object.ClassObject;

public class ClassMode extends Mode{
	
	public ClassMode(JPanel panel, List<ShapeObject> objectList) {
		super(panel, objectList);
	}
    public void mousePressed(MouseEvent e) {
    	int mouseX = e.getX();
        int mouseY = e.getY();
        createObject(mouseX, mouseY);
    }
	
    public void createObject(int mouseX, int mouseY) {
    	ShapeObject classObject = new ClassObject(mouseX, mouseY);
        objectList.add(classObject);
        panel.add(classObject);
        panel.repaint();
    }
}
