package WEEK1.design_pattern_exercises.exercise6;

public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("high_res_photo.png");

        System.out.println("First call:");
        image.display();

        System.out.println("\nSecond call:");
        image.display();
    }
}
