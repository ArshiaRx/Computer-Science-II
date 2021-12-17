import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Lab9 - Lissajous Curves
 *
 * @author (Arshia Rahim)
 * Date: 2021-12-04
 */
public class Lissajous extends JPanel{
    JTextField aText, bText, deltaText;
    double a;  double b;   double delta;
    int size;
    
    public Lissajous(int size){
        setPreferredSize(new Dimension(size, size));
        this.size = size;
        
        aText = new JTextField(5);
        aText.setText("6");
        
        bText = new JTextField(5);
        bText.setText("5");
        
        deltaText = new JTextField(5);   //JTestField (Space size)
        deltaText.setText("0.4");
        
        add(new JLabel("a: "));
        add(aText);
        
        add(new JLabel("b: "));
        add(bText);
        
        add(new JLabel("delta: "));
        add(deltaText);
        
        aText.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent a){
                repaint();
            }
        });
        
        bText.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent b){ 
                repaint();
            }
        });        

        deltaText.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent delta){ 
                repaint();
            }
        }); 
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        //parseDouble = initialize new double initialized to the value that is specified by String
            a = Double.parseDouble(aText.getText());
            b = Double.parseDouble(bText.getText());
            delta = Double.parseDouble(deltaText.getText());
     
        double currentX = 0;
        double currentY = 0;
        
        for (double t = 0; t <= (a + b) * Math.PI ; t += 0.01){  //smallest increment 0.01
            double newX = size/2 + (2 * size/5) * Math.sin(a * t + delta);
            double newY = size/2 + (2 * size/5) * Math.cos(b * t);
            
            int x1 = (int) currentX;
            int y1 = (int) currentY;
            int x2 = (int) newX;
            int y2 = (int) newY;
            
            g.drawLine(x1,y1, x2,y2);
            currentX = newX;
            currentY = newY;
        }       
    }  
}