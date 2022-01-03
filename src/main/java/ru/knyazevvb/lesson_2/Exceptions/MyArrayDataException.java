package ru.knyazevvb.lesson_2.Exceptions;

public class MyArrayDataException extends Exception{
    public MyArrayDataException (int i, int j, String s, Throwable throwable) {
super(String.format("Неверное значение '%s' в ячейке [%d][%d]", s, i, j), throwable);
    }
}
