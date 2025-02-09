public class Wolf {
    String name = "Клык";
    String sex = "Мужской";
    float weight = 39.7f;
    int age = 8;
    String color = "Тёмно-серый";

    void move() {
        System.out.println(name + " идёт");
    }

    void sit() {
        System.out.println(name + " сидит");
    }

    void run() {
        System.out.println(name + " бежит");
    }

    void howl() {
        System.out.println(name + " воет");
    }

    void hunt() {
        System.out.println(name + " охотится");
    }
}