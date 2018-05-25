import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        String resourceFolder = "C:\\SoftUni\\Java-Fundamentals-May-2018\\JavaAdvanced\\Exercises\\FilesAndStreams\\resources\\";

        String inputPathString = resourceFolder + "inputForSort.txt";
        String outputPathString = resourceFolder + "sortOutput.txt";

        Path inputPath = Paths.get(inputPathString);
        Path outputPath = Paths.get(outputPathString);

        try {
            List<String> lines = Files.readAllLines(inputPath);
            Collections.sort(lines);
            Files.write(outputPath, lines);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
