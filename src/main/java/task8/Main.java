package main.java.task8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Дано n костей домино, выложенных в ряд. На каждой половинке записано число от 1 до 6.
 * Ваня хочет, чтобы сумма чисел на верхних половинках и на нижних были четными. Кости можно поворачивать.
 * Узнайте какое количество костей домино нужно повернуть, чтобы сумма верхних половинок и нижних были четными.
 * Входные данные В первой строке задано целое число n (1≤n≤100), обозначающее количество костей, имеющихся у Вани.
 * В следующих n строках через пробел заданы два целых числа xi,yi (1≤xi,yi≤6).
 * Число xi записано на верхней половинке i-ой кости, yi — на нижней.
 * <p>
 * Выходные данные: Выведите единственное целое число — минимальное количество костей домино,
 * которое нужно повернуть. Если Вани ни как не удастся исполнить задуманное, выведите -1.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество костей домино: ");
        int n = in.nextInt();
        if (n < 1 || n > 100)
            throw new RuntimeException("wrong value of domino expect (1 <= n <= 100)");
        System.out.print("Введите значения костей домино: ");
        in = new Scanner(System.in);
        List<Domino> dominoList = new ArrayList<>();
        String domino = in.nextLine();
        while (!Objects.equals(domino, "")) {
            int up = Integer.parseInt(domino.split(" ")[0]);
            int down = Integer.parseInt(domino.split(" ")[1]);
            if (up < 1 || up > 6 || down < 1 || down > 6)
                throw new RuntimeException("wrong size of domino");
            dominoList.add(new Domino(up, down));
            domino = in.nextLine();
        }
        in.close();
        if (n != dominoList.size())
            throw new RuntimeException("wrong size of domino list");
        System.out.println(checkDomino(dominoList));
    }

    public static int checkDomino(List<Domino> list) {
        int sumUp = list.stream()
                .map(Domino::getUp)
                .mapToInt(Integer::intValue)
                .sum();
        int sumDown = list.stream()
                .map(Domino::getDown)
                .mapToInt(Integer::intValue)
                .sum();

        if (sumUp % 2 == 0 && sumDown % 2 == 0) {
            return 0;
        }

        if ((sumUp - sumDown) % 2 == 0) {
            for (Domino domino : list) {
                if ((domino.getUp() - domino.getDown()) % 2 != 0) {
                    return 1;
                }
            }
        }
        return -1;
    }

}
