import java.util.ArrayList;

/**
 * Lab3 - Extending An Existing Class
 *
 * @author (Arshia Rahim)
 * @Date: 2021-10-30
 */
public class AccessCountArrayList<E> extends ArrayList<E> {
    private int counter = 0;
        
    @Override
    public E get(int index) {
        counter++;
        return super.get(index);
    }
        
    @Override
    public E set(int index, E element) {
        counter++;
        return super.set(index, element);
    }
        
    public int getAccessCount() {
        return counter;
    }
        
    public void resetCount() {
        counter = 0;
    }
        
}

