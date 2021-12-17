import java.util.*;
import java.math.BigInteger;

/**
 * Lab0(E) - All Integers Great And Small
 *
 * @author (Arshia Rahim)
 * Date: 2021-12-08
 */

public class P2J5
{

    public static List<BigInteger> fibonacciSum(BigInteger n)
    {   
        BigInteger Num_zero = BigInteger.valueOf(0);
        List<BigInteger> Result = new ArrayList<>();
        
        while (n.compareTo(Num_zero) == 1) { 
           
            BigInteger f = nearestSmallerEqFibonacciSum(n); 

            Result.add(f);

            n = n.subtract(f);
        } 
        return Result;
    }
    public static BigInteger nearestSmallerEqFibonacciSum(BigInteger n) 
    { 
        BigInteger Num_zero = BigInteger.valueOf(0);
        BigInteger Num_one = BigInteger.valueOf(1);
        
        if (n.compareTo(Num_zero) == 0 || n.compareTo(Num_one) == 0){
            return n;
        }
        
        BigInteger f0 = BigInteger.valueOf(0);
        BigInteger f1 = BigInteger.valueOf(1);
        BigInteger f2 = BigInteger.valueOf(1);
        
        while ((f2.compareTo(n) == 0) || (f2.compareTo(n) == -1)){
            f0 = f1;
            f1 = f2;
            f2 = f0.add(f1);
        } 
        return f1; 
    }
    public static BigInteger sevenZero(int n){
        BigInteger User_input = new BigInteger(Integer.toString(n));
        
        BigInteger Num_zero = BigInteger.valueOf(0);
        BigInteger Num_seven = BigInteger.valueOf(7);   
        BigInteger Num_ten = BigInteger.valueOf(10);
        
        BigInteger result = new BigInteger("7");
        int start = 1;
        
        while(result.mod(User_input) != Num_zero){ 
            
            result = Num_seven.multiply(Num_ten.pow(start));
            start++;

            if(result.mod(User_input) == Num_zero){
                    return result;
                }
            
            for(int i = 0; i < start - 1; i++){
                result = result.add(Num_seven.multiply(Num_ten.pow(i)));

            }
            
            for(int i = 0; i < start - 1 ; i++){
                 if(result.mod(User_input) == Num_zero){
                    return result;
                }
                result = result.subtract(Num_seven.multiply(Num_ten.pow(i)));
            }
        }
        return result;
    }
}
