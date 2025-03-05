package com.startjava.lession2.method.naming;

public class MethodInvoker {
    public static void main(String[] args) {
        execNonBooleanMethods();
        execBooleanMethods();
    }

    public static void execNonBooleanMethods() {
        NonBooleanMethods nonBm = new NonBooleanMethods();
        nonBm.findLongestWord();
        nonBm.selectMenuOption();
        nonBm.calculateAverageMarks();
        nonBm.countUniqueWords();
        nonBm.showError();
        nonBm.syncCloudData();
        nonBm.restoreFromBackup();
        nonBm.pauseFileDownload();
        nonBm.factoryReset();
        nonBm.writeContentToFile();
        nonBm.convertTemperature();
        nonBm.inputMathExpression();
        nonBm.determineWinner();
        nonBm.findBookByName();
    }

    public static void execBooleanMethods() {
        BooleanMethods bm = new BooleanMethods();
        System.out.println(bm.isActiveProgram());
        System.out.println(bm.isDeletedFile());
        System.out.println(bm.hasUniqueDigit());
        System.out.println(bm.isLetterInput());
        System.out.println(bm.hasEqualsDigits());
        System.out.println(bm.hasRemainingLives());
        System.out.println(bm.isEmpty());
        System.out.println(bm.isValidFilePath());
        System.out.println(bm.fileExists());
    }
}