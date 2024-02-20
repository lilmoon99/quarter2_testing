package ru.moon.service;

import ru.moon.data.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ShelterService {
    private Shelter shelter = new Shelter();

    public void addAnimal() {
        Scanner scanner = new Scanner(System.in);
        int type = 0;
        System.out.println("Enter the name:");
        Scanner scanner1 = new Scanner(System.in);
        String tempName = scanner1.nextLine();
        System.out.println("Enter the birthday: ");
        String tempBirthdate = scanner1.nextLine();

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
            parsedbirthdate = LocalDate.parse(tempBirthdate);
        } catch (DateTimeParseException e) {
            System.out.println("Wrong birthdate!");
        }
        Animal animal = null;
        switch (type) {
            case 1 -> animal = new Cat(tempName, tempBirthdate);
            case 2 -> animal = new Dog(tempName, tempBirthdate);
            case 3 -> animal = new Hamster(tempName, tempBirthdate);
            default -> System.out.println("Animal type has not found!");
        }
        if (animal != null) {
            this.shelter.add_animal(animal);
            System.out.println("Your pet successfully added to shelter.");


        } else {
            System.out.println("Your pet didn't add to shelter.");
        }
    }

    public void deleteAnimal(int id) {
        for (Animal animal : this.shelter.getShelter()) {
            if (animal.getId() == id) {
                shelter.delete_animal(animal);
            }
        }
    }


    public void trainAnimal(){
        int id = 0;
        String skill = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter trainee id:");
        //TODO exception catch
        id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter skill to be trained: ");
        skill = scanner.nextLine();
        for (Animal animal : this.shelter.getShelter()){
            if (animal.getId() == id){
                animal.trainSkill(skill);
            }
        }
    }



    public void getShelterContent() {
        this.shelter.getShelter().forEach(System.out::println);
    }
}
