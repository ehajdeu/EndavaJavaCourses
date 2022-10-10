package collections.session2;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Ion");
        queue.add("Andrei");
        queue.add("Leonid");
        queue.add("Ana");
        queue.add("Maria");

        System.out.println(queue);
        //[Ion, Andrei, Leonid, Ana, Maria]
        queue.remove();
        System.out.println(queue);
        //[Andrei, Leonid, Ana, Maria]
    }
}
