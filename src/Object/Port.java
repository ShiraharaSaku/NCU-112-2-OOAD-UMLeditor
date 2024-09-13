package Object;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

public class Port extends JComponent {
    private int edge = 10;	// Ãäªø¬°10
    private List<Line> startLineList = new ArrayList<Line>();
    private List<Line> endLineList = new ArrayList<Line>();
    private PortDirection direction;
    private BaseObject baseObject;
    

    public Port(BaseObject baseObject, PortDirection direction) {
    	this.baseObject = baseObject;
        this.direction = direction;
    	
        initialLocation();
        setSize(edge, edge);
    }    

    public void addStartLine(Line startLine) {
    	startLineList.add(startLine);
    	
    }
    public void addEndLine(Line endLine) {
    	endLineList.add(endLine);
    	
    }
    
    public void updateLineList() {
    	updateLineAttributes(startLineList);
    	updateLineAttributes(endLineList);
    }    
    
    public void updateLineAttributes(List<Line> lineList) {
    	for (Line line : lineList){
    		line.setLocation();
    		line.setSize();
    	}
    }
    
    public void movePort(int deltaX, int deltaY) {
    	super.setLocation(getX()+deltaX, getY()+deltaY);
    	updateLineList();
    }
    
    public Point getCenter() {
    	Point location = getLocation();
    	Point center = new Point();
    	center.x = location.x + edge/2;
    	center.y = location.y + edge/2;
    	return center;
    }
    
    
    public void initialLocation() {
    	int x = 0;
    	int y = 0;
    	switch(direction) {
		case N:
			x = baseObject.getX() + baseObject.getWidth()/2;
			y = baseObject.getY();
	        break;
	    case S:
			x = baseObject.getX() + baseObject.getWidth()/2;
			y = baseObject.getY() + baseObject.getHeight();
	        break;
	    case E:
			x = baseObject.getX() + baseObject.getWidth();
			y = baseObject.getY() + baseObject.getHeight()/2;
	        break;
	    case W:
			x = baseObject.getX();
			y = baseObject.getY() + baseObject.getHeight()/2;
	        break;
    	}
    	setLocation(x, y);
    }
    
    @Override
    public void setLocation(int x, int y) {
    	super.setLocation(x-edge/2, y-edge/2);
    	
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(255, 255, 255));
        g2.fillRect(0, 0, edge, edge);
    }
}
