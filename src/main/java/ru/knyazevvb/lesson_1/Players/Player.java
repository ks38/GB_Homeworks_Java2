package ru.knyazevvb.lesson_1.Players;

public interface Player {
    boolean run(double runLength);

    boolean jump(double jumpHeight);

    boolean swim(double swimLength);
}
