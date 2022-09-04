package Patterns.structural;

import java.util.HashMap;
import java.util.Map;

public class AppDemo005_FlyWeight {

    public static void main(String[] args) {
        //Если класс уже был создан, то не создаем его снова, а получаем ссылку на уже созданный
        FlyWeightStore flyWeightStore = new FlyWeightStore();
        Machine machine01 = flyWeightStore.getMachine("green");
        Machine machine02 = flyWeightStore.getMachine("red");
        Machine machine03 = flyWeightStore.getMachine("green");
        Machine machine04 = flyWeightStore.getMachine("blue");


        System.out.println(machine01);
        System.out.println(machine02);
        System.out.println(machine03);
        System.out.println(machine04);

        //Patterns.structural.Machine@7229724f -> flyWeightStore.getMachine("green");
        //Patterns.structural.Machine@4c873330 -> flyWeightStore.getMachine("red");
        //Patterns.structural.Machine@7229724f -> flyWeightStore.getMachine("green");
        //Patterns.structural.Machine@119d7047 -> flyWeightStore.getMachine("blue");
    }
}

class Machine {
    String color;
}

class FlyWeightStore {
    Map<String, Machine> map = new HashMap<>();
    Machine getMachine(String color){
        Machine machine = map.get(color);
        if(machine == null){
            machine = new Machine();
            machine.color = color;
            map.put(color, machine);
        }
        return machine;
    }

}


