package References;

import java.lang.ref.WeakReference;

public class AppDemo001_References {

    public static void main(String[] args) {

        //Strong references
        Object obj = new Object();

        //Weak References //удаляется при первом GC (удобно для реализации кешей)
        WeakReference<Object> weakReference = new WeakReference<Object>(obj);

        Object obj1 = weakReference.get();

    }


}
