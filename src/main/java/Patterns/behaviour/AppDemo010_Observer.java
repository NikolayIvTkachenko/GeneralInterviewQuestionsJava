package Patterns.behaviour;

import java.util.ArrayList;
import java.util.Random;

public class AppDemo010_Observer {

    public static void main(String[] args) {

        WorkFactoryLine workFactoryLine = new WorkFactoryLine();

        MonitorPanel monitorPanel01 = new MonitorPanel(workFactoryLine, "Panel V001");
        MonitorPanel monitorPanel02 = new MonitorPanel(workFactoryLine, "Panel V002");
        MonitorPanel monitorPanel03 = new MonitorPanel(workFactoryLine, "Panel V003");

        System.out.println("== Iteration 01 ==");
        workFactoryLine.getDataFromLine();
        monitorPanel01.display();
        monitorPanel02.display();
        monitorPanel03.display();

        System.out.println("== Iteration 02 ==");
        workFactoryLine.getDataFromLine();
        monitorPanel01.display();
        monitorPanel02.display();
        monitorPanel03.display();

        System.out.println("== Iteration 03 ==");
        workFactoryLine.getDataFromLine();
        monitorPanel01.display();
        monitorPanel02.display();
        monitorPanel03.display();

    }
}

interface DeviceSubject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyAllObservers();
}

interface Observer {
    void update(DataTransmitter dataTransmitter);
}

interface DataTransmitter{}

interface DisplayData{
    void display();
}

class WorkFactoryLine implements DeviceSubject{

    private int maxTemp = 100;
    private int minTemp = 10;

    private int maxHum = 100;
    private int minHum = 0;

    private ArrayList<Observer> observers;

    private long countDetails = 0;

    private float temperatureBlock01;
    private float temperatureBlock02;
    private float temperatureBlock03;

    private float humidityBlock01;
    private float humidityBlock02;
    private float humidityBlock03;

    public WorkFactoryLine(){
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int n = observers.indexOf(observer);
        if(n >= 0){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyAllObservers() {
        DataTransmitter dataTransmitter = readDataFromLine();
        for(Observer observer: observers){
            observer.update(dataTransmitter);
        }
    }

    public void getDataFromLine(){
        ++countDetails;
        temperatureBlock01 = (long)(Math.random()*((maxTemp-minTemp)+1))+minTemp;
        temperatureBlock02 = (long)(Math.random()*((maxTemp-minTemp)+1))+minTemp;
        temperatureBlock03 = (long)(Math.random()*((maxTemp-minTemp)+1))+minTemp;
        humidityBlock01 = (long)(Math.random()*((maxHum-minHum)+1))+minHum;
        humidityBlock02 = (long)(Math.random()*((maxHum-minHum)+1))+minHum;
        humidityBlock03 = (long)(Math.random()*((maxHum-minHum)+1))+minHum;

        measureChanged();
    }

    private void  measureChanged(){
        notifyAllObservers();
    }

    private DataTransmitter readDataFromLine(){

        DataTransmitter dataTransmitter = new DataLineModel001(countDetails,
                temperatureBlock01,
                temperatureBlock02,
                temperatureBlock03,
                humidityBlock01,
                humidityBlock02,
                humidityBlock03);
        return dataTransmitter;
    }
}

class DataLineModel001 implements DataTransmitter{
    private long countDetails;

    private float temperatureBlock01;
    private float temperatureBlock02;
    private float temperatureBlock03;

    private float humidityBlock01;
    private float humidityBlock02;
    private float humidityBlock03;

    public DataLineModel001(long countDetails,
                            float temperatureBlock01, float temperatureBlock02, float temperatureBlock03,
                            float humidityBlock01, float humidityBlock02, float humidityBlock03) {
        this.countDetails = countDetails;
        this.temperatureBlock01 = temperatureBlock01;
        this.temperatureBlock02 = temperatureBlock02;
        this.temperatureBlock03 = temperatureBlock03;
        this.humidityBlock01 = humidityBlock01;
        this.humidityBlock02 = humidityBlock02;
        this.humidityBlock03 = humidityBlock03;
    }

    @Override
    public String toString() {
        return "DataLineModel001{" +
                "countDetails=" + countDetails +
                ", temperatureBlock01=" + temperatureBlock01 +
                ", temperatureBlock02=" + temperatureBlock02 +
                ", temperatureBlock03=" + temperatureBlock03 +
                ", humidityBlock01=" + humidityBlock01 +
                ", humidityBlock02=" + humidityBlock02 +
                ", humidityBlock03=" + humidityBlock03 +
                '}';
    }
}

class MonitorPanel implements Observer, DisplayData{

    private String namePanel ="";
    DataTransmitter dataTransmitter;
    DeviceSubject deviceSubject;

    public MonitorPanel(DeviceSubject deviceSubject, String namePanel){
        this.deviceSubject = deviceSubject;
        deviceSubject.registerObserver(this);
        this.namePanel = namePanel;
    }

    @Override
    public void update(DataTransmitter dataTransmitter) {
        this.dataTransmitter = dataTransmitter;
    }

    @Override
    public void display() {
        System.out.println("== === ==");
        System.out.println("== " + namePanel);
        System.out.println(dataTransmitter);
    }
}