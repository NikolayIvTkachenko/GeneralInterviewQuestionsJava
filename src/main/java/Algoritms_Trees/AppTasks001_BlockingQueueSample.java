package Algoritms_Trees;

import java.util.concurrent.ArrayBlockingQueue;

public class AppTasks001_BlockingQueueSample {

    public static void main(String[] args) {

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        Thread producer = new Thread(() ->{
            String[] words = new String[] {"Filly", "Silly", "Question", "Batman", "Joker", "Ice", "Robin", "Cat", "Penguin"};

            for(int i = 0; i < words.length && !Thread.interrupted();){
                try{

                    Thread.sleep(5000);
                    queue.put(words[i]);
                    System.out.println("producer: write to queue " + words[i] + ", number of elements in queue: "+ queue.size());
                    i++;
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {

            StringBuilder sb = new StringBuilder();
            while(!Thread.interrupted()) {
                try{
                    sb.setLength(0);
                    Thread.sleep(8000);
                    sb.append(queue.take());
                    System.out.println("Consumer: handle from queue -> reverse " + sb.reverse() + ", number of element in queue: " + queue.size());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //============================================//
        producer.start();
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        consumer.start();


    }

}
