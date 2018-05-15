import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BlurFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;

        int blur = Integer.parseInt(reader.readLine());

        String[] dimensions = reader.readLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        long[][] matrix = new long[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            String[] line = reader.readLine().split("\\s+");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Long.parseLong(line[j]);
            }
        }

        String[] target = reader.readLine().split("\\s+");

        int targetRow = Integer.parseInt(target[0]);
        int targetCol = Integer.parseInt(target[1]);

        int startRow = targetRow - 1 >= 0 ? targetRow - 1 : 0;
        int startCol = targetCol - 1 >= 0 ? targetCol - 1 : 0;
        int endRow = targetRow + 1 < matrix.length  ? targetRow + 1 : matrix.length;
        int endCol = targetCol + 1 < matrix[0].length  ? targetCol + 1 : matrix.length;

        int currentRow = startRow;
        int currentCol = startCol;
        for (int i = 0; i <= endRow - startRow; i++) {
            for (int j = 0; j <= endCol - startCol; j++) {
                matrix[currentRow][currentCol] += blur;

                if (currentCol + 1 >= matrix[0].length) {
                    break;
                }
                currentCol += 1;
            }
            currentCol = startCol;
            if (currentRow + 1 >= matrix.length) {
                break;
            }
            currentRow += 1;
        }

        for (long[] line : matrix) {
            List<String> lineResult = new ArrayList<>();
            for (long cell : line) {
                lineResult.add(String.valueOf(cell));
            }
            System.out.println(String.join(" ", lineResult));
        }
    }
}
