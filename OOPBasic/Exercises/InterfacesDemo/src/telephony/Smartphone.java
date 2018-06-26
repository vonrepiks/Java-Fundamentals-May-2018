package telephony;

public class Smartphone implements Callable, Browsable {

    public Smartphone() {
    }

    @Override
    public String browse(String url) {
        if (url.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Invalid URL!");
        }
        return String.format("Browsing: %s!", url);
    }

    @Override
    public String call(String phoneNumber) {
        if (!phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid number!");
        }
        return String.format("Calling... %s", phoneNumber);
    }
}
