package Patterns.creational;

public class AppDemo003_Factory {

    public static void main(String[] args) {

        Factory factory = new Factory();
        Car car01 = factory.create("toyota");
        car01.drive();

    }

}

interface Car {
    void drive();
}

class Toyota implements Car {

    @Override
    public void drive() {
        System.out.println("Drive Toyota");
    }
}

class Honda implements Car {

    @Override
    public void drive() {
        System.out.println("Drive Honda");
    }
}

class Factory {
    public Car create(String typeOfCar) {
        switch (typeOfCar){
            case "toyota" : return new Toyota();
            case "honda" : return new Honda();
            default: return null;
        }
    }
}