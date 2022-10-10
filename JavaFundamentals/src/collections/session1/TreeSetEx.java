package collections.session1;

import java.util.Collections;
import java.util.TreeSet;
import javax.sound.midi.Soundbank;

public class TreeSetEx {
    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>();
        Student st1 = new Student("Vasile","Alekseev", 2);
        Student st2 = new Student("Andrei","Ivanov", 3);
        Student st3 = new Student("Dumitru","Felc", 1);
        Student st4 = new Student("Ion","Dendu", 5);
        Student st5 = new Student("Anton","Sarbu", 4);

        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st5);
        System.out.println(st1.compareTo(st2));
        System.out.println(treeSet);
        //[Student{name='Dumitru', surName='Felc', course=1}, Student{name='Vasile', surName='Alekseev', course=2}, Student{name='Andrei', surName='Ivanov', course=3}, Student{name='Anton', surName='Sarbu', course=4}, Student{name='Ion', surName='Dendu', course=5}]
        System.out.println(treeSet.first());
        //Student{name='Dumitru', surName='Felc', course=1}
        System.out.println(treeSet.last());
        //Student{name='Ion', surName='Dendu', course=5}
        System.out.println(treeSet.headSet(st4));
        //[Student{name='Dumitru', surName='Felc', course=1}, Student{name='Vasile', surName='Alekseev', course=2}, Student{name='Andrei', surName='Ivanov', course=3}, Student{name='Anton', surName='Sarbu', course=4}]
        System.out.println(treeSet.tailSet(st2));
        //[Student{name='Andrei', surName='Ivanov', course=3}, Student{name='Anton', surName='Sarbu', course=4}, Student{name='Ion', surName='Dendu', course=5}]
        System.out.println(treeSet.subSet(st2,st4));
//        //[Student{name='Andrei', surName='Ivanov', course=3}, Student{name='Anton', surName='Sarbu', course=4}]
    }
}

