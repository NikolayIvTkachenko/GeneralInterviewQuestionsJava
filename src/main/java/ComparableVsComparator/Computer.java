package ComparableVsComparator;

public class Computer implements Comparable<Computer> {

    private String brand;
    private int ram;
    private int hdd;
    private String processor;
    private int price;

    public Computer(){}

    public Computer(String brand, int ram, int hdd, String processor, int price) {
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
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", hdd=" + hdd +
                ", processor='" + processor + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Computer computer) {
        //this > computer = +
        //this < computer = -
        //this == computer = 0
        if(this.getRam() > computer.getRam()) return 1;
        else if(this.getRam() < computer.getRam()) return -1;
        else return 0;
    }
}
