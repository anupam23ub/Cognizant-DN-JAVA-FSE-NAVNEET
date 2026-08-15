package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_40_Virtual_Threads;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreadsDemo {

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
                    Thread.startVirtualThread(() -> {

                        System.out.println(
                                "Virtual Thread "
                                        + threadNumber
                                        + " is running"
                        );
                    });

            threads.add(thread);
        }

        for (Thread thread : threads) {

            thread.join();
        }

        long endTime =
                System.currentTimeMillis();

        System.out.println(
                "\nVirtual Threads Created: "
                        + threadCount
        );

        System.out.println(
                "Execution Time: "
                        + (endTime - startTime)
                        + " ms"
        );
    }
}