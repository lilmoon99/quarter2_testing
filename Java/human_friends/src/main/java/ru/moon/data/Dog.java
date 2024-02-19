package ru.moon.data;

import java.time.LocalDate;
import java.util.Date;

public class Dog extends Animal{
    public Dog(String name, CharSequence birthdate) {
        super(name, birthdate);
    }

    @Override
    public void voice() {
        System.out.println("Bark!");
    }

    @Override
    public String toString() {
        return "Dog's name: " + super.getName() + "|"+
                "Birthday: " + super.getBirthdate();
    }
}
