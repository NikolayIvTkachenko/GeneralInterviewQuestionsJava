package InnerClasses;

public class AppDemo001_Inner {

    public int n = 11;
    static int m = 66;

    static class StaticClassInner{
        void methodStaticClassInnerDo(){
            System.out.println("m = " + m);
        }
    }

    class InnerClass{
        private int h = 40;
        void methodInnerClassDo(){
            System.out.println("n = " + n);
            System.out.println("m = " + m);
        }
    }

    InnerClass innerClass03 = new InnerClass();

    void methodMainDo(){
        InnerClass innerClass02 = new InnerClass();
        innerClass02.methodInnerClassDo();
        System.out.println("innerClass02.h = " + innerClass02.h);
        innerClass03.methodInnerClassDo();
    }

    void methodInnerClass(){
        class InnerClasInsideMethod{
            void methodDo(){
                System.out.println("Test InnerClasInsideMethod methodDo");
            }
        }
        InnerClasInsideMethod innerClasInsideMethod = new InnerClasInsideMethod();
        innerClasInsideMethod.methodDo();
    }


    public static void main(String[] args) {

        System.out.println("== StaticClassInner ====");
        StaticClassInner staticClassInner = new StaticClassInner();
        staticClassInner.methodStaticClassInnerDo();

        System.out.println("== AppDemo001_Inner ====");
        AppDemo001_Inner appDemo001_inner = new AppDemo001_Inner();
        appDemo001_inner.methodMainDo();

        System.out.println("== AppDemo001_Inner InnerClass ====");
        InnerClass innerClass03 = appDemo001_inner.new InnerClass();
        innerClass03.methodInnerClassDo();

        System.out.println("== OutInner  ====");
        OutInner outInner = new OutInner();
        outInner.methodDo();

        System.out.println("== AppDemo001_Inner methodInnerClass()  ====");
        AppDemo001_Inner appDemo001_inner02 = new AppDemo001_Inner();
        appDemo001_inner02.methodInnerClass();

    }

}


class OutInner{
    void methodDo(){
        AppDemo001_Inner.StaticClassInner innerClass04 = new AppDemo001_Inner.StaticClassInner();
        innerClass04.methodStaticClassInnerDo();
    }
}
