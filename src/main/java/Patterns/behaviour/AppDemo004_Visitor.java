package Patterns.behaviour;

public class AppDemo004_Visitor {
    public static void main(String[] args) {

        Robot robot01 = new BattleRobot();
        robot01.doJob(new VisitorImplementation());
    }
}

//interface Robot {
//    void doJob();
//}

//class BuildRobot implements Robot {
//
//    @Override
//    public void doJob() {
//        System.out.println("Building house");
//    }
//}
//
//class BattleRobot implements Robot {
//
//    @Override
//    public void doJob() {
//        System.out.println("Take a pert in the Battle");
//    }
//}

interface Robot {
    void doJob(Visitor visitor);
}

class BuildRobot implements Robot {

    @Override
    public void doJob(Visitor visitor) {
        visitor.doWork();
    }
}

class BattleRobot implements Robot {

    @Override
    public void doJob(Visitor visitor) {
        visitor.doBattle();
    }
}

interface Visitor {
    void doWork();
    void doBattle();
}

class VisitorImplementation implements Visitor {

    @Override
    public void doWork() {
        System.out.println("Building house");
    }

    @Override
    public void doBattle() {
        System.out.println("Take a pert in the Battle");
    }
}