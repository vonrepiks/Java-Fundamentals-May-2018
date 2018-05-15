import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlurFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int blur = Integer.parseInt(scanner.nextLine());

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        long[][] matrix = new long[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            String[] lineTokens = scanner.nextLine().split("\\s+");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Long.parseLong(lineTokens[j]);
            }
        }
        String[] cellDimensions = scanner.nextLine().split("\\s+");
        int targetRow = Integer.parseInt(cellDimensions[0]);
        int targetCol = Integer.parseInt(cellDimensions[1]);

        int startRow = targetRow - 1;
        if (targetRow - 1 < 0) {
            startRow = targetRow;
        }
        int startCol = targetCol - 1 < 0 ? targetCol : targetCol - 1;
        int endRow = targetRow + 1;
        if (targetRow + 1 >= matrix.length) {
            endRow = targetRow;
        }
        int endCol = targetCol + 1 >= matrix[targetRow].length ? targetCol : targetCol + 1;

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                matrix[i][j] += blur;
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(long[][] matrix) {
        for (long[] line : matrix) {
            List<String> resultLine = new ArrayList<>();
            for (long cell : line) {
                resultLine.add(String.valueOf(cell));
            }
            System.out.println(String.join(" ", resultLine));
        }
    }
}
