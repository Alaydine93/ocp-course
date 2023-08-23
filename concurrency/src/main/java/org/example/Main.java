package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        singleThreadUsingExecutorService();
    }

    private static void singleThreadUsingExecutorService() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for(int i = 0; i < 3; i++){
                System.out.println("Printing record : " + i);
            }
        };
        try {
            Future<?> future = service.submit(() -> System.out.println("future task"));
            System.out.println("Begin");
            service.execute(printInventory);
            service.execute(printRecords);
            service.execute(printInventory);
            System.out.println("End");
        } finally {
            service.shutdown();
        }
    }
}