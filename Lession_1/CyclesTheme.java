
public class CyclesTheme {
    public static void main(String[] args) {
        // 1. Подсчет суммы четных и нечетных чисел
        System.out.println("\n1. Подсчет суммы четных и нечетных чисел\n");

        int a1 = -10;
        int b1 = 21; 
        int x = 0;
        int y = 0;
        int i = a1;

        do {
            if (i % 2 == 0) {
                x += i;
            } else {
                y += i;
            }
            i++;
        } while (i < b1);
        System.out.println("В отрезке [" + a1 + ", " + b1 + "] сумма четных чисел = " + 
                x + ", а нечетных = " + y);
        
        // 2. Вывод чисел между min и max в порядке убывания
        System.out.println("\n2. Вывод чисел между min и max в порядке убывания\n");

        int a2 = 4;
        int b2 = 5;
        int c2 = -5;
        int maxNum = 0;
        int minNum = 0;

        if (a2 > b2 && a2 > c2) {
            maxNum = a2;
        } else if (b2 > c2) {
            maxNum = b2;
        } else {
            maxNum = c2;
        }

        if (a2 < b2 && a2 < c2) {
            minNum = a2;
        } else if (b2 < c2) {
            minNum = b2;
        } else {
            minNum = c2;
        }
        System.out.println("Числа в интервале (" + minNum + ", " + maxNum + ") " + 
                "в порядке убывания:");
        for (int i2 = (maxNum - 1); i2 > minNum; i2--) {
            System.out.print(i2 + " ");
        }

        // 3. Вывод реверсивного числа и суммы его цифр
        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр\n");

        int originalNumber = 7986541;
        int a3 = originalNumber;
        int sum = 0;
        System.out.print("Исходное число " + originalNumber + " в обратном порядке: ");
        while (a3 > 0) {
            int numCount = a3 % 10;
            sum += numCount;
            System.out.print(numCount);
            a3 = a3 / 10;
        }
        System.out.println("\nСумма цифр в разрядах числа " + originalNumber + " = " + sum);

        // 4. Вывод чисел в несколько строк
        System.out.println("\n4. Вывод чисел в несколько строк");
        int a4 = -10;
        int b4 = 30;
        int maxNum4 = 0;
        int minNum4 = 0;
        int numberPerLine = 0;
        if (a4 < b4) {
            minNum4 = a4;
            maxNum4 = b4;
        } else {
            minNum4 = b4;
            maxNum4 = a4;
        } 
        for (int i5 = minNum4; i5 < maxNum4; i5++) {
            if (numberPerLine % 5 == 0) {
                System.out.println();
            }
            numberPerLine++;
            System.out.printf("%5d ", i5);
        }

        while (numberPerLine % 5 != 0) {
            numberPerLine++;
            System.out.printf("%5d ", 0); 
        }

        // 5. Проверка количества двоек числа на четность/нечетность
        System.out.println("\n\n5. Проверка количества двоек числа на четность/нечетность\n");
        int num5 = 3242592;
        int i5 = num5;
        int twoCounter = 0;
        while (i5 > 0) {
            if (i5 % 10 == 2) {
                twoCounter++;
            }
            i5 = i5 / 10;
        }
        if (twoCounter % 2 != 0) {
            System.out.println("В числе " + num5 + " нечетное (" + twoCounter + ") количество двоек"); 
        } else {
            System.out.println("В числе " + num5 + " четное (" + twoCounter + ") количество двоек");
        }

        // 6. Вывод геометрических фигур
        System.out.println("\n6. Вывод геометрических фигур");

        int lenghtOfRectangle = 17;
        int widhtOfRectangle = 5;
        int squareOfRectangle = lenghtOfRectangle * widhtOfRectangle;
        char asterisk = '*';

        for (int i6 = 0; i6 < squareOfRectangle; i6++) {
            if (i6 % lenghtOfRectangle == 0) {
                System.out.println();
            }
            System.out.print(asterisk);
        }
        System.out.println("\n");

        char number = '#';
        int cathetusTriangle1 = 5;
        int i7 = cathetusTriangle1;
        int j7 = 1;
        while (i7 >= 1) {
            while (j7 <= i7) {
                System.out.print(number);
                j7++;
            }
            System.out.println();
            i7--;
            j7 = 1;
        }
        System.out.println();

        char dollar = '$';
        int triangleHeight = 5;
        int i8 = 1;
        int j8 = 1;
        
        do {
            do {
                System.out.print(dollar);
                j8++;
            } while (j8 <= i8);
            System.out.println();
            i8++;
            j8 = 1;
        } while (i8 < triangleHeight);

        do {
            do {
                System.out.print(dollar);
                j8++;
            } while (j8 <= i8);
            System.out.println();
            j8 = 1;
            i8--;
        } while (i8 >= 1);

        // 7. Вывод ASCII-символов
        System.out.println("\n7. Вывод ASCII-символов\n");

        int symbolCode1 = 33;
        int symbolCode2 = 47;
        System.out.println("Decimal Character Description");

        for (int i9 = symbolCode1; i9 <= symbolCode2; i9++) {
            char ch = (char) i9;
            String charDescription;
            if (i9 % 2 == 1) {
                charDescription = Character.getName(ch);
                System.out.printf("%4d%9s%10s%-5s%n", i9, ch, "", charDescription);
            }
        }
        System.out.println("\nDecimal Character Description");

        symbolCode1 = 97;
        symbolCode2 = 122;

        for (int i9 = symbolCode1; i9 <= symbolCode2; i9++) {
            char ch = (char) i9;
            String charDescription;
            if (i9 % 2 == 0) {
                charDescription = Character.getName(ch);
                System.out.printf("%4d%9s%10s%-5s%n", i9, ch, "", charDescription);
            }
        }

        // 8. Проверка, является ли число палиндромом
        System.out.println("\n8. Проверка, является ли число палиндромом\n");

        int palindromeDigit = 1234321;
        int originalNumber1 = palindromeDigit;
        int reverseNumber = 0;

        while (originalNumber1 > 0) {
            int lastNum = originalNumber1 % 10;
            originalNumber1 = originalNumber1 / 10;
            reverseNumber = reverseNumber * 10 + lastNum;
        }

        if (palindromeDigit == reverseNumber) {
            System.out.println("Число " + palindromeDigit + " - палиндром");
        } else {
            System.out.println("Число " + palindromeDigit + " - не является палиндромом");
        }

        // 9. Проверка, является ли число счастливым
        System.out.println("\n9. Проверка, является ли число счастливым\n");

        int luckyNumber = 550055;
        int numCount1 = 0;
        int i10 = luckyNumber;
        int firstThreeSum = 0;
        int lastThreeSum = 0;
        int trueLastDigits = 0;
        int firstDigits = 0;

        while (i10 > 0) {
            i10 = i10 / 10;
            numCount1++;
        }

        if (numCount1 < 6 || numCount1 > 6) {
            System.out.println("Введено неверное значение");
        } else {
            i10 = luckyNumber;
            int counter1 = numCount1 / 2;
            while (counter1 > 0) {
                int lastNum = i10 % 10;
                lastThreeSum = lastThreeSum + lastNum;
                i10 = i10 / 10;
                counter1--;
            }

            int lastDigits = 0;
            i10 = luckyNumber;
            for (int i11 = 1; i11 <= (numCount1 / 2); i11++) {
                int lastNum = i10 % 10;
                i10 = i10 / 10;
                lastDigits = lastDigits * 10 + lastNum;
            }

            i10 = lastDigits;
            while (i10 > 0) {
                int lastNum = i10 % 10;
                i10 = i10 / 10; 
                trueLastDigits = trueLastDigits * 10 + lastNum;
            }

            i10 = luckyNumber;
            int reverseNumber2 = 0;
            while (i10 > 0) {
                int lastNum = i10 % 10;
                i10 = i10 / 10;
                reverseNumber2 = reverseNumber2 * 10 + lastNum;
            }

            i10 = reverseNumber2;
            int counter2 = numCount1 / 2;
            while (counter2 > 0) {
                int lastNum = i10 % 10;
                firstThreeSum = firstThreeSum + lastNum;
                i10 = i10 / 10;
                counter2--;
            }

            i10 = reverseNumber2;
            for (int i11 = 1; i11 <= (numCount1 / 2); i11++) {
                int lastNum = i10 % 10;
                i10 = i10 / 10;
                firstDigits = firstDigits * 10 + lastNum;
            }
            if (firstThreeSum == lastThreeSum) {
                System.out.println("Число " + luckyNumber + " счастливое");
                if (trueLastDigits < 100) {
                    System.out.println("сумма цифр 0" + trueLastDigits + " = " + lastThreeSum);
                } else {
                    System.out.println("сумма цифр " + trueLastDigits + " = " + lastThreeSum);
                }
                System.out.println("сумма цифр " + firstDigits + " = " + firstThreeSum);
            } else {
                System.out.println("Число " + luckyNumber + " не счастливое");
            }
        }
        // 10. Вывод таблицы умножения Пифагора
        System.out.println("\n10. Вывод таблицы умножения Пифагора\n");

        for (int i11 = 1; i11 <= 9; i11++) {
            if (i11 > 1 && i11 <= 2) {
                System.out.println("---------------------------");
            }
            for (int j11 = 1; j11 <= 9; j11++) {
                int digitProduce = i11 * j11;
                if (digitProduce == 1) {
                    System.out.print("   ");
                } else if (j11 > 1 && j11 <= 2) {
                    System.out.print(" | ");
                } else {
                    System.out.printf("%3d", digitProduce);
                }
            }
            System.out.println();
        }   
    }
}
