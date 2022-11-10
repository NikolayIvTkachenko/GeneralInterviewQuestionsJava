package Algoritms_Sample;

/*
Найти сумму всех листьев в дервее
Пример деоева

                10
               /  \
              6   14
             / \
            3   8
           / \
          1   4

 Сумма всех листьев = 1 + 4 + 8 + 14 = 27

 */

public class AppTasks008_TreeSumAllLeaf {

    public static void main(String[] args) {
        Node tree01 = createTree01();

        Integer resultTree01 = SumtTeeLeaf(tree01);
        System.out.println("result = " + resultTree01);


    }

    private static Node createTree01(){
        Node root = new Node(10);
        Node node6 = new Node(6);
        Node node14 = new Node(14);
        Node node8 = new Node(8);
        Node node3 = new Node(3);
        Node node1 = new Node(1);
        Node node4 = new Node(4);
        root.left = node6;
        root.right = node14;
        node6.left = node3;
        node6.right = node8;
        node3.left = node1;
        node3.right = node4;
        return root;
    }

    private static int SumtTeeLeaf(Node root){
        int result = 0;

        result += SumAllLeafies(root, result);

        return result;
    }

    private static int SumAllLeafies(Node node, int result){

        if (node.left == null && node.right == null){
            System.out.println("node.valueInt = " + node.valueInt);
            result += node.valueInt;
            return result;
        }
        if(node.left != null) {
            result = SumAllLeafies(node.left, result);
        }
        if(node.right != null) {
            result = SumAllLeafies(node.right, result);
        }
        return result;
    }

}

class Node{
    int valueInt;
    Node left;
    Node right;
    public Node(int value){
        this.valueInt = value;
    }
}
