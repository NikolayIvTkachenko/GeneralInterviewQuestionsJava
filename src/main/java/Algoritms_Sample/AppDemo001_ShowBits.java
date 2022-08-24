package Algoritms_Sample;

import java.io.PrintStream;

public class AppDemo001_ShowBits {

    private static PrintStream out = System.out;

    public static void main(String[] args) {

        ShowBits b = new ShowBits(8);
        ShowBits b4 = new ShowBits(32);
        ShowBits b8 = new ShowBits(64);


        out.println("128 in binary view");
        b.show(128, out);

        out.println("86732 in binary view");
        b4.show(86732, out);

        out.println("227655756 in binary view");
        b8.show(227655756, out);
    }

}
