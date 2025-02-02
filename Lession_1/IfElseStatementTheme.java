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
            System.out.println("Первая буква вашего имени - не M и не I, а другая");
        }

        // 2. Поиск большего числа
        System.out.println("\n2. Поиск большего числа\n");
        int num1 = 123;
        int num2 = 223;
        if (num1 > num2) {
            System.out.println("Число " + num1 + " больше, чем " + num2);
        } else if (num1 < num2) {
            System.out.println("Число " + num2 + " больше, чем " + num1);
        } else {
            System.out.println("Числа " + num1 + " и " + num2 + " равны");
        }

        // 3. Проверка числа
        System.out.println("\n3. Проверка числа\n");

        int checkedNum = 0;
        if (checkedNum == 0) {
            System.out.println("Проверяемое число равно 0");
        } else {
            if (checkedNum % 2 == 1) {
                System.out.println(checkedNum + " является положительным и нечётным");
            } else if (checkedNum % 2 == -1) {
                System.out.println(checkedNum + " является отрицательным и нечётным");
            } else if ((checkedNum % 2 == 0) && (checkedNum > 0)) {
                System.out.println(checkedNum + " является положительным и чётным");
            } else {
                System.out.println(checkedNum + " является отрицательным и чётным");
            } 
        }

        // 4. Поиск одинаковых цифр в числах
        System.out.println("\n4. Поиск одинаковых цифр в числах\n");

        int num3 = 123;
        int num4 = 223;

        int hundredCountNum3 = num3 / 100;
        int tenCountNum3 = (num3 % 100) / 10;
        int oneCountNum3 = num3 % 10;

        int hundredCountNum4 = num4 / 100;
        int tenCountNum4 = (num4 % 100) / 10;
        int oneCountNum4 = num4 % 10;

        if (hundredCountNum3 != hundredCountNum4 && tenCountNum3 != tenCountNum4 &&
                oneCountNum3 != oneCountNum4) {
            System.out.println("Равных цифр в разрядах чисел нет");
        } else {
            if (hundredCountNum3 == hundredCountNum4) {
                System.out.println("У чисел " + num3 + " и " + num4 +
                        " сотни равны - " + hundredCountNum3);
            }
            if (tenCountNum3 == tenCountNum4) {
                System.out.println("У чисел " + num3 + " и " + num4 +
                        " равное количество десятков - " + tenCountNum3);
            }
            if (oneCountNum3 == oneCountNum4) {
                System.out.println("У чисел " + num3 + " и " + num4 +
                        " равное количество единиц - " + oneCountNum3);
            }
        }

        // 5. Определение символа по его коду
        System.out.println("\n5. Определение символа по его коду\n");

        char checkedSymbol = '\u0057';

        if (checkedSymbol >= '0' && checkedSymbol <= '9') {
            System.out.println(checkedSymbol + " - это цифра");
        } else if (checkedSymbol >= 'A' && checkedSymbol <='Z') {
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
        if (moneyOnDeposit1 > 100000 && moneyOnDeposit1 <= 300000) {
            depositInterest1 = 0.07f;
        } else if (moneyOnDeposit1 > 300000) {
            depositInterest1 = 0.10f;
        }
        System.out.println("На вклад внесено " + moneyOnDeposit1 + " рублей, " +
                "\nсумма начисленного процента составила - " + 
                moneyOnDeposit1 * depositInterest1 + " рублей, " +
                "\nитоговая сумма на вкладе составит - " + 
                (moneyOnDeposit1 + moneyOnDeposit1 * depositInterest1) + " рублей");

        // 7. Определение оценки по предметам
        System.out.println("\n7. Определение оценки по предметам\n");

        float historyPercent = 59f;
        float historyGrade = 2f;
        if (60 < historyPercent && historyPercent <= 73) {
            historyGrade = 3;
        } else if (73 < historyPercent && historyPercent <= 91) {
            historyGrade = 4;
        } else if (91 < historyPercent) {
            historyGrade = 5;
        }
        System.out.println("оценка по истории - " + historyGrade);
        float programmingPercent = 92f;
        float programmingGrade = 2f;
        if (60 < programmingPercent && programmingPercent <= 73) {
            programmingGrade = 3;
        } else if (73 < programmingPercent && programmingPercent <= 91) {
            programmingGrade = 4;
        } else if (91 < programmingPercent) {
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
        float profit1 = (monthlySale1 - (monthlyRentPrice1 + monthlyProduction1)) * 12;
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

        BigDecimal annualSales = monthlySale.multiply(BigDecimal.valueOf(12))
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal annualRentPrice = monthlyRentPrice.multiply(BigDecimal.valueOf(12))
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal annualProduction = monthlyProduction.multiply(BigDecimal.valueOf(12))
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalInput = annualRentPrice.add(annualProduction);
        BigDecimal profit = annualSales.subtract(totalInput);
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
        if ((moneyOnDeposit.compareTo(BigDecimal.valueOf(100000)) > 0) && 
                moneyOnDeposit.compareTo(BigDecimal.valueOf(300000)) < 0) {
            depositInterest = new BigDecimal("0.07");
        } else if (moneyOnDeposit.compareTo(BigDecimal.valueOf(300000)) >= 0) {
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