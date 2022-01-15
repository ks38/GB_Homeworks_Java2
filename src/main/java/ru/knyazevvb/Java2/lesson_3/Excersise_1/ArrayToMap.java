package ru.knyazevvb.Java2.lesson_3.Excersise_1;

import java.util.*;

public class ArrayToMap {

    public static void main(String[] args) {

        String[] words = {
                "one", "two", "three", "four", "one",
                "two", "seven", "eight", "nine", "four",
                "дерево", "дерево", "банан", "груша", "груша"
        };

        System.out.println("\nВывод всех слов: " + Arrays.asList(words));

//использую LinkedHashMap чтобы упорядочить вывод строк по порядку их индексов в массиве.

        LinkedHashMap<String, Integer> repeat = new LinkedHashMap<>();

        for (String s : words) {
            repeat.put(s, repeat.getOrDefault(s, 0) + 1);
        }

        System.out.println("\nСлова и количество повторений: " + repeat);
    }
}
