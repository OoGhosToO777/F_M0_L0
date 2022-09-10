package Calc;

public class Calc {
    public static double calculated(String text) {
        // Полученные данные переводим в char для нахождения пробела
        char[] arr = text.toCharArray();
        // Если space == true - значит пробел нашли
        int spaceIndex = 0;
        boolean space = false;
        // Отлавниваем исключение
        try {
            for (int i = 0; !space; i++) {
                space = Character.isWhitespace(arr[i]);
                spaceIndex = i;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Напишите своё уравнение по примеру \"11 * 2\"");
            System.exit(1);
        }

        // Позиции первого числа, арифметическог осимвола, второго числа
        String firstNumber = text.substring(0, spaceIndex);
        String arithmeticSign = text.substring(spaceIndex + 1, spaceIndex + 2);
        String secondNumber = text.substring(spaceIndex + 3);
        // Переводим первое и втрое числа в double
        double firstNumberDouble = Double.parseDouble(firstNumber);
        double secondNumberDouble = Double.parseDouble(secondNumber);

        // Массив с примерами арифметических символов
        String[] signArr = new String[]{"+", "-", "*", "/"};
        // Перебираем массив символов чтобы найти нужный символ
        int symbolIndex = 0;
        boolean symbol = false;
        // Отлавниваем исключение
        try {
            for (int i = 0; !symbol; i++) {
                symbol = signArr[i].equals(arithmeticSign);
                symbolIndex = i;
            }
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("Поддерживаемые арифметические операции: \nСложение(+)\nВычитание(-)\nУмножение(*)\nДеление(/)");
            System.exit(1);
        }

        // Производим нужную операцию
        switch (symbolIndex) {
            case 0:
                return firstNumberDouble + secondNumberDouble;
            case 1:
                return firstNumberDouble - secondNumberDouble;
            case 2:
                return firstNumberDouble * secondNumberDouble;
            case 3:
                return firstNumberDouble / secondNumberDouble;
        }
        return 0;

    }

}
