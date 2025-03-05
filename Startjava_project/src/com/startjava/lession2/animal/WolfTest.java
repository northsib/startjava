package com.startjava.lession2.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        // wolf.name = "Серый";
        // wolf.sex = "Мужской";
        // wolf.age = 11;
        // wolf.weight = 45.2f;
        // wolf.color = "серый";

        System.out.println(wolf.getName());
        wolf.setName("Серая");
        System.out.println(wolf.getName());

        System.out.println(wolf.getSex());
        wolf.setSex("Женский");
        System.out.println(wolf.getSex());

        System.out.println(wolf.getWeight());
        wolf.setWeight(35.4f);
        System.out.println(wolf.getWeight());

        System.out.println(wolf.getAge());
        wolf.setAge(5);
        System.out.println(wolf.getAge());

        System.out.println(wolf.getColor());
        wolf.setColor("Серый");
        System.out.println(wolf.getColor());

        System.out.println("Создали волка с именем - " + wolf.getName() + 
                ", его пол - " + wolf.getSex() + 
                ", его возраст - " + wolf.getAge() + 
                ",\nего вес - " + wolf.getWeight() + 
                ", его цвет - " + wolf.getColor());

        wolf.move();
        wolf.sit();
        wolf.run();
        wolf.howl();
        wolf.hunt();
    }
}
