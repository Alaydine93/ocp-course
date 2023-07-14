package org.example.records;

public record CrateRecord<T>(T contents) {

    @Override
    public T contents() {
        if (contents == null)
            throw new IllegalStateException("missing content");
        return contents;
    }
}
