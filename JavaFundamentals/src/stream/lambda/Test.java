package stream.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Test {
    public static void main(String[] args) {
        UniverStudent st1 = new UniverStudent("Vasile",'M',18,1,7.5);
        UniverStudent st2 = new UniverStudent("Ana",'F',19,2,9.5);
        UniverStudent st3 = new UniverStudent("Alexei",'M',22,4,5.5);
        UniverStudent st4 = new UniverStudent("Dumitru",'M',20,3,8.2);
        UniverStudent st5 = new UniverStudent("Ion",'M',29,3,6.8);

        ArrayList<UniverStudent> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);


        // Studentii cu varsta mai mare de 19 prin clase anonime
        StudentInfo info = new StudentInfo();
        info.testStudent(students, new StudentCheck() {
            @Override
            public boolean check(UniverStudent s) {
                return s.getAge()>19;
            }
        });
        System.out.println("------------------------------------------------------------------");

        // Fix asa doar ca prin Lambda
        info.testStudent(students,(UniverStudent s) -> {return s.getAge() > 19; });
        System.out.println("------------------------------------------------------------------");

        // Studentii cu nota medie mai mica ca 8
        info.testStudent(students,s -> s.getAvgGrade() < 8);
        System.out.println("------------------------------------------------------------------");

        // Studentii cu sexul = Masculin, varsta > 19 si Media > 8
        info.testStudent(students,(UniverStudent s) -> s.getAge()>19 && s.getSex() == 'M' && s.getAvgGrade() > 8);

        System.out.println("------------------------------------------------------------------");
        Collections.sort(students, Comparator.comparingInt(UniverStudent::getAge));
        System.out.println(students);
    }
}
