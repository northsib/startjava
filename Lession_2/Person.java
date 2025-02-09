public class Person {
    String sex = "Мужской";
    String name = "Мирослав";
    int height = 110;
    int weight = 20;
    int age = 4;

    void speak() {
        System.out.println("Меня зовут " + name + ", я умею говорить");
    }

    void move() {
        System.out.println(name + " начал движение");
    }

    void javaLearn() {
        System.out.println(name + " учит Java");
    }

    void run() {
        System.out.println(name + " побежал");
    }

    void sit() {
        System.out.println(name + " сел");
    }
}