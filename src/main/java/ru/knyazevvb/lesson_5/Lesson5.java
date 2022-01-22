package ru.knyazevvb.lesson_5;

public class Lesson5 {
    static final int SIZE = 10_000_000;
    static final int HALF_SIZE = SIZE / 2;

    public static void main(String[] args) {
        method1();
        method2();
    }

    private static void method1() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1.0F;
        }
        long start = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время выполнения вычислений в один поток: " + (System.currentTimeMillis() - start) + " мс.\n");
    }

    private static void method2() {
        float[] array = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = 1F;
        }

        float[] half1 = new float[HALF_SIZE];
        float[] half2 = new float[HALF_SIZE];
        long start = System.currentTimeMillis();

        final Thread t1 = new Thread(() -> {
            System.arraycopy(array, 0, half1, 0, HALF_SIZE);
            for (int i = 0; i < half1.length; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        final Thread t2 = new Thread(() -> {
            System.arraycopy(array, HALF_SIZE, half2, 0, HALF_SIZE);
            for (int i = 0; i < half2.length; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(half1, 0, array, 0, HALF_SIZE);
        System.arraycopy(half2, 0, array, HALF_SIZE, HALF_SIZE);

        long finish = System.currentTimeMillis();
        System.out.println("Время выполнения вычислений в 2 потока: " + (finish - start) + " мс.");
    }
}
