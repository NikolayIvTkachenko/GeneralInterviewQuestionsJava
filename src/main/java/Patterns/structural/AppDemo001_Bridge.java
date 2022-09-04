package Patterns.structural;

public class AppDemo001_Bridge {
    public static void main(String[] args) {

        Vehicle vehicleCarVolvo = new Car(new Volvo());
        vehicleCarVolvo.drive();

        Vehicle vehicleTrackVolvo = new Track(new Volvo());
        vehicleTrackVolvo.drive();

    }
}

abstract class Vehicle {
    Model model;

    public Vehicle(Model model){
        this.model = model;
    }

    abstract void drive();
}

interface Model {
    void drive(String msg);
}

class Car extends Vehicle {

    public Car(Model model) {
        super(model);
    }

    @Override
    void drive() {
        model.drive("Drive Car");
    }
}


class Track extends Vehicle {

    public Track(Model model) {
        super(model);
    }

    @Override
    void drive() {
        model.drive("Drive Track");
    }
}

class Volvo implements Model {

    @Override
    public void drive(String msg) {
        System.out.println(msg + " Model: Volvo");
    }
}

class Honda implements Model {

    @Override
    public void drive(String msg) {
        System.out.println(msg + " Model: Honda");
    }
}



//===============================================================================================
//bad without Bridge
//                      ---Shape---
//                   /               \
//          Rectangle                Circle
//        /          \              /          \
//  BlueRect        RedRect      BlueCirc     RedCirc
//
//
//good with Bridge
//                      ---Shape---                                     Color
//                   /               \                              /           \
//          Rectangle(Color)         Circle(Color               Blue            Red
//
//
//

//Bad Variant
//interface Car{}
//interface Track {}
//interface Bike {}
//
//class AudiCar {}
//class AudiTrack {}
//
//class ToyotaCar {}
//class ToyotaTrack {}
//
//class MercedesCar {}
//class MercedesTrack {}