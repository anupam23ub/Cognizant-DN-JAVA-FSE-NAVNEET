package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_30_PatternMatchingSwitch;

public class PatternMatchingSwitchDemo {

    public static void printType(Object obj) {

        switch (obj) {

            case Integer i ->
                System.out.println("Integer value: " + i);

            case String s ->
                System.out.println("String value: " + s);

            case Double d ->
                System.out.println("Double value: " + d);

            case Boolean b ->
                System.out.println("Boolean value: " + b);

            case null ->
                System.out.println("Object is null");

            default ->
                System.out.println("Unknown type: "
                        + obj.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {

        printType(100);

        printType("Hello Java");

        printType(99.99);

        printType(true);

        printType(null);

        printType(new StringBuilder("Demo"));
    }
}