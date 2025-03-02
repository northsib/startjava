public class BooleanMethods {
    public boolean isActiveProgram() {
        System.out.println("\n" + MethodName.getCurrent() + 
                "() -> программа выполняется далее или завершается? " + 
                String.valueOf(true) + "\n");
        return false;
    }

    public boolean isDeletedFile() {
        System.out.println(MethodName.getCurrent() + "() -> удалился ли файл? " + 
                String.valueOf(true) + "\n");
        return true;
    }

    public boolean hasUniqueDigit() {
        System.out.println(MethodName.getCurrent() + "() -> содержит ли уникальную цифру? " + 
                String.valueOf(true) + "\n");
        return true;
    }

    public boolean isLetterInput() {
        System.out.println(MethodName.getCurrent() + "() -> введена ли буква? " + 
                String.valueOf(true) + "\n");
        return true;
    }

    public boolean hasEqualsDigits() {
        System.out.println(MethodName.getCurrent() + "() -> содержатся ли равные цифры? " + 
                String.valueOf(true) + "\n");
        return true;
    }

    public boolean hasRemainingLives() {
        System.out.println(MethodName.getCurrent() + "() -> остались ли попытки (в игре)? " + 
                String.valueOf(true) + "\n");
        return true;
    }

    public boolean isEmpty() {
        System.out.println(MethodName.getCurrent() + 
                "() -> состоит ли строка из пробелов? " + 
                String.valueOf(true) + "\n");
        return true;
    }

    public boolean isEvenRoll() {
        System.out.println(MethodName.getCurrent() + "() -> выпало ли чётное число? " + 
                String.valueOf(true) + "\n");
        return true;
    }

    public boolean isValidFilePath() {
        System.out.println(MethodName.getCurrent() + "() -> путь к файлу действительный? " + 
                String.valueOf(true) + "\n");
        return true;
    }

    public boolean fileExists() {
        System.out.println(MethodName.getCurrent() + "() -> файл существует? " + 
                String.valueOf(true) + "\n");
        return true;
    }
}