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
        //SoftReference<Object> softReference = new SoftReference<>(obj);
        //PhantonRefernces //нужен, чтобы опредлить, что объект был собран сборщиком мусора
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue();
        PhantomReference<Object> phantomReference = new PhantomReference<>(obj, referenceQueue);
        obj = null;

        //System.out.println("softReference: " + softReference.get());
        System.out.println("weakReference: " + weakReference.get());
        System.out.println("phantomReference: " + phantomReference.get());
        System.out.println("==start gc ====");
        System.gc();
        System.out.println("==started gc ====");
        //System.out.println("softReference: " + softReference.get());
        System.out.println("weakReference: " + weakReference.get());
        System.out.println("phantomReference: " + phantomReference.get());



        //Result output
        //weakReference: java.lang.Object@119d7047
        //phantomReference: null
        //        ==start gc ====
        //==started gc ====
        //weakReference: null
        //phantomReference: null

    }

}
