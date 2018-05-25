import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String resourceFolder = "C:\\SoftUni\\Java-Fundamentals-May-2018\\JavaAdvanced\\Exercises\\FilesAndStreams\\resources\\";
        String rootDirectoryPath = resourceFolder + "Files-and-Streams";

        File rootDir = new File(rootDirectoryPath);

        if (!rootDir.exists()) {
            return;
        }

        File[] files = rootDir.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (!file.isDirectory()) {
                System.out.printf("%s: %s%n", file.getName(), file.length());
            }
        }
    }
}

