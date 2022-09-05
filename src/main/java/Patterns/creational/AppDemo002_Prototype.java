package Patterns.creational;

public class AppDemo002_Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        StoreRobots storeRobots = new StoreRobots();
        Robot robot01 = new Robot();
        storeRobots.setRobot(robot01);

        Robot robot02 = storeRobots.getRobot();

        System.out.println("robot01 = " + robot01);
        System.out.println("robot02 = " + robot02);
    }
}

class Robot implements Cloneable {
    @Override
    protected Robot clone() throws CloneNotSupportedException {
        return (Robot) super.clone();
    }
}

class StoreRobots {
    protected Robot robot;

    public Robot getRobot() throws CloneNotSupportedException {
        return robot.clone();
    }

    public void setRobot(Robot robot){
        this.robot = robot;
    }
}
