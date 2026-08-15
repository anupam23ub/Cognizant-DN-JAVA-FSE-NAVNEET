package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_39_Reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionDemo {

    public static void main(String[] args) {

        try {

            Class<?> clazz =
                    Class.forName("Student");

            System.out.println(
                    "Class Name: "
                            + clazz.getName()
            );

            System.out.println("\nMethods:");

            Method[] methods =
                    clazz.getDeclaredMethods();

            for (Method method : methods) {

                System.out.println(
                        "Method: "
                                + method.getName()
                );

                Parameter[] parameters =
                        method.getParameters();

                for (Parameter parameter : parameters) {

                    System.out.println(
                            " Parameter Type: "
                                    + parameter.getType()
                                            .getSimpleName()
                    );
                }
            }

            Object obj =
                    clazz.getDeclaredConstructor()
                            .newInstance();

            Method greetMethod =
                    clazz.getDeclaredMethod(
                            "greet",
                            String.class
                    );

            System.out.println(
                    "\nInvoking greet() dynamically:"
            );

            greetMethod.invoke(
                    obj,
                    "Rahul"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}