package ComparableVsComparator;

public class Laptop {

    private String brand;
    private int ram;
    private int hdd;
    private String processor;
    private int price;

    public Laptop(){}

    public Laptop(String brand, int ram, int hdd, String processor, int price) {
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.processor = processor;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", hdd=" + hdd +
                ", processor='" + processor + '\'' +
                ", price=" + price +
                '}';
    }
}
