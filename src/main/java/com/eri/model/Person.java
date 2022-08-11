package com.eri.model;

public abstract class Person {
    private String name;

    private String surname;

    public Person(){

    }

    public Person(String name, String surname){
        setName(name);
        setSurname(surname);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
