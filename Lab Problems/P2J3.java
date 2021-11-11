import java.util.Arrays;
import java.util.ArrayList;

/**
 * Lab0(C) - Reverse The Verse
 *
 * @author (Arshia Rahim)
 * @Date: 2021-10-23
 */
public class P2J3
{
    public static void reverseAscendingSubarrays(int[] items){
        // THIS CODE WORKS
        int i = 0; int counter = 0;
        for (i = 1; i < items.length; i++){
            if (items[i] > items[i - 1]){
                counter += 1;
            }
            else {
                int begin = (i - counter) - 1;
                int end = (i - 1);
                
                while (begin < end){
                    int element = items[begin];
                    items[begin] = items[end];
                    items[end] = element;
                    begin++;
                    end--;
                }
                counter = 0;
            }
        }
        if (counter > 0){
            int begin = (i - counter) - 1;
            int end = (i - 1);
            while (begin < end){
                int element = items[begin];
                items[begin] = items[end];
                items[end] = element;
                begin++;
                end--;
            }
        }
    }
    public static String pancakeScramble(String text){
        // THIS CODE WORKS
        String firstString = new String("");
        String secondString = new String("");
        int position = 2;
        for (int i = 0; i < text.length() - 1; i++){
            firstString = new StringBuilder(text.substring(0, position)).reverse().toString();
            secondString = text.substring(position, text.length());
            text = firstString + secondString;
            position += 1;
        }
        return text;
    }
    public static String reverseVowels(String text){
        // THIS CODE WORKS
        char[] firstText = text.toCharArray();
        char[] Text = new char[text.length()];
        int count = 0;
        
        String Result = new String("");  String Vowels = new String("");
        for (int i = 0; i < text.length(); i++){
            if (firstText[i] == 'a' || firstText[i] == 'A'){
                Vowels = firstText[i] + Vowels;
            }
            if (firstText[i] == 'u' || firstText[i] == 'U'){
                Vowels = firstText[i] + Vowels;
            }
            if (firstText[i] == 'e' || firstText[i] == 'E'){
                Vowels = firstText[i] + Vowels;
            }
            if (firstText[i] == 'i' || firstText[i] == 'I'){
                Vowels = firstText[i] + Vowels;
            }
            if (firstText[i] == 'o' || firstText[i] == 'O'){
                Vowels = firstText[i] + Vowels;
            }
        }
        
        for (int i = 0; i < text.length(); i++){
            if (firstText[i] == 'a' || firstText[i] == 'A' || firstText[i] == 'i' || firstText[i] == 'I' || firstText[i] == 'e' || firstText[i] == 'E' || firstText[i] == 'u' || firstText[i] == 'U'||firstText[i] == 'o' || firstText[i] == 'O'){
                if (Character.isUpperCase(firstText[i])){
                    Result += Character.toUpperCase(Vowels.charAt(count));
                    count += 1;
                }
                else{
                    Result += Character.toLowerCase(Vowels.charAt(count));
                    count += 1;
                }
            }
            else{
                Result +=  firstText[i];
            }
        }
        return Result;
    }
}