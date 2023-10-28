package org.example.records;

public record Crane(int numberEggs, String name) {

    public Crane {
        if (name == null || name.length() < 1)
            throw new IllegalArgumentException("Name must be provided");
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    public Crane(String firstName, String lastName) {
        this(1, firstName + " " + lastName);
    }

    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public int numberEggs() {
        return this.numberEggs * 5;
    }
}
