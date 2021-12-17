import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Lab1 - Polynomial I: Basics;  Lab2 - Polynomial II: Arithmetic; Lab4: Polynomial III: Comparisons
 *
 * @author (Arshia Rahim)
 * @Date: 2021-10-27
 */

public class Polynomial implements Comparable<Polynomial> {
    public Polynomial(int[] coefficients)
    {   
        if (coefficients.length == 1) {
            this.H2O = coefficients.clone();
            this.degree = 0;
        } else {
            int temp = 0;
            for (int i = 0; i < coefficients.length; i ++) {
                if (coefficients[i] != 0) {
                    temp = i;
                }
            }
            this.degree = temp;
            int[] update = new int[degree + 1];
            for (int i = 0; i < coefficients.length; i++) {
                if (i <= degree) {
                    update[i] = coefficients[i];
                }
            }   
            this.H2O = update.clone();
        }
    }
    private final int[] H2O;
    private final int degree;
    
    public int getDegree() {
        return degree;
    }
    
    public int getCoefficient(int k) {
        if (k > degree) {
            return 0;
        }
        return H2O[k];
    }
    
    private long exponent(int num, int pow) {
        long result = num;
        while (pow > 1) {
            result *= num;
            pow--;
        }
        return result;
    }
    
    //Lab2: Polynomial II: Arithmetic
    public Polynomial add(Polynomial other) {
        int[] arr = new int[Math.max(this.degree, other.degree) + 1];
        
        for (int i = 0; i <= this.degree; i++) {
            arr[i] = this.H2O[i];
        }
        
        for (int j = 0; j <= other.degree; j++) {
            arr[j] += other.H2O[j];
        }
        
        return new Polynomial(arr);
    }
    public Polynomial multiply(Polynomial other) {
        int[] arr = new int[(this.degree + other.degree) + 1];
        
        int big = Math.max(this.degree, other.degree);
        int small;
        int[] small_Array; int[] big_Array;
        if (big == this.degree) {
            big_Array = this.H2O;
            small_Array = other.H2O;
            small = other.degree;
        } else {
            big_Array = other.H2O;
            small_Array = this.H2O;
            small = this.degree;
        }

        for (int i = 0; i <= big; i++) {
            for (int j = 0; j <= small; j++) {
                arr[i + j] += big_Array[i] * small_Array[j];
            }
        }
        return new Polynomial(arr);
    }
    
    //Construct For object Class
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
    
    //Lab4: Polynomial III: Comparisons
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
        return Arrays.hashCode(Arrays.copyOf(H2O, degree));
    }
    
    @Override public String toString() {
        System.out.println(this.H2O.toString());
        return "Welcome To CCPS209";
    }
    
    public long evaluate(int x) {
        if (H2O.length == 1) {
            return H2O[0];
        }
        long result = H2O[0];
        
        for (int i = 1; i < H2O.length; i ++) {
            result = result + H2O[i] * exponent(x, i); 
        }
        return result;
    }
}
