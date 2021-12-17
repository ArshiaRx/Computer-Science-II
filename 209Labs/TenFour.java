import java.util.*;

/**
 * Lab37 - Big Ten-Four
 *
 * @author (Arshia)
 * Date: 2021-12-12
 */
public class TenFour
{
    public static List<Integer> shortestPath(int n, int limit){
        boolean[] seen = new boolean[limit];
        int[] parent = new int[limit];
        LinkedList<Integer> frontier = new LinkedList<>();
        
        ArrayList<Integer> path = new ArrayList<>();
        seen[4] = true;
        frontier.add(4);
        
        if (n == 4){
            return Collections.singletonList(4);
        }
        if (n > limit) {
            return path;
        }
        
        while(!frontier.isEmpty()){
            int v = frontier.pop();
            
            if (v == n) {
                while (v != 4) {
                    path.add(v);
                    v = parent[v];
                }
            }
            
            if (!path.isEmpty()){
                path.add(4);
                break;
            }
            
            if ((10 * v) < limit && seen[(10 * v)] == false){
                seen[(10 * v)] = true;
                parent[(10 * v)] = v;
                frontier.add(10 * v);
            }
            
            if ((10 * v + 4) < limit && seen[(10 * v + 4)] == false){
                seen[(10 * v + 4)] = true;
                parent[(10 * v + 4)] = v;
                frontier.add(10 * v + 4);
            }
            
            if ((v / 2) < limit && v % 2 == 0 && seen[(v / 2)] == false){
                seen[(v / 2)] = true;
                parent[(v / 2)] = v;
                frontier.add(v/2);
            }
        }
        Collections.reverse(path);
        return path;
    }
}
