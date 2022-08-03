package ComparableVsComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AppCompMain {

    public static void main(String[] args) {


        //Interface Comparable
        List<Computer> computers = new ArrayList<>();

        computers.add(new Computer("IBM", 16, 500, "Pentium-8", 2000));
        computers.add(new Computer("DELL", 16, 100, "Pentium-8", 3000));
        computers.add(new Computer("MACINTOSH", 32, 500, "Pentium-10", 4000));
        computers.add(new Computer("ASPERA", 48, 2500, "Pentium-20", 7000));


        Collections.sort(computers);

        for(Computer c : computers){
            System.out.println("Computer: " + c.toString());
        }


        //Object Comparator
        List<Laptop> laptops = new ArrayList<>();

        laptops.add(new Laptop("IBM", 16, 500, "Pentium-8", 2000));
        laptops.add(new Laptop("DELL", 8, 1000, "Pentium-8", 3000));
        laptops.add(new Laptop("MACINTOSH", 32, 500, "Pentium-10", 4000));
        laptops.add(new Laptop("ASPERA", 48, 2500, "Pentium-20", 7000));


        Comparator<Laptop> comLaptop = new Comparator<Laptop>() {
            @Override
            public int compare(Laptop o1, Laptop o2) {
                if(o1.getRam() > o2.getRam()) return 1;
                else if(o1.getRam() < o2.getRam()) return -1;
                else return 0;
            }
        };

        Collections.sort(laptops, comLaptop);

        for(Laptop l : laptops){
            System.out.println("Laptop: " + l.toString());
        }


    }

}
