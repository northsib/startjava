public class Jaeger {
    private String modelName;
    private String mark;
    private String origin;

    private float height;
    private int weight;

    private int speed;
    private int strength;
    private int armor;

    public Jaeger() {
    }

    public Jaeger(String modelName, String mark, String origin, float height, int weight, 
            int speed, int strength, int armor) {
        this.modelName = modelName;
        this.mark = mark;
        this.origin = origin;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
        this.strength = strength;
        this.armor = armor;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public boolean drift() {
        System.out.println(modelName + " вошел в дрифт");
        return true;
    }

    public void move() {
        System.out.println(modelName + " начал движение");
    }

    public String scanKaiju(String target) {
        if ("kaiju".equalsIgnoreCase(target)) {
            return "Сканирую... ! ! !Тревога! ! ! Обнаружен Кайдзю! ! !";
        } else {
            return "Сканирую... ничего не обнаружено";
        }
    }

    public void useVortexCannon() {
        System.out.println("Прицеливаюсь... выстрел ! ! !");
    }

    public void getInfo() {
        System.out.println("Создан объект: \nModel Name - " + modelName + ", Mark - " + mark + 
                ", Origin - " + origin + ", Height - " + height + 
                " m,\nWeight - " + weight + " tons, Speed - " + speed + 
                ", Strength - " + strength + ", Armor - " + armor + ".");
    }
}