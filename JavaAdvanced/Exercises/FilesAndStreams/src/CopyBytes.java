import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        String resourceFolder = "C:\\SoftUni\\Java-Fundamentals-May-2018\\JavaAdvanced\\Exercises\\FilesAndStreams\\resources\\";

        String inputPath = resourceFolder + "input.txt";
        String outputPath = resourceFolder + "output.txt";

        int asciiCodeSpace = 32;
        int asciiCodeNewLine = 10;

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            int oneByte = fis.read();
            while (oneByte >= 0) {
                if (asciiCodeNewLine == oneByte || asciiCodeSpace == oneByte) {
                    fos.write(oneByte);
                } else {
                    char[] characters = String.valueOf(oneByte).toCharArray();
                    for (char character : characters) {
                        fos.write(character);
                    }
                }
                oneByte = fis.read();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
