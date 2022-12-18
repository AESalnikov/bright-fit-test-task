package main.java.task2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Дана строка, которая содержит сумму нескольких цифр,  цифры в строке могут быть только 1,2 или 3.
 * Преобразуйте строку таким образом, чтобы цифры в строке шли в порядке неубывания.
 * Входные данные:
 * В первой строке записана не пустая строка s, s не содержит пробелов, состоит только из цифр и знаков "+"
 * и является корректной суммой цифр 1,2,3. Длина строки s не более 100 символов.
 * <p>
 * Выходные данные:
 * Преобразованная строка, в которой все цифры идут в порядке неубывания.
 * <p>
 * Примеры тестов:
 * Входные данные:
 * 3+2+1
 * Выходные данные:
 * 1+2+3
 * <p>
 * Входные данные:
 * 1+1+3+1+3
 * Выходные данные:
 * 1+1+1+3+3
 * <p>
 * Входные данные:
 * 2
 * Выходные данные:
 * 2
 */
public class Main {

    public static void main(String[] args) {
        System.out.print("Введите строку: ");
        Scanner in = new Scanner(System.in);
        String inputString = in.next();
        in.close();
        System.out.println(sort(inputString));
    }

    public static String sort(String inputString) {
        StringBuilder result = new StringBuilder();
        Arrays.stream(inputString.split("\\+"))
                .sorted()
                .forEach(n -> result.append(n).append("+"));
        return result.substring(0, result.length() - 1);
    }

}
