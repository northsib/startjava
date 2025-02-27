public class ActionPerformer {
    public void callAllActionMethods() {
        findLongestWord();
        selectMenuOption();
        calculateAverageMarks();
        countUniqueWords();
        showError();
        syncCloudData();
        restoreFromBackup();
        pauseFileDownload();
        factoryReset();
        writeContentToFile();
        convertTemperature();
        inputMathExpression();
        determineWinner();
        findBookByName();
    }

    private void findLongestWord() {
        System.out.println("\n" + MethodTracker.name() + "() -> найти самое длинное слово\n");
    }

    private void selectMenuOption() {
        System.out.println(MethodTracker.name() + "() -> выбрать пункт меню\n");
    }

    private void calculateAverageMarks() {
        System.out.println(MethodTracker.name() + "() -> вычислить среднее значение оценок\n");
    }

    private void countUniqueWords() {
        System.out.println(MethodTracker.name() + "() -> подсчитать количество уникальных слов\n");
    }

    private void showError() {
        System.out.println(MethodTracker.name() + "() -> вывести сообщение об ошибке\n");
    }

    private void syncCloudData() {
        System.out.println(MethodTracker.name() + "() -> синхронизировать данные с облачным хранилищем\n");
    }

    private void restoreFromBackup() {
        System.out.println(MethodTracker.name() + "() -> восстановить данные из резервной копии\n");
    }

    private void pauseFileDownload() {
        System.out.println(MethodTracker.name() + "() -> приостановить загрузку файла\n");
    }

    private void factoryReset() {
        System.out.println(MethodTracker.name() + "() -> сбросить настройки до заводских\n");
    }

    private void writeContentToFile() {
        System.out.println(MethodTracker.name() + "() -> записать содержимое в файл\n");
    }

    private void convertTemperature() {
        System.out.println(MethodTracker.name() + "() -> преобразовать температуру\n");
    }

    private void inputMathExpression() {
        System.out.println(MethodTracker.name() + "() -> ввести математическое выражение\n");
    }

    private void determineWinner() {
        System.out.println(MethodTracker.name() + "() -> определить победителя\n");
    }

    private void findBookByName() {
        System.out.println(MethodTracker.name() + "() -> найти книгу по имени\n");
    }
}