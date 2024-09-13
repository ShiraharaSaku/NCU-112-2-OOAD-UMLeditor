package Object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;


public class AssociationLine extends Line{
    public AssociationLine(Port startPort, Port endPort) {
    	super(startPort, endPort);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(new Color(255, 255, 255));
     
        int arrowEdge = 10;
        
        Point startPoint = startPort.getCenter();
        Point endPoint = endPort.getCenter();
        int startX = startPoint.x - getX();
        int startY = startPoint.y - getY();
        int endX = endPoint.x - getX();
        int endY = endPoint.y - getY();
        
        g2.drawLine(startX, startY, endX, endY);
        
        double lineAngle = Math.atan2(endY - startY, endX - startX);
        double arrowAngle = Math.PI / 4;  // 45«×
        int p1X = (int) (endX - arrowEdge * Math.cos(lineAngle - arrowAngle));
        int p1Y = (int) (endY - arrowEdge * Math.sin(lineAngle - arrowAngle));
        int p2X = (int) (endX - arrowEdge * Math.cos(lineAngle + arrowAngle));
        int p2Y = (int) (endY - arrowEdge * Math.sin(lineAngle + arrowAngle));
        
        g2.drawLine(endX, endY, p1X, p1Y);
        g2.drawLine(endX, endY, p2X, p2Y);
    }
}
