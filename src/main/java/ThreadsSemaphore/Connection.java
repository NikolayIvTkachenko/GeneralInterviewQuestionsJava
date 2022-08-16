package ThreadsSemaphore;


import java.util.concurrent.Semaphore;

public class Connection {

    Semaphore sem = new Semaphore(10, true);

    private static Connection instance = new Connection();

    private int connections = 0;

    private Connection() {

    }

    public static Connection getInstance(){
        return instance;
    }

    public void connect() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try{
            doConnect();
        }finally {
            sem.release();
        }
    }

    private void doConnect() {

        synchronized (this) {
            connections++;
            System.out.println("Current connection: " + connections);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (this){
            connections--;
        }
    }



}
