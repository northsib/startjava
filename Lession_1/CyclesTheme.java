
public class CyclesTheme {
    public static void main(String[] args) {
        // 1. Подсчет суммы четных и нечетных чисел
        System.out.println("\n1. Подсчет суммы четных и нечетных чисел\n");

        int startInterval = -10;
        int endInterval = 21; 
        int evenNumberSum = 0;
        int oddNumberSum = 0;
        int i = startInterval;

        do {
            if (i % 2 == 0) {
                evenNumberSum += i;
            } else {
                oddNumberSum += i;
            }
            i++;
        } while (i < endInterval);
        System.out.println("В отрезке [" + startInterval + ", " + endInterval + 
                "] сумма четных чисел = " + evenNumberSum + ", а нечетных = " + oddNumberSum);
        
        // 2. Вывод чисел между min и max в порядке убывания
        System.out.println("\n2. Вывод чисел между min и max в порядке убывания\n");

        int randomNumber1 = 4;
        int randomNumber2 = 5;
        int randomNumber3 = -5;
        int maxNumber = 0;
        int minNumber = 0;

        if (randomNumber1 > randomNumber2 && randomNumber1 > randomNumber3) {
            maxNumber = randomNumber1;
        } else if (randomNumber2 > randomNumber3) {
            maxNumber = randomNumber2;
        } else {
            maxNumber = randomNumber3;
        }

        if (randomNumber1 < randomNumber2 && randomNumber1 < randomNumber3) {
            minNumber = randomNumber1;
        } else if (randomNumber2 < randomNumber3) {
            minNumber = randomNumber2;
        } else {
            minNumber = randomNumber3;
        }
        System.out.println("Числа в интервале (" + minNumber + ", " + maxNumber + ") " + 
                "в порядке убывания:");
        for (i = (maxNumber - 1); i > minNumber; i--) {
            System.out.print(i + " ");
        }

        // 3. Вывод реверсивного числа и суммы его цифр
        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр\n");

        int originalNumber = 7986541;
        i = originalNumber;
        int sum = 0;
        System.out.print("Исходное число " + originalNumber + " в обратном порядке: ");
        while (i > 0) {
            int numCount = i % 10;
            sum += numCount;
            System.out.print(numCount);
            i = i / 10;
        }
        System.out.println("\nСумма цифр в разрядах числа " + originalNumber + " = " + sum);

        // 4. Вывод чисел в несколько строк
        System.out.println("\n4. Вывод чисел в несколько строк");
        int rangeStart = -10;
        int rangeEnd = 30;
        maxNumber = 0;
        minNumber = 0;
        int numberPerLine = 0;
        if (rangeStart < rangeEnd) {
            minNumber = rangeStart;
            maxNumber = rangeEnd;
        } else {
            minNumber = rangeEnd;
            maxNumber = rangeStart;
        } 
        for (i = minNumber; i < maxNumber; i++) {
            if (numberPerLine % 5 == 0) {
                System.out.println();
            }
            numberPerLine++;
            System.out.printf("%5d ", i);
        }

        while (numberPerLine % 5 != 0) {
            numberPerLine++;
            System.out.printf("%5d ", 0); 
        }

        // 5. Проверка количества двоек числа на четность/нечетность
        System.out.println("\n\n5. Проверка количества двоек числа на четность/нечетность\n");
        originalNumber = 3242592;
        i = originalNumber;
        int twoCounter = 0;
        while (i > 0) {
            if (i % 10 == 2) {
                twoCounter++;
            }
            i = i / 10;
        }
        if (twoCounter % 2 != 0) {
            System.out.println("В числе " + originalNumber + " нечетное (" + twoCounter + 
                    ") количество двоек"); 
        } else {
            System.out.println("В числе " + originalNumber + " четное (" + twoCounter + 
                    ") количество двоек");
        }

        // 6. Вывод геометрических фигур
        System.out.println("\n6. Вывод геометрических фигур");

        int lenghtOfRectangle = 17;
        int widhtOfRectangle = 5;
        int squareOfRectangle = lenghtOfRectangle * widhtOfRectangle;
        char asterisk = '*';

        for (i = 0; i < squareOfRectangle; i++) {
            if (i % lenghtOfRectangle == 0) {
                System.out.println();
            }
            System.out.print(asterisk);
        }
        System.out.println("\n");

        char number = '#';
        int cathetusTriangle1 = 5;
        i = cathetusTriangle1;
        int j = 1;
        while (i >= 1) {
            while (j <= i) {
                System.out.print(number);
                j++;
            }
            System.out.println();
            i--;
            j = 1;
        }
        System.out.println();

        char dollar = '$';
        int triangleHeight = 5;
        i = 1;
        j = 1;
        
        do {
            do {
                System.out.print(dollar);
                j++;
            } while (j <= i);
            System.out.println();
            i++;
            j = 1;
        } while (i < triangleHeight);

        do {
            do {
                System.out.print(dollar);
                j++;
            } while (j <= i);
            System.out.println();
            j = 1;
            i--;
        } while (i >= 1);

        // 7. Вывод ASCII-символов
        System.out.println("\n7. Вывод ASCII-символов\n");

        int symbolCode1 = 33;
        int symbolCode2 = 47;
        System.out.println("Decimal Character Description");

        for (i = symbolCode1; i <= symbolCode2; i++) {
            char printChar = (char) i;
            String charDescription;
            if (i % 2 == 1) {
                charDescription = Character.getName(printChar);
                System.out.printf("%4d%9s%10s%-5s%n", i, printChar, "", charDescription);
            }
        }
        System.out.println("\nDecimal Character Description");

        symbolCode1 = 97;
        symbolCode2 = 122;

        for (i = symbolCode1; i <= symbolCode2; i++) {
            char printChar = (char) i;
            String charDescription;
            if (i % 2 == 0) {
                charDescription = Character.getName(printChar);
                System.out.printf("%4d%9s%10s%-5s%n", i, printChar, "", charDescription);
            }
        }

        // 8. Проверка, является ли число палиндромом
        System.out.println("\n8. Проверка, является ли число палиндромом\n");

        int palindromeDigit = 1234321;
        originalNumber = palindromeDigit;
        int reverseNumber = 0;

        while (originalNumber > 0) {
            int lastNumber = originalNumber % 10;
            originalNumber = originalNumber / 10;
            reverseNumber = reverseNumber * 10 + lastNumber;
        }

        if (palindromeDigit == reverseNumber) {
            System.out.println("Число " + palindromeDigit + " - палиндром");
        } else {
            System.out.println("Число " + palindromeDigit + " - не является палиндромом");
        }

        // 9. Проверка, является ли число счастливым
        System.out.println("\n9. Проверка, является ли число счастливым\n");

        int luckyNumber = 442055;
        int numCount = 0;
        i = luckyNumber;

        while (i > 0) {
            i = i / 10;
            numCount++;
        }
        if (numCount < 6 || numCount > 6) {
            System.out.println("Введено неверное значение");
            return;
        }

        int lastThreeNumbers = luckyNumber % 1000;
        int firstThreeNumbers = luckyNumber / 1000;

        int lastThreeSum = 0; 
        for (i = 0; i < 3; i++) {
            int lastNumber = lastThreeNumbers % 10;
            lastThreeSum += lastNumber;
            lastThreeNumbers = lastThreeNumbers / 10;
        }

        int firstThreeSum = 0; 
        for (i = 0; i < 3; i++) {
            int lastNumber = firstThreeNumbers % 10;
            firstThreeSum += lastNumber;
            firstThreeNumbers = firstThreeNumbers / 10;
        }

        lastThreeNumbers = luckyNumber % 1000;
        firstThreeNumbers = luckyNumber / 1000;

        if (firstThreeSum == lastThreeSum) {
            System.out.println("Число " + luckyNumber + " счастливое");
            if (lastThreeNumbers < 100) {
                System.out.println("сумма цифр 0" + lastThreeNumbers + " = " + lastThreeSum);
            } else {
                System.out.println("сумма цифр " + lastThreeNumbers + " = " + lastThreeSum);
            }
            System.out.println("сумма цифр " + firstThreeNumbers + " = " + firstThreeSum);
        } else {
            System.out.println("Число " + luckyNumber + " не счастливое");
        }

        // 10. Вывод таблицы умножения Пифагора
        System.out.println("\n10. Вывод таблицы умножения Пифагора\n");

        for (i = 1; i <= 9; i++) {
            if (i > 1 && i <= 2) {
                System.out.println("---------------------------");
            }
            for (j = 1; j <= 9; j++) {
                int digitProduce = i * j;
                if (digitProduce == 1) {
                    System.out.print("   ");
                } else if (j > 1 && j <= 2) {
                    System.out.print(" | ");
                } else {
                    System.out.printf("%3d", digitProduce);
                }
            }
            System.out.println();
        }   
    }
}
