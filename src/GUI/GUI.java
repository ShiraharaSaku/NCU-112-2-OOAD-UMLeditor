package GUI;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Mode.*;
import Event.*;

public class GUI {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private JFrame frame = new JFrame("UML editor");
    private JPanel panel = new JPanel();
    private Menu menuBar;
    private PanelListner panelListner = new PanelListner(panel);

    
    public void startGUI() {
    	//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createFrame();
                createButton();
                createPanel();
                createMenu();
            }
        });
    	
    }
    
    
    private void createFrame() {
        //Create and set up the window.
    	int width = 800;
        int height = 600;
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Display the window.
        frame.pack();
        frame.setLayout(null);
        frame.setVisible(true);
        
        // set size and color
        frame.setSize(width, height);
        Color background = new Color(50, 50, 50);
        frame.getContentPane().setBackground(background);
    }
 
    
    private void createPanel(){
    	// Create a JPanel to hold the objects

        int width = 650;        
        int height = 425;
        
        int x = 100;
        int y = 50;
    	
        panel.setLayout(null); // Use null layout for explicit positioning of components
        panel.setSize(width, height);
        panel.setLocation(x, y);
        panel.setBackground(new Color(30, 30, 30));

        panel.setFocusable(true);
        
        frame.getContentPane().add(panel);
		frame.add(panel);

		panel.addMouseListener(panelListner);  
		panel.addMouseMotionListener(panelListner);
    	
    }

    
    private void createButton(){
        ButtonGroup buttonGroup = new ButtonGroup() {
        	@Override
            public void setSelected(ButtonModel model, boolean selected) {
                if (selected) { super.setSelected(model, selected); } 
                else {  clearSelection(); }
            }
        };
        
        for (ModeType modeType : ModeType.values()) {
        	if (modeType == ModeType.NULL) break;
            Button button = new Button(modeType);
            frame.add(button);
            buttonGroup.add(button);
            
            button.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
            		panelListner.changeMode(modeType);
                }
            });
        }
    }

    
    private void createMenu() {
    	SelectMode selectMode = (SelectMode) (panelListner.getMode(ModeType.SELECT));
    	MenuEvent menuEvent = new MenuEvent(panel, selectMode);
    	menuBar = new Menu(menuEvent);
    	
    	frame.setJMenuBar(menuBar);
    }
    
}