package ru.knyazevvb.lesson_1.Obstacles;

import ru.knyazevvb.lesson_1.Players.*;

public class Treadmill implements Barrier{
    private double length;

    public Treadmill(double length) {
        this.length = length;
    }

    @Override
    public boolean doBarrier(Player player) {
        return player.run(length);
    }
}
