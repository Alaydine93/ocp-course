package org.example;

public class Crate<T> {

    private T content;

    public T lookInCrate() {
        return this.content;
    }

    public void packCrate(T content) {
        this.content = content;
    }
}
