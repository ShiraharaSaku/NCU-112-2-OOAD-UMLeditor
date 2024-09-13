package Event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Mode.*;
import Object.ShapeObject;

public class PanelListner implements MouseListener, MouseMotionListener{
	
	private JPanel panel;
    private Mode currentMode = new Mode();
    private List<ShapeObject> objectList = new ArrayList<ShapeObject>();
    private List<Mode> modeList = new ArrayList<Mode>();

	public PanelListner() {
		createMode();
	}
	
	public PanelListner(JPanel panel) {
		this.panel = panel;
		createMode();
	}
	
	public void mouseClicked(MouseEvent e) {
		currentMode.mouseClicked(e);
    }

    public void mouseEntered(MouseEvent e) {
    	currentMode.mouseEntered(e);
    }

    public void mouseExited(MouseEvent e) {
    	currentMode.mouseExited(e);
    }

    public void mousePressed(MouseEvent e) {
		currentMode.mousePressed(e);
    }

    public void mouseReleased(MouseEvent e) {
		currentMode.mouseReleased(e);
    }
    
    public void mouseDragged(MouseEvent e) {
		currentMode.mouseDragged(e);
    }
    
    public void mouseMoved(MouseEvent e) {
		currentMode.mouseMoved(e);
    }

    private void createMode() {
    	modeList.add(new SelectMode(panel, objectList));
    	modeList.add(new AssociationMode(panel, objectList));
    	modeList.add(new GeneralizationMode(panel, objectList));
    	modeList.add(new CompositionMode(panel, objectList));
    	modeList.add(new ClassMode(panel, objectList));
    	modeList.add(new UseCaseMode(panel, objectList));
    	modeList.add(new Mode());
    }
    public Mode getMode(ModeType modeType){
    	return modeList.get(modeType.ordinal());
    }
    
    public void changeMode(ModeType modeType){
    	Mode newMode = getMode(modeType);
    	currentMode.changeChosenState(false);
    	if (currentMode != newMode) {
        	currentMode = newMode;
        	currentMode.changeChosenState(true);
    	}
    	else {
    		currentMode = getMode(ModeType.NULL);
    	}
    }
}
