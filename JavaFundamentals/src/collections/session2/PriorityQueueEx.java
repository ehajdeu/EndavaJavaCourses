//package collections.session2;
//
//import java.util.PriorityQueue;
//import Collections.session1.Student;
//import java.util.PriorityQueue;
//import java.util.Queue;
//
//public class PriorityQueueEx {
//    public static void main(String[] args) {
//        Queue<Student> studentQueue = new PriorityQueue<>();
//        Student st1 = new Student("Vasile","Alekseev", 2);
//        Student st2 = new Student("Andrei","Ivanov", 3);
//        Student st3 = new Student("Dumitru","Felc", 1);
//        Student st4 = new Student("Ion","Dendu", 5);
//        Student st5 = new Student("Anton","Sarbu", 4);
//
//        studentQueue.add(st1);
//        studentQueue.add(st2);
//        studentQueue.add(st3);
//        studentQueue.add(st4);
//        studentQueue.add(st5);
//
//        System.out.println(studentQueue);
//        //[Student{name='Dumitru', surName='Felc', course=1}, Student{name='Andrei', surName='Ivanov', course=3}, Student{name='Vasile', surName='Alekseev', course=2}, Student{name='Ion', surName='Dendu', course=5}, Student{name='Anton', surName='Sarbu', course=4}]
//        studentQueue.poll();
//        System.out.println(studentQueue);
//        //[Student{name='Vasile', surName='Alekseev', course=2}, Student{name='Andrei', surName='Ivanov', course=3}, Student{name='Anton', surName='Sarbu', course=4}, Student{name='Ion', surName='Dendu', course=5}]
//    }
//}
