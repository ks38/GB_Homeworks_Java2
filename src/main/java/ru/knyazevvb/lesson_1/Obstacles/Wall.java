package ru.knyazevvb.lesson_1.Obstacles;

import ru.knyazevvb.lesson_1.Players.*;

public class Wall implements Barrier {
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public boolean doBarrier(Player player) {
        return player.jump(height);
    }
}
