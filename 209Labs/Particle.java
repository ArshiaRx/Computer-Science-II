import java.util.Random;

/**
 * Lab7 - Concurrency In Animation
 *
 * @author (Arshia Rahim)
 * @Date: 2021-11-27
 */

public class Particle
{
    private double x; private double y;    //Coordinates
    
    private static final Random rng = new Random();
    private static final double BUZZY = 0.7;
    
    public Particle (int width, int height){
        this.x = rng.nextInt(width);   this.y = rng.nextInt(height);   //Generate rndom int to x(width)
        //& y(heighy)
    }
    
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void move(){     
        x += rng.nextGaussian();    y += rng.nextGaussian();     //Move the particles based on axis
     }
     
}
