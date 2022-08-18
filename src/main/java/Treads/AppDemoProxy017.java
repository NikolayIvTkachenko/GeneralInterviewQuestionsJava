package Treads;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;

public class AppDemoProxy017 {

    public static void main(String[] args) {

        //InvocationHandler handler = new TestProxy(new Integer(5));
        InvocationHandler handler = new TestProxy(6);
        Class[] classes = new Class[] {Comparable.class, Callable.class};
        Object proxy = Proxy.newProxyInstance(null, classes, handler);
        //proxy.getClass();
        //proxy.toString();
        //((Comparable)proxy).compareTo(5);
        //((Comparable)proxy).compareTo(3);
        //proxy.toString();
    }


    static class TestProxy implements InvocationHandler {

        Object target;

        public TestProxy(Object target){
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(args);
            return method.invoke(target, args);
        }
    }

}
