package Treads;

import java.util.concurrent.Exchanger;

public class AppDemoExcanger012 {

    public static void main(String[] args) throws InterruptedException {

        Exchanger<String> exchanger = new Exchanger<>();

        new Mike(exchanger);
        new Anket(exchanger);

        //Thread.sleep(200);

    }

    static class Mike extends Thread {
        Exchanger<String> exchanger;

        public Mike(Exchanger<String> exchanger){
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try{
                exchanger.exchange("I'm 20 years old");
                exchanger.exchange("Hi my name is Mike");

                sleep(1000);

            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Anket extends Thread {
        Exchanger<String> exchanger;

        public Anket(Exchanger exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                String info = exchanger.exchange(null);
                System.out.println(info);

                String info02 = exchanger.exchange(null);
                System.out.println(info02);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


}
