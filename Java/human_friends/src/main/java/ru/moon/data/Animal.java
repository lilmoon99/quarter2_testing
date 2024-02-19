package ru.moon.data;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;

public abstract class Animal {
    private String name;
    private LocalDate birthdate;

    public Animal(String name, CharSequence birthdate) {
        this.name = name;
        this.birthdate = LocalDate.parse(birthdate);
    }

    public abstract void voice();

    @Override
    public String toString() {
        return "Animal name: " + name +
                ", birthdate: " + birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

}
