package com.startjava.lession2_3_4.method.naming;

public class NonBooleanMethods {
    public void findLongestWord() {
        System.out.println("\n" + MethodName.getCurrent() + 
                "() -> найти самое длинное слово\n");
    }

    public void selectMenuOption() {
        System.out.println(MethodName.getCurrent() + "() -> выбрать пункт меню\n");
    }

    public void calculateAverageMarks() {
        System.out.println(MethodName.getCurrent() + 
                "() -> вычислить среднее значение оценок\n");
    }

    public void countUniqueWords() {
        System.out.println(MethodName.getCurrent() + 
                "() -> подсчитать количество уникальных слов\n");
    }

    public void showError() {
        System.out.println(MethodName.getCurrent() + "() -> вывести сообщение об ошибке\n");
    }

    public void syncCloudData() {
        System.out.println(MethodName.getCurrent() + 
                "() -> синхронизировать данные с облачным хранилищем\n");
    }

    public void restoreFromBackup() {
        System.out.println(MethodName.getCurrent() + 
                "() -> восстановить данные из резервной копии\n");
    }

    public void pauseFileDownload() {
        System.out.println(MethodName.getCurrent() + "() -> приостановить загрузку файла\n");
    }

    public void factoryReset() {
        System.out.println(MethodName.getCurrent() + 
                "() -> сбросить настройки до заводских\n");
    }

    public void writeContentToFile() {
        System.out.println(MethodName.getCurrent() + "() -> записать содержимое в файл\n");
    }

    public void convertTemperature() {
        System.out.println(MethodName.getCurrent() + "() -> преобразовать температуру\n");
    }

    public void inputMathExpression() {
        System.out.println(MethodName.getCurrent() + 
                "() -> ввести математическое выражение\n");
    }

    public void determineWinner() {
        System.out.println(MethodName.getCurrent() + "() -> определить победителя\n");
    }

    public void findBookByName() {
        System.out.println(MethodName.getCurrent() + "() -> найти книгу по имени\n");
    }
}