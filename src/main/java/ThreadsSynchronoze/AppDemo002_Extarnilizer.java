package ThreadsSynchronoze;

import java.io.*;

public class AppDemo002_Extarnilizer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Car car = new Car();
        car.wheel = 5;
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("test.txt")));
        car.writeExternal(objectOutputStream);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("test.txt")));
        Car car2 = new Car();
        car2.readExternal(objectInputStream);
        System.out.println(car2);

    }

    static class Car implements Externalizable {
        int wheel;

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(wheel);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            wheel = in.readInt();
        }

        @Override
        public String toString() {
            return "Car{" +
                    "wheel=" + wheel +
                    '}';
        }
    }

}
