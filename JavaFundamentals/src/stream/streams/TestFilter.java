package stream.streams;

import java.util.ArrayList;
import java.util.List;

public class TestFilter {
    public static void main(String[] args) {
        Student st1 = new Student("Vasile",20,3,6.7);
        Student st2 = new Student("Andrei",18,2,9.3);
        Student st3 = new Student("Ion",34,1,8.6);
        Student st4 = new Student("Petru",23,4,7.7);

        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);

        Student student = students.stream()
                        .filter(element -> element.getCourse()>=2 && element.getAverageGrade()>7)
                                .findAny()
                .get();

        System.out.println(student);

    }
}
