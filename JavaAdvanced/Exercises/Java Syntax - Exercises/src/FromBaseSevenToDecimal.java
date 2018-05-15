import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Hristo on 21.01.2017 г..
 */
public class FromBaseSevenToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String base7 = scanner.nextLine();

        if(base7.equals("7")){
            System.out.println(10);
        } else{
            System.out.println(Integer.toString(Integer.parseInt(base7, 7), 10));
        }
    }
}
