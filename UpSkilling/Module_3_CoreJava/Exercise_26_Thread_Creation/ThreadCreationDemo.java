package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_26_Thread_Creation;

class MessagePrinter implements Runnable {

    private String message;

    public MessagePrinter(String message) {
        this.message = message;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println(message + " - " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class ThreadCreationDemo {

    public static void main(String[] args) {

        Thread thread1 =
                new Thread(new MessagePrinter("Thread 1"));

        Thread thread2 =
                new Thread(new MessagePrinter("Thread 2"));

        thread1.start();
        thread2.start();
    }
}