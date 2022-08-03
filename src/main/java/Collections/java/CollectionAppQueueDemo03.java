package Collections.java;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CollectionAppQueueDemo03 {

    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.offer(4);
        queue.offer(5);
        queue.offer(1);

        System.out.println(queue.poll());
        System.out.println(queue.poll());


        PriorityQueue<UserProfile> usersProfile = new PriorityQueue<>(
                Comparator.comparing((UserProfile u) -> u.age)
        );

        usersProfile.offer(new UserProfile(20));
        usersProfile.offer(new UserProfile(30));
        usersProfile.offer(new UserProfile(40));

        System.out.println(usersProfile.poll().age);

    }


    static class UserProfile {
        private final Integer age;

        public UserProfile(Integer age) {
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }


    }
}
