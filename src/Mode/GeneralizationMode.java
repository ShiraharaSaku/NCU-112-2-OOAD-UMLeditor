package Mode;

import java.util.List;

import javax.swing.JPanel;

import Object.ShapeObject;
import Object.Line;
import Object.GeneralizationLine;

public class GeneralizationMode extends LineMode {
	
	public GeneralizationMode(JPanel panel, List<ShapeObject> objectList) {
		super(panel, objectList);
	}
	
    public void createObject() {
    	Line generalizationLine = new GeneralizationLine(startPort, endPort);
    	
    	startPort.addStartLine(generalizationLine);
    	endPort.addEndLine(generalizationLine);
       
        panel.add(generalizationLine);
        panel.repaint();
    }

}
