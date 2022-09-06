package Patterns.behaviour;

public class AppDemo008_Iterator {
    public static void main(String[] args) {
        String[] dataArray = {"One", "Two", "Three", "Four", "Five"};
        ArrayContainer arrayContainer = new ArrayContainer(dataArray);
        Iterator iterator = arrayContainer.getIterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}

interface ContainerCollection {
    Iterator getIterator();
}

class ArrayContainer implements ContainerCollection {

    String[] strArray;

    public ArrayContainer(String[] strArray){
        this.strArray = strArray;
    }

    @Override
    public Iterator getIterator() {
        return new ArrayIterator();
    }

    class ArrayIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < strArray.length;
        }

        @Override
        public Object next() {
            if(hasNext()) {
                return strArray[index++];
            }
            return null;
        }
    }
}


