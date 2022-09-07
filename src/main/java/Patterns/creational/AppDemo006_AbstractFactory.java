package Patterns.creational;

import javax.crypto.Mac;

abstract class VehicleGeneral{

    CarBody carBody;
    Doors doors;
    Wheels wheels;
    Engine engine;
    Transmission transmission;

    abstract void moving();
    abstract void stop();
}

class RussianVehicleGeberal extends VehicleGeneral{

    @Override
    void moving() {
        System.out.println("RussianVehicleGeberal moving");
    }

    @Override
    void stop() {
        System.out.println("RussianVehicleGeberal stopped!");
    }
}

class AmericanVehicleGeberal extends VehicleGeneral{

    @Override
    void moving() {
        System.out.println("AmericanVehicleGeberal moving");
    }

    @Override
    void stop() {
        System.out.println("AmericanVehicleGeberal stopped!");
    }
}

class EuroVehicleGeberal extends VehicleGeneral{

    @Override
    void moving() {
        System.out.println("EuroVehicleGeberal moving");
    }

    @Override
    void stop() {
        System.out.println("EuroVehicleGeberal stopped!");
    }
}



interface CarBody{
    void createCarBody();
}
interface Doors{
    void createDoors();
}
interface Wheels{
    void createWheels();
}
interface Engine{
    void createEngine();
}
interface Transmission{
    void createTransmission();
}

abstract class MachineryFactory{
    abstract VehicleGeneral  createCar();
}

interface VehicleComponentFactory{
    CarBody createCarBody();
    Doors createDoors();
    Wheels createWheels();
    Engine createEngine();
    Transmission createTransmission();
}

//CarBody
//Doors
//Wheels
//Engine
//Transmission

class RussianCarBody implements CarBody{

    @Override
    public void createCarBody() {
        System.out.println("Created RussianCarBody");
    }
}

class AmericanCarBody implements CarBody{

    @Override
    public void createCarBody() {
        System.out.println("Created AmericanCarBody");
    }
}

class EuroCarBody implements CarBody{

    @Override
    public void createCarBody() {
        System.out.println("Created EuroCarBody");
    }
}
//==
class RussianDoors implements Doors{

    @Override
    public void createDoors() {
        System.out.println("Created RussianDoors ");
    }
}

class AmericanDoors implements Doors{

    @Override
    public void createDoors() {
        System.out.println("Created AmericanDoors");
    }
}

class EuroDoors implements Doors{

    @Override
    public void createDoors() {
        System.out.println("Created EuroDoors");
    }
}
//==
class RussianWheels implements Wheels{

    @Override
    public void createWheels() {
        System.out.println("Created RussianWheels");
    }
}

class AmericanWheels implements Wheels{

    @Override
    public void createWheels() {
        System.out.println("Created AmericanWheels");
    }
}

class EuroWheels implements Wheels{

    @Override
    public void createWheels() {
        System.out.println("Created EuroWheels");
    }
}
//==
class RussianEngine implements Engine{

    @Override
    public void createEngine() {
        System.out.println("Created RussianEngine");
    }
}

class AmericanEngine implements Engine{

    @Override
    public void createEngine() {
        System.out.println("Created AmericanEngine");
    }
}

class EuroEngine implements Engine{

    @Override
    public void createEngine() {
        System.out.println("Created EuroEngine");
    }
}
//=
class RussianTransmission implements Transmission{

    @Override
    public void createTransmission() {
        System.out.println("Created RussianTransmission");
    }
}

class AmericanTransmission implements Transmission{

    @Override
    public void createTransmission() {
        System.out.println("Created AmericanTransmission");
    }
}

class EuroTransmission implements Transmission{

    @Override
    public void createTransmission() {
        System.out.println("Created EuroTransmission");
    }
}


class ManageFactory {

    private static ManageFactory instance = new ManageFactory();

    private ManageFactory(){}

    public static ManageFactory getInstance(){
        return instance;
    }

    public VehicleGeneral getVehicleGeneral(String type){
        //RussianVehicleFactory
        //AmericanVehicleFactory
        //EuroVehicleFactory
        MachineryFactory machineryFactory = null;
        if(type.equals("american")){
            machineryFactory = new AmericanVehicleFactory();
            return machineryFactory.createCar();
        }else if(type.equals("russian")){
            machineryFactory = new RussianVehicleFactory();
            return machineryFactory.createCar();
        }else if(type.equals("euro")){
            machineryFactory = new EuroVehicleFactory();
            return machineryFactory.createCar();
        }
        return null;
    }

}


