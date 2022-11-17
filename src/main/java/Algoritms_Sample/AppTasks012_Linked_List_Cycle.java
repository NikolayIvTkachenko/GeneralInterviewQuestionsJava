package Algoritms_Sample;

//Given head, the head of a linked list, determine if the linked list has a cycle in it.
//
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
// Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
//
//Return true if there is a cycle in the linked list. Otherwise, return false.
//Example 01
//  3 -> 2 -> 0 -> -4
//       |_________ |
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
//
//
//Example 02
//
//  1 -> 2
//  |____|
//
//Input: head = [1,2], pos = 0
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
//
//
//Example 03
// 1
//
//Input: head = [1], pos = -1
//Output: false
//Explanation: There is no cycle in the linked list.
//


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class AppTasks012_Linked_List_Cycle {

    public static void main(String[] args) {

        //Example 01 =>    3 -> 2 -> 0 -> -4
        System.out.println("");
        System.out.println("Example 01 =>    3 -> 2 -> 0 -> -4");
        OneLinkedListNode node11 = new OneLinkedListNode(3);
        OneLinkedListNode node12 = new OneLinkedListNode(2);
        OneLinkedListNode node121 = new OneLinkedListNode(2);
        OneLinkedListNode node122 = new OneLinkedListNode(2);
        OneLinkedListNode node13 = new OneLinkedListNode(0);
        OneLinkedListNode node14 = new OneLinkedListNode(-4);

        node11.next = node12;
        node12.next = node121;
        node121.next = node122;
        node122.next = node13;
        node13.next = node14;
        node14.next = node12;

        System.out.println("");
        System.out.println("current.hashCode()");
        //Возвращает одну ссылку
        OneLinkedListNode current = node11;
        for(int i = 0; i<8; i++){
            System.out.println("Hash = " + current.hashCode());
            current = current.next;
        }
//        current.hashCode()
//        Hash = 999966131
//        Hash = 2065951873
//        Hash = 1791741888
//        Hash = 1595428806
//        Hash = 1072408673
//        Hash = 1531448569
//        Hash = 2065951873
//        Hash = 1791741888

        System.out.println("");
        System.out.println("customHashCode()");
        //customHashCode()
        current = node11;
        for(int i = 0; i<8; i++){
            System.out.println("Hash = " + current.customHashCode());
            current = current.next;
        }
        //customHashCode()
        //Hash = 3b9a45b3
        //Hash = 7b23ec81
        //Hash = 6acbcfc0
        //Hash = 5f184fc6
        //Hash = 3feba861
        //Hash = 5b480cf9
        //Hash = 7b23ec81
        //Hash = 6acbcfc0

        System.out.println("Result = " + defineCycleWithPosition(node11));
        System.out.println("Result 2 = " + defineCycleWithoutPosition(node11));


        //Example 02 =>  1 -> 2
        System.out.println("");
        System.out.println("Example 02 =>  1 -> 2");
        OneLinkedListNode node21 = new OneLinkedListNode(1);
        OneLinkedListNode node22 = new OneLinkedListNode(2);
        node21.next = node22;
        node22.next = node21;
        System.out.println("Result = " + defineCycleWithPosition(node21));
        System.out.println("Result 2 = " + defineCycleWithoutPosition(node21));


        //Example 03 =>  1
        System.out.println("");
        System.out.println("Example 03 =>  1");
        OneLinkedListNode node31 = new OneLinkedListNode(1);
        node31.next = null;
        System.out.println("Result = " + defineCycleWithPosition(node31));
        System.out.println("Result 2 = " + defineCycleWithoutPosition(node31));

    }

    //Условие значения не повторяются
    private static boolean defineCycleWithPosition(OneLinkedListNode node){
        //LinkedHashSet
        //LinkedHashSet<Integer> integerSet = new LinkedHashSet<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        boolean key = true;
        OneLinkedListNode current = node;
        while (key) {
            if(current != null) {
                if (!arrayList.contains(current.value)) {
                    arrayList.add(current.value);
                    current = current.next;
                } else {

                    key = false;
                    System.out.println("Element: " + arrayList.contains(current.value));
                    System.out.println("Pos: " + arrayList.indexOf(current.value));
                    return true;
                }
            }else{
                return false;
            }
        }
        return false;
    }



    private static boolean defineCycleWithoutPosition(OneLinkedListNode node){
        Set<OneLinkedListNode> sets = new HashSet<>();

        boolean key = true;
        OneLinkedListNode current = node;
        while(key) {

            if(sets.contains(current)){
                key = false;
                return true;
            }else{
                if(current != null) {
                    sets.add(current);
                    current = current.next;
                }else{
                    key = false;
                    return false;
                }
            }
        }
        return false;
    }



}

class OneLinkedListNode{

    int value;
    OneLinkedListNode next;

    public OneLinkedListNode(){}

    public OneLinkedListNode(int value){
        this.value = value;
    }


    public String customHashCode() {
        return this.toString().substring(this.toString().length()-8);
    }
}
