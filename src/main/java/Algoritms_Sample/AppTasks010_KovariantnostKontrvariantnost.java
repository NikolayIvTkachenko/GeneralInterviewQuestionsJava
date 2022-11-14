package Algoritms_Sample;

import java.util.ArrayList;


//Инвариант List<Type>
//Что можно присвоить: только List<Type>
//Что можно прочитать: Type и предки Type
//Что можно добавлять: Type и наследники Type
//
//
//
//
//Ковариант List<? extends Type>
//Что можно присвоить: list<Type> и List и настледников Type
//Что можно прочитать: Type и предки Type
//Что можно добавлять: ничего
//
//
//
//Контрвариант List<? super Type>
//Что можно присвоить: List<Type> и List и предков Type
//Что можно прочитать: Object
//Что можно добавлять: Type и наследники Type
//
//




public class AppTasks010_KovariantnostKontrvariantnost {

    public static void main(String[] args) {

        Robot robot01 = new Robot();
        Robot robot02 = new Robot();
        RepairRobot repairRobot01 = new RepairRobot();
        RepairRobot repairRobot02 = new RepairRobot();
        WarRobot warRobot01 = new WarRobot();
        WarRobot warRobot02 = new WarRobot();
        StormRobot stormRobot01 = new StormRobot();
        StormRobot stormRobot02 = new StormRobot();

        warRobot02 = stormRobot02;
        robot02 = stormRobot02;

        //Инвариантность
        ArrayList<Robot> robotArrayList = new ArrayList<>();
        ArrayList<WarRobot> warRobotArrayList = new ArrayList<>();
        //robotArrayList = warRobotArrayList; //Инвариантность

    }

    //Ковариантность
    private static int totalWeight(ArrayList<? extends RepairRobot> repairRobots){
        int energy = 0;
        for(int i = 0; i < repairRobots.size(); i++){
            energy += repairRobots.get(i).energy;
        }

        Robot robot = repairRobots.get(0);//Получаем объект класса  свободно
        //repairRobots.add(new RepairRobot());//Но добавить в массив не можем

        return energy;
    }


    //Контрвариантность
    private static void addRepairRobot(ArrayList<? super RepairRobot> repairList){
        for(int i = 0; i < 10; i++) {
            repairList.add(new RepairRobot());

        }
        //WarRobot warrobot = repairList.get(0);//Не можем получить конктеный класс. Только объект
        //Robot robot = repairList.get(0);//Не можем получить конктеный класс. Только объект
        Object object = repairList.get(0);

    }


    private static class Robot {
        int energy;
    }

    private static class RepairRobot extends Robot {
        int energy;
    }

    private static class WarRobot extends RepairRobot {
        int weapon;
    }

    private static class StormRobot extends WarRobot {
        int speed;
    }

}
