package ru.knyazevvb.Java2.lesson_3.Excersise_2;

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {

    private HashMap<String, HashSet<String>> phoneBook = new HashMap<>();

    public void add(String lastName, String phone) {
        HashSet<String> telephone = phoneBook.getOrDefault(lastName, new HashSet<>());
        telephone.add(phone);
        phoneBook.put(lastName, telephone);
    }

    public HashSet<String> get(String lastName) {
        return phoneBook.get(lastName);
    }
}
