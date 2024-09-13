package GUI;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Event.MenuEvent;

public class Menu extends JMenuBar{
    private MenuEvent menuEvent;
    
    public Menu(MenuEvent menuEvent) {
        this.menuEvent = menuEvent;
        createMenu();
    }


	private void createMenu() {
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        
        Color barColor = new Color(200, 200, 200);
        
        this.setBackground(barColor); 

        this.add(fileMenu);
        this.add(editMenu);
        editMenu.add(createGroup());
        editMenu.add(createUnGroup());
        editMenu.add(createChangeName());
    }
	
	private JMenuItem createGroup() {
        JMenuItem groupItem = new JMenuItem("Group");
        
        groupItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	menuEvent.groupObjects();
            }
        });
        return groupItem;
    }
	
	private JMenuItem createUnGroup() {
        JMenuItem ungroupItem = new JMenuItem("UnGroup");
        
        ungroupItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	menuEvent.UnGroupObjects();
            }
        });
        return ungroupItem;
    }
	
	private JMenuItem createChangeName() {
        JMenuItem changeNameItem = new JMenuItem("Change Object Name");
        
        changeNameItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	menuEvent.changeObjectName();
            }
        });
        return changeNameItem;
    }

	
}
