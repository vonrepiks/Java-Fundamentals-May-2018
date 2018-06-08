import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crossfire2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, rows, cols);

        String line;
        while (true) {
            if ("Nuke it from orbit".equals(line = reader.readLine())) {
                break;
            }
            
            int[] tokens = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int row = tokens[0];
            int col = tokens[1];
            int radius = tokens[2];

            destroyColumn(matrix, row, col, radius);
            destroyRow(matrix, row, col, radius);
            clearEmptyLines(matrix);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> line : matrix) {
            StringBuilder result = new StringBuilder();
            for (Integer cell : line) {
                result.append(cell).append(" ");
            }

            System.out.println(result.toString().trim());
        }
    }

    private static void clearEmptyLines(List<List<Integer>> matrix) {
        matrix.removeIf(line -> line.isEmpty());
    }

    private static void destroyRow(List<List<Integer>> matrix, int row, int col, int radius) {
        for (int i = col + radius; i >= col - radius; i--) {
            if (isValidDimensions(row, i, matrix)) {
                matrix.get(row).remove(i);
            }
        }
    }

    private static void destroyColumn(List<List<Integer>> matrix, int row, int col, int radius) {
        for (int i = row - radius; i <= row + radius; i++) {
            if (isValidDimensions(i, col, matrix) && i != row) {
                matrix.get(i).remove(col);
            }
        }
    }

    private static boolean isValidDimensions(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int number = 1;
        for (int i = 0; i < rows; i++) {
            List<Integer> line = new ArrayList<>();
            matrix.add(line);
            for (int j = 0; j < cols; j++) {
                matrix.get(i).add(number);
                number++;
            }
        }
    }
}
