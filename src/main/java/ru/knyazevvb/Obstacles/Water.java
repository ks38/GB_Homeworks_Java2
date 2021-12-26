package ru.knyazevvb.Obstacles;

import ru.knyazevvb.Players.*;

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
