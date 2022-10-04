package src.ch00;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterStreamTest {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        stringList.add("B");
        stringList.add("E");

        Iterator<String> iterator = stringList.iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            if(next.equals("B")) System.out.println(next);
        }

        for(int i=0; i<stringList.size(); i++) {
            if(stringList.get(i).equals("B")) System.out.println(stringList.get(i));
        }

        for(String s : stringList) {
            if(s.equals("B")) System.out.println(s);
        }

        stringList.stream().filter(v -> v.equals("B")).forEach(System.out::println);
    }
}
