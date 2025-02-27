public class ConditionChecker {
    private boolean result;

    public void callAllBooleanMethods() {
        isProgramActive();
        isFileDeleted();
        hasUniqueDigit();
        isAlphaInput();
        hasEqualsDigits();
        hasRemainingLives();
        isWhitespaceString();
        isValidFilePath();
        fileExists();
    }

    private boolean isProgramActive() {
        result = false;
        System.out.println("\n" + MethodTracker.name() + 
                "() -> программа выполняется далее или завершается? " +
                result + "\n");
        return result;
    }

    private boolean isFileDeleted() {
        result = false;
        System.out.println(MethodTracker.name() + "() -> удалился ли файл? " + result + "\n");
        return result;
    }

    private boolean hasUniqueDigit() {
        result = false;
        System.out.println(MethodTracker.name() + "() -> содержит ли уникальную цифру? " + result + "\n");
        return result;
    }

    private boolean isAlphaInput() {
        result = false;
        System.out.println(MethodTracker.name() + "() -> введена ли буква? " + result + "\n");
        return result;
    }

    private boolean hasEqualsDigits() {
        result = false;
        System.out.println(MethodTracker.name() + "() -> содержатся ли равные цифры? " + result + "\n");
        return result;
    }

    private boolean hasRemainingLives() {
        result = false;
        System.out.println(MethodTracker.name() + "() -> остались ли попытки (в игре)? " + result + "\n");
        return result;
    }

    private boolean isWhitespaceString() {
        result = false;
        System.out.println(MethodTracker.name() + "() -> состоит ли строка из пробелов? " + result + "\n");
        return result;
    }

    private boolean isEvenRoll() {
        result = false;
        System.out.println(MethodTracker.name() + "() -> выпало ли чётное число? " + result + "\n");
        return result;
    }

    private boolean isValidFilePath() {
        result = false;
        System.out.println(MethodTracker.name() + "() -> путь к файлу действительный? " + result + "\n");
        return result;
    }

    private boolean fileExists() {
        result = false;
        System.out.println(MethodTracker.name() + "() -> файл существует? " + result + "\n");
        return result;
    }
}