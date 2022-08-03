package Collections.java;

import java.util.HashMap;

public class CollectionAppHashMapDemo03 {

    public static void main(String[] args) {

        HashMap<String, Integer> populationByCity = new HashMap<>();

        populationByCity.put("New York", 230021);
        populationByCity.put("Las Vegas", 112234);
        populationByCity.put("San Francisco", 113561);


        Integer population = populationByCity.get("New York");

        if(populationByCity.containsKey("New York")){
            System.out.println("We got New York's population");
        }

        populationByCity.keySet();
        populationByCity.values();
        populationByCity.entrySet();

    }
}
