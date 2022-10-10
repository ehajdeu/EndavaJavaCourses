package collections.session2;

import java.util.ArrayList;
import java.util.List;

public class WildCards {
    public static void main(String[] args) {
        ArrayList<Double> intList = new ArrayList<>();
        intList.add(1D);
        intList.add(14D);
        intList.add(24D);
        sumOfNums(intList);
        showListElements(intList);
        List<String> strList = new ArrayList<>();
        strList.add("Vasile");
        strList.add("merge");
        strList.add("bine");
        showListElements(strList);
    }
    static void showListElements(List<?> list){
        System.out.println("Elements in list are: " + list.toString());
    }

    static void sumOfNums(ArrayList<? extends Number> list){
        double sum = 0;
        for (int i = 0; i < list.size(); i++){
            sum += list.get(i).doubleValue();
        }
        System.out.println("Sum is " + sum);
    }

}
//<?>
