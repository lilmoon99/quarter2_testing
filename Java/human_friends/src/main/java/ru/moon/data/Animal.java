package ru.moon.data;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public abstract class Animal {
    private String name;
    private LocalDate birthdate;

    private Set<String> skills;

    private int id;

    public Animal(String name, CharSequence birthdate) {
        this.name = name;
        this.birthdate = LocalDate.parse(birthdate);
        this.skills = new HashSet<>();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public void trainSkill(String skill){
        this.skills.add(skill);
    }
}
