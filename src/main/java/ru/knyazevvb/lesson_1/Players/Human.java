package ru.knyazevvb.lesson_1.Players;

public class Human implements Player {

    private String name;
    private final double MAX_JUMP;
    private final double MAX_RUN;
    private final double MAX_SWIM;

    public Human(String name) {
        this.name = name;
        MAX_JUMP = 2.0;
        MAX_RUN = 5000.0;
        MAX_SWIM = 200;
    }

    @Override
    public boolean run(double runLength) {
        if (runLength <= MAX_RUN) {
            System.out.printf("Человек по имени %s пробежал %.2f метров.\n", name, runLength);
            return true;
        } else {
            System.out.printf("Человек по имени %s не может пробежать %.2f метров. Его максимум - это %.2f метров.\n", name, runLength, MAX_RUN);
            return false;
        }
    }

    @Override
    public boolean jump(double jumpHeight) {
        if (jumpHeight <= MAX_JUMP) {
            System.out.printf("Человек по имени %s подпрыгнул на %.2f метров.\n", name, jumpHeight);
            return true;
        } else {
            System.out.printf("Человек по имени %s не может подпрыгнуть на %.2f метров. Его максимум - это %.2f метров.\n", name, jumpHeight, MAX_JUMP);
            return false;
        }
    }

    @Override
    public boolean swim(double swimLength) {
        if (swimLength <= MAX_SWIM) {
            System.out.printf("Человек по имени %s проплыл %.2f метров.\n", name, swimLength);
            return true;
        } else {
            System.out.printf("Человек по имени %s утонул\n", name);
            return false;
        }
    }
}

