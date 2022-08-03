package Testing_example;

public class Vehicle {

    private Integer numberOfWheels;

    public Vehicle(Integer numberOfWheels){
        if (numberOfWheels < 30){
            throw new IllegalArgumentException();
        }
        this.numberOfWheels = numberOfWheels;
    }

    public Integer getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(Integer numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }
}