class RussianVehicleFactory extends MachineryFactory implements VehicleComponentFactory {
    @Override
    VehicleGeneral createCar() {
        System.out.println("== Start building process Russian Vehicle ===");
        VehicleGeneral vehicleGeneral = new RussianVehicleGeberal();
        vehicleGeneral.carBody = createCarBody();
        vehicleGeneral.doors = createDoors();
        vehicleGeneral.wheels = createWheels();
        vehicleGeneral.engine = createEngine();
        vehicleGeneral.transmission = createTransmission();
        System.out.println(" Russian Vehicle is completed!");
        System.out.println("== End building process ===");
        System.out.println();
        return vehicleGeneral;
    }

    @Override
    public CarBody createCarBody() {
        return new RussianCarBody();
    }

    @Override
    public Doors createDoors() {
        return new RussianDoors();
    }

    @Override
    public Wheels createWheels() {
        return new RussianWheels();
    }

    @Override
    public Engine createEngine() {
        return new RussianEngine();
    }

    @Override
    public Transmission createTransmission() {
        return new RussianTransmission();
    }
}

class AmericanVehicleFactory extends MachineryFactory implements VehicleComponentFactory  {
    @Override
    VehicleGeneral createCar() {
        System.out.println("== Start building process American Vehicle ===");
        VehicleGeneral vehicleGeneral = new AmericanVehicleGeberal();
        vehicleGeneral.carBody = createCarBody();
        vehicleGeneral.doors = createDoors();
        vehicleGeneral.wheels = createWheels();
        vehicleGeneral.engine = createEngine();
        vehicleGeneral.transmission = createTransmission();
        System.out.println(" Euro Vehicle is completed!");
        System.out.println("== End building process ===");
        System.out.println();
        return vehicleGeneral;
    }

    @Override
    public CarBody createCarBody() {
        return new AmericanCarBody();
    }

    @Override
    public Doors createDoors() {
        return new AmericanDoors();
    }

    @Override
    public Wheels createWheels() {
        return new AmericanWheels();
    }

    @Override
    public Engine createEngine() {
        return new AmericanEngine();
    }

    @Override
    public Transmission createTransmission() {
        return new AmericanTransmission();
    }
}

class EuroVehicleFactory extends MachineryFactory implements VehicleComponentFactory {
    @Override
    VehicleGeneral createCar() {
        System.out.println("== Start building process Euro Vehicle ===");
        VehicleGeneral vehicleGeneral = new EuroVehicleGeberal();
        vehicleGeneral.carBody = createCarBody();
        vehicleGeneral.doors = createDoors();
        vehicleGeneral.wheels = createWheels();
        vehicleGeneral.engine = createEngine();
        vehicleGeneral.transmission = createTransmission();
        System.out.println(" Euro Vehicle is completed!");
        System.out.println("== End building process ===");
        System.out.println();
        return vehicleGeneral;
    }

    @Override
    public CarBody createCarBody() {
        return new EuroCarBody();
    }

    @Override
    public Doors createDoors() {
        return new EuroDoors();
    }

    @Override
    public Wheels createWheels() {
        return new EuroWheels();
    }

    @Override
    public Engine createEngine() {
        return new EuroEngine();
    }

    @Override
    public Transmission createTransmission() {
        return new EuroTransmission();
    }
}

public class AppDemo006_AbstractFactory {

    public static void main(String[] args) {

        //"american"
        //"russian"
        //"euro"
        System.out.println("=== Create american Vehicle ==");
        VehicleGeneral vehicleGeneralA = ManageFactory.getInstance().getVehicleGeneral("american");

        System.out.println("=== Create russian Vehicle ==");
        VehicleGeneral vehicleGeneralR = ManageFactory.getInstance().getVehicleGeneral("russian");

        System.out.println("=== Create euro Vehicle ==");
        VehicleGeneral vehicleGeneralE = ManageFactory.getInstance().getVehicleGeneral("euro");

    }
}

