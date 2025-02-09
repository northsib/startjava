import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        // 1. Перевод псевдокода на язык Java
        System.out.println("\n1. Перевод псевдокода на язык Java\n");

        String selectedGender = "Мужской";
        if (!selectedGender.equals("Мужской")) {
            System.out.println("Ваш пол - женский");
        } else {
            System.out.println("Ваш пол - мужской");
        }

        int age = 17;
        if (age > 18) {
            System.out.println("Вы достигли совершеннолетия");
        } else {
            System.out.println("Вам нет 18 лет");
        }

        double height = 1.82d;
        if (height < 1.8) {
            System.out.println("Вы недостаточно высокий");
        } else {
            System.out.println("У вас высокий рост");
        }

        String name = "Gregory";
        char firstLetterName = name.charAt(0);
        if (firstLetterName == 'M') {
            System.out.println("Первая буква вашего имени - M");
        } else if (firstLetterName == 'I') {
            System.out.println("Первая буква вашего имени - I");
        } else {
            System.out.println("Первая буква вашего имени - не M и не I, а " + firstLetterName);
        }

        // 2. Поиск большего числа
        System.out.println("\n2. Поиск большего числа\n");
        int firstNumber = 123;
        int secondNumber = 223;
        if (firstNumber > secondNumber) {
            System.out.println("Число " + firstNumber + " больше, чем " + secondNumber);
        } else if (firstNumber < secondNumber) {
            System.out.println("Число " + secondNumber + " больше, чем " + firstNumber);
        } else {
            System.out.println("Числа " + firstNumber + " и " + secondNumber + " равны");
        }

        // 3. Проверка числа
        System.out.println("\n3. Проверка числа\n");

        int checkedNum = 0;
        if (checkedNum == 0) {
            System.out.println("Проверяемое число равно 0");
        } else {
            if (checkedNum % 2 == 0) {
                System.out.print(checkedNum + " - является чётным");
            } else {
                System.out.print(checkedNum + " - является нечётным");
            }
            if (checkedNum > 0) {
                System.out.println(" и положительным");
            } else {
                System.out.println(" и отрицательным");
            }
        }

        // 4. Поиск одинаковых цифр в числах
        System.out.println("\n4. Поиск одинаковых цифр в числах\n");

        firstNumber = 123;
        secondNumber = 223;

        int firstHundredCount = firstNumber / 100;
        int firstTenCount = (firstNumber % 100) / 10;
        int firstOneCount = firstNumber % 10;

        int secondHundredCount = secondNumber / 100;
        int secondTenCount = (secondNumber % 100) / 10;
        int secondOneCount = secondNumber % 10;

        if (firstHundredCount != secondHundredCount && firstTenCount != secondTenCount &&
                firstOneCount != secondOneCount) {
            System.out.println("Равных цифр в разрядах чисел нет");
        } else {
            System.out.println("У чисел " + firstNumber + " и " + secondNumber + ":");
            if (firstHundredCount == secondHundredCount) {
                System.out.println("Сотни равны - " + firstHundredCount);
            }
            if (firstTenCount == secondTenCount) {
                System.out.println("Десятки равны - " + firstTenCount);
            }
            if (firstOneCount == secondOneCount) {
                System.out.println("Единицы равны - " + firstOneCount);
            }
        }

        // 5. Определение символа по его коду
        System.out.println("\n5. Определение символа по его коду\n");

        char checkedSymbol = '\u0057';

        if (checkedSymbol >= '0' && checkedSymbol <= '9') {
            System.out.println(checkedSymbol + " - это цифра");
        } else if (checkedSymbol >= 'A' && checkedSymbol <= 'Z') {
            System.out.println(checkedSymbol + " - это большая буква");
        } else if (checkedSymbol >= 'a' && checkedSymbol <= 'z') {
            System.out.println(checkedSymbol + " - это маленькая буква");
        } else {
            System.out.println(checkedSymbol + " - это не цифра и не буква");
        }

        // 6. Подсчет начисленных банком процентов
        System.out.println("\n6. Подсчет начисленных банком процентов\n");

        float moneyOnDeposit1 = 321123.59f;
        float depositInterest1 = 0.5f;
        if (moneyOnDeposit1 > 100000) {
            depositInterest1 = 0.07f;
        } 
        if (moneyOnDeposit1 > 300000) {
            depositInterest1 = 0.10f;
        }
        float accruedEarnings1 = moneyOnDeposit1 * depositInterest1;
        System.out.println("На вклад внесено " + moneyOnDeposit1 + " рублей, " +
                "\nсумма начисленного процента составила - " + accruedEarnings1 + 
                " рублей, \nитоговая сумма на вкладе составит - " + 
                (moneyOnDeposit1 + accruedEarnings1) + " рублей");

        // 7. Определение оценки по предметам
        System.out.println("\n7. Определение оценки по предметам\n");

        float historyPercent = 59f;
        float historyGrade = 2f;
        if (historyPercent > 60) {
            historyGrade = 3;
        } 
        if (historyPercent > 73) {
            historyGrade = 4;
        }
        if (historyPercent > 91) {
            historyGrade = 5;
        }
        System.out.println("оценка по истории - " + historyGrade);
        float programmingPercent = 92f;
        float programmingGrade = 2f;
        if (programmingPercent > 60) {
            programmingGrade = 3;
        }
        if (programmingPercent > 73) {
            programmingGrade = 4;
        }
        if (programmingPercent > 91) {
            programmingGrade = 5;
        }

        System.out.println("оценка по программированию - " + programmingGrade);
        System.out.println("Средний балл по предметам составил - " + 
                (historyGrade + programmingGrade) / 2);
        System.out.println("Средний процент по предметам составил - " + 
                (historyPercent + programmingPercent) / 2);

        // 8. Расчет годовой прибыли
        System.out.println("\n8. Расчет годовой прибыли\n");

        float monthlySale1 = 13025.233f;
        float monthlyRentPrice1 = 5123.018f;
        float monthlyProduction1 = 9001.729f;

        float profit1 = 12 * (monthlySale1 - monthlyRentPrice1 - monthlyProduction1);

        if (profit1 <= 0) {
            System.out.println("Прибыль за год: " + profit1 + " руб.");
        } else {
            System.out.println("Прибыль за год: +" + profit1 + " руб.");
        }

        // 9. Расчет годовой прибыли (с использованием BigDecimal)
        System.out.println("\n9. Расчет годовой прибыли (с использованием BigDecimal)\n");

        BigDecimal monthlySale = new BigDecimal("13025.233");
        BigDecimal monthlyRentPrice = new BigDecimal("5123.018");
        BigDecimal monthlyProduction = new BigDecimal("9001.729");

        BigDecimal profit = monthlySale.subtract(monthlyRentPrice).subtract(monthlyProduction)
                .multiply(BigDecimal.valueOf(12)).setScale(2, RoundingMode.HALF_UP);

        if (profit.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Прибыль за год: " + profit + " руб.");
        } else {
            System.out.println("Прибыль за год: +" + profit + " руб.");
        } 
        
        // 10. Подсчет начисленных банком процентов (с использованием BigDecimal)
        System.out.println("\n10. Подсчет начисленных банком процентов " +
                "(с использованием BigDecimal)\n");

        BigDecimal moneyOnDeposit = new BigDecimal("321123.59");
        BigDecimal depositInterest = new BigDecimal("0.05");
        if (moneyOnDeposit.compareTo(BigDecimal.valueOf(100000)) >= 0) {
            depositInterest = new BigDecimal("0.07");
        } 
        if (moneyOnDeposit.compareTo(BigDecimal.valueOf(300000)) >= 0) {
            depositInterest = new BigDecimal("0.10");
        }
        BigDecimal accruedEarnings = moneyOnDeposit.multiply(depositInterest)
                    .setScale(2, RoundingMode.HALF_UP);
        System.out.println("На вклад внесено " + moneyOnDeposit + " рублей, " +
                "\nсумма начисленного процента составила - " + accruedEarnings + 
                " рублей,\nитоговая сумма на вкладе составит - " + 
                moneyOnDeposit.add(accruedEarnings) + " рублей");
    }
}