import java.util.LinkedList;
import java.util.List;

/**   
 * Lab8 - Text Files II: Tail
 *
 * @author (Arshia Rahim)
 * Date: 2021-12-10
 */

public class Tail extends FileProcessor<List<String>>
{
    private LinkedList<String> last_line_number;
    
    public Tail(int n){
        this.n = n;                          //The n here is the same as the menntioned in private
        last_line_number = new LinkedList<String>();     
    }
        
    @Override
    protected void startFile() {
        //Nothing To do in here
    }
    
    private int n;
    
    @Override
    protected void processLine(String line) {
    
        if(last_line_number.size() == n)   //If the last_line_number be the same as n
        {
            last_line_number.removeFirst();        //remove that last_line_number
        }
        last_line_number.addLast(line);
    }
    
    @Override
    protected List<String> endFile() {
        return last_line_number;
    }
}
