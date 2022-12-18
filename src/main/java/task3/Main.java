package main.java.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * У вас есть набор товаров, из которого вы можете выбрать те, которые хотели бы взять с собой в поход.
 * Для каждого предмета вам известен его вес, вес i-го предмета равен . Общий вес предметов, которые вы возьмете с
 * собой в поход должен быть не меньше m, но не больше k. Так же разница в весе товаров, которые вы возьмете с собой,
 * между самым тяжелым и самым легким не должна быть меньше p.
 * <p>
 * Входные данные:
 * <p>
 * Первая строка содержит четыре целых числа n,m,k,p () - соответственно количество товаров, минимальное и максимальное
 * значение общего веса, минимальная разница по весу товаров между самым тяжелым и самым легким.
 * <p>
 * Вторая строка содержит n целых чисел - вес каждого товара ().
 * <p>
 * Выходные данные:
 * Вывести количество способов выбрать подходящий комплект товаров для похода.
 */
public class Main {

    public static void main(String[] args) {
        System.out.print("Введите 4 целых числа через пробел (n m k p): ");
        Scanner in = new Scanner(System.in);
        String coefficientsStr = in.nextLine();
        System.out.print("Введите вес вещей: ");
        in = new Scanner(System.in);
        String thingsStr = in.nextLine();
        in.close();
        List<Integer> coeffList = getCoeffList(coefficientsStr);
        Integer n = coeffList.get(0);
        List<Integer> weights = getThingList(thingsStr, n);
        System.out.println("Количество способов: " + numberOptions(coeffList, weights));
    }

    public static Integer numberOptions(List<Integer> coeffList, List<Integer> weights) {
        Integer m = coeffList.get(1);
        Integer k = coeffList.get(2);
        Integer p = coeffList.get(3);
        int result = 0;
        weights = weights.stream()
                .sorted()
                .collect(Collectors.toList());
        for (int l = 0; l < weights.size(); l++) {
            for (int i = l; i < weights.size() - 1; i++) {
                List<Integer> list = new ArrayList<>();
                int count = l;
                while (count <= i) {
                    list.add(weights.get(count));
                    count++;
                }
                for (int j = i + 1; j < weights.size(); j++) {
                    list.add(weights.get(j));
                    int weight = list.stream().mapToInt(Integer::intValue).sum();
                    if ((Collections.max(list) - Collections.min(list)) >= p
                            && weight >= m
                            && weight <= k) {
                        result++;
                    }
                    list.remove(list.size() - 1);
                }
            }
        }
        return result;
    }

    public static List<Integer> getThingList(String thingsStr, Integer countThings) {
        return Arrays.stream(thingsStr.split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList())
                .subList(0, countThings);
    }

    public static List<Integer> getCoeffList(String coeffStr) {
        return Arrays.stream(coeffStr.split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

}
