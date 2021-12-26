package ru.knyazevvb;

import ru.knyazevvb.Players.*;
import ru.knyazevvb.Obstacles.*;

public class Main {
    public static void main(String[] args) {

        Player[] players = {
                new Human("Сергей"),
                new Robot("Терминатор"),
                new Cat("Тимоша"),
                new Duck("Хабиб")
        };

        Barrier[] barriers = {
                new Treadmill(50),
                new Wall(10),
                new Water(5)
        };

        for (Player p : players) {
            for (Barrier b : barriers) {
                if (!b.doBarrier(p)) {
                    break;
                }
            }
        }
    }
}
