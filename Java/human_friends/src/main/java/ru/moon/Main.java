package ru.moon;

import ru.moon.data.Cat;
import ru.moon.data.Dog;
import ru.moon.data.Shelter;
import ru.moon.service.ShelterService;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("Barsik","1999-01-25");
        Dog dog = new Dog("Bobik","2023-01-04");
        ShelterService shelterService = new ShelterService();
        shelterService.add_animal("Barsik","1999-01-25");
        System.out.println(shelterService.getShelterContent());
    }
}