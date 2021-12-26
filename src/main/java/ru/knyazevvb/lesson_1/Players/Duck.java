package ru.knyazevvb.lesson_1.Players;

public class Duck implements Player {

    private String name;
    private final double MAX_JUMP;
    private final double MAX_RUN;
    private final double MAX_SWIM;

    public Duck(String name) {
        this.name = name;
        MAX_JUMP = 0.1;
        MAX_RUN = 50;
        MAX_SWIM = 1000000;
    }

    @Override
    public boolean run(double runLength) {
        if (runLength <= MAX_RUN) {
            System.out.printf("Утка по имени %s пробежала %.2f метров.\n", name, runLength);
            return true;
        } else {
            System.out.printf("Утка по имени %s не может пробежать %.2f метров. Её максимум - это %.2f метров.\n", name, runLength, MAX_RUN);
            return false;
        }
    }

    @Override
    public boolean jump(double jumpHeight) {
        if (jumpHeight <= MAX_JUMP) {
            System.out.printf("Утка по имени %s подпрыгнула на %.2f метров.\n", name, jumpHeight);
            return true;
        } else {
            System.out.printf("Утка по имени %s не может подпрыгнуть на %.2f метров. Её максимум - это %.2f метров.\n", name, jumpHeight, MAX_JUMP);
            return false;
        }
    }

    @Override
    public boolean swim(double swimLength) {
        if (swimLength <= MAX_SWIM) {
            System.out.printf("Утка по имени %s проплыла %.2f метров.\n", name, swimLength);
            return true;
        } else {
            System.out.printf("Утка по имени %s утонула\n", name);
            return false;
        }
    }
}
