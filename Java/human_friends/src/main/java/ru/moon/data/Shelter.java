package ru.moon.data;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Shelter {
    private Set<Animal> shelter;
    private int animalCounter;

    private int id = 0;

    public Shelter() {
        this.shelter = new HashSet<>();
        this.animalCounter = 0;
    }

    public void add_animal(Animal animal){
        id++;
        animal.setId(id);
        this.shelter.add(animal);
        this.animalCounter++;
    }

    public void delete_animal(Animal animal){
        this.shelter.remove(animal);
        this.animalCounter--;
    }



    public Set<Animal> getShelter() {
        return shelter;
    }

    public void setShelter(Set<Animal> shelter) {
        this.shelter = shelter;
    }

    public int getAnimalCounter() {
        return animalCounter;
    }


    @Override
    public String toString() {
        return "Animals in shelter: \n"+ shelter +
                "\nanimals count: " + animalCounter;
    }
}
