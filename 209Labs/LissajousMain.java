import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

/**
 * Lab9 - Lissajous Curves
 *
 * @author (Arshia Rahim)
 * Date: 2021-12-04
 */
public class LissajousMain
{
    public static void main(String[] args){
        JFrame frame = new JFrame("Lissajous Demo");  //name of Jframe  (Heading)
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //Close operation on close
        frame.setLayout(new FlowLayout());
        frame.add(new Lissajous(500));   //Size of the frame Lissajous
        frame.pack();
        frame.setVisible(true);   //make it visible
    }
    
}
