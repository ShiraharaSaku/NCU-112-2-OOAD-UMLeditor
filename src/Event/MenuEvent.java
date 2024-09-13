package Event;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Mode.SelectMode;
import Object.CompositeObject;
import Object.ShapeObject;

public class MenuEvent {

	public SelectMode selectMode;
    private JPanel panel;
    
    public MenuEvent(JPanel panel, SelectMode selectMode) {
        this.panel = panel;
        this.selectMode = selectMode;
    }

	public void groupObjects() {

		List<ShapeObject> selectList = new ArrayList<ShapeObject>();
		if (selectMode.isChosen()) {
			selectList = selectMode.getSelectList();
		}
		
		if (selectList.size()>1) {
			List<ShapeObject> objectList = selectMode.getObjectList();
			CompositeObject group = new CompositeObject(selectList);
			
	        for (ShapeObject obj : selectList) {
	            objectList.remove(obj);
	        }
            selectMode.removeSelect();
            objectList.add(group);
    		panel.add(group);
    		panel.repaint();
		}
		
    }

	public void UnGroupObjects() {
		List<ShapeObject> selectList = new ArrayList<ShapeObject>();
		if (selectMode.isChosen()) {
			selectList = selectMode.getSelectList();
		}
		
		if (selectList.size() == 1) {
			List<ShapeObject> objectList = selectMode.getObjectList();
			
			ShapeObject obj = selectList.get(0);
        	obj.unGroup(objectList, panel);
        	
            selectMode.removeSelect();
    		panel.repaint();
		}
		
		/* 多個 composite 物件可以一起 unGroup
		if (!selectList.isEmpty()) {
			List<ShapeObject> objectList = selectMode.getObjectList();
			
	        for (ShapeObject obj : selectList) {
	        	obj.unGroup(objectList, panel);
	        }
            selectMode.removeSelect();
    		panel.repaint();
		}
		*/
    }

	public void changeObjectName() {
		List<ShapeObject> selectList = new ArrayList<ShapeObject>();
		if (selectMode.isChosen()) {
			selectList = selectMode.getSelectList();
		}
		
		if (selectList.size() == 1) {
			ShapeObject obj = selectList.get(0);
			changeNameDialog(obj);
		}
    }
	
	// 創建對話框
	public void changeNameDialog(ShapeObject obj) {
	    JDialog dialog = new JDialog();
	    JPanel panel = new JPanel();
	    dialog.setTitle("Change Object Name");
	    dialog.setLocation(200, 200);
	    
	    JTextField textField = new JTextField(obj.getName(), 20);
	    JButton okButton = new JButton("OK");
	    JButton cancelButton = new JButton("Cancel");

	    okButton.addActionListener(e -> {
	        String newName = textField.getText();
	        obj.setName(newName);
	        dialog.dispose();
	    });

	    cancelButton.addActionListener(e -> {
	        dialog.dispose();
	    });

	    panel.add(textField);
	    panel.add(okButton);
	    panel.add(cancelButton);
	    dialog.add(panel);
	    dialog.pack();
	    dialog.setVisible(true);
    }
}
