package ru.moon.data;

import java.time.LocalDate;
import java.util.Date;

public class Dog extends Animal {
    public Dog(String name, CharSequence birthdate) {
        super(name, birthdate);
    }

    @Override
    public void voice() {
        System.out.println("Bark!");
    }

    @Override

    public String toString() {
        if (super.getSkills().isEmpty()){

            return "ID: " +super.getId()+"|"+ "Dog's name: " + super.getName() + "|" +"Birthday: " + super.getBirthdate();
        }
        return "ID: " +super.getId()+"|"+ "Dog's name: " + super.getName() + "|" +"Birthday: " + super.getBirthdate() + "|" + "skills:" + super.getSkills().toString().replaceAll("\\[", "").replaceAll("]","");

    }
}
