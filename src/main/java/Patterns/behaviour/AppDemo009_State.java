package Patterns.behaviour;

public class AppDemo009_State {

    public static void main(String[] args) {
        ContextStat contextStat = new ContextStat(new LoverCaseStat(), " MaX");
        contextStat.doAction();
        contextStat.setStat(new UpperCaseStat());
        contextStat.doAction();



    }
}

interface Stat {
    void doAction(ContextStat context);
}

class LoverCaseStat implements Stat{

    @Override
    public void doAction(ContextStat context) {
        System.out.println(context.name.toLowerCase());
    }
}

class UpperCaseStat implements Stat{

    @Override
    public void doAction(ContextStat context) {
        System.out.println(context.name.toUpperCase());
    }
}

class ContextStat {
    Stat stat;
    String name;

    public ContextStat(Stat stat, String name){
        this.stat = stat;
        this.name = name;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    void doAction(){
        stat.doAction(this);
    }
}