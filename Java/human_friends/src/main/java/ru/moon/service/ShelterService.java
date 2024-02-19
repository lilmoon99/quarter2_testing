package ru.moon.service;

import ru.moon.data.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ShelterService {
    private Shelter shelter = new Shelter();

    public void add_animal(String name, CharSequence birthdate) {
        Scanner scanner = new Scanner(System.in);
        int type = 0;
        LocalDate parsedbirthdate;
        try {
            System.out.println("""
                    Choose animal type:
                    1 - Cat
                    2 - Dog
                    3 - Hamster
                    """);
            type = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Wrong choose!");
        }
        try {
            parsedbirthdate = LocalDate.parse(birthdate);
        } catch (DateTimeParseException e) {
            System.out.println("Wrong birthdate!");
        }
        Animal animal = null;
        switch (type) {
            case 1 -> animal = new Cat(name, birthdate);
            case 2 -> animal = new Dog(name, birthdate);
            case 3 -> animal = new Hamster(name, birthdate);
            default -> System.out.println("Animal type has not found!");
        }
        if (animal != null) {
            this.shelter.add_animal(animal);
            System.out.println("Your pet successfully added to shelter.");
            animal.voice();
        }else {
            System.out.println("Your pet didn't add to shelter.");
        }
    }

    public Set<Animal> getShelterContent(){
        return this.shelter.getShelter();
    }
}
