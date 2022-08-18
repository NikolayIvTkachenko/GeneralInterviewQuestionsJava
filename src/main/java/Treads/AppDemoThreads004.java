package Treads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppDemoThreads004 {



    public static void main(String[] args) {

        NameList nameList = new NameList();
        nameList.add("first");

        class MyThread extends Thread {


            @Override
            public void run() {
                System.out.println(nameList.removeFirst());
            }
        }

        MyThread myThread1 = new MyThread();
        myThread1.setName("one");
        myThread1.start();
        new MyThread().start();
    }




    static class NameList {
        private List list = Collections.synchronizedList(new ArrayList<>());

        public synchronized void add(String name){
            list.add(name);
        }

        public synchronized String removeFirst(){
            if (list.size() > 0 ){
                //demonstrate working error
                if(Thread.currentThread().getName().equals("one")){
                    Thread.yield();
                }
                return (String) list.remove(0);
            }
            return null;

        }
    }
}
