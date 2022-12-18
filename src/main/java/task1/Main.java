package main.java.task1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Дано два числа. Переставьте в первом числе цифры так, чтобы получилось наименьшее число, в котором нет лидирующих
 * нулей и сравните его со вторым. Если числа совпадут выведите OK, иначе ERROR.
 * Входные данные:
 * В первой строке заданно два целых числа n и m ().
 * Выходные данные:
 * OK - если числа совпали, или ERROR в противном случае.
 *
 * Примеры тестов:
 * Входные данные:
 * 3310
 * 1033
 * Выходные данные:
 * OK
 *
 * Входные данные:
 * 4
 * 5
 * Выходные данные:
 * ERROR
 */
public class Main {

    public static void main(String[] args) {
        System.out.print("Введите первое число: ");
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        System.out.print("Введите второе число: ");
        in = new Scanner(System.in);
        int num2 = in.nextInt();
        in.close();
        num1 = sortDigits(num1);
        System.out.println(num1 == num2 ? "OK" : "ERROR");
    }

    public static int sortDigits(Integer number) {
        char[] arrChar = String.valueOf(number).toCharArray();
        Arrays.sort(arrChar);
        if (arrChar[0] != '0') {
            return Integer.parseInt(new String(arrChar));
        }
        for (int i = 1; i < arrChar.length; i++) {
            if (arrChar[i] != '0') {
                char tmp = arrChar[i];
                arrChar[i] = arrChar[0];
                arrChar[0] = tmp;
                break;
            }
        }
        return Integer.parseInt(new String(arrChar));
    }

}
