package Algoritms_Sample;

//
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
//
//Example 1:
//Input: s = "()"
//Output: true
//
//Example 2:
//Input: s = "()[]{}"
//Output: true
//
//Example 3:
//Input: s = "(]"
//Output: false
//


import java.util.Stack;

public class AppTasks013_Valid_Parentheses {
    public static void main(String[] args) {

        System.out.println("");
        System.out.println("s = \"()\"");
        char[] array01 = new char[2];
        array01[0] = '(';
        array01[1] = ')';
        System.out.println("Result = " + chaeckParanthesis(array01));

        System.out.println("");
        System.out.println("s = \"()[]{}\"");
        char[] array02 = new char[6];
        array02[0] = '(';
        array02[1] = ')';
        array02[2] = '[';
        array02[3] = ']';
        array02[4] = '{';
        array02[5] = '}';
        System.out.println("Result = " + chaeckParanthesis(array02));

        System.out.println("");
        System.out.println("s = \"(]\"");
        char[] array03 = new char[2];
        array03[0] = '(';
        array03[1] = ']';
        System.out.println("Result = " + chaeckParanthesis(array03));


    }

    private static boolean chaeckParanthesis(char[] array){
        System.out.println("chaeckParanthesis");
        //System.out.println("array = " + array.toString());
        Stack stack = new Stack<>();

        for(int i = 0; i < array.length; i++){
            if(stack.isEmpty()){
                stack.push(array[i]);
            } else {
                char p = (char) stack.peek();
                System.out.println("p = " + String.valueOf(p));
                System.out.println("array[i] = " + array[i]);
                switch (array[i]){
                    case ')':
                        if(p =='(')stack.pop();
                        break;
                    case ']':
                        if(p =='[')stack.pop();
                        break;
                    case '}':
                        if(p =='{')stack.pop();
                        break;
                    default:
                        stack.push(array[i]);
                        break;
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }


}
