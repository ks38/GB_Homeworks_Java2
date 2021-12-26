package ru.knyazevvb.lesson_1.Obstacles;

import ru.knyazevvb.lesson_1.Players.*;

public class Water implements Barrier{
    private double swimLength;

    public Water(double swimLength) {
        this.swimLength = swimLength;
    }

    @Override
    public boolean doBarrier(Player player) {
        return player.swim(swimLength);
    }
}
