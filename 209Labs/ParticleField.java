import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * Lab7 - Concurrency In Animation
 *
 * @author (Arshia Rahim)
 * @Date: 2021-11-27
 */

public class ParticleField extends JPanel //exetend javax.swing.JPanel
{
    private boolean running = true;
    
    private java.util.List<Particle> particles = new java.util.ArrayList<Particle>();
    
    public ParticleField(int n, int width, int height){
        
        //set prefrerredSize for rectangle width & height
        setPreferredSize(new Dimension(width, height));
        
        //initialize n number particle and add to p list
        for (int i = 0; i < n; i++){
            Particle p_list = new Particle(width, height);
            particles.add(p_list);
        }
        
        Thread thread = new Thread (new Runnable() 
        {                              
        @Override
            public void run() {
                
                while (running){       //Run until Terminate

                    //sleeping for 20 mili Seconds
                try {
                    Thread.sleep(20);
                    } 
                catch (InterruptedException e) {
                     e.printStackTrace();
                     }
                
                for(int i = 0; i < particles.size() ; i++){
                    particles.get(i).move();
                }
                    repaint();
                }                                       
             }
        });
        thread.start();    //starting the thread
    }

    @Override
        protected void paintComponent(Graphics g) {

            for(Particle pixle : particles){
                int x = (int) pixle.getX();       int y = (int) pixle.getY();  //setting up the particle axis 
                                                                              
                g.fillRect(x, y, 3, 3);      //filled rectangle    //Draw particle 3 by 3 pixels           

            }
    }

    public void terminate(){
        running = false;    //end the animation
    }
}

