package ru.knyazevvb.lesson_1.Players;

public class Robot implements Player {
    private String name;
    private final double MAX_JUMP;
    private final double MAX_RUN;

    public Robot(String name) {
        this.name = name;
        MAX_JUMP = 20.0;
        MAX_RUN = 5000000.0;
    }

    @Override
    public boolean run(double runLength) {
        if (runLength <= MAX_RUN) {
            System.out.printf("Робот по имени %s пробежал %.2f метров.\n", name, runLength);
            return true;
        } else {
            System.out.printf("Робот по имени %s не может пробежать %.2f метров. Его максимум - это %.2f метров.\n", name, runLength, MAX_RUN);
            return false;
        }
    }

    @Override
    public boolean jump(double jumpHeight) {
        if (jumpHeight <= MAX_JUMP) {
            System.out.printf("Робот по имени %s подпрыгнул на %.2f метров.\n", name, jumpHeight);
            return true;
        } else {
            System.out.printf("Робот по имени %s не может подпрыгнуть на %.2f метров. Его максимум - это %.2f метров.\n", name, jumpHeight, MAX_JUMP);
            return false;
        }
    }

    @Override
    public boolean swim(double swimLength) {
        System.out.printf("Робот по имени %s утонул\n", name);
        return false;
    }
}
