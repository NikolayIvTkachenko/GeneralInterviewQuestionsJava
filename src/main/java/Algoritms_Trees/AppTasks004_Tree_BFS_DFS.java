package Algoritms_Trees;

//DFS - Deep-first search -> поиск в глубину
//BFS - Breadth-first search -> поиск в ширину

//TREE
//                    21
//              /           \
//             11            36
//           /    \       /     \
//          5     10     32     43
//           \          /      /  \
//            7        27     38  55
//


import Algoritms_Queue_Stack.SimpleQueue;
import Algoritms_Queue_Stack.SimpleStack;

public class AppTasks004_Tree_BFS_DFS {

    public static void main(String[] args) {

        TreeV3 root = new TreeV3(21,
                new TreeV3(11,
                    new TreeV3(5, null, new TreeV3(7)), new TreeV3(10)),
                new TreeV3(36,
                        new TreeV3(32, new TreeV3(27), null),
                        new TreeV3(43, new TreeV3(38), new TreeV3(55))));

        System.out.println("Sum of tree: " + root.sum());
        //Sum of tree: 285

        System.out.println("===");
        System.out.println("DFS - Deep-first search -> поиск в глубину");
        sumDeep(root);
        //DFS - Deep-first search -> поиск в глубину
        //21
        //11
        //5
        //7
        //10
        //36
        //32
        //27
        //43
        //38
        //55


        System.out.println("");
        System.out.println("BFS - Breadth-first search -> поиск в ширину");
        sumWide(root);
        //BFS - Breadth-first search -> поиск в ширину
        //21
        //11
        //36
        //5
        //10
        //32
        //43
        //7
        //27
        //38
        //55


    }

    //Обход дерева в ширину Breed-First search
    //Обход в ширину выполняется через очередь
    public static int sumWide(TreeV3 root) {
        SimpleQueue<TreeV3> queue = new SimpleQueue<>();
        queue.add(root);
        int summ = 0;

        while(!queue.isEmpty()){
            TreeV3 node = queue.remove();
            System.out.println(node.value);

            summ = summ + node.value;

            if(node.left != null){
                queue.add(node.left);
            }

            if(node.right != null){
                queue.add(node.right);
            }
        }

        return summ;
    }


    //Обход дерева в глубину Deep-First Search
    //Обход в глубину выполняется через стек

    public static int sumDeep(TreeV3 root){
        SimpleStack<TreeV3> stack = new SimpleStack<>();
        stack.push(root);

        int summ = 0;

        while(!stack.isEmpty()) {
            TreeV3 node = stack.pop();

            System.out.println(node.value);

            summ = summ + node.value;

            if(node.right != null){
                stack.push(node.right);
            }

            if(node.left != null){
                stack.push(node.left);
            }
        }
        return summ;
    }



    //метод подчета суммы рекурсией
    public static int sumRecursive(TreeV3 root){
        int summ = root.value;

        if(root.left != null){
            summ += sumRecursive(root.left);
        }

        if(root.right != null){
            summ += sumRecursive((root.right));
        }

        return summ;
    }

}

class TreeV3 {

    int value;
    TreeV3 left;
    TreeV3 right;

    public TreeV3(int value){
        this.value = value;
    }

    public TreeV3(int value, TreeV3 left, TreeV3 right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    //Вычисление суммы всех элементов дерева
    public int sum(){
        int summ = value;

        if(left != null){
            summ += left.sum();
        }

        if(right != null){
            summ += right.sum();
        }
        return summ;
    }




}
