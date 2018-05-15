import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleArea {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstPoint = reader.readLine().split("\\s+");
        String[] secondPoint = reader.readLine().split("\\s+");
        String[] thirdPoint = reader.readLine().split("\\s+");

        double side1x = Double.parseDouble(firstPoint[0]);
        double side1y = Double.parseDouble(firstPoint[1]);
        double side2x = Double.parseDouble(secondPoint[0]);
        double side2y = Double.parseDouble(secondPoint[1]);
        double side3x = Double.parseDouble(thirdPoint[0]);
        double side3y = Double.parseDouble(thirdPoint[1]);

        int area = (int) Math.abs((side1x * (side2y - side3y) + side2x * (side3y - side1y) + side3x * (side1y - side2y)) / 2);

        System.out.println(area);
    }
}
