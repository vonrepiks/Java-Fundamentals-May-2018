package telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] phoneNumbers = reader.readLine().split("\\s+");
        String[] urls = reader.readLine().split("\\s+");

        Smartphone smartphone = new Smartphone();

        Arrays.stream(phoneNumbers).forEach(phoneNumber -> {
            try {
                System.out.println(smartphone.call(phoneNumber));
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        });

        Arrays.stream(urls).forEach(url -> {
            try {
                System.out.println(smartphone.browse(url));
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        });
    }
}
