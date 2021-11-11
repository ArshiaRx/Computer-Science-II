import java.math.BigInteger;

/**
 * Lab0(H) - More Integers Great And Small
 *
 * @author (Arshia Rahim)
 * Date: 2021-10-25
 */
public class P2J8
{
    public static void hittingIntegerPowers(int a, int b, int t, int[] out){
     BigInteger num1 = new BigInteger(a + "");
     BigInteger num2 = new BigInteger(b + "");
     
     BigInteger a_multiply = new BigInteger(a + "");
     BigInteger b_multiply = new BigInteger(b + "");
     BigInteger t_multiply = new BigInteger(t + "");
     
     int pa = 1; int pb = 1;
     boolean expect = true;
     while (expect) {
         BigInteger diff = num1.subtract(num2).abs().multiply(t_multiply);
         
         if(diff.compareTo(num1) <= 0 || diff.compareTo(num2) <= 0) {
             out[0] = pa; out[1] = pb;
             break;
         }
         if (num1.compareTo(num2) <= 0){
             num1 = num1.multiply(a_multiply);
             pa++;
         }
         else {
             num2 = num2.multiply(b_multiply);
             pb++;
         }
     }
    }
    static BigInteger sequence(BigInteger i, int s){
        BigInteger solution = i.multiply(i);
        BigInteger second_solution = i.multiply(BigInteger.valueOf(s - 4));
        
        solution = solution.multiply(BigInteger.valueOf(s - 2));
        return (solution.subtract(second_solution)).divide(BigInteger.valueOf(2));
    }
    public static BigInteger nearestPolygonalNumber(BigInteger n, int s){
        BigInteger Value_one = BigInteger.valueOf(1);
        BigInteger Value_two = BigInteger.valueOf(2);
        BigInteger multiply_ten = BigInteger.valueOf(10);
        
        BigInteger b = BigInteger.valueOf(1);
        BigInteger a = b.divide(multiply_ten);
        
        while (sequence(b, s).compareTo(n) == -1){
            b = b.multiply(multiply_ten);
        }
        while (a.compareTo(b) < 0){
            BigInteger middle = a.add(b).divide(Value_two);
            BigInteger mid_value = sequence(middle, s);
                        
            if (mid_value.compareTo(n) == 0){
                return mid_value;
            }
            if (mid_value.compareTo(n) == 1){
                b = middle;
            }
            else {
                a = middle.add(Value_one);
            }
        }
        if (a.compareTo(b) == 0){
            a = a.subtract(Value_one);
        }
        BigInteger firstDiff = n.subtract(sequence(a, s)).abs();
        BigInteger secondDiff = n.subtract(sequence(b, s)).abs();
        
        if (firstDiff.compareTo(secondDiff) <= 0){
            return sequence(a, s);
        }
        else{
            return sequence(b, s);
        }
    }
}
