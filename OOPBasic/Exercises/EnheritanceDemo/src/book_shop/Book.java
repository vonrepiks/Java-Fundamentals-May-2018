package book_shop;

public class Book {
    private static final String INVALID_AUTHOR = "Author not valid!";
    private static final String INVALID_TITLE = "Title not valid!";
    private static final String INVALID_PRICE = "Price not valid!";

    private String title;
    private String author;
    private double price;

    public Book(String author, String title, double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException(INVALID_TITLE);
        }
        this.title = title;
    }

    private void setAuthor(String author) {
        String[] authorTokens = author.split("\\s+");
        if (authorTokens.length == 2 && Character.isDigit(authorTokens[1].charAt(0))) {
            throw new IllegalArgumentException(INVALID_AUTHOR);
        }
        this.author = author;
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    private String getTitle() {
        return this.title;
    }

    private String getAuthor() {
        return this.author;
    }

    private double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();
    }
}
