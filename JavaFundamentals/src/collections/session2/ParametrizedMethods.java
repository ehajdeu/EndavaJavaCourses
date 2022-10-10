package collections.session2;

import java.util.ArrayList;

public class ParametrizedMethods {
    public static void main(String[] args) {
        ArrayList<Integer> arrayListInt = new ArrayList<>();
        arrayListInt.add(1);
        arrayListInt.add(0);
        arrayListInt.add(9);
        System.out.println(getSecondElement(arrayListInt));

        ArrayList<String> arrayListStr = new ArrayList<>();
        arrayListStr.add("Vasile");
        arrayListStr.add("Andrei");
        arrayListStr.add("Dima");
        System.out.println(getSecondElement(arrayListStr));

    }
    public static <T> T getSecondElement(ArrayList<T> arrayList){
        return arrayList.get(1);
    }
}
