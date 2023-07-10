package org.example.interfaces;

@FunctionalInterface
public interface Climb {
    void reach();

    private void fall() {
        return;
    }
}
