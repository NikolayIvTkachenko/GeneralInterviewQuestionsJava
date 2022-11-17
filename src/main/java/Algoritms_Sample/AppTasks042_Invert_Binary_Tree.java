package Algoritms_Sample;

public class AppTasks042_Invert_Binary_Tree {

    public static void main(String[] args) {


                /* Построим следующее дерево
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        preorder(root);
        System.out.println("");
        invertBinaryTree(root);
        preorder(root);

    }

    // Класс для хранения узла бинарного дерева
    static class Node
    {
        int data;
        Node left = null, right = null;

        Node(int data) {
            this.data = data;
        }
    }

    // Функция для обхода заданного бинарного дерева в прямом порядке
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Вспомогательная функция для замены левого поддерева на правое поддерево
    public static void swap(Node root)
    {
        if (root == null) {
            return;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    // Функция инвертирования заданного бинарного дерева с использованием прямого обхода
    public static void invertBinaryTree(Node root)
    {
        // базовый случай: если дерево пусто
        if (root == null) {
            return;
        }

        // поменять местами левое поддерево с правым поддеревом
        swap(root);

        // инвертируем левое поддерево
        invertBinaryTree(root.left);

        // инвертируем правое поддерево
        invertBinaryTree(root.right);
    }

}
