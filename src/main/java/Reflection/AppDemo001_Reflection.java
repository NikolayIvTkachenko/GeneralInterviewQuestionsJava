package Reflection;

import java.lang.reflect.*;

public class AppDemo001_Reflection {

    public static void main(String[] args) throws IllegalAccessException {

        SomeClass someClass = new SomeClass();
        Class clss = someClass.getClass();
        System.out.println(clss.getName());

        System.out.println();
        System.out.println("== Constructors ===");
        Constructor[] constructors = clss.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println("Constructor name = " + constructor.getName());
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter: parameters) {
                System.out.println("Parameter name: " + parameter.getName());
                System.out.println("Parameter Type: " + parameter.getType());
            }
        }

        System.out.println();
        System.out.println("== Methods ===");
        Method[] methods = clss.getMethods();
        for(Method method: methods){
            System.out.println("Method Name: " + method.getName());
            Parameter[] parameters = method.getParameters();
            for(Parameter parameter : parameters){
                System.out.println("Method name: " + method.getName());
                System.out.println("Method Type name: " + parameter.getType().getName());
            }
            System.out.println("Modifiers: " + Modifier.toString(method.getModifiers()));
            System.out.println("Return type: " + method.getReturnType().getName());
        }

        System.out.println();
        System.out.println("== Fields ===");
        Field[] fields = clss.getDeclaredFields();
        for(Field field: fields){
            System.out.println("Field name: " + field.getName());
            System.out.println(field.getType().getName());
            System.out.println(Modifier.toString(field.getModifiers()));
            field.setAccessible(true);
            System.out.println(field.getInt(someClass)); //=> class Reflection.AppDemo001_Reflection cannot access a member of class Reflection.SomeClass with modifiers "private static transient"
            field.setInt(someClass, 67);
            System.out.println(field.getInt(someClass));
        }



        //=>
        //Reflection.SomeClass
        //
        //== Constructors ===
        //Constructor name = Reflection.SomeClass
        //Constructor name = Reflection.SomeClass
        //Parameter name: arg0
        //Parameter Type: class java.lang.String
        //
        //== Methods ===
        //Method Name: someMethod
        //Method name: someMethod
        //Method Type name: java.lang.String
        //Method Name: wait
        //Method name: wait
        //Method Type name: long
        //Method name: wait
        //Method Type name: int
        //Method Name: wait
        //Method Name: wait
        //Method name: wait
        //Method Type name: long
        //Method Name: equals
        //Method name: equals
        //Method Type name: java.lang.Object
        //Method Name: toString
        //Method Name: hashCode
        //Method Name: getClass
        //Method Name: notify
        //Method Name: notifyAll

        //== Fields ===
        //Field name: i
        //int
        //private static transient
        //Field name: str
        //java.lang.String

    }
}


class SomeClass {
    //private static transient int i;
    private int i;
    //String str; //=>Attempt to get java.lang.String field "Reflection.SomeClass.str" with illegal data type conversion to int
    //	at java.base/jdk.internal.reflect.UnsafeFieldAccessorImpl.newGetIllegalArgumentException(UnsafeFieldAccessorImpl.java:69)
    //	at java.base/jdk.internal.reflect.UnsafeFieldAccessorImpl.newGetIntIllegalArgumentException(UnsafeFieldAccessorImpl.java:132)
    //	at java.base/jdk.internal.reflect.UnsafeObjectFieldAccessorImpl.getInt(UnsafeObjectFieldAccessorImpl.java:57)

    public SomeClass(){}

    public SomeClass(String str){
        //this.str = str;
    }

    public String someMethod(String str){
        System.out.println("This is " + str);
        return str;
    }
}

