package ru.yaroslavl.library.models;

import javax.validation.constraints.*;

public class Book {
    private int id;

    @NotEmpty(message = "Название книги не может быть пустым")
    @Size(min = 2, max = 50, message = "Название книги должно содержать от 2 до 40 символов")
    private String title;

    @NotEmpty(message = "Имя автора не может быть пустым")
    @Size(min = 2, max = 50, message = "Имя автора должно содержать от 2 до 40 символов")
    private String author;

    @Min(value = 1700, message = "Введите корректный год рождения (от 1700 до 2099)")
    @Max(value = 2022, message = "Введите корректный год рождения (от 1700 до 2099)")
    private int year;

    public Book () {

    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
