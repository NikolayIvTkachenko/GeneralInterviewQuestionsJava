package Algoritms_Sample;

//You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//
//Merge all the linked-lists into one sorted linked-list and return it.
//
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
//
//
//


import Algoritms_LinkedList.AppTasks002_ListNode_ReverseList;
import ComparableVsComparator.Laptop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AppTasks011_Merge_k_Sorted_List {

    public static void main(String[] args) {
        //[[1,4,5],[1,3,4],[2,6]]

        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(5);
        listNode11.next = listNode12;
        listNode12.next = listNode13;

        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode23 = new ListNode(4);
        listNode21.next = listNode22;
        listNode22.next = listNode23;

        ListNode listNode31 = new ListNode(2);
        ListNode listNode32 = new ListNode(6);
        listNode31.next = listNode32;

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = listNode11;
        listNodes[1] = listNode21;
        listNodes[2] = listNode31;

//        ListNode listNodeGeneral01 = listNode11;
//        ListNode listNodeGeneral02 = listNode21;
//        ListNode listNodeGeneral03 = listNode31;


        Solution solution = new Solution();
        solution.showArrayListnodes(listNodes);
        ListNode result = solution.mergeKLists(listNodes);
        System.out.println("ANSWER = ");
        solution.showListNode(result);



    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "{ ListNode = " + val +
                    " }";
        }
    }

    private static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            //Traverse all the linked lists and collect the values of the nodes into an array.
            //Sort and iterate over this array to get the proper value of nodes.
            //Create a new sorted linked list and extend it with the new nodes.

            List<ListNode> listNodesArray = new ArrayList<>();
            //Пройдем по всему массиву и соберем один единый массив
            for (int i = 0; i < lists.length; i++){
                ListNode current = lists[i];
                while (current != null){
                    listNodesArray.add(current);
                    current = current.next;
                }
            }

            Comparator<ListNode> comListNode = new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    if(o1.val > o2.val) return 1;
                    else if(o1.val < o2.val) return -1;
                    else return 0;
                }
            };
            System.out.println("Before sort listNodesArray = " + listNodesArray);
            Collections.sort(listNodesArray,comListNode);
            System.out.println("After sort listNodesArray = " + listNodesArray);



            System.out.println("listNodesArray.size = " + listNodesArray.size());
            for(int i = 0; i < listNodesArray.size()-1; i++){
                listNodesArray.get(i).next = listNodesArray.get(i+1);
            }
            return listNodesArray.get(0);
        }


        public void showListNode(ListNode listNode){
            while (listNode != null){
                System.out.print(listNode);
                listNode = listNode.next;
            }
        }

        public void showArrayListnodes(ListNode[] listNodes){
            for(int i=0; i< listNodes.length; i++){
                showListNode(listNodes[i]);
                System.out.print(" , ");
            }

        }
    }

}

