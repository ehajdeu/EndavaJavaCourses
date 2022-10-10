package stream.lambda;

import java.util.ArrayList;

public class StudentInfo {
    void testStudent(ArrayList<UniverStudent> students, StudentCheck checkSt){
        for (UniverStudent student:students){
            if (checkSt.check(student)){
                System.out.println(student);
            }
        }
    }
}
