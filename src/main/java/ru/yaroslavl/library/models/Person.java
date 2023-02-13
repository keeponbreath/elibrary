package ru.yaroslavl.library.models;

import javax.validation.constraints.*;

public class Person {
    private int id;

    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 50, message = "Имя должно содержать от 2 до 50 символов")
    private String name;

    @Min(value = 1920, message = "Минимальный год рождения: 1920")
    @Max(value = 2005, message = "Максимальный год рождения: 2005")
    private int b_year;

    public Person() {

    }

    public Person(String name, int b_year) {
        this.name = name;
        this.b_year = b_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getB_year() {
        return b_year;
    }

    public void setB_year(int b_year) {
        this.b_year = b_year;
    }

}
