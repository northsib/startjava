import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        // 1. Перевод псевдокода на язык Java
        System.out.println("\n1. Перевод псевдокода на язык Java\n");

        String selectedGender = "Мужской";
        if (!(selectedGender == "Мужской")) {
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
        } else if (checkedNum % 2 == 1) {
            System.out.println(checkedNum + " является положительным и нечётным");
        } else if (checkedNum % 2 == -1) {
            System.out.println(checkedNum + " является отрицательным и нечётным");
        } else if ((checkedNum % 2 == 0) && (checkedNum > 0)) {
            System.out.println(checkedNum + " является положительным и чётным");
        } else if (checkedNum < 0) {
            System.out.println(checkedNum + " является отрицательным и чётным");
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
        
        if ((hundredCountNum3 == hundredCountNum4) || (tenCountNum3 == tenCountNum4) || (
                oneCountNum3 == oneCountNum4)) {
            if ((hundredCountNum3 == hundredCountNum4) && (tenCountNum3 == tenCountNum4) && (
                    oneCountNum3 == oneCountNum4)) {
                System.out.println("Введенные Вами числа равны");
            } else if ((hundredCountNum3 == hundredCountNum4) && (tenCountNum3 == tenCountNum4)) {
                System.out.println("У чисел " + num3 + " и " + num4 + 
                        " равное количество сотен - " + hundredCountNum3 + 
                        " и равное количество десятков - " + tenCountNum3);
            } else if ((hundredCountNum3 == hundredCountNum4) && (oneCountNum3 == oneCountNum4)) {
                System.out.println("У чисел " + num3 + " и " + num4 + 
                        " равное количество сотен - " + hundredCountNum3 + 
                        " и равное количество единиц - " + oneCountNum3);
            } else if ((tenCountNum3 == tenCountNum4) && (oneCountNum3 == oneCountNum4)) {
                System.out.println("У чисел " + num3 + " и " + num4 + 
                        " равное количество десятков - " + tenCountNum3 + 
                        " и равное количество единиц - " + oneCountNum3);
            } else if (hundredCountNum3 == hundredCountNum4) {
                System.out.println("У чисел " + num3 + " и " + num4 + 
                        " равное количество сотен - " + hundredCountNum3);
            } else if (tenCountNum3 == tenCountNum4) {
                System.out.println("У чисел " + num3 + " и " + num4 + 
                        " равное количество десятков - " + tenCountNum3);
            } else if (oneCountNum3 == oneCountNum4) {
                System.out.println("У чисел " + num3 + " и " + num4 + 
                        " равное количество единиц - " + oneCountNum3);
            }
        } else {
            System.out.println("Равных цифр в разрядах чисел нет");
        }

        // 5. Определение символа по его коду
        System.out.println("\n5. Определение символа по его коду\n");

        char checkedSymbol = 'a';
        int symbolDecimal = (int) checkedSymbol;

        if (48 <= symbolDecimal && symbolDecimal <= 57) {
            System.out.println(checkedSymbol + " - это цифра");
        } else if (65 <= symbolDecimal && symbolDecimal <= 90) {
            System.out.println(checkedSymbol + " - это большая буква");
        } else if (97 <= symbolDecimal && symbolDecimal <= 122) {
            System.out.println(checkedSymbol + " - это маленькая буква");
        } else {
            System.out.println(checkedSymbol + " - это не цифра и не буква");
        }

        // 6. Подсчет начисленных банком %
        System.out.println("\n6. Подсчет начисленных банком\n");

        BigDecimal moneyOnDeposit = new BigDecimal("321123.59");
        System.out.println("На вклад внесено " + moneyOnDeposit + " рублей");
        if (moneyOnDeposit.compareTo(new BigDecimal("100000")) < 0) {
            BigDecimal depositInterest = new BigDecimal("0.05");
            BigDecimal accruedEarnings = moneyOnDeposit.multiply(depositInterest)
                    .setScale(2, RoundingMode.HALF_UP);
            System.out.println("Сумма начисленного процента составит - " + 
                    accruedEarnings + " рублей");
            System.out.println("Итоговая сумма на вкладе составит - " + 
                    moneyOnDeposit.add(accruedEarnings) + " рублей");
        } else if (0 < moneyOnDeposit.compareTo(new BigDecimal("100000")) && 
                moneyOnDeposit.compareTo(new BigDecimal("300000")) < 0) {
            BigDecimal depositInterest = new BigDecimal("0.07");
            BigDecimal accruedEarnings = moneyOnDeposit.multiply(depositInterest)
                    .setScale(2, RoundingMode.HALF_UP);
            System.out.println("Сумма начисленного процента составит - " + 
                    accruedEarnings + " рублей");
            System.out.println("Итоговая сумма на вкладе составит - " + 
                    moneyOnDeposit.add(accruedEarnings) + " рублей");
        } else if (moneyOnDeposit.compareTo(new BigDecimal("300000")) > 0) {
            BigDecimal depositInterest = new BigDecimal("0.10");
            BigDecimal accruedEarnings = moneyOnDeposit.multiply(depositInterest)
                    .setScale(2, RoundingMode.HALF_UP);
            System.out.println("Сумма начисленного процента составит - " + 
                    accruedEarnings + " рублей");
            System.out.println("Итоговая сумма на вкладе составит - " + 
                    moneyOnDeposit.add(accruedEarnings) + " рублей");
        }

        // 7. Определение оценки по предметам
        System.out.println("\n7. Определение оценки по предметам\n");

        BigDecimal historyProcent = new BigDecimal("84");
        BigDecimal historyAssesment = new BigDecimal("0"); 
        if (historyProcent.compareTo(new BigDecimal("60")) <= 0) {
            historyAssesment = new BigDecimal("2");
            System.out.println("оценка по истории - " + historyAssesment);
        }
        if (0 < historyProcent.compareTo(new BigDecimal("60")) && 
                historyProcent.compareTo(new BigDecimal("73")) <= 0) {
            historyAssesment = new BigDecimal("3");
            System.out.println("оценка по истории - " + historyAssesment);
        }
        if (0 < historyProcent.compareTo(new BigDecimal("73")) && 
                historyProcent.compareTo(new BigDecimal("91")) <= 0) {
            historyAssesment = new BigDecimal("4");
            System.out.println("оценка по истории - " + historyAssesment);
        }
        if (0 < historyProcent.compareTo(new BigDecimal("91"))) {
            historyAssesment = new BigDecimal("5");
            System.out.println("оценка по истории - " + historyAssesment);
        }

        BigDecimal programmingProcent = new BigDecimal("79");
        BigDecimal programmingAssesment = new BigDecimal("0");
        if (programmingProcent.compareTo(new BigDecimal("60")) <= 0) {
            programmingAssesment = new BigDecimal("2");
            System.out.println("оценка по программированию - " + programmingAssesment);
        } 
        if (0 < programmingProcent.compareTo(new BigDecimal("60")) && 
                programmingProcent.compareTo(new BigDecimal("73")) <= 0) {
            programmingAssesment = new BigDecimal("3");
            System.out.println("оценка по программированию - " + programmingAssesment);
        } 
        if (0 < programmingProcent.compareTo(new BigDecimal("73")) && 
                programmingProcent.compareTo(new BigDecimal("91")) <= 0) {
            programmingAssesment = new BigDecimal("4");
            System.out.println("оценка по программированию - " + programmingAssesment);
        }
        if (0 < programmingProcent.compareTo(new BigDecimal("91"))) {
            programmingAssesment = new BigDecimal("5");
            System.out.println("оценка по программированию - " + programmingAssesment);
        }
        BigDecimal averageAssesment = historyAssesment.add(programmingAssesment)
                .divide(new BigDecimal("2"), 1, RoundingMode.HALF_UP);
        System.out.println("Средний балл по предметам составил " + averageAssesment);
        BigDecimal averageProcent = historyProcent.add(programmingProcent)
                .divide(new BigDecimal("2"), 2, RoundingMode.HALF_UP);
        System.out.println("Средний процент по предметам составил " + averageProcent);

        // 8. Расчет годовой прибыли
        System.out.println("\n8. Расчет годовой прибыли\n");

        BigDecimal monthlySale = new BigDecimal("14000");
        BigDecimal monthlyRentPrice = new BigDecimal("5000");
        BigDecimal monthlyProduction = new BigDecimal("9000");

        BigDecimal annualSales = monthlySale.multiply(new BigDecimal("12"))
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal annualRentPrice = monthlyRentPrice.multiply(new BigDecimal("12"))
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal annualProduction = monthlyProduction.multiply(new BigDecimal("12"))
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalInput = annualRentPrice.add(annualProduction);
        BigDecimal profit = annualSales.subtract(totalInput);
        if (profit.compareTo(new BigDecimal("0")) == 0) {
            System.out.println("Прибыль за год: " + profit + " руб.");
        } else if (profit.compareTo(new BigDecimal("0")) > 0) {
            System.out.println("Прибыль за год: +" + profit + " руб.");
        } else if (profit.compareTo(new BigDecimal("0")) < 0) {
            System.out.println("Прибыль за год: " + profit + " руб.");
        }
    }
}