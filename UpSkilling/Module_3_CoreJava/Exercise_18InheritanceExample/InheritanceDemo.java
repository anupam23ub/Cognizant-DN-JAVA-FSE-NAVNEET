package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_18InheritanceExample;

class Animal {

    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

public class InheritanceDemo {

    public static void main(String[] args) {

        Animal animal = new Animal();
        Dog dog = new Dog();

        System.out.println("Animal Sound:");
        animal.makeSound();

        System.out.println();

        System.out.println("Dog Sound:");
        dog.makeSound();
    }
}