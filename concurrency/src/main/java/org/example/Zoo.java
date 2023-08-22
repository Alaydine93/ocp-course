package org.example;

public class Zoo {
    public static void main(String... args){
        var job = new Thread(() -> pause());

        job.setDaemon(false);
        job.start();
        System.out.println("Main method finished");
    }
    public static void pause() {
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {}
        System.out.println("Thread finished");
    }
}
