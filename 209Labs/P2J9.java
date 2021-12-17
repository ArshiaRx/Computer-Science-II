import java.util.Arrays;

/**
 * Lab0(I) - Squaring Off
 *
 * @author (Arshia Rahim)
 * @Date: 2021-10-25
 */
public class P2J9
{
    public static boolean[] sumOfTwoDistinctSquares(int n){
        boolean[] result = new boolean[n];
        
        int i = 1;
        int j = i;
        j++;
        
        while((i * i + j * j) < n){
            result[(i * i + j * j)] = true;
            j++; 
            if ((i * i + j * j) >= n){
                i++;
                j = i + 1;
            }
        }
        return result;
    }
    public static boolean[] subtractSquare(int n){
        boolean[] result = new boolean[n];
        
        for (int i = 0; i < n;  i++){
            int next = 1;
            
            while((i - next*next) >= 0){
                if(!result [i - next * next]){
                    result[i] = true;
                    break;
                }
                next++;
            }
        }
        return result;
    }
}
