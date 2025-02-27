public class BooleanMethods {
    public boolean isProgramActive() {
        System.out.println("\n" + MethodCallerInfo.getCurrentMethodName() + 
                "() -> программа выполняется далее или завершается?\n");
        return true;
    }

    public boolean isFileDeleted() {
        System.out.println(MethodCallerInfo.getCurrentMethodName() + "() -> удалился ли файл?\n");
        return true;
    }

    public boolean hasUniqueDigit() {
        System.out.println(MethodCallerInfo.getCurrentMethodName() + "() -> содержит ли уникальную цифру?\n");
        return true;
    }

    public boolean isAlphaInput() {
        System.out.println(MethodCallerInfo.getCurrentMethodName() + "() -> введена ли буква?\n");
        return true;
    }

    public boolean hasEqualsDigits() {
        System.out.println(MethodCallerInfo.getCurrentMethodName() + "() -> содержатся ли равные цифры?\n");
        return true;
    }

    public boolean hasRemainingLives() {
        System.out.println(MethodCallerInfo.getCurrentMethodName() + "() -> остались ли попытки (в игре)?\n");
        return true;
    }

    public boolean isWhitespaceString() {
        System.out.println(MethodCallerInfo.getCurrentMethodName() + 
                "() -> состоит ли строка из пробелов?\n");
        return true;
    }

    public boolean isEvenRoll() {
        System.out.println(MethodCallerInfo.getCurrentMethodName() + "() -> выпало ли чётное число?\n");
        return true;
    }

    public boolean isValidFilePath() {
        System.out.println(MethodCallerInfo.getCurrentMethodName() + "() -> путь к файлу действительный?\n");
        return true;
    }

    public boolean fileExists() {
        System.out.println(MethodCallerInfo.getCurrentMethodName() + "() -> файл существует?\n");
        return true;
    }
}