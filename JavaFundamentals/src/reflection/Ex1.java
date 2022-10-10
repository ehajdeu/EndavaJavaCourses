package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class employeeClass = Class.forName("reflection.Employee");
//        Class employeeClass2 = Employee.class;
//        Employee emp = new Employee();
//        Class employeeClass3 = emp.getClass();
        Field someField = employeeClass.getField("id");
        System.out.println("Type of id field = " + someField.getType());

        System.out.println(" ------------------------------------------------------ ");

        Field [] fields = employeeClass.getFields();
        for (Field field : fields){
            System.out.println("Field " + field.getName() + ", with type " + field.getType() );
        }

        System.out.println(" ------------------------------------------------------ ");

        Field [] allFields = employeeClass.getDeclaredFields();

        for (Field field : allFields){
            System.out.println("Field " + field.getName() + ", with type " + field.getType() );
        }

        System.out.println(" ------------------------------------------------------ ");

        Method someMethod = employeeClass.getMethod("increaseSalary", Double.class);
        System.out.printf("Return type of method increaseSalary {} + parameter types {}",
                someMethod.getReturnType(),
                Arrays.toString(someMethod.getParameterTypes())
        );

        Constructor constructor = employeeClass.getConstructor();

    }
}
