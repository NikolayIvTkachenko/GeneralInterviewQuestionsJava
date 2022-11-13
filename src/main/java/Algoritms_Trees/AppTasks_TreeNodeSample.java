package Algoritms_Trees;

public class AppTasks_TreeNodeSample {

    public static void main(String[] args) {

        TreeNodeV1 theTree = new TreeNodeV1(); // Создание дерева
        theTree.insert(50, 1.5); // Вставка трех узлов
        theTree.insert(25, 1.7);
        theTree.insert(75, 1.9);
        NodeV1 found = theTree.find(25); // Поиск узла с ключом 25
        if (found != null)
            System.out.println("Found the node with key 25");
        else
            System.out.println("Could not find node with key 25");
    }
}



class TreeNodeV1 {
    private NodeV1 root;

    public TreeNodeV1() {
    }

    public TreeNodeV1(NodeV1 root) {
        this.root = root;
    }

    public NodeV1 find(int key) {
        NodeV1 current = root;
        while(current.iData > key){
            if(key < current.iData) current = current.leftChild;
            else current = current.rightData;
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
                    current = current.rightData;
                    if(current == null) {
                        parent.rightData = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void delete(int id) {

    }

    //Три простых алгоритма обхода дерева
    //reorder - прямой
    //inoreder - симметричный
    //postoreder - обратный



}

class TreeTraversal {

    public TreeTraversal(){}

}


class NodeV1 {
    int iData;
    double fData;
    NodeV1 leftChild;
    NodeV1 rightData;

    public NodeV1() {}

    public NodeV1(int iData, double fData, NodeV1 leftChild, NodeV1 rightData) {
        this.iData = iData;
        this.fData = fData;
        this.leftChild = leftChild;
        this.rightData = rightData;
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
