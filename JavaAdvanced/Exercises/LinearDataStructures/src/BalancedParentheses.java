import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> parentheses = new ArrayDeque<>();

        boolean balanced = true;
        for (String symbol : input) {
            parentheses.push(symbol);
            if (parentheses.peek().equals(")") && parentheses.size() > 1) {
                parentheses.pop();
                if (!parentheses.pop().equals("(")) {
                    balanced = false;
                    break;
                }
            } else if (parentheses.peek().equals("}") && parentheses.size() > 1) {
                parentheses.pop();
                if (!parentheses.pop().equals("{")) {
                    balanced = false;
                    break;
                }
            } else if (parentheses.peek().equals("]") && parentheses.size() > 1) {
                parentheses.pop();
                if (!parentheses.pop().equals("[")) {
                    balanced = false;
                    break;
                }
            } else if (parentheses.peek().equals(" ") && parentheses.size() > 1) {
                parentheses.pop();
                if (!parentheses.pop().equals(" ")) {
                    balanced = false;
                    break;
                }
            }
        }

        if(balanced && parentheses.size() == 0){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }
}