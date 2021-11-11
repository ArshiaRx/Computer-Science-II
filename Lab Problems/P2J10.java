public class P2J10
{   
    private static int[][] getNum(boolean[] v1, boolean[] v2){
        int[][] array = new int[2][2];
        array[0][0] = 0;
        array[0][1] = 0;
        array[1][0] = 0;
        array[1][1] = 0;

        for (int i = 0; i <v1.length; i++){
            if(v1[i] == false && v2[i] == false){
                array[0][0] += 1;
            }else if(v1[i] == false && v2[i] == true){
                array[0][1] += 1;
            }else if(v1[i] == true && v2[i] == false){
                array[1][0] += 1;
            }else{
                array[1][1] += 1;
            }
        }

        return array;
    }
    
    
    public static Fraction matchingDissimilarity(boolean[] v1, boolean[] v2) {
        int[][] num = getNum(v1, v2);
        int num1 = num[1][0] + num[0][1];
        int denom = v1.length;
        return new Fraction(num1, denom);
    }
    
    public static Fraction jaccardDissimilarity(boolean[] v1, boolean[] v2){
        int[][] num = getNum(v1, v2);
        int num1 = num[1][0] + num[0][1];
        int denom = num[1][1] +  num[1][0] + num[0][1];
        return new Fraction(num1, denom);

    }
    
    public static Fraction diceDissimilarity(boolean[] v1, boolean[] v2){
        int[][] num = getNum(v1, v2);
        int num1 = num[1][0] + num[0][1];
        int denom = 2 * num[1][1] +  num[1][0] + num[0][1];
        return new Fraction(num1, denom);
    }
    
    public static Fraction rogersTanimonoDissimilarity(boolean[] v1, boolean[] v2){
        int[][] num = getNum(v1, v2);
        int num1 = 2 * (num[0][1] + num[1][0]);
        int denom = num[1][1] + num[0][0] +  2 * (num[0][1] + num[1][0]);
        return new Fraction(num1, denom);
    }
    
    public static Fraction russellRaoDissimilarity(boolean[] v1, boolean[] v2){
        int[][] num = getNum(v1, v2);
        int num1 = num[0][0] + num[0][1] + num[1][0];
        int denom = v1.length;
        return new Fraction(num1, denom);
    }
    
    public static Fraction sokalSneathDissimilarity(boolean[] v1, boolean[] v2) {
        int[][] num = getNum(v1, v2);
        int num1 = 2 * (num[1][0] + num[0][1]);
        int denom = num[1][1] + 2 * (num[1][0] + num[0][1]);
        return new Fraction(num1, denom);
    }

}