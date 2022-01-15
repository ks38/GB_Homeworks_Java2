package ru.knyazevvb.Java2.lesson_3.Excersise_2;

public class Main {
    public static void main(String[] args) {
        Phonebook book = new Phonebook();
        book.add("Иванов", "123");
        book.add("Иванов", "456");
        book.add("Петров", "789");
        book.add("Петров", "012");
        book.add("Петров", "345");
        book.add("Петров", "678");
        book.add("Сидоров", "901");
        book.add("Сидоров", "234");

        System.out.println("Телефоны Ивановых: " + book.get("Иванов"));
        System.out.println("Телефоны Сидоровых: " + book.get("Сидоров"));
        System.out.println("Телефоны Петровых: " + book.get("Петров"));
    }
}
