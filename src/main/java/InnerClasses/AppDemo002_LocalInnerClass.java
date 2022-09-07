package InnerClasses;

public class AppDemo002_LocalInnerClass {

    static int v = 7;
    int g = 8;

    void doAction01(int e){
        int r = 5;
        class LocalInnerTest {
            private final static int q = 9;
            public int w = g;
            int t = e;
            int y = r;
            int u = v;
        }
        LocalInnerTest local = new LocalInnerTest();
    }

    void doAction2(){
        class LocalInnerTest  {

        }
        LocalInnerTest local = new LocalInnerTest();
    }


    public static void main(String[] args) {
        AppDemo002_LocalInnerClass main = new AppDemo002_LocalInnerClass();
        main.doAction01(8);
        main.doAction2();

    }
}
