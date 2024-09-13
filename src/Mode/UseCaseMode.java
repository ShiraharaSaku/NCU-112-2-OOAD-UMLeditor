package Mode;

import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;
import Object.ShapeObject;
import Object.UseCaseObject;

public class UseCaseMode extends Mode {
	
	public UseCaseMode(JPanel panel, List<ShapeObject> objectList) {
		super(panel, objectList);
	}
    public void mousePressed(MouseEvent e) {
    	int mouseX = e.getX();
        int mouseY = e.getY();
        createObject(mouseX, mouseY);
    }
    
	
    public void createObject(int mouseX, int mouseY) {
    	ShapeObject usecaseObject = new UseCaseObject(mouseX, mouseY);
        objectList.add(usecaseObject);
        panel.add(usecaseObject);
        panel.repaint();
    }
}
