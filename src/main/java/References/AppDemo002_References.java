package References;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class AppDemo002_References {

    public static void main(String[] args) throws InterruptedException {

        //Strong references
        Object obj = new Object();
        //Weak References //удаляется при первом GC (удобно для реализации кешей)
        WeakReference<Object> weakReference = new WeakReference<Object>(obj);
        //SoftReferences //удаляется CG когда заканчивается память
        SoftReference<Object> softReference = new SoftReference<>(obj);
        //PhantonRefernces //нужен, чтобы опредлить, что объект был собран сборщиком мусора
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue();
        PhantomReference<Object> phantomReference = new PhantomReference<>(obj, referenceQueue);
        obj = null;


    }

}
