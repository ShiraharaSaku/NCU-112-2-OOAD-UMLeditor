package Mode;

import java.util.List;

import javax.swing.JPanel;

import Object.ShapeObject;
import Object.Line;
import Object.AssociationLine;

public class AssociationMode extends LineMode {
	
	public AssociationMode(JPanel panel, List<ShapeObject> objectList) {
		super(panel, objectList);
	}
	
	public void createObject() {
    	Line associationLine = new AssociationLine(startPort, endPort);
    	
    	startPort.addStartLine(associationLine);
    	endPort.addEndLine(associationLine);
        
        panel.add(associationLine);
        panel.repaint();
    }
	
	
}
