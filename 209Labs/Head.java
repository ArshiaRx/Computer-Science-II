import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.MouseEvent;
import java.awt.event.*;

/**
 * Lab5 - Introduction To Swing
 *
 * @author (Arshia Rahim)
 * Date: 2021-11-28
 */

public class Head extends JPanel
{

    private boolean mouseInside;
    
    public Head()
    {
        this.setPreferredSize(new Dimension(500, 500));
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        class MyMouseListener extends MouseAdapter {
        
            @Override public void mouseEntered(MouseEvent e) {
                mouseInside = true;
                repaint();
            }
            
            @Override public void mouseExited(MouseEvent e) {
                mouseInside = false;
                repaint();
            }
        }
        this.addMouseListener(new MyMouseListener());
    }
        @Override public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //Face
        g2.setStroke(new BasicStroke(1.0f));
        Area elli = new Area(new Ellipse2D.Double(100, 50, 400, 300));
        AffineTransform trans = AffineTransform.getRotateInstance(-Math.PI / 20, 385, 120);
        elli = elli.createTransformedArea(trans);
        g2.setPaint(Color.ORANGE);
        g2.fill(elli);
        
        //EyeBrow1
        Rectangle2D.Double eyebrowOne = new Rectangle2D.Double(200, 100, 70, 10);
        g2.setPaint(Color.BLACK);
        g2.fill(eyebrowOne);
        
        //EyeBrow2
        Rectangle2D.Double eyebrowTwo = new Rectangle2D.Double(350, 100, 80, 10);
        g2.fill(eyebrowTwo);
        
        //Nose
        Area Nose = new Area(new Ellipse2D.Double(270, 180, 65, 65));
        AffineTransform transNose = AffineTransform.getRotateInstance(-Math.PI / 20, 385, 120);
        g2.setPaint(Color.GREEN);
        g2.fill(Nose);
        
        //Lips
        Area lips = new Area(new Ellipse2D.Double(220, 270, 90, 30));
        AffineTransform transLips = AffineTransform.getRotateInstance(-Math.PI / 20, 385, 120);
        g2.setPaint(Color.RED);
        g2.fill(lips);

        //Left Eye Open
        Area eyesOnOne = new Area(new Ellipse2D.Double(180, 110, 100, 50));
        AffineTransform transFour = AffineTransform.getRotateInstance(-Math.PI / 20, 385, 120);
        eyesOnOne = eyesOnOne.createTransformedArea(transFour);
        g2.setPaint(Color.WHITE);
        g2.fill(eyesOnOne);
        Shape LeftEye = new Ellipse2D.Double(220, 150, 30, 30);
        g2.setPaint(Color.BLACK);
        g2.fill(LeftEye);
        
        //Right Eye Open
        Area eyesOnTwo = new Area(new Ellipse2D.Double(330, 130, 100, 50));
        AffineTransform transFive = AffineTransform.getRotateInstance(-Math.PI / 20, 385, 120);
        eyesOnTwo = eyesOnTwo.createTransformedArea(transFive);
        g2.setPaint(Color.WHITE);
        g2.fill(eyesOnTwo);
        Shape RightEye = new Ellipse2D.Double(350, 145, 30, 30);
        g2.setPaint(Color.BLACK);
        g2.fill(RightEye);
        
        
        //Eyes Close
        if (!mouseInside) {
            //Left eye Closed
            
            Area eyesOffOne = new Area(new Ellipse2D.Double(180, 110, 100, 50));
            AffineTransform transTwo = AffineTransform.getRotateInstance(-Math.PI / 20, 385, 120);
            eyesOffOne = eyesOffOne.createTransformedArea(transTwo);
            g2.setPaint(Color.BLACK);
            g2.fill(eyesOffOne);
            
            //Right eye Closed
            
            Area eyesOffTwo = new Area(new Ellipse2D.Double(330, 130, 100, 50));
            AffineTransform transThree = AffineTransform.getRotateInstance(-Math.PI / 20, 385, 120);
            eyesOffTwo = eyesOffTwo.createTransformedArea(transThree);
            g2.fill(eyesOffTwo);
        }
    }
}


