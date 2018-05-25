import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String resourceFolder = "C:\\SoftUni\\Java-Fundamentals-May-2018\\JavaAdvanced\\Exercises\\FilesAndStreams\\resources\\";

        String inputPath = resourceFolder + "input.txt";

        try (FileInputStream fis = new FileInputStream(inputPath)) {
            int oneByte = fis.read();
            while (oneByte >= 0) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fis.read();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
