package References;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class AppDemo001_References {

    public static void main(String[] args) throws InterruptedException {

        //Strong references
        Object obj = new Object();

        //Weak References //удаляется при первом GC (удобно для реализации кешей)
        WeakReference<Object> weakReference = new WeakReference<Object>(obj);

        Object obj1 = weakReference.get();


        //SoftReferences //удаляется CG когда заканчивается память
        SoftReference<Object> softReference = new SoftReference<>(obj);


        //PhantonRefernces //нужен, чтобы опредлить, что объект был собран сборщиком мусора
        Object obj2 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue();
        PhantomReference<Object> phantomReference = new PhantomReference<>(obj2, referenceQueue);
        phantomReference.get(); //always get null
        //referenceQueue.remove(); //будет ждать пока obj  не собирется сборщикм мусора ..прогоамма будет висеть
        obj2 = null;
        new Thread(){
            @Override
            public void run() {
                try {
                    referenceQueue.remove();
                    System.out.println("reference was removed");
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }.start();
        System.out.println("start cg");
        System.gc();

    }


}
