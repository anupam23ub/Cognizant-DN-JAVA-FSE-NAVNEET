package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_17_ClassAndObjectCreation;

class Car {

    String make;
    String model;
    int year;

    public void displayDetails() {

        System.out.println("Make  : " + make);
        System.out.println("Model : " + model);
        System.out.println("Year  : " + year);
        System.out.println();

    }
}

public class CarDemo {

    public static void main(String[] args) {

        Car car1 = new Car();
        car1.make = "Toyota";
        car1.model = "Camry";
        car1.year = 2022;

        Car car2 = new Car();
        car2.make = "Honda";
        car2.model = "City";
        car2.year = 2023;

        System.out.println("Car 1 Details:");
        car1.displayDetails();

        System.out.println("Car 2 Details:");
        car2.displayDetails();

    }
}