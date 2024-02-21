package ru.moon.data;

import java.time.LocalDate;
import java.util.Date;

public class Hamster extends Animal {
    public Hamster(String name, CharSequence birthdate) {
        super(name, birthdate);
    }

    @Override
    public void voice() {
        System.out.println("Help me!");
    }

    @Override
    public String toString() {
        if (super.getSkills().isEmpty()){

            return "ID: " +super.getId()+"|"+ "Hamster's name: " + super.getName() + "|" +"Birthday: " + super.getBirthdate();
        }
        return "ID: " +super.getId()+"|"+ "Hamster's name: " + super.getName() + "|" +"Birthday: " + super.getBirthdate() + "|" + "skills:" + super.getSkills().toString().replaceAll("\\[", "").replaceAll("]","");

    }
}
