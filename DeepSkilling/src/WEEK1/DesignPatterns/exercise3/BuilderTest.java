package WEEK1.DesignPatterns.exercise3;

public class BuilderTest {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32GB")
                .setStorage("2TB NVMe SSD")
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("16GB")
                .build();

        System.out.println("Gaming Setup: " + gamingPC);
        System.out.println("Office Setup: " + officePC);
    }
}
