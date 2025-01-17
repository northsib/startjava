import java.lang.String;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariablesTheme {
    public static void main(String[] args) {
        // 1. Вывод характеристик компьютера
        System.out.println("\n1. Вывод характеристик компьютера\n");

        String processorName = "Intel 9700KF";
        System.out.println("Название процессора - " + processorName);

        byte coresCount = 8;
        System.out.println("Количество ядер - " + coresCount);

        short windowsVersion = 10;
        System.out.println("Установлена операционная система Windows " + windowsVersion); 

        int ram = 32;
        System.out.println("Количество оперативной памяти - " + ram + " GB");

        long theadCount = 8;
        System.out.println("Количество потоков - " + theadCount);

        float frequency = 3.6f;
        System.out.println("Частота процессора - " + frequency + " GHz");

        double hddCapacity = 1.2d;
        System.out.println("Емкость жесткого диска - " + hddCapacity + " Tb");

        char ramSlots = '4';
        System.out.println("Количество слотов оперативной памяти - " + ramSlots);

        boolean hasJava = true; 
        System.out.println("На компьютере установлена Java - " + hasJava + "\n");

        // 2. Расчет стоимости товара со скидкой
        System.out.println("2. Расчёт стоимости товара со скидкой\n");

        float penCost = 105.5f;
        float bookCost = 235.83f;
        float discount = 0.11f;

        float penDiscount = penCost * discount;
        float bookDiscount = bookCost * discount;
        float discountSum = penDiscount + bookDiscount;
        float newPenCost = penCost - penDiscount;
        float newBookCost = bookCost - bookDiscount;

        System.out.println("Стоимость ручки без скидки = " + penCost + " рублей");
        System.out.println("Стоимость книги без скидки = " + bookCost + " рублей");
        System.out.println("Сумма скидки составила = " + discountSum + " рублей");
        System.out.println("Стоимость ручки со скидкой = " + newPenCost + " рублей");
        System.out.println("Стоимость книги со скидкой = " + newBookCost + " рублей\n");

        // 3. Вывод слова JAVA
        System.out.println("3. Вывод слова JAVA\n");

        System.out.println("   J    A    V     V    A");
        System.out.println("   J   A A    V   V    A A");
        System.out.println("J  J  AAAAA    V V    AAAAA");
        System.out.println(" JJ  A     A    V    A     A\n");

        // 4. Вывод min и max значений целых числовых типов
        System.out.println("4. Вывод min и max значений целых числовых типов \n");
        
        byte maxByte = Byte.MAX_VALUE;
        System.out.println("Максимальное значение byte = " + maxByte);
        maxByte++;
        System.out.println("Максимальное значение byte после инкремента на единицу = " + maxByte);
        maxByte--;
        maxByte--;
        System.out.println("Максимальное значение byte после декремента на единицу = " + maxByte + "\n");
        
        short maxShort = Short.MAX_VALUE;
        System.out.println("Максимальное значение short = " + maxShort);
        maxShort++;
        System.out.println("Максимальное значение short после инкремента на единицу = " + maxShort);
        maxShort--;
        maxShort--;
        System.out.println("Максимальное значение short после декремента на единицу = " + maxShort + "\n");
        
        int maxInt = Integer.MAX_VALUE;
        System.out.println("Максимальное значение int = " + maxInt);
        maxInt++;
        System.out.println("Максимальное значение int после инкремента на единицу = " + maxInt);
        maxInt--;
        maxInt--;
        System.out.println("Максимальное значение int после декремента на единицу = " + maxInt + "\n");
        
        long maxLong = Long.MAX_VALUE;
        System.out.println("Максимальное значение long = " + maxLong);
        maxLong++;
        System.out.println("Максимальное значение long после инкремента на единицу = " + maxLong);
        maxLong--;
        maxLong--;
        System.out.println("Максимальное значение long после декремента на единицу = " + maxLong + "\n");

        // 5. Перестановка значений переменных
        System.out.println("5. Перестановка значений переменных\n");

        int a = 2;
        int b = 5;
        System.out.println("Значение переменной a = " + a + " , значение переменной b = " + b);

        int x = a;
        a = b; 
        b = x;
        System.out.println("При помощи третьей переменной x, мы переставили значения a и b местами,"); 
        System.out.println("a = " + a + ", b = " + b);

        a += b;
        b = a - b;
        a -= b;
        System.out.println("При помощи арифметических операций, мы переставили значения a и b местами,");
        System.out.println("a = " + a + ", b = " + b);

        a ^= b;
        b = a ^ b;
        a ^= b; 
        System.out.println("При помощи побитовой операции, мы переставили значения a и b местами,");
        System.out.println("a = " + a + ", b = " + b + "\n");

        // 6. Вывод символов и их кодов
        System.out.println("6. Вывод символов и их кодов\n");

        char dollar = '$';
        System.out.println("Код символа - " + (int) dollar + ", знак символа - $");
        char asterisk = '*';
        System.out.println("Код символа - " + (int) asterisk + ", знак символа - *");
        char atSign = '@';
        System.out.println("Код символа - " + (int) atSign + ", знак символа - @");
        char caret = '^';
        System.out.println("Код символа - " + (int) caret + ", знак символа - ^");
        char tilde = '~';
        System.out.println("Код символа - " + (int) tilde + ", знак символа - ~\n");

        // 7. Вывод в консоль ASCII-арт Дюка
        System.out.println("7. Вывод в консоль ASCII-арт Дюка\n");

        char symbol1 = '/';
        char symbol2 = '\\';
        char symbol3 = '_';
        char symbol4 = '(';
        char symbol5 = ')';

        // Верхняя(первая) строчка
        System.out.print("    " + symbol1);
        System.out.println(symbol2);
        // Вторая строчка
        System.out.println("   " + symbol1 + "  " + symbol2);
        // Третья строчка
        System.out.print("  " + symbol1);
        System.out.print(symbol3);
        System.out.print(symbol4);
        System.out.print(symbol5);
        System.out.print(symbol3);
        System.out.println(symbol2);
        // Четвертая строчка
        System.out.println(" " + symbol1 + "      " + symbol2);
        // Нижняя(пятая) строчка
        System.out.print(symbol1); 
        System.out.print(symbol3);
        System.out.print(symbol3);
        System.out.print(symbol3);
        System.out.print(symbol1);
        System.out.print(symbol2);
        System.out.print(symbol3);
        System.out.print(symbol3);
        System.out.print(symbol3);
        System.out.println(symbol2 + "\n");

        // 8. Манипуляции с сотнями, десятками и единицами числа
        System.out.println("8. Манипуляции с сотнями, десятками и единицами числа\n");
        int num = 123;
        int hundredsCount = num / 100;
        int tensCount = (num % 100) / 10;
        int unitsCount = num % 10; 
        System.out.println("Число 123 содержит:");
        System.out.println("  сотен - " + hundredsCount);
        System.out.println("  десятков - " + tensCount);
        System.out.println("  единиц - " + unitsCount);
        int classSum = hundredsCount + tensCount + unitsCount;
        System.out.println("Сумма разрядов = " + classSum);
        int classProduce = hundredsCount * tensCount * unitsCount;
        System.out.println("Произведение разрядов = " + classProduce + "\n");

        // 9. Перевод секунд в часы, минуты и секунды
        System.out.println("9. Перевод секунд в часы, минуты и секунды\n");

        int timeInSeconds = 86399;
        int hours = timeInSeconds / 3600;
        int minutes = (timeInSeconds % 3600) / 60; 
        int seconds = timeInSeconds % 60;
        System.out.println("Время - " + hours + ":" + minutes + ":" + seconds + "\n");

        // 10. Расчёт стоимости товара со скидкой через BigDecimal
        System.out.println("10. Расчёт стоимости товара со скидкой через BigDecimal\n");

        var penCost1 = new BigDecimal("105.50");
        var bookCost1 = new BigDecimal("235.83");
        var discount1 = new BigDecimal("0.11");
        System.out.println("Стоимость ручки без скидки = " + penCost1 + " рублей");
        System.out.println("Стоимость книги без скидки = " + bookCost1 + " рублей");
        var penDiscount1 = penCost1.multiply(discount1).setScale(2, RoundingMode.HALF_UP);
        var bookDiscount1 = bookCost1.multiply(discount1).setScale(2, RoundingMode.HALF_UP);
        var discountSum1 = penDiscount1.add(bookDiscount1);
        System.out.println("Сумма скидки составила = " + discountSum1 + " рублей");
        var newPenCost1 = penCost1.subtract(penDiscount1);
        var newBookCost1 = bookCost1.subtract(bookDiscount1);
        System.out.println("Стоимость ручки со скидкой = " + newPenCost1 + " рублей");
        System.out.println("Стоимость книги со скидкой = " + newBookCost1 + " рублей\n");
    }
}