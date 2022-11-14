package Algoritms_Trees;

import Algoritms_Queue_Stack.SimpleStack;

public class AppTasks003_StackSample {

    public static void main(String[] args) {

        testStack();
    }

    private static void testStack(){
        SimpleStack<Integer> stack = new SimpleStack<>();
        for(int i = 1; i < 10; i++){
            System.out.println(i);
            stack.push(i);
        }

        System.out.println("\n");
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }


}
