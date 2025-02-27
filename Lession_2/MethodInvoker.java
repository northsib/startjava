public class MethodInvoker {
    public static void main(String[] args) {
        invokeNonBooleanMethods();
        invokeBooleanMethods();
    }

    public static void invokeNonBooleanMethods() {
        NonBooleanMethods nonBooleanMethods = new NonBooleanMethods();
        nonBooleanMethods.findLongestWord();
        nonBooleanMethods.selectMenuOption();
        nonBooleanMethods.calculateAverageMarks();
        nonBooleanMethods.countUniqueWords();
        nonBooleanMethods.showError();
        nonBooleanMethods.syncCloudData();
        nonBooleanMethods.restoreFromBackup();
        nonBooleanMethods.pauseFileDownload();
        nonBooleanMethods.factoryReset();
        nonBooleanMethods.writeContentToFile();
        nonBooleanMethods.convertTemperature();
        nonBooleanMethods.inputMathExpression();
        nonBooleanMethods.determineWinner();
        nonBooleanMethods.findBookByName();
    }

    public static void invokeBooleanMethods() {
        BooleanMethods booleanMethods = new BooleanMethods();
        booleanMethods.isProgramActive();
        booleanMethods.isFileDeleted();
        booleanMethods.hasUniqueDigit();
        booleanMethods.isAlphaInput();
        booleanMethods.hasEqualsDigits();
        booleanMethods.hasRemainingLives();
        booleanMethods.isWhitespaceString();
        booleanMethods.isValidFilePath();
        booleanMethods.fileExists();
    }
}