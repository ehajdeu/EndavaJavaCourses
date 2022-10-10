package stream.streams;

import stream.lambda.UniverStudent;

import java.util.ArrayList;
import java.util.List;

public class FlatMapEx {
    public static void main(String[] args) {
        UniverStudent st1 = new UniverStudent("Andrei", 'm', 22, 3, 9.4);
        UniverStudent st2 = new UniverStudent("Ina", 'f', 32, 3, 5.4);
        UniverStudent st3 = new UniverStudent("Dima", 'm', 19, 1, 6.8);
        UniverStudent st4 = new UniverStudent("Diana", 'f', 25, 2, 7.2);
        UniverStudent st5 = new UniverStudent("Sergiu", 'm', 26, 4, 8.8);

        Faculty f1 = new Faculty("Economics");
        Faculty f2 = new Faculty("Informatics");

        f1.addUniverStudentOnFaculty(st1);
        f1.addUniverStudentOnFaculty(st3);
        f1.addUniverStudentOnFaculty(st5);
        f2.addUniverStudentOnFaculty(st2);
        f2.addUniverStudentOnFaculty(st4);

        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(f1);
        facultyList.add(f2);

        facultyList.stream().filter(e -> e.name == "Informatics")
                .flatMap(element -> element.getUniverStudentsOnFaculty().stream())
                .forEach(System.out::println);


    }
}

class Faculty{
    String name;
    List<UniverStudent> UniverStudentsOnFaculty;

    public Faculty(String name) {
        this.name = name;
        UniverStudentsOnFaculty = new ArrayList<>();
    }

    public List<UniverStudent> getUniverStudentsOnFaculty() {
        return UniverStudentsOnFaculty;
    }

    public void addUniverStudentOnFaculty(UniverStudent UniverStudent){
        UniverStudentsOnFaculty.add(UniverStudent);
    }
}

