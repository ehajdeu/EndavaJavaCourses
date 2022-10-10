package collections.session1;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorEe {
    public static void main(String[] args) {
        String s = "madam";
        List<Character> symbols = new LinkedList<>();

        for (char ch : s.toCharArray()){ // impartim stringul in litere
            symbols.add(ch);
        }
        ListIterator<Character> iterator = symbols.listIterator();
        ListIterator<Character> prevIterator = symbols.listIterator(symbols.size());
        boolean isPlaindrom = true;
        while (iterator.hasNext() && prevIterator.hasPrevious()){
            if (iterator.next() != prevIterator.previous()){
                isPlaindrom = false;
            }
        }
        if (isPlaindrom == true){
            System.out.println(" IS Palindrom");
        } else {
            System.out.println("NOT Palindrom");
        }
    }
}
