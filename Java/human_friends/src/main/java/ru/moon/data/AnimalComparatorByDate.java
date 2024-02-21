package ru.moon.data;

import java.time.LocalDateTime;
import java.util.Comparator;

public class AnimalComparatorByDate implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getBirthdate().compareTo(o2.getBirthdate());
    }
}
