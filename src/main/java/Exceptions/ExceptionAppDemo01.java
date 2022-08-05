package Exceptions;

import javax.management.RuntimeErrorException;

public class ExceptionAppDemo01 {

    public static void main(String[] args) throws RuntimeException{

        //throw new RuntimeException();
        //throw new RuntimeErrorException("");

        System.out.println("Test exception");

        throw new RuntimeException();

    }

}
