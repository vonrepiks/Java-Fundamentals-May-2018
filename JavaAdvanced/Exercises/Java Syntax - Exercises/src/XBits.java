 import java.util.Scanner;

public class XBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = 8;
        int cols = 32;
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            char[] chars = Integer.toBinaryString(number).toCharArray();
            // index     0 1 2 3 4 5 6 7 8 9 10 11
            //matrix row 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
            //char array 0 0 1 0 1 1 0
            for (int j = 0; j < chars.length; j++) {
                int startPoint = matrix[i].length - chars.length;
                int index = startPoint + j;
                matrix[i][index] = Integer.parseInt(String.valueOf(chars[j]));
            }
        }

        int countValidXbit = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                // boolean isValidXbit = isValidXBit();
                if (matrix[row][col] == 1 && isValidXBit(matrix, row, col)) {
                    countValidXbit++;
                }
            }
        }

        System.out.println(countValidXbit);
    }

    private static boolean isValidXBit(int[][] matrix, int row, int col) {
        int[] pattern = { 1, 0, 1, 0, 1, 0, 1, 0, 1 };
        int currentIndex = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (pattern[currentIndex++] != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
