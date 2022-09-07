package Patterns.creational;

public class AppDemo005_FabricMethod {

    public static void main(String[] args) {

        SimpleVehicleFactory factory = new SimpleVehicleFactory();
        //"car"
        //"track"
        //"tank"
        //"heavytrack"
        //"pulltrack"
        Vehicle car = factory.createVehicle("car");
        car.moving();
        car.stop();

        Vehicle track = factory.createVehicle("track");
        track.moving();
        track.stop();

    }

}

interface Vehicle{
    void moving();
    void stop();
}

class CarVehicle implements Vehicle{

    public CarVehicle(){
        System.out.println("CarVehicle was created");
    }

    @Override
    public void moving() {
        System.out.println("CarVehicle moving!");
    }

    @Override
    public void stop() {
        System.out.println("CarVehicle stopped!");
    }
}

class TrackVehicle implements Vehicle{

    public TrackVehicle(){
        System.out.println("TrackVehicle was created");
    }

    @Override
    public void moving() {
        System.out.println("TrackVehicle moving!");
    }

    @Override
    public void stop() {
        System.out.println("TrackVehicle stopped!");
    }
}

class TankVehicle implements Vehicle{

    public TankVehicle(){
        System.out.println("TankVehicle was created");
    }

    @Override
    public void moving() {
        System.out.println("TankVehicle moving!");
    }

    @Override
    public void stop() {
        System.out.println("TankVehiclee stopped!");
    }
}

class HeavyTrackVehicle implements Vehicle{

    public HeavyTrackVehicle(){
        System.out.println("HeavyTrackVehicle was created");
    }

    @Override
    public void moving() {
        System.out.println("HeavyTrackVehicle moving!");
    }

    @Override
    public void stop() {
        System.out.println("HeavyTrackVehicle stopped!");
    }
}

class PullTrackVehicle implements Vehicle{

    public PullTrackVehicle(){
        System.out.println("PullTrackVehicle was created");
    }

    @Override
    public void moving() {
        System.out.println("PullTrackVehicle moving!");
    }

    @Override
    public void stop() {
        System.out.println("PullTrackVehicle stopped!");
    }
}

class SimpleVehicleFactory {
    public Vehicle createVehicle(String typeVehicle){
        Vehicle vehicle = null;

        if(typeVehicle.equals("car")){
            vehicle = new CarVehicle();
        } else if (typeVehicle.equals("track")){
            vehicle = new TrackVehicle();
        } else if (typeVehicle.equals("tank")){
            vehicle = new TankVehicle();
        } else if (typeVehicle.equals("heavytrack")){
            vehicle = new HeavyTrackVehicle();
        } else if (typeVehicle.equals("pulltrack")){
            vehicle = new PullTrackVehicle();
        }

        return vehicle;
    }
}