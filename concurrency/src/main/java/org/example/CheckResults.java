package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CheckResults {
    private static int counter = 0;

    public static void main(String... args) {
       scheduledTasks();
    }

    private static void checkResultsWithFuture() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            Future<?> result = service.submit(() -> {
                for (int i = 0; i < 1_000_000; i++) {
                    counter++;
                }
            });
            result.get(10, TimeUnit.MILLISECONDS);
            System.out.println("Reached at : " + counter);
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            service.shutdown();
        }
    }

    private static void scheduledTasks(){
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = () -> System.out.println("Hello Zoo");
        Callable<String> task2 = () -> "Monkey";
        ScheduledFuture<?> r1 = service.schedule(task1, 10, TimeUnit.SECONDS);
        ScheduledFuture<?> r2 = service.schedule(task2, 15, TimeUnit.SECONDS);
    }

    private static void useCallable() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            Future<?> result = service.submit(() -> 30 + 11);
            System.out.println(result.get());
        } catch (ExecutionException | InterruptedException e) {
        } finally {
            service.shutdown();
        }
    }
}
