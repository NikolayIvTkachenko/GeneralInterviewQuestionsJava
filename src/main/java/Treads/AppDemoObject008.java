package Treads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AppDemoObject008 {

    static List<String> stringList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {


        new Operator().start();
        new Machine().start();



    }

    static class Operator extends Thread {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (true){
                synchronized (stringList) {
                    stringList.add(scanner.nextLine());
                    stringList.notify();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Machine extends Thread {
        @Override
        public void run() {
            while (stringList.isEmpty()){
                synchronized (stringList){
                    try {
                        stringList.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(stringList.remove(0));
                }
            }
        }
    }


}
