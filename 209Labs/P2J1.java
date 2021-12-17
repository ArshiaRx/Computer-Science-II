
/**
 * Lab0(A) - Plain Old Integers
 *
 * @author (Arshia Rahim)
 * @Date 2021-10-05
 */
public class P2J1
{
    public static long fallingPower(int n, int k)
    {
        //ouput = power
        //n = base
        //repeat untill i reaches k --> (int i = 0; i < k; i++)
        //In python is known as: (n**output) OR (n ** output) 
        
        long output = 1;
        for (int i = 0; i < k;  i++)      
        {                                 
            output *= n;                  
            --n; 
        }
        return output;
    }
    
    public static int[] everyOther(int[] arr)
    {
        int[] result = new int[arr.length / 2 + arr.length % 2];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[2 * i];
        }
        return result;
    }
    
    public static int[][] createZigZag(int rows, int cols, int start)
    {
        int[][] output = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++){
                    output[i][j] = start;
                    start += 1;
                }
            }
            else
            {
                for (int j = cols - 1; j >= 0; j--){
                    output[i][j] = start;
                    start += 1;
                }
            }
        }
        return output;
    }
    
    public static int countInversions(int[] arr)
    {
        int count = 0;
            for(int i = 0; i < arr.length; i++){
            
            for(int j = i+1; j < arr.length; j++){ // start at +1 of i to go through the rest of the array after i 
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
