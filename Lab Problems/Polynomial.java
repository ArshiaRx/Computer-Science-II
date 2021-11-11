import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Lab1 - Polynomial 1: Basics
 *
 * @author (Arshia Rahim)
 * @Date: 2021-10-27
 */

public class Polynomial implements Comparable<Polynomial> {
    public Polynomial(int[] coefficients)
    {   
        if (coefficients.length == 1) {
            this.co = coefficients.clone();
            this.deg = 0;
        } else {
            int temp = 0;
            for (int i = 0; i < coefficients.length; i ++) {
                if (coefficients[i] != 0) {
                    temp = i;
                }
            }
            this.deg = temp;
            int[] update = new int[deg + 1];
            for (int i = 0; i < coefficients.length; i++) {
                if (i <= deg) {
                    update[i] = coefficients[i];
                }
            }   
            this.co = update.clone();
        }
    }
    private final int[] co;
    private final int deg;
    
    public int getDegree() {
        return deg;
    }
    
    public int getCoefficient(int k) {
        if (k > deg) {
            return 0;
        }
        return co[k];
    }
    
    private long exponent(int num, int pow) {
        long res = num;
        while (pow > 1) {
            res *= num;
            pow--;
        }
        return res;
    }
    
    public Polynomial add(Polynomial other) {
        int[] arr = new int[Math.max(this.deg, other.deg) + 1];
        
        for (int i = 0; i <= this.deg; i++) {
            arr[i] = this.co[i];
        }
        
        for (int j = 0; j <= other.deg; j++) {
            arr[j] += other.co[j];
        }
        
        return new Polynomial(arr);
    }
    public Polynomial multiply(Polynomial other) {
        int[] arr = new int[(this.deg + other.deg) + 1];
        
        int big = Math.max(this.deg, other.deg);
        int small;
        int[] small_arr;
        int[] big_arr;
        if (big == this.deg) {
            big_arr = this.co;
            small_arr = other.co;
            small = other.deg;
        } else {
            big_arr = other.co;
            small_arr = this.co;
            small = this.deg;
        }

        for (int i = 0; i <= big; i++) {
            for (int j = 0; j <= small; j++) {
                arr[i + j] += big_arr[i] * small_arr[j];
            }
        }
        return new Polynomial(arr);
    }
    
    /**
     * Constructor for objects of class Polynomial
    */
    public int compareTo(Polynomial other) {
        int degreeA = this.getDegree();
        int degreeB = other.getDegree();
        int result = 0;
        
        if (degreeA == degreeB) {
             
            while(degreeA > -1 && result == 0) {
                int coeffA = this.getCoefficient(degreeA);
                int coeffB = other.getCoefficient(degreeA);
                int diff = coeffA - coeffB;
                if (diff != 0) {
                    if (coeffA > coeffB) {
                        result = 1;
                        return result;
                    } else {
                        result = -1;
                        return result;
                    }
                }
                degreeA--;
            }
            
        } else {
            if (degreeA > degreeB) {
                result = 1;
            } else {
                result = -1;
            }
        }
        return result;
    }
    
    @Override public boolean equals(Object other) {
        
        if (other instanceof Polynomial) {
            int result = this.compareTo((Polynomial) other);
            if (result == 0) {
                return true;
            }
        }
        return false;
    }
    
    @Override public int hashCode() {
        return Arrays.hashCode(Arrays.copyOf(co, deg));
    }
    
    @Override public String toString() {
        System.out.println(this.co.toString());
        return "hi";
    }
    
    public long evaluate(int x) {
        if (co.length == 1) {
            return co[0];
        }
        long result = co[0];
        
        for (int i = 1; i < co.length; i ++) {
            result = result + co[i] * exponent(x, i); 
        }
        return result;
    }
}
