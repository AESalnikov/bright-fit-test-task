package main.java.task4;

import java.util.Scanner;

/**
 * Есть последовательность чисел: 4,7,44,47,74,77,444...
 * Числа в последовательности состоят только из цифр 4 и 7. Последовательность отсортирована по возрастанию.
 * <p>
 * Вам дано одно из таких чисел, нужно определить его номер в этой последовательности.
 * Входные данные: В первой и единственной строке число n (1≤n≤109) из последовательности.
 * <p>
 * Выходные данные: Выведите позицию, на которой n находится среди всех чисел последовательности.
 */
public class Main {

    public static void main(String[] args) {

        System.out.print("Введите число из последовательности: ");
        Scanner in = new Scanner(System.in);
        String inputStr = in.nextLine();
        in.close();
        System.out.println(getIndex(inputStr));
    }

    public static int getIndex(String value) {
        value = value.replaceAll("4", "0").replaceAll("7", "1");
        int length = value.length();
        return length > 1
                ? Integer.parseInt(value, 2) + 1 + countingValuesBeforeDegree(length)
                : Integer.parseInt(value, 2) + 1;
    }

    public static int countingValuesBeforeDegree(int length) {
        int result = 0;
        for (int i = 1; i < length; i++) {
            result += Math.pow(2, i);
        }
        return result;
    }

}
