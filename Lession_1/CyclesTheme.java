
public class CyclesTheme {
    public static void main(String[] args) {
        // 1. Подсчет суммы четных и нечетных чисел
        System.out.println("\n1. Подсчет суммы четных и нечетных чисел\n");

        int startInterval = -10;
        int endInterval = 21; 
        int evenNumberSum = 0;
        int oddNumberSum = 0;
        int currentNumber = startInterval;

        do {
            if (currentNumber % 2 == 0) {
                evenNumberSum += currentNumber;
            } else {
                oddNumberSum += currentNumber;
            }
            currentNumber++;
        } while (currentNumber <= endInterval);
        System.out.println("В отрезке [" + startInterval + ", " + endInterval + 
                "] сумма четных чисел = " + evenNumberSum + ", а нечетных = " + oddNumberSum);
        
        // 2. Вывод чисел между min и max в порядке убывания
        System.out.println("\n2. Вывод чисел между min и max в порядке убывания\n");

        int randomNumber1 = 7;
        int randomNumber2 = 5;
        int randomNumber3 = 13;
        int max = randomNumber1;
        int min = randomNumber2;

        if (randomNumber2 > randomNumber1) {
            max = randomNumber2;
            min = randomNumber1;
        }

        if (randomNumber3 > max) {
            max = randomNumber3;
        }
        if (randomNumber3 < min) {
            min = randomNumber3;
        }

        System.out.println("Числа в интервале (" + min + ", " + max + ") в порядке убывания:");
        for (int i = (max - 1); i > min; i--) {
            System.out.print(i + " ");
        }

        // 3. Вывод реверсивного числа и суммы его цифр
        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр\n");

        int originalNumber = 7986541;
        int tempNumber = originalNumber;
        int sum = 0;
        System.out.print("Исходное число " + originalNumber + " в обратном порядке: ");
        while (tempNumber > 0) {
            int remainder = tempNumber % 10;
            sum += remainder;
            System.out.print(remainder);
            tempNumber /= 10;
        }
        System.out.println("\nСумма цифр в разрядах числа " + originalNumber + " = " + sum);

        // 4. Вывод чисел в несколько строк
        System.out.println("\n4. Вывод чисел в несколько строк");
        int rangeStart = 1;
        int rangeEnd = 30;

        int numberPerLine = 0;
        if (rangeStart > rangeEnd) {
            System.out.println("Ошибка!");
        } 

        for (int i = rangeStart; i < rangeEnd; i++) {
            if (i % 2 == 1 || i % 2 == -1) {
                System.out.printf("%5d ", i);
                numberPerLine++;
                if (numberPerLine % 5 == 0) {
                    System.out.println();
                }
            }
        }

        while (numberPerLine % 5 != 0) {
            numberPerLine++;
            System.out.printf("%5d ", 0); 
        }

        // 5. Проверка количества двоек числа на четность/нечетность
        System.out.println("\n\n5. Проверка количества двоек числа на четность/нечетность\n");
        originalNumber = 3242592;
        tempNumber = originalNumber;
        int twoCounter = 0;
        while (tempNumber > 0) {
            if (tempNumber % 10 == 2) {
                twoCounter++;
            }
            tempNumber = tempNumber / 10;
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

        int lenght = 17;
        int height = 5;
        int square = lenght * height;

        for (int i = 0; i < square; i++) {
            if (i % lenght == 0) {
                System.out.println();
            }
            System.out.print("*");
        }
        System.out.println("\n");

        lenght = 5;
        height = 1;
        while (lenght >= 1) {
            while (height <= lenght) {
                System.out.print("#");
                height++;
            }
            System.out.println();
            lenght--;
            height = 1;
        }
        System.out.println();

        height = 5;
        int currentHeight = 1;
        int currentSymbolPerLine = 1;
        
        do {
            System.out.print("$");
            currentSymbolPerLine++;
            if (currentSymbolPerLine > currentHeight) {
                System.out.println();
                currentHeight++;
                currentSymbolPerLine = 1;
            }
        } while (currentHeight < height);

        do {
            System.out.print("$");
            currentSymbolPerLine++;
            if (currentSymbolPerLine > currentHeight) {
                System.out.println();
                currentHeight--;
                currentSymbolPerLine = 1;
            }
        } while (currentHeight >= 1);

        // 7. Вывод ASCII-символов
        System.out.println("\n7. Вывод ASCII-символов\n");

        rangeStart = 33;
        rangeEnd = 47;
        System.out.println("Decimal Character Description");

        for (int i = rangeStart; i <= rangeEnd; i++) {
            if (i % 2 == 1) {
                System.out.printf("%4d%9s%10s%-5s%n", i, (char) i, "", Character.getName((char) i));
            }
        }
        System.out.println("\nDecimal Character Description");

        rangeStart = 97;
        rangeEnd = 122;

        for (int i = rangeStart; i <= rangeEnd; i++) {
            if (i % 2 == 0) {
                System.out.printf("%4d%9s%10s%-5s%n", i, (char) i, "", Character.getName((char) i));
            }
        }

        // 8. Проверка, является ли число палиндромом
        System.out.println("\n8. Проверка, является ли число палиндромом\n");

        int inputNumber = 1234321;
        tempNumber = inputNumber;
        int reversedNumber = 0;

        while (tempNumber > 0) {
            reversedNumber *= 10 + tempNumber % 10;
            tempNumber /= 10;
        }

        if (inputNumber == reversedNumber) {
            System.out.println("Число " + inputNumber + " - палиндром");
        } else {
            System.out.println("Число " + inputNumber + " - не является палиндромом");
        }

        // 9. Проверка, является ли число счастливым
        System.out.println("\n9. Проверка, является ли число счастливым\n");

        int luckyNumber = 442055;
        int lastThreeNumbers = luckyNumber % 1000;
        int firstThreeNumbers = luckyNumber / 1000;
        int lastThreeSum = 0; 
        int firstThreeSum = 0; 

        for (int i = 0; i < 3; i++) {
            lastThreeSum += lastThreeNumbers % 10;
            lastThreeNumbers = lastThreeNumbers / 10;
            firstThreeSum += firstThreeNumbers % 10;
            firstThreeNumbers = firstThreeNumbers / 10;
        }

        lastThreeNumbers = luckyNumber % 1000;
        firstThreeNumbers = luckyNumber / 1000;

        if (firstThreeSum == lastThreeSum) {
            System.out.println("Число " + luckyNumber + " счастливое");
            System.out.println("сумма цифр " + 
                            String.format("%03d", lastThreeNumbers) + 
                            " = " + lastThreeSum);
            System.out.println("сумма цифр " + firstThreeNumbers + " = " + firstThreeSum);
        } else {
            System.out.println("Число " + luckyNumber + " не счастливое");
        }

        // 10. Вывод таблицы умножения Пифагора
        System.out.println("\n10. Вывод таблицы умножения Пифагора\n");

        for (int i = 1; i <= 9; i++) {
            if (i > 1 && i <= 2) {
                System.out.println("---------------------------");
            }
            for (int j = 1; j <= 9; j++) {
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
