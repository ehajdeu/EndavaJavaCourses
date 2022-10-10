package collections.session1;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private String name;
    private String surName;
    private int age;

    public Student(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student anotherStudent){
        if (this.age > anotherStudent.getAge()){
            return 1;
        } else if (this.age  == anotherStudent.getAge()){
            return 0;
        } else
            return -1;
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", surName='" + surName + '\'' +
            ", age=" + age +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
            Objects.equals(name, student.name) &&
            Objects.equals(surName, student.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, age);
    }
}
