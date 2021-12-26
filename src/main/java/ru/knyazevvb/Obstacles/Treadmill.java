package ru.knyazevvb.Obstacles;

import ru.knyazevvb.Players.*;

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
