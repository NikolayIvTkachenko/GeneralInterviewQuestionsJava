package Algoritms_LinkedList;

public class Person {

    int id;
    String name;
    String phone;

    public Person(int id, String name, String phone){
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
