package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_19_InterfaceImplementation;

interface Playable {

    void play();
}

class Guitar implements Playable {

    @Override
    public void play() {
        System.out.println("Playing Guitar");
    }
}

class Piano implements Playable {

    @Override
    public void play() {
        System.out.println("Playing Piano");
    }
}

public class InterfaceDemo {

    public static void main(String[] args) {

        Guitar guitar = new Guitar();
        Piano piano = new Piano();

        System.out.println("Guitar:");
        guitar.play();

        System.out.println();

        System.out.println("Piano:");
        piano.play();
    }
}