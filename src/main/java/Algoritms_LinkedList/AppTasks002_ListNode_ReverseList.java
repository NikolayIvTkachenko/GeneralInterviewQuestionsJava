package Algoritms_LinkedList;

public class AppTasks002_ListNode_ReverseList {


    public static void main(String[] args) {

    }

    private static class ListNode {
        int value;
        ListNode next;
        public ListNode(int x) {
            value = x;
        }
    }

    private static class Solution {
        public ListNode reverseList(ListNode head){
            ListNode previousNode = null;
            ListNode currentNode = head;
            while(currentNode != null){
                ListNode nextNode = currentNode.next;
                currentNode.next = previousNode;
                previousNode = currentNode;
                currentNode = nextNode;
            }
            return previousNode;
        }
    }
}
