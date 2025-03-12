package com.startjava.lession2_3_4.animal;

public class Wolf {
    private String name = "Клык";
    private String sex = "Мужской";
    private float weight = 39.7f;
    private int age = 8;
    private String color = "Тёмно-серый";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == "") {
            System.out.println("Пустая строка");
        } else {
            this.name = name;
        }
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public float getWeight() {
        return weight;
    } 

    public void setWeight(float weight) {
        if (weight < 0 && weight > 50) {
            System.out.println("некорректное значение");
        } else {
            this.weight = weight;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 && age > 8) {
            System.out.println("некорректное значение");
        } else {
            this.age = age;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == "") {
            System.out.println("Пустая строка");
        } else {
            this.color = color;
        }
    }

    public void move() {
        System.out.println(name + " идёт");
    }

    public void sit() {
        System.out.println(name + " сидит");
    }

    public void run() {
        System.out.println(name + " бежит");
    }

    public void howl() {
        System.out.println(name + " воет");
    }

    public void hunt() {
        System.out.println(name + " охотится");
    }
}