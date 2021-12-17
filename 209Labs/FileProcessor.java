import java.io.BufferedReader;
import java.io.IOException;

/**
 * Lab6 - Text Files I: Word Count
 * Abstract class FileProcessor <R>
 *
 * @author (Arshia Rahim)
 * Date: 2021-12-09
 */

public abstract class FileProcessor <R> {

    protected abstract void startFile();
    protected abstract void processLine(String line);
    protected abstract R endFile();

    public final R processFile(BufferedReader reader ) throws IOException {

        startFile();
        String line = "";

        while ((line = reader.readLine()) != null) {
            processLine(line);
        }

        R result = endFile();

        return result;
    }
}
