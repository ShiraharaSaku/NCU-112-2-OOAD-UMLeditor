package Mode;

import java.util.List;

import javax.swing.JPanel;

import Object.CompositionLine;
import Object.ShapeObject;
import Object.Line;

public class CompositionMode extends LineMode {
	
	public CompositionMode( JPanel panel, List<ShapeObject> objectList) {
		super(panel, objectList);
	}
	
	public void createObject() {
    	Line compositionLine = new CompositionLine(startPort, endPort);
    	
    	startPort.addStartLine(compositionLine);
    	endPort.addEndLine(compositionLine);
    	
        panel.add(compositionLine);
        panel.repaint();
    }
}
