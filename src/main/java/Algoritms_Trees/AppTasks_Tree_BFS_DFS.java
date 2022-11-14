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


public class AppTasks_Tree_BFS_DFS {

    public static void main(String[] args) {

        TreeV3 root = new TreeV3(21,
                new TreeV3(11,
                    new TreeV3(5, null, new TreeV3(7)), new TreeV3(9)),
                new TreeV3(36,
                        new TreeV3(32, new TreeV3(27), null),
                        new TreeV3(43, new TreeV3(38), new TreeV3(55))));

        System.out.println("Sum of tree: " + root.sum());


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
