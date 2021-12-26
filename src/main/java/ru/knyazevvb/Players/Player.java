package ru.knyazevvb.Players;

public interface Player {
    boolean run(double runLength);

    boolean jump(double jumpHeight);

    boolean swim(double swimLength);
}
