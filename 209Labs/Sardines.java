
/**
 * Lab33 - Sardine Array
 *
 * @Name: Arshia Rahim
 * @Date: 2021-11-01
 */
public class Sardines
{
    private boolean[] data;
    private int k;
 
    public Sardines(int n, int k) {
        int matrix = n * k;
        
        if((n < 0) || (matrix / n != k) || (k < 0) || (k > 31)) {
            throw new IllegalArgumentException();
        }
        
        data = new boolean[matrix];
        this.k = k;
    }
    
    public void set(int idx, int v) {
        if (idx < 0 || idx >= data.length / k) {
            throw new ArrayIndexOutOfBoundsException();
        }
        
        if (v < 0 || ((int)Math.pow(2, k) - 1 < v)) {
            throw new IllegalArgumentException();
        }    
        int offset = k * idx;
        
        for (int i = 0; i < k; i++) {
            if ((v & 0x1) == 1) {
                data[offset + i] = true;  
            } else {
                data[offset + i] = false;
            }
            v >>>= 1; 
        }
    }
    
    public int get(int idx) {
        if (idx < 0 || idx >= data.length / k) {
            throw new ArrayIndexOutOfBoundsException();
        }
        
        int result = 0;
        int OFF_set = k * idx;
        
        for (int j = k - 1; j >= 0; j--) {
            result <<= 1;
            
            if (data[OFF_set + j] == true) {
                result |= 0x1;
            }
        }
        return result;
    } 
    
}
