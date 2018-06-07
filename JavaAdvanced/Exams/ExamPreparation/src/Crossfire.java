import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        int n = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = String.valueOf(n);
                n++;
            }
        }

        String commandLine;
        while (true) {
            if ("Nuke it from orbit".equals(commandLine = reader.readLine())) {
                break;
            }

            int[] tokens = Arrays.stream(commandLine.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int row = tokens[0];
            int col = tokens[1];
            int radius = tokens[2];

            destroyCol(matrix, row, col, radius);
            destroyRow(matrix, row, col, radius);
            matrix = clearEmptyCells(matrix);
        }

        printMatrix(matrix);
    }

    private static String[][] clearEmptyCells(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(matrix[i]).filter(s -> s != null).toArray(String[]::new);
        }
        matrix = Arrays.stream(matrix).filter(l -> l.length > 0).toArray(String[][]::new);
        return matrix;
    }

    private static boolean isInTheMatrix(int currentRow, int currentCol, String[][] matrix) {
        return currentRow >= 0 && currentRow < matrix.length && currentCol >= 0 && currentCol < matrix[currentRow].length;
    }

    private static void destroyCol(String[][] matrix, int row, int col, int radius) {
        for (int i = row - radius; i <= row + radius; i++) {
            if (isInTheMatrix(i, col, matrix)) {
                matrix[i][col] = null;
            }
        }
    }

    private static void destroyRow(String[][] matrix, int row, int col, int radius) {
        for (int i = col - radius; i <= col + radius; i++) {
            if (isInTheMatrix(row, i, matrix)) {
                matrix[row][i] = null;
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] line : matrix) {
            StringBuilder sb = new StringBuilder();
            for (String cell : line) {
                sb.append(cell).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
