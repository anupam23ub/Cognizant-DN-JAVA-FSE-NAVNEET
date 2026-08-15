package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_37_JavapBytecode;

public class BytecodeDemo {

    public int add(int a, int b) {

        return a + b;
    }

    public static void main(String[] args) {

        BytecodeDemo obj =
                new BytecodeDemo();

        int result =
                obj.add(10, 20);

        System.out.println(
                "Result = " + result
        );
    }
}