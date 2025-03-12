package com.startjava.lession2_3_4.method.naming;

public class BooleanMethods {
    public boolean isActiveProgram() {
        System.out.print("\n" + MethodName.getCurrent() + 
                "() -> программа выполняется далее или завершается? ");
        return false;
    }

    public boolean isDeletedFile() {
        System.out.print("\n" + MethodName.getCurrent() + "() -> удалился ли файл? ");
        return true;
    }

    public boolean hasUniqueDigit() {
        System.out.print("\n" + MethodName.getCurrent() + "() -> содержит ли уникальную цифру? ");
        return true;
    }

    public boolean isLetterInput() {
        System.out.print("\n" + MethodName.getCurrent() + "() -> введена ли буква? ");
        return true;
    }

    public boolean hasEqualsDigits() {
        System.out.print("\n" + MethodName.getCurrent() + "() -> содержатся ли равные цифры? ");
        return true;
    }

    public boolean hasRemainingLives() {
        System.out.print("\n" + MethodName.getCurrent() + "() -> остались ли попытки (в игре)? ");
        return false;
    }

    public boolean isEmpty() {
        System.out.print("\n" + MethodName.getCurrent() + 
                "() -> состоит ли строка из пробелов? ");
        return true;
    }

    public boolean isEvenRoll() {
        System.out.print("\n" + MethodName.getCurrent() + "() -> выпало ли чётное число? ");
        return true;
    }

    public boolean isValidFilePath() {
        System.out.print("\n" + MethodName.getCurrent() + "() -> путь к файлу действительный? ");
        return false;
    }

    public boolean fileExists() {
        System.out.print("\n" + MethodName.getCurrent() + "() -> файл существует? ");
        return true;
    }
}