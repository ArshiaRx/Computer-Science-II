import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

/**
 * Lab10 - Computation Streams
 *
 * @author (Arshia Rahim)
 * Date: 2021-12-01
*/

public class StreamExercises {
    public static int countLines(Path path, int thres) throws IOException{
        Stream<String> All_lines = Files.lines(path);
        Stream<String> filter_Lines =  All_lines.filter(line -> line.length() >= thres);
        Object[] List_line = filter_Lines.toArray();
        int size = List_line.length;
        return size;
    }

    public static List<String> collectWords(Path path) throws IOException{
        Stream<String> All_lines = Files.lines(path);
        Stream<String> lowercase_Line = All_lines.map(line -> line.toLowerCase());
        Stream<String> lineWords = lowercase_Line.map(line-> line.split("[^a-z]+")).flatMap(Arrays::stream); 
        Stream<String> Only_Words = lineWords.filter(word -> word.length() >= 1).sorted();

        List<String> Duplicated_Result = Only_Words.collect(Collectors.toList());
        List<String> result = new ArrayList<String>(new LinkedHashSet<String>(Duplicated_Result));
        
        return result;
    }
}