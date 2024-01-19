package ru.GB;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.text.html.parser.Entity;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        Gson gson = new Gson();

        Person person = new Person("Aliaksandr", "Karpenka", 42);
        String json = gson.toJson(person);
        Person read = gson.fromJson(json, Person.class);
        System.out.println(read);
    }
}