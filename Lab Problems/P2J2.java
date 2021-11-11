import java.util.LinkedList;
import java.util.HashSet;

/**
 * Lab0(B) - Duplication
 * 
 *  @author (Arshia Rahim)
 *  @Date: 2021-10-18
 */
class P2J2 {

    public static String removeDuplicates(String text) {
        // THIS CODE WORKS
        StringBuilder removeDuplicate = new StringBuilder("");
        for (int i = 0; i < text.length(); i++){
            char element = text.charAt(i);
            if (i == 0){
                removeDuplicate.append(element);
            }
            if (i > 0 && text.charAt(i - 1) != element){
                removeDuplicate.append(element);
            }
        }
        return removeDuplicate.toString();    
    }

    public static String uniqueCharacters(String text) {
        // THIS CODE WORKS
        String unique_String = "";
        HashSet<Character> check = new HashSet();
        
        for (int i = 0; i < text.length(); i++) {
            char element = text.charAt(i);
            
            if (!check.contains(element)) {
                check.add(element);
                unique_String += Character.toString(element);
            }
        }
        return unique_String;
    }

    public static int countSafeSquaresRooks(int n, boolean[][] rooks) {
        // THIS CODE WORKS
        int[] Rows = new int[n];
        int[] Coloumns = new int[n];
        
        for (int i = 0; i < n; i++){
            Coloumns[i] = 0;
            Rows[i] = 0;
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (rooks[i][j] == true){
                    Coloumns[j] = 1;
                    Rows[i] = 1;
                }
            }
        }
        int Safe_Coloumns = 0; int Safe_Rows = 0;
        for (int i = 0; i < n; i++){
            if (Coloumns[i] == 0){
                Safe_Coloumns++;
            }
            if (Rows[i] == 0){
                Safe_Rows++;
            }
        }
        
        return Safe_Rows * Safe_Coloumns;
    }

    public static int recaman(int n) {
        // THIS CODE WORKS
        int[] recamanSequence = new int[n * 10];
        recamanSequence[0] = 0;
        
        boolean[] first_Value = new boolean[n * 10];
        first_Value[0] = true;
        for (int i = 1; i <= n; i++) {
            int Backward_Value = recamanSequence[i - 1] - i;
            int Forward_Value = recamanSequence[i - 1] + i;
            if ((Backward_Value > 0) && (!first_Value[Backward_Value])) {
                recamanSequence[i] = Backward_Value;
                first_Value[Backward_Value] = true;
            } else {
                recamanSequence[i] = Forward_Value;
               first_Value[Forward_Value] = true;
            }
        }
        return recamanSequence[n];
    }
}
