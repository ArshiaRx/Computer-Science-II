import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Lab0(F): Two Branching Recursions
 *
 * @author (Arshia Rahim)
 * Date: 2021-12-11
 */

public class P2J6
{
    
    public static List<Integer> sumOfDistinctCubes(int n){
        int maxValue_possible = (int) Math.cbrt(n);   //Math.cbrt: returns the cuberoot of n (usually
        //Math.cbrt used for double but since it is initialized as int, it works for n which is int)
        
        for (int i = maxValue_possible + 1; i > 0; i--) {
          LinkedList<Integer> all_element = new LinkedList<>();
          boolean vertify = sumOfDistinctCubes(n, i, all_element);
          if (vertify) {
            return all_element;
          }
        }
        return new LinkedList<>();
        }
        //lets say n is 3,
        //maxValue_possible = 3^3 = 27
        //i = 27 + 1;  i > 0; i--
        //i = 28,  i-- = 27
        //if vertify, succcessful add to linkedlist
    private static boolean sumOfDistinctCubes(int n, int c, LinkedList<Integer> soFar) {
        if (n < 0) {
          return false;
        }
        if (n == 0) {
          return true;
        }
        if (n == 1) {
          soFar.add(1);
          return true;
        }
        soFar.add(c);
        for (int i = c - 1; i > 0; i--) {
          if (sumOfDistinctCubes(n - c * c * c, i, soFar)) 
              return true;
        }       
        soFar.remove(soFar.size() - 1);
        return false;
      }

    public static List<String> forbiddenSubstrings(String alphabet, int n, List<String> tabu){
        
          ArrayList<String> res = new ArrayList<String>();
          forbiddenSubstrings(alphabet, n, tabu, "", res);
          return res;
    }
    
    private static void forbiddenSubstrings(String alphabet, int n,
    List<String> tabu, String soFar, List<String> result){
        
          for (int e = 0; e < tabu.size(); e++) {
            if (soFar.endsWith(tabu.get(e))) {
                  return;
            }
          }
          if (soFar.length() == n) {
                result.add(soFar);
          } 
          else {
                for (int e = 0; e < alphabet.length(); e++) {
                      char C = alphabet.charAt(e);
                      forbiddenSubstrings(alphabet, n, tabu, soFar + C, result);
                }
          }
    }
}

