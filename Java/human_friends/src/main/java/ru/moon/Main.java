package ru.moon;


import ru.moon.service.ShelterService;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to pet shelter.");
        ShelterService shelterService = new ShelterService();
        System.out.println("""
                1 - Use empty shelter
                2 - Use shelter preset
                """);
        Scanner scanner = new Scanner(System.in);
        int choose = 0;
        try{
            choose = scanner.nextInt();
            if (choose == 1){
                initProgram(shelterService);
            } else if (choose == 2) {
                loadPreset(shelterService);
            }else System.out.println("Choose is incorrect");
        }catch (InputMismatchException e){
            System.out.println("You entered wrong number!");
        }
    }

    private static void initProgram(ShelterService shelterService){
        boolean isContinue = true;
        while(isContinue){
            System.out.println("""
                    Choose a command:
                    1 - Add animal to shelter
                    2 - Train animal
                    3 - Show animals
                    4 - Exit
                    """);
            Scanner scanner = new Scanner(System.in);
            try {
                int choose = scanner.nextInt();
                switch (choose){
                    case 1 -> shelterService.addAnimal();
                    case 2 -> shelterService.trainAnimal();
                    case 3 -> shelterService.getShelterContent();
                    case 4 -> isContinue = false;
                }
            }catch (InputMismatchException e){
                System.out.println("You wrote not a number!");
            }catch (NoSuchElementException e){
                System.out.println("You didn't write anything!");
            }
        }
    }

    private static void loadPreset(ShelterService shelterService){
        shelterService.presetLoader();
        System.out.println("Preset loaded!");
        initProgram(shelterService);
    }
}