package org.example.interfaces;

import org.example.records.Animal;

@FunctionalInterface
public interface CheckTrait {

    boolean test(Animal animal);
}
