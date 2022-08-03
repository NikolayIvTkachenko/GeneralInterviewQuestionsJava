package Collections.java;

import com.sun.tools.javac.Main;

import java.util.*;

public class CollectionSyncronizationAppDemo04 {

    private static Random random = new Random();
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        Thread t1 = new Thread( () -> {
            synchronized (CollectionSyncronizationAppDemo04.class) {
                list.add(random.nextInt());
            }

        });

        Thread t2 = new Thread(() -> {
            synchronized (CollectionSyncronizationAppDemo04.class){
                System.out.println("Reading the list: " + list);
            }

        });

        t1.start();
        t2.start();


        List<Integer> listSynch = Collections.synchronizedList(new ArrayList<>());

        Map<Integer, Integer> mapSynch = Collections.synchronizedMap(new HashMap<>());

        Set<Integer> setSynch = Collections.synchronizedSet(new HashSet<>());

    }


}
