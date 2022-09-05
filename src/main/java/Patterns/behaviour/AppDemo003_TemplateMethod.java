package Patterns.behaviour;

public class AppDemo003_TemplateMethod {
    public static void main(String[] args) {
        TemplateMethod templateMethod01 = new Task();
        templateMethod01.run();


    }
}


abstract class TemplateMethod {
    abstract void methodOne();
    abstract void methodTwo();
    abstract void methodThree();

    void run(){
        methodOne();;
        methodTwo();
        methodThree();
    }
}

class Task extends TemplateMethod {

    @Override
    void methodOne() {
        System.out.println("Action One");
    }

    @Override
    void methodTwo() {
        System.out.println("Action One");
    }

    @Override
    void methodThree() {
        System.out.println("Action Three");
    }
}