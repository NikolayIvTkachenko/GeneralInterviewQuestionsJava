package StreamsLambda;

public class Food {

    private String title;
    private int price;

    public Food(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }
}
