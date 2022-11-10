package Algoritms_Sample;

/*
Найти максимальное значение листа в дереве
Задачу решить без использования рекурсии, с использованием перечисления
Пример деоева

                10
               /  \
              6   14
             / \
            3   8
           / \
          1   4

 Максимальное значение = 14
 Елементов = 7

 */

import ComparableVsComparator.Laptop;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class AppTasks009_MaxLeafValue {

    public static void main(String[] args) {
        NodeV2 tree01 = createTree01();
        Integer maxValue = maxLeafValue(tree01);
        System.out.println("maxValue= " + maxValue);

    }



    private static int maxLeafValue(NodeV2 root){

        ArrayList<NodeV2> nodeList = new ArrayList<NodeV2>();
        Queue<NodeV2> queue = new LinkedList<>();

        queue.add(root);
        do {
            NodeV2 nodeV2 = queue.poll();
            nodeList.add(nodeV2);
            if(nodeV2.left != null) {
                queue.add(nodeV2.left);
            }
            if(nodeV2.right != null) {
                queue.add(nodeV2.right);
            }

        }while (!queue.isEmpty());

//        Comparator<NodeV2> comLaptop = new Comparator<NodeV2>() {
//            @Override
//            public int compare(NodeV2 o1, NodeV2 o2) {
//                if(o1.valueInt > o2.valueInt) return 1;
//                else if(o1.valueInt < o2.valueInt) return -1;
//                else return 0;
//            }
//        };



        System.out.println("nodeList.size = " + nodeList.size());
        //int result = nodeList.stream().flatMap(v -> v.valueInt).max(Integer::compare).get();
        // result = nodeList.stream().map(nodeV2 -> Collections.max(nodeV2.valueInt)).max(Comparator.comparing(Integer::intValue)).get();
        //int result = nodeList.stream().max()).get();
        Integer result = nodeList.stream().max((i, j) -> i.compareTo(j)).map(m -> m.valueInt).get();
        return result;
    }


    private static NodeV2 createTree01(){
        NodeV2 root = new NodeV2(10);
        NodeV2 node6 = new NodeV2(6);
        NodeV2 node14 = new NodeV2(14);
        NodeV2 node8 = new NodeV2(8);
        NodeV2 node3 = new NodeV2(3);
        NodeV2 node1 = new NodeV2(1);
        NodeV2 node4 = new NodeV2(4);
        root.left = node6;
        root.right = node14;
        node6.left = node3;
        node6.right = node8;
        node3.left = node1;
        node3.right = node4;
        return root;
    }

}
class NodeV2 implements Comparable<NodeV2> {
    Integer valueInt;
    NodeV2 left;
    NodeV2 right;
    public NodeV2(int value){
        this.valueInt = value;
    }

    @Override
    public int compareTo(@NotNull NodeV2 o) {
        if(this.valueInt > o.valueInt) return 1;
        else if(this.valueInt < o.valueInt) return -1;
        else return 0;
    }
}
