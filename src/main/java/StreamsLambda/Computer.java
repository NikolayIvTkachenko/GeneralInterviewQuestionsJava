package StreamsLambda;

public class Computer {

    private String type;
    private String company;
    private String model;
    private int price;

    public Computer(String type, String company, String model, int price) {
        this.type = type;
        this.company = company;
        this.model = model;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getCompany() {
        return company;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }
}
