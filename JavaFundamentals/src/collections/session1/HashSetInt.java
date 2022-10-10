package collections.session1;

import java.util.HashSet;

public class HashSetInt {
    public static void main(String[] args) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(1);
        hashSet1.add(3);
        hashSet1.add(0);
        hashSet1.add(12);

        HashSet<Integer> hashSet2 = new HashSet<>();
        hashSet2.add(3);
        hashSet2.add(7);
        hashSet2.add(1);
        hashSet2.add(24);

        HashSet<Integer> union = new HashSet<>(hashSet1);
        union.addAll(hashSet2);
        System.out.println(union);

        HashSet<Integer> intersect = new HashSet<>(hashSet1);
        intersect.retainAll(hashSet2);
        System.out.println(intersect);

        HashSet<Integer> substract = new HashSet<>(hashSet1);
        substract.removeAll(hashSet2);
        System.out.println(substract);
    }
}
