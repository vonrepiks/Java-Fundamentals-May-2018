import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }

        int firstDiagonalSum = 0;
        int secondDiagonalSum = 0;

        int row = 0;
        int firstDiagonalCol = 0;
        int secondDiagonalCol = matrix.length - 1;
        while (true) {
            if (row >= matrix.length) {
                break;
            }
            firstDiagonalSum += matrix[row][firstDiagonalCol];
            secondDiagonalSum += matrix[row][secondDiagonalCol];
            row++;
            firstDiagonalCol++;
            secondDiagonalCol--;
        }
        int result = Math.abs(firstDiagonalSum - secondDiagonalSum);
        System.out.println(result);
    }
}
