public class MethodTracker {
    public static String name() {
        String name = Thread.currentThread().getStackTrace()[2].getMethodName();
        return name;
    }
}