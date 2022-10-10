package collections.session1;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Andrei");
        hashSet.add("Petrea");
        hashSet.add("Leonid");
        hashSet.add("Seghei");

        System.out.println(hashSet);

        hashSet.remove("Andrei");
        System.out.println(hashSet);

        System.out.println(hashSet.contains("Leonid"));

        System.out.println(hashSet.size());

        System.out.println(hashSet.isEmpty());


    }
}
