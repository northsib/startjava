import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariablesTheme {
    public static void main(String[] args) {
        // 1. Вывод характеристик компьютера
        System.out.println("\n1. Вывод характеристик компьютера\n");

        int cpuIntelModel = 9700;
        System.out.println("Название процессора - Intel " + cpuIntelModel + "KF");

        byte coreCount = 8;
        System.out.println("Количество ядер - " + coreCount);

        short windowsVersion = 10;
        System.out.println("Установлена операционная система Windows " + windowsVersion); 

        int ramAmount = 32;
        System.out.println("Количество оперативной памяти - " + ramAmount + " GB");

        long threadCount = 8;
        System.out.println("Количество потоков - " + threadCount);

        float cpuFrequency = 3.6f;
        System.out.println("Частота процессора - " + cpuFrequency + " GHz");

        double hddCapacity = 1.2d;
        System.out.println("Емкость жесткого диска - " + hddCapacity + " Tb");

        char ramSlots = '4';
        System.out.println("Количество слотов оперативной памяти - " + ramSlots);

        boolean hasJava = true; 
        System.out.println("На компьютере установлена Java - " + hasJava);

        // 2. Расчет стоимости товара со скидкой
        System.out.println("\n2. Расчёт стоимости товара со скидкой\n");

        float penCost = 105.5f;
        float bookCost = 235.83f;
        float discount = 0.11f;

        System.out.println("Стоимость ручки без скидки = " + penCost + " рублей");
        System.out.println("Стоимость книги без скидки = " + bookCost + " рублей");
        System.out.println("Сумма скидки составила = " + 
                ((penCost + bookCost) * discount) + " рублей");

        float discountedPenCost = penCost - (penCost * discount);
        System.out.println("Стоимость ручки со скидкой = " + discountedPenCost + " рублей");
        float discountedBookCost = bookCost - (bookCost * discount);
        System.out.println("Стоимость книги со скидкой = " + discountedBookCost + " рублей");
        
        // 3. Вывод слова JAVA
        System.out.println("\n3. Вывод слова JAVA\n");

        System.out.println("   J    A    V     V    A");
        System.out.println("   J   A A    V   V    A A");
        System.out.println("J  J  AAAAA    V V    AAAAA");
        System.out.println(" JJ  A     A    V    A     A");

        // 4. Вывод min и max значений целых числовых типов
        System.out.println("\n4. Вывод min и max значений целых числовых типов \n");
        
        byte maxByte = Byte.MAX_VALUE;
        System.out.println("Максимальное значение byte = " + maxByte++);
        System.out.println("Максимальное значение byte после инкремента на единицу = " + maxByte--);
        System.out.println("Максимальное значение byte после декремента на единицу = " + maxByte);
        
        short maxShort = Short.MAX_VALUE;
        System.out.println("\nМаксимальное значение short = " + maxShort++);
        System.out.println("Максимальное значение short после инкремента на единицу = " + maxShort--);
        System.out.println("Максимальное значение short после декремента на единицу = " + maxShort);

        int maxInt = Integer.MAX_VALUE;
        System.out.println("\nМаксимальное значение int = " + maxInt++);
        System.out.println("Максимальное значение int после инкремента на единицу = " + maxInt--);
        System.out.println("Максимальное значение int после декремента на единицу = " + maxInt);
        
        long maxLong = Long.MAX_VALUE;
        System.out.println("\nМаксимальное значение long = " + maxLong++);
        System.out.println("Максимальное значение long после инкремента на единицу = " + maxLong--);
        System.out.println("Максимальное значение long после декремента на единицу = " + maxLong);

        char maxChar = Character.MAX_VALUE;
        System.out.println("\nМаксимальное значение char = " + (int) maxChar);
        System.out.println("Максимальное значение char после инкремента на единицу = " + 
                (int) ++maxChar);
        System.out.println("Максимальное значение char после декремента на единицу = " + 
                (int) --maxChar);

        // 5. Перестановка значений переменных
        System.out.println("\n5. Перестановка значений переменных\n");

        int a = 2;
        int b = 5;
        System.out.println("Значение переменной a = " + a + " , значение переменной b = " + b);

        int swap = a;
        a = b; 
        b = swap;
        System.out.println("При помощи третьей переменной swap, мы переставили значения a и b " + 
                "местами, a = " + a + ", b = " + b);

        a += b;
        b = a - b;
        a -= b;
        System.out.println("При помощи арифметических операций, мы переставили значения a и b " + 
                "местами, a = " + a + ", b = " + b);

        a ^= b;
        b ^= a;
        a ^= b; 
        System.out.println("При помощи побитовой операции, мы переставили значения a и b " + 
                "местами, a = " + a + ", b = " + b);

        // 6. Вывод символов и их кодов
        System.out.println("\n6. Вывод символов и их кодов\n");

        char dollar = '$';
        System.out.println("Код символа - " + (int) dollar + ", знак символа - $");
        char asterisk = '*';
        System.out.println("Код символа - " + (int) asterisk + ", знак символа - *");
        char atSign = '@';
        System.out.println("Код символа - " + (int) atSign + ", знак символа - @");
        char caret = '^';
        System.out.println("Код символа - " + (int) caret + ", знак символа - ^");
        char tilde = '~';
        System.out.println("Код символа - " + (int) tilde + ", знак символа - ~");

        // 7. Вывод в консоль ASCII-арт Дюка
        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка\n");

        char slash = '/';
        char backslash = '\\';
        char underscore = '_';
        char openParenthesis = '(';
        char closeParenthesis = ')';

        System.out.println("    " + slash + backslash);
        System.out.println("   " + slash + "  " + backslash);
        System.out.println("  " + slash + underscore + openParenthesis + closeParenthesis + 
                underscore + backslash);
        System.out.println(" " + slash + "      " + backslash);
        System.out.println("" + slash + underscore + underscore + underscore + 
                slash + backslash + underscore + underscore + underscore + backslash);

        // 8. Манипуляции с сотнями, десятками и единицами числа
        System.out.println("\n8. Манипуляции с сотнями, десятками и единицами числа\n");

        int num = 123;
        int hundredCount = num / 100;
        int tenCount = (num % 100) / 10;
        int oneCount = num % 10; 
        System.out.println("Число " + num + " содержит:");
        System.out.println("  сотен - " + hundredCount);
        System.out.println("  десятков - " + tenCount);
        System.out.println("  единиц - " + oneCount);
        int digitSum = hundredCount + tenCount + oneCount;
        System.out.println("Сумма разрядов = " + digitSum);
        int digitProduct = hundredCount * tenCount * oneCount;
        System.out.println("Произведение разрядов = " + digitProduct + "\n");

        // 9. Перевод секунд в часы, минуты и секунды
        System.out.println("9. Перевод секунд в часы, минуты и секунды\n");

        int timeInSeconds = 86399;
        int hh = timeInSeconds / 3600;
        int mm = (timeInSeconds % 3600) / 60; 
        int ss = timeInSeconds % 60;
        System.out.println("Время - " + hh + ":" + mm + ":" + ss + "\n");

        // 10. Расчёт стоимости товара со скидкой через BigDecimal
        System.out.println("10. Расчёт стоимости товара со скидкой через BigDecimal\n");

        var penCost1 = new BigDecimal("105.50");
        var bookCost1 = new BigDecimal("235.83");
        var discount1 = new BigDecimal("0.11");
        System.out.println("Стоимость ручки без скидки = " + penCost1 + " рублей");
        System.out.println("Стоимость книги без скидки = " + bookCost1 + " рублей");
        System.out.println("Сумма скидки составила = " + 
                penCost1.add(bookCost1)
                .multiply(discount1)
                .setScale(2, RoundingMode.HALF_UP) + " рублей");
        var discountedPenCost1 = penCost1.subtract(
                penCost1.multiply(discount1)
                .setScale(2, RoundingMode.HALF_UP));
        var discountedBookCost1 = bookCost1.subtract(
                bookCost1.multiply(discount1)
                .setScale(2, RoundingMode.HALF_UP));
        System.out.println("Стоимость ручки со скидкой = " + discountedPenCost1 + " рублей");
        System.out.println("Стоимость книги со скидкой = " + discountedBookCost1 + " рублей");
    }
}