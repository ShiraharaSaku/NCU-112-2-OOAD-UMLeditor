package Mode;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Object.ShapeObject;
import Object.SelectArea;


public class SelectMode extends Mode{
    private List<ShapeObject> selectObjects = new ArrayList<ShapeObject>();
    
    SelectArea currentSelectArea = null;
    
	int previousMouseX;
    int previousMouseY;	
    
    int selectAreaStartX;
    int selectAreaStartY;


	public SelectMode(JPanel panel, List<ShapeObject> objectList) {
		super(panel, objectList);
	}
	
	public void mouseClicked(MouseEvent e) {        
		removeSelect();
		int mouseX = e.getX();
        int mouseY = e.getY();
        selectSingleObject(mouseX, mouseY);
        panel.repaint();
    }


    public void mousePressed(MouseEvent e) {        
		removeSelect();
        int mouseX = e.getX();
        int mouseY = e.getY();
    	selectAreaStartX = mouseX;
    	selectAreaStartY = mouseY;
    	previousMouseX = mouseX;
        previousMouseY = mouseY;
        selectSingleObject(mouseX, mouseY);
        panel.repaint();
    }

    public void mouseReleased(MouseEvent e) {
        if (currentSelectArea != null) {
        	selectGroupObject();
        	
        	panel.remove(currentSelectArea);
        	currentSelectArea = null;
            panel.repaint();
        }
    }
    
    public void mouseDragged(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        
        // 有選取物體，拖移物體
        if (selectObjects.size() != 0) {
            int deltaX = mouseX - previousMouseX;
            int deltaY = mouseY - previousMouseY;
            
            for (ShapeObject selectObject : selectObjects) {
            	selectObject.moveObject(deltaX, deltaY);
            }
            
            previousMouseX = mouseX;
            previousMouseY = mouseY;
        }
        // 沒選取物體，創建選取區域
        else {
        	if (currentSelectArea != null) {
        		currentSelectArea.setArea(selectAreaStartX, selectAreaStartY, mouseX, mouseY);
	        }
        	else {
                currentSelectArea = new SelectArea(selectAreaStartX, selectAreaStartY, mouseX, mouseY);
                panel.add(currentSelectArea);
        	}
        }

        panel.repaint();
    }
    
    
    public void selectSingleObject(int mouseX, int mouseY) {
        for (int i = objectList.size()-1; i>=0; i--) {
            ShapeObject obj = objectList.get(i);
            if (obj.isMouseInside(mouseX, mouseY)) {
    	        selectObjects.add(obj);
    	        obj.displayPorts(panel);
            	break;
            }
        }
        
    }
    
    public void selectGroupObject() {
        for (int i = objectList.size()-1; i>=0; i--) {
        	ShapeObject obj = objectList.get(i);
            if (currentSelectArea.isObjectInside(obj)) {
            	selectObjects.add(obj);
            	obj.displayPorts(panel);
            }
        }
    }
    
    public void removeSelect() {
    	// 解除選取物件並移除 port 的顯示
		for (int i = selectObjects.size()-1; i>=0; i--) {
			ShapeObject selectObject = selectObjects.get(i);
			selectObject.undisplayPorts(panel);
    		selectObjects.remove(selectObject);
		}
    }
    
    public List<ShapeObject> getSelectList(){
    	return selectObjects;
    }
    
    @Override
    public void changeChosenState(boolean isChosen) {
    	this.isChosen = isChosen;
    	removeSelect();
    }
}
