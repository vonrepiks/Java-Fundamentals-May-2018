import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String resourceFolder = "C:\\SoftUni\\Java-Fundamentals-May-2018\\JavaAdvanced\\Exercises\\FilesAndStreams\\resources\\";

        String inputPath = resourceFolder + "input.txt";
        String outputPath = resourceFolder + "output.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath)));
             PrintWriter writer = new PrintWriter(outputPath)) {
            String line = reader.readLine();
            int counter = 1;
            while (line != null) {
                if (counter % 3 == 0) {
                    writer.println(line);
                }
                counter++;
                line = reader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
