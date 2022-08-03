package Collections.kotlin_java.collection_generic;

public class CollectionAppDemo01 {

    public static void main(String[] args) {

        var lists = new GenericList<String>();
        //var iterator = lists.iterator();
        lists.add("a");
        lists.add("b");

//        // [a, b, c]
//        // ->
//        while (iterator.hasNext()){
//            var current = iterator.next();
//            System.out.println(current);
//        }

        for (var item : lists){
            System.out.println(item);
        }



    }
}
