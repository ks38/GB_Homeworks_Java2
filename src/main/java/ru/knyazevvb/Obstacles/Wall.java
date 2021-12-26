package ru.knyazevvb.Obstacles;
import ru.knyazevvb.Players.*;

public class Wall implements Barrier{
    private double height;


    public Wall(double height) {
        this.height = height;
    }

    @Override
    public boolean doBarrier(Player player) {
        return player.jump(height);
    }
}
