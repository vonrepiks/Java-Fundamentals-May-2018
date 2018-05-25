import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        String resourceFolder = "C:\\SoftUni\\Java-Fundamentals-May-2018\\JavaAdvanced\\Exercises\\FilesAndStreams\\resources\\";

        String inputPath = resourceFolder + "input.txt";
        String outputPath = resourceFolder + "output.txt";

        Set<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, '.', ',', '!', '?');

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            int oneByte = fis.read();
            while (oneByte >= 0) {
                if (!punctuation.contains((char)oneByte)) {
                    fos.write(oneByte);
                }
                oneByte = fis.read();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
