package Algoritms_Trees;

import org.w3c.dom.Node;

public class AppTasks_TreeNodeSample {

    public static void main(String[] args) {

        TreeNodeV1 theTree = new TreeNodeV1(); // Создание дерева
        theTree.insert(50, 1.5); // Вставка трех узлов
        theTree.insert(25, 1.7);
        theTree.insert(75, 1.9);
        theTree.insert(95, 2.9);
        theTree.insert(65, 2.2);
        theTree.insert(23, 0.9);
        theTree.insert(43, 1.2);

        NodeV1 found = theTree.find(25); // Поиск узла с ключом 25
        if (found != null)
            System.out.println("Found the node with key 25");
        else
            System.out.println("Could not find node with key 25");

        System.out.println();
        System.out.println("OUTPUT TREE");
        TreeTraversal treeTraversal = new TreeTraversal();
        treeTraversal.inOrder(theTree.getRoot());

        System.out.println();
        System.out.println("OUTPUT TREE AFTER DELETE");
        theTree.delete(65);
        treeTraversal.inOrder(theTree.getRoot());

        System.out.println();
        System.out.println("MIN and MAX");
        System.out.println();
        int iData = theTree.minimum().iData;
        System.out.println("theTree.minimum().iData = " + iData);

        System.out.println();
        iData = theTree.maximum().iData;
        System.out.println("theTree.maximum().iData = " + iData);


    }
}



class TreeNodeV1 {
    private NodeV1 root;

    public TreeNodeV1() {
    }

    public TreeNodeV1(NodeV1 root) {
        this.root = root;
    }

    public NodeV1 getRoot(){
        return root;
    }

    public NodeV1 find(int key) {
        NodeV1 current = root;
        while(current.iData > key){
            if(key < current.iData) current = current.leftChild;
            else current = current.rightChild;
            if(current == null) return null;
        }
        return current;
    }

    public void insert(int id, double dd) {
        NodeV1 newNode = new NodeV1();
        newNode.iData = id;
        newNode.fData = dd;

        if(root == null){
            root = newNode;
        } else {
            NodeV1 current = root;
            NodeV1 parent;
            while(true) {
                parent = current;
                if(id < current.iData){ //идем на лево
                    current = current.leftChild;
                    if(current == null){ //Если достигнут конец цепочки
                        parent.leftChild = newNode; //втавить слева
                        return;
                    }
                } else { //идем на права
                    current = current.rightChild;
                    if(current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }


    //Узел с минимальным значением ключа, крайне левый
    public NodeV1 minimum(){
        NodeV1 current, last;
        current = root;
        last = current;
        while(current != null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    //Узел с максимальным значением ключа, крайне правый
    public NodeV1 maximum(){
        NodeV1 current, last;
        current = root;
        last = current;
        while(current != null){
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public boolean delete(int key) {

        NodeV1 current = root;
        NodeV1 parent = root;
        boolean isLeftChild = true;

        //Определяем узел и определяем где он, слева или справа,
        //Если узла нет, то возвращаем => false
        while(current.iData != key){
            parent = current;
            if(key < current.iData){
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null) return false;
        }

        //Если цзел не имеет потомков, то просто удаляем
        if(current.leftChild==null
                && current.rightChild==null){
            if(current == root) root = null;
            else if(isLeftChild) parent.leftChild = null;
            else parent.rightChild = null;
        }

        //Если нет правого потомка, узел заменяется левым поддеревом
        else if (current.rightChild == null){
            if(current == root) root = current.leftChild;
            else if(isLeftChild) //Левый потомок родителя
                parent.leftChild = current.leftChild;
            else  //Правый потомок родителя
                parent.rightChild = current.leftChild;
        }

        //Если нет левого потомка, узел заменяется правым поддеревом
        else if(current.leftChild == null){
            if(current == root)
                root = current.rightChild;
            else if(isLeftChild) //левый потомок родителя
                parent.leftChild = current.rightChild;
            else //Правый потомок родителя
                parent.rightChild = current.rightChild;
        }

        //Если удаляемый узел имеет двух потомков
        //Замена узла приемников из правой ветки, девая ветка???
        //Фактически ищем наименьший узел в наборе узлов, больших исходного узла.
        //Сначала программа переходит к правому потомку исходного узла,
        //ключ которого должен быть больше ключа узла. Затем она переходит к левому
        //потомка и т.д., следуя вниз по цепочке левых потомков.
        //Последний левый потомок на этом
        //пути является преемником исходного узла
        //Если у правого потомка исходного узла нет левых потомков,
        // то сам правый потомок станивтся преемником
        //ДВА ПОТОМКА, УЗЕЛ ЗАМЕНЯЕТСЯ ПРИЕМНИКОМ
        else{
            //ПОИСК ПРИЕМНИКА ДЛЯ УДАЛЯЕМОГО УЗЛА (CURRENT)
            NodeV1 successor = getSuccessor(current);

            if(current == root) root = successor;
            else if(isLeftChild) parent.leftChild = successor;
            else parent.rightChild = successor;

            //Преемник связывается с левым потомком current
            successor.leftChild = current.leftChild;
        }

        return true;
    }


    //Метод возвращает узел со следующим после delNode
    //для этого он сначала переходит к правому потомку, а затем
    //отслеживает цепочку левых потомков этого узла
    private NodeV1 getSuccessor(NodeV1 delNode){
        NodeV1 successorParent = delNode;
        NodeV1 successor = delNode;
        NodeV1 current = delNode.rightChild; //переходим к правому потомку

        while(current != null){ //выполняется пока есть левые потомки
            successorParent = successor;
            successor = current;
            current = current.leftChild; //Переход к левому потомку
        }

        //successor - содержит приемника
        //Если приемник не является правым потомком
        //создать связи между узлами
        if(successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    //Три простых алгоритма обхода дерева
    //reorder - прямой
    //inoreder - симметричный
    //postoreder - обратный



}

class TreeTraversal {

    public TreeTraversal(){}

    //inoreder - симметричный
    public void inOrder(NodeV1 localRoot){

        if(localRoot != null){
            System.out.print(" " + localRoot.iData);
            inOrder(localRoot.leftChild);
            inOrder(localRoot.rightChild);
        }
    }

}


class NodeV1 {
    int iData;
    double fData;
    NodeV1 leftChild;
    NodeV1 rightChild;

    public NodeV1() {}

    public NodeV1(int iData, double fData, NodeV1 leftChild, NodeV1 rightChild) {
        this.iData = iData;
        this.fData = fData;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}

class NodeV2 {
    Person p;
    NodeV2 leftChild;
    NodeV2 rightChild;

    public NodeV2() {}

    public NodeV2(Person p, NodeV2 leftChild, NodeV2 rightChild) {
        this.p = p;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}


class Person {
    int iData;
    double fData;

    public Person(int iData, double fData) {
        this.iData = iData;
        this.fData = fData;
    }
}
