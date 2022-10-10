package stream.streams;


import stream.lambda.UniverStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {
        UniverStudent st1 = new UniverStudent("Andrei", 'm', 22, 3, 9.4);
        UniverStudent st2 = new UniverStudent("Ina", 'f', 32, 3, 5.4);
        UniverStudent st3 = new UniverStudent("Dima", 'm', 19, 1, 6.8);
        UniverStudent st4 = new UniverStudent("Diana", 'f', 25, 2, 7.2);
        UniverStudent st5 = new UniverStudent("Sergiu", 'm', 26, 4, 8.8);

        List<UniverStudent> list = new ArrayList<>();
        list.add(st1);
        list.add(st2);
        list.add(st3);
        list.add(st4);
        list.add(st5);

        Map<Integer,List<UniverStudent>> map = list.stream().map(el -> {
            el.setName(el.getName().toUpperCase());
            return el;
        }).collect(Collectors.groupingBy(UniverStudent::getCourse));

        for (Map.Entry<Integer,List<UniverStudent>> element: map.entrySet()){
            System.out.println(element.getKey() + " " + element.getValue().toString());
        }

        Map<Boolean, List<UniverStudent>> map2 =
                list.stream().
                        collect(Collectors.partitioningBy(el -> el.getAvgGrade()>7));

        for (Map.Entry<Boolean, List<UniverStudent>> element: map2.entrySet()){
            System.out.println(element.getValue().toString());
        }

    }
}
