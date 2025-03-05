package com.startjava.lession2.robot;

public class JaegerTest {
    public static void main(String[] args) {
        Jaeger jaeger1 = new Jaeger();
        jaeger1.setModelName("Striker Eureka");
        jaeger1.setMark("Mark-5");
        jaeger1.setOrigin("Australia");
        jaeger1.setHeight(76.2f);
        jaeger1.setWeight(41792);
        jaeger1.setSpeed(10);
        jaeger1.setStrength(10);
        jaeger1.setArmor(9);

        jaeger1.getInfo();

        jaeger1.drift();
        jaeger1.move();
        System.out.println(jaeger1.scanKaiju("Kaiju"));
        jaeger1.useVortexCannon();

        System.out.println();

        Jaeger jaeger2 = new Jaeger("Gipsy Danger", "Mark-3", "USA", 79.25f, 1980, 7, 8, 6);
        jaeger2.getInfo();

        jaeger2.drift();
        jaeger2.move();
        System.out.println(jaeger2.scanKaiju("Human"));
        jaeger2.useVortexCannon();
    }
}