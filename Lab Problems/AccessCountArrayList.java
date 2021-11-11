import java.util.ArrayList;

/**
 * Lab3 - Extending An Existing Class
 *
 * @author (Arshia Rahim)
 * @Date: 2021-10-30
 */
public class AccessCountArrayList<E> extends ArrayList<E> {
    private int count = 0;
        
    @Override
    public E get(int index) {
        count++;
        return super.get(index);
    }
        
    @Override
    public E set(int index, E element) {
        count++;
        return super.set(index, element);
    }
        
    public int getAccessCount() {
        return count;
    }
        
    public void resetCount() {
        count = 0;
    }
        
}

