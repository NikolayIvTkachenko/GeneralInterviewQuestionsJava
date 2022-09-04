package References;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class AppDemo001_PhantomReferences {

    public static void main(String[] args) throws InterruptedException {
        //PhantonRefernces //нужен, чтобы опредлить, что объект был собран сборщиком мусора
        TestObject obj = new TestObject();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue();
        PhantomReference<Object> phantomReference = new PhantomReference<>(obj, referenceQueue);
        //phantomReference.get(); //always get null
        //referenceQueue.remove(); //будет ждать пока obj  не собирется сборщикм мусора ..прогоамма будет висеть
        obj = null;
        new Thread(() -> {
            try {
                referenceQueue.remove();
                System.out.println("reference was removed");
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }).start();

        System.out.println("start cg");
        System.gc();
        System.out.println("gc was started");
        Thread.sleep(3000);
        System.out.println("End program");
    }

    static class TestObject {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("Object was finalized");
        }
    }

}
