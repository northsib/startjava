public class MethodInvoker {
    public static void main(String[] args) {
        ActionPerformer actionMethods = new ActionPerformer();
        actionMethods.callAllActionMethods();
        ConditionChecker booleanMethods = new ConditionChecker();
        booleanMethods.callAllBooleanMethods();
    }
}