package ru.moon;


import ru.moon.service.ShelterService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ShelterService shelterService = new ShelterService();
        boolean isContinue = true;
        while(isContinue){
            System.out.println("""
                    1 - add animal to shelter
                    2 - train animal
                    3 - show animals
                    4 - delete animal
                    5 - exit
                    """);
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            switch (choose){
                case 1 -> shelterService.addAnimal();
                case 2 -> shelterService.trainAnimal();
                case 3 -> shelterService.getShelterContent();
                //TODO add animal deleting function
                case 5 -> isContinue = false;
            }
        }
//        shelterService.addAnimal();
    }
}