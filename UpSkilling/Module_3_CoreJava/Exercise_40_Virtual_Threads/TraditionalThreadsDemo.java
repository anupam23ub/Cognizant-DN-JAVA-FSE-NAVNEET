package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_40_Virtual_Threads;

import java.util.ArrayList;
import java.util.List;

public class TraditionalThreadsDemo {

    public static void main(String[] args)
            throws InterruptedException {

        int threadCount = 100_000;

        List<Thread> threads =
                new ArrayList<>();

        long startTime =
                System.currentTimeMillis();

        for (int i = 1; i <= threadCount; i++) {

            int threadNumber = i;

            Thread thread =
                    new Thread(() -> {

                        System.out.println(
                                "Platform Thread "
                                        + threadNumber
                                        + " is running"
                        );
                    });

            thread.start();

            threads.add(thread);
        }

        for (Thread thread : threads) {

            thread.join();
        }

        long endTime =
                System.currentTimeMillis();

        System.out.println(
                "\nPlatform Threads Created: "
                        + threadCount
        );

        System.out.println(
                "Execution Time: "
                        + (endTime - startTime)
                        + " ms"
        );
    }
}