package ru.moon.data;

import java.time.LocalDate;


public class Cat extends Animal{
    public Cat(String name, CharSequence birthdate) {
        super(name, birthdate);
    }

    @Override
    public void voice() {
        System.out.println("Meow!");
    }

    @Override
    public String toString() {
        if (super.getSkills().isEmpty()){

            return "ID: " +super.getId()+"|"+ "Cat's name: " + super.getName() + "|" +"Birthday: " + super.getBirthdate();
        }
        return "ID: " +super.getId()+"|"+ "Cat's name: " + super.getName() + "|" +"Birthday: " + super.getBirthdate() + "|" + "skills:" + super.getSkills().toString().replaceAll("\\[", "").replaceAll("]","");

    }

}
