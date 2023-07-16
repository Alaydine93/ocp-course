package ressources;

import java.io.IOException;

public class MyFileClass implements AutoCloseable{
    private final int num;

    public MyFileClass(int num){
        this.num = num;
    }

    @Override
    public void close() throws IOException {
        System.out.println("Closing " + num);
    }
}
