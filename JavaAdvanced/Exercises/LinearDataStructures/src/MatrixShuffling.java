import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = line[col];
            }
        }

        String line;
        while (true) {
            if ("END".equals(line = scanner.nextLine())) {
                break;
            }
            try {
            String[] tokens = line.split("\\s+");

            if(!"swap".equals(tokens[0]) && tokens.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }

            int row1 = Integer.parseInt(tokens[1]);;
            int col1 = Integer.parseInt(tokens[2]);;
            int row2 = Integer.parseInt(tokens[3]);
            int col2 = Integer.parseInt(tokens[4]);

                swap(row1, col1, row2, col2, matrix);
                print(matrix);
            } catch (IndexOutOfBoundsException | NumberFormatException e) { // IndexOutOfBoundsException
                System.out.println("Invalid input!");
            }
        }
    }

    private static void print(String[][] matrix) {
        for (String[] line : matrix) {
            for (String cell : line) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static void swap(int row1, int col1, int row2, int col2, String[][] matrix) {
        String firstCell = matrix[row1][col1];
        String secondCell = matrix[row2][col2];

        matrix[row1][col1] = secondCell;
        matrix[row2][col2] = firstCell;
    }
}
