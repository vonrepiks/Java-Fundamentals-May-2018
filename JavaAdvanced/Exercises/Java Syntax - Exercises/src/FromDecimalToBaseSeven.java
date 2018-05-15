import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Hristo on 21.01.2017 г..
 */
public class FromDecimalToBaseSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());

        String base7 = "";

        while(decimal >= 7){
            base7 += String.valueOf(decimal % 7);
            decimal /= 7;
        }
        base7 += decimal;

        System.out.println(new StringBuilder(base7).reverse().toString());
    }
}
