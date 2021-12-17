import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Lab7 - Concurrency In Animation
 *
 * @author (Arshia Rahim)
 * Date: 2021-11-27
 */

public class ParticleMain {
    public static void main(String[] args) {
    
    JFrame frame = new JFrame();   //Create a frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //close the operation when exit windows
                                                                //add new ParticleField
    final ParticleField particleField = new ParticleField(2000, 800, 800);  
    frame.add(particleField);

    //Registering windowlistener is setting the property of the windows action
    
    frame.addWindowListener(new WindowListener() { 
    @Override
           public void windowOpened(WindowEvent arg0) {
            }

    @Override
          public void windowIconified(WindowEvent arg0) {
          }

    @Override
          public void windowDeiconified(WindowEvent arg0) {
          }

    @Override
          public void windowDeactivated(WindowEvent arg0) {

          }

    @Override
          public void windowClosing(WindowEvent arg0) {   //terminate when widows close
             particleField.terminate();
          }

    @Override
         public void windowClosed(WindowEvent arg0) {
          }

    @Override
         public void windowActivated(WindowEvent arg0) {
          }
    });
    frame.pack();
    frame.setVisible(true);
    }
}
