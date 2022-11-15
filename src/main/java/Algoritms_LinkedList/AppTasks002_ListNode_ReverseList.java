package Algoritms_LinkedList;

public class AppTasks002_ListNode_ReverseList {


    public static void main(String[] args) {
        //1 -> 2 -> 3 -> 4 -> null
        //null <- 4 <- 3 <- 2 <- 1

        Solution solution = new Solution();

        ListNode listNode01 = new ListNode(1);
        ListNode listNode02 = new ListNode(2);
        ListNode listNode03 = new ListNode(3);
        ListNode listNode04 = new ListNode(4);


        listNode01.next = listNode02;
        listNode02.next = listNode03;
        listNode03.next = listNode04;
        listNode04.next = null;

        showAllRecord(listNode01);

        showAllRecord(solution.reverseList(listNode01));

    }

    private static class ListNode {
        int value;
        ListNode next;
        public ListNode(int x) {
            value = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "value=" + value +
                    //"next = " + next +
                    '}';
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

    private static void showAllRecord(ListNode node){
        while (node != null){
            System.out.print(node.toString());
            System.out.print(" -> ");
            node = node.next;
        }

    }

}
