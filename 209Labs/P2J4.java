import java.util.*;
import java.lang.Math;

/**
 * Lab0(D) - Lists Of Integers
 *
 * @author (Arshia Rahim)
 * @Date: 2021-10-24
 */
public class P2J4
{
    public static List<Integer> runningMedianOfThree(List<Integer> items){
        int i;
        if (items.size() == 0 || items.size() == 1){
            return items;
        }
        List<Integer> new_List = new ArrayList<>();
        new_List.add(0, items.get(0));  
        new_List.add(1, items.get(1));
        
        for (i = 2; i < items.size(); i++){
            List<Integer> sub_list = new ArrayList<>();
            sub_list.add(items.get(i));
            sub_list.add(items.get(i - 1));
            sub_list.add(items.get(i - 2));
            
            Collections.sort(sub_list);
            new_List.add(i, sub_list.get(1));
        }
        return new_List;
    }
    public static int firstMissingPositive(List<Integer> items){
        for (int i = 1; i < items.size() + 3; i++){
            if (!items.contains(i)){
                return i;
            }
        }
        return 1;
    }
    public static void sortByElementFrequency(List<Integer> items){
       final Map<Integer, Integer> frequent = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < items.size(); i++) { 
            if (frequent.containsKey(items.get(i))) {
                frequent.put(items.get(i), frequent.get(items.get(i)) + 1);
            } else {
                frequent.put(items.get(i), 1);
            }
        }
        
        Collections.sort(items, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                int diff_int = frequent.get(n2) - frequent.get(n1);
                
                if (diff_int == 0) {
                    return n1.compareTo(n2);
                }
                
                return diff_int;
            }
        });
    }
    public static List<Integer> factorFactorial(int n){
        List<Integer> factorial_list = new ArrayList<>();
        
        if (n == 0 || n == 1){
            return factorial_list;
        }
        for (int i = 2; i <= n; i++){
            int element = i;
            for  (int j = 2 ; j <= element; j++){
                if (element % j == 0){
                    factorial_list.add(j);
                    element /= j;
                    j--;
                }
            }
        }
        Collections.sort(factorial_list);
        return factorial_list;
    }
}

