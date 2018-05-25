import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders {
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

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.add(rootDir);

        System.out.println(rootDir.getName());

        int counter = 1;

        while (!queue.isEmpty()) {
            File currentDir = queue.remove();

            File[] currentFiles = currentDir.listFiles();

            if (currentFiles == null) {
                continue;
            }

            for (File file : currentFiles) {
                if (file.isDirectory()) {
                    counter++;
                    System.out.println(file.getName());
                    queue.add(file);
                }
            }
        }
        System.out.printf("%d folders", counter);
    }
}
