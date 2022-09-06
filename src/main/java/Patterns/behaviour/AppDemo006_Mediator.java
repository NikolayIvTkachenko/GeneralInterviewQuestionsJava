package Patterns.behaviour;

import java.util.ArrayList;
import java.util.List;

public class AppDemo006_Mediator {

    public static void main(String[] args) {

        ConcreteMediator mediator = new ConcreteMediator();
        mediator.add(new ConcreteCollegue(mediator, "first"));
        mediator.add(new ConcreteCollegue(mediator, "second"));
        ConcreteCollegue collegue = new ConcreteCollegue(mediator, "third");
        mediator.add(collegue);
        collegue.changeStatus();

    }
}

interface Mediator {
    void requestAll(Collegue collegue);
}

interface Collegue {
    void setFalse();
    void setTrue();
    void changeStatus();
}

class ConcreteCollegue implements Collegue{

    boolean status;
    Mediator mediator;
    String name;

    public ConcreteCollegue(Mediator mediator, String name){
        this.mediator = mediator;
        this.name = name;
    }

    @Override
    public void setFalse() {
        status = false;
        System.out.println(name + " Object status is False");
    }

    @Override
    public void setTrue() {
        status = true;
        System.out.println(name + " Object status is True");
    }

    @Override
    public void changeStatus() {
        mediator.requestAll(this);
    }
}

class ConcreteMediator implements Mediator {
    List<Collegue> collegueList = new ArrayList<>();

    void add(Collegue collegue) {
        collegueList.add(collegue);
    }

    @Override
    public void requestAll(Collegue collegue) {
        collegue.setTrue();
        for(Collegue coll: collegueList){
            if(coll != collegue) {
                coll.setFalse();
            }
        }
    }
}