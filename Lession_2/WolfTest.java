public class WolfTest {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.name = "Серый";
        wolf.sex = "Мужской";
        wolf.age = 11;
        wolf.weight = 45.2f;
        wolf.color = "серый";

        System.out.println("Создали волка с именем - " + wolf.name + ", его пол - " + wolf.sex + 
                ", его возраст - " + wolf.age + ",\nего вес - " + wolf.weight + ", его цвет - " + 
                wolf.color);

        wolf.move();
        wolf.sit();
        wolf.run();
        wolf.howl();
        wolf.hunt();
    }
}
