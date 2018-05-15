import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ByteParty {
    private static final String TERMINATE_COMMAND = "party over";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<char[]> binaries = new ArrayList<>();
        while (n-- > 0) {
            int number = Integer.parseInt(reader.readLine());

            char[] binary = new char[8];
            for (int i = 0; i < binary.length; i++) {
                binary[i] = '0';
            }
            char[] binaryNumber = new StringBuilder(Integer.toBinaryString(number)).reverse().toString().toCharArray();
            System.arraycopy(binaryNumber, 0, binary, 0, binaryNumber.length);

            binaries.add(binary);
        }

        String line;
        while (true) {
            if (TERMINATE_COMMAND.equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");
            int index = Integer.parseInt(tokens[1]);

            switch (tokens[0]) {
                case "1":
                    turnBytesToOneByIndex(binaries, index);
                    break;
                case "0":
                    turnBytesToZeroByIndex(binaries, index);
                    break;
                case "-1":
                    changeByteByIndex(binaries, index);
                    break;
                default:
                    break;
            }
        }
        String debug = "";
        for (char[] binary : binaries) {
            System.out.println(Integer.parseInt(new StringBuilder(String.valueOf(binary)).reverse().toString(), 2));
        }
    }

    private static void turnBytesToOneByIndex(List<char[]> binaries, int index) {
        for (char[] binary : binaries) {
            binary[index] = '1';
        }
    }

    private static void turnBytesToZeroByIndex(List<char[]> binaries, int index) {
        for (char[] binary : binaries) {
            binary[index] = '0';
        }
    }

    private static void changeByteByIndex(List<char[]> binaries, int index) {
        for (char[] binary : binaries) {
            if (binary[index] == '0') {
                binary[index] = '1';
            } else {
                binary[index] = '0';
            }
        }
    }
}