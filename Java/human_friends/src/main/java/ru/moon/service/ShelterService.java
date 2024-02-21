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
        System.out.println("Enter the birthday(YYYY-MM-DD): ");
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




    public void trainAnimal(){
        if (this.shelter.getShelter().isEmpty()){
            System.out.println("Your shelter is empty");
        }else {
            int id = 0;
            String skill = null;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter trainee id:");
            try {
                id = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("You entered wrong id!");
            }
            System.out.println("Enter skill to be trained: ");
            try {
                skill = scanner.nextLine();
                boolean isIdExists = false;
                for (Animal animal : this.shelter.getShelter()){
                    isIdExists = animal.getId() == id;
                    if (isIdExists){
                        animal.trainSkill(skill);
                    }
                }
                if (!isIdExists){
                    System.out.println("Animal with is ID is not existing in shelter!");
                }
            }catch (NoSuchElementException e){
                System.out.println("You didn't type anything!");
            }
        }
    }



    public void getShelterContent() {
        if (this.shelter.getShelter().isEmpty()){
            System.out.println("Your shelter is empty!");
        }
//        this.shelter.getShelter().forEach(System.out::println);
        List<Animal> sortedByDate = new ArrayList<>(this.shelter.getShelter());
        sortedByDate.sort(new AnimalComparatorByDate());
        sortedByDate.forEach(System.out::println);
    }

    public void presetLoader(){

        this.shelter.add_animal(new Cat("Murzik","2023-01-05"));
        this.shelter.add_animal(new Dog("Bobik","2016-05-20"));
        this.shelter.add_animal(new Hamster("Boris","2023-09-21"));
    }
}
