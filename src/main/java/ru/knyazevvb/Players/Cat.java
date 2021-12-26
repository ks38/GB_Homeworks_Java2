package ru.knyazevvb.Players;

public class Cat implements Player {
    private String name;
    private final double MAX_JUMP;
    private final double MAX_RUN;

    public Cat(String name) {
        this.name = name;
        MAX_JUMP = 0.5;
        MAX_RUN = 5000.0;
    }

    @Override
    public boolean run(double length) {
        if (length <= MAX_RUN) {
            System.out.printf("Кот по имени %s пробежал %.2f метров.\n", name, length);
            return true;
        } else {
            System.out.printf("Кот по имени %s не может пробежать %.2f метров. Его максимум - это %.2f метров.\n", name, length, MAX_RUN);
            return false;
        }
    }

    @Override
    public boolean jump(double height) {
        if (height <= MAX_JUMP) {
            System.out.printf("Кот по имени %s подпрыгнул на %.2f метров.\n", name, height);
            return true;
        } else {
            System.out.printf("Кот по имени %s не может подпрыгнуть на %.2f метров. Его максимум - это %.2f метров.\n", name, height, MAX_JUMP);
            return false;
        }
    }
}

