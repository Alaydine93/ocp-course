package org.example.utils;

import org.example.Squirrel;

import java.util.Comparator;

public class MultifieldComparator implements Comparator<Squirrel> {

    @Override
    public int compare(Squirrel s1, Squirrel s2) {
        return Comparator.comparing((Squirrel::getName)).thenComparing(Squirrel::getWeight).compare(s1, s2);
    }
}
