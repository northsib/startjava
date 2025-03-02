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
        bm.isActiveProgram();
        bm.isDeletedFile();
        bm.hasUniqueDigit();
        bm.isLetterInput();
        bm.hasEqualsDigits();
        bm.hasRemainingLives();
        bm.isEmpty();
        bm.isValidFilePath();
        bm.fileExists();
    }
}