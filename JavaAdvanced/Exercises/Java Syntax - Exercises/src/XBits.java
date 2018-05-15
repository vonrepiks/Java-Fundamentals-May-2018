import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XBits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] matrix = new int[32][32];

        for (int i = 0; i < 8; i++) {
            int number = Integer.parseInt(reader.readLine());

            String binary = new StringBuilder(Integer.toBinaryString(number)).reverse().toString();
            int[] line = new int[32];

            int index = 0;
            for (int j = line.length - 1; j >= 0; j--) {
                if (index >= binary.length()) {
                    break;
                }
                line[j] = binary.charAt(index++) - '0';
            }
            matrix[i] = line;
        }

        int validXBit = 0;
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                if (matrix[i][j] == 1 && isValidXbit(matrix, i, j)) {
                    validXBit++;
                }
            }
        }
        System.out.println(validXBit);
    }

    private static boolean isValidXbit(int[][] matrix, int row, int col) {
        int[] validXbit = { 1, 0, 1, 0, 1, 0, 1, 0, 1 };
        int index = 0;
        for (int k = row; k < row + 3; k++) {
            for (int l = col; l < col + 3; l++) {
                if (validXbit[index++] != matrix[k][l]) {
                    return false;
                }
            }
        }
        return true;
    }
}
