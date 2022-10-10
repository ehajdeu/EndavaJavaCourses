package stream.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReduceEx {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(7);
        list.add(12);
        list.add(2);
        int produce = list.stream().reduce((acumulator, element)->
                acumulator*=element).get();
        System.out.println(produce);

        List<String> listOfNames = new ArrayList<>();
        listOfNames.add("Andrei");
        listOfNames.add("Vasile");
        listOfNames.add("Petru");

        Optional<String> result = listOfNames.stream()
                .reduce((a,e)->
                        a+" "+e   );
        if (result.isPresent()){
            System.out.println(result);
        }

    }
}
