package ru.knyazevvb.lesson_2;

import ru.knyazevvb.lesson_2.Exceptions.*;

public class Lesson2 {

    private static final int ARRAY_SIZE = 4;


    public static void main(String[] args) {

        String[][] testArr1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] testArr2 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7",},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] testArr3 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "Првав", "12"},
                {"13", "14", "15", "16"}};

        String[][] testArr4 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
        };

        try {
            System.out.println("Сумма чисел массива 1 = " + getArraySum(testArr1));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }

        try {
            System.out.println("Сумма чисел массива 2 = " + getArraySum(testArr2));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }

        try {
            System.out.println("Сумма чисел массива 3 = " + getArraySum(testArr3));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }

        try {
            System.out.println("Сумма чисел массива 4 = " + getArraySum(testArr4));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
    }

    private static int getArraySum(String[][] s) throws MyArrayDataException, MyArraySizeException {
        int sum = 0;
        if (s.length != ARRAY_SIZE) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < s.length; i++) {
            if (s[i].length != ARRAY_SIZE) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < s[i].length; j++) {
                try {
                    sum += Integer.parseInt(s[i][j]);
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException(i, j, s[i][j], exception);
                }
            }
        }
        return sum;
    }
}

