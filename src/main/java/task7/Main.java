package main.java.task7;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ЕГЭ для n школьников будет проходить в длинном кабинете, так что школьники будут сидеть в ряд
 * в некотором порядке, все школьники пронумерованы по порядку с 1 до n. Нужно их рассадить так,
 * чтобы никакие два школьника с соседними номерами не сидели рядом.
 * <p>
 * Входные данные
 * В единственной строке задано целое число n (1≤n≤5000) — количество школьников на ЕГЭ.
 * <p>
 * Выходные данные:
 * В первую строку выведите целое число m — максимальное количество школьников, которых можно рассадить так,
 * что никакие два школьника с соседними номерами не сидят рядом.
 * <p>
 * Во вторую строку выведите один из возможных вариантов рассадки школьников.
 * Выведите m целых различных чисел a1,a2,...,ak (1≤ai≤n), где ai — номер школьника на i-й позиции.
 * Школьники на соседних позициях не должны иметь соседние номера. Формально, |ai-ai+1|≠1 для всех i от 1 до m-1.
 */
public class Main {

    public static void main(String[] args) {
        System.out.print("Введите количество школьников: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        if (n < 1 || n > 5000)
            throw new RuntimeException("wrong number of students");
        List<Integer> result = seatStudents(n);
        System.out.println(result.size());
        System.out.println(toResultString(result));
    }

    public static String toResultString(List<Integer> list) {
        StringBuilder result = new StringBuilder();
        list.forEach(num -> result.append(num).append(", "));
        return result.substring(0, result.length() - 2);
    }

    public static List<Integer> seatStudents(Integer n) {
        List<Integer> result = new LinkedList<>();
        if (n == 1 || n == 2) {
            return List.of(1);
        }
        if (n == 3) {
            return List.of(1, 3);
        }
        if (n >= 4) {
            result.add(3);
            result.add(1);
            result.add(4);
            result.add(2);
            for (int i = 5; i < n + 1; i++) {
                if (i % 2 == 1) {
                    result.add(0, i);
                } else {
                    result.add(i);
                }
            }
        }
        return result;
    }

}
