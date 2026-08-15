import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressionDemo {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Rahul");
        names.add("Amit");
        names.add("Priya");
        names.add("Zara");
        names.add("Neha");

        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));

        System.out.println("Sorted List:");

        for (String name : names) {
            System.out.println(name);
        }
    }
}