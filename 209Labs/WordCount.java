import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;
import java.nio.file.*;

/**
 * Lab6 - Text Files I: Word Count
 *
 * @author (Arshia Rahim)
 * Date: 2021-12-09
 */

public class WordCount extends FileProcessor<List<Integer>> {
    private int char_Count, word_Count, line_Count;
    List <Integer> List_result = new ArrayList<Integer >();

    protected void startFile() {
        char_Count = 0; word_Count = 0; line_Count = 0;
        
    }

    protected void processLine(String line) {
        word_Count += counterWords(line);
        char_Count += line.length();
        line_Count++;
    }
    
    private int counterWords(String line){
        int counter = 0;
        boolean lastSpace = true;

        for (char Char: line.toCharArray()){

            if (Character.isWhitespace(Char)){
                lastSpace = true;
            } else {

                if (lastSpace){
                    counter++;
                }
                lastSpace = Character.isWhitespace(Char);
            }
        }
        return counter;
    }

    protected List<Integer> endFile() {

        List_result.add(char_Count);
        List_result.add(word_Count);
        List_result.add(line_Count);

        return List_result;
    }  
}
