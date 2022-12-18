package main.java.task6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * У Пети есть две кучки брусков, каждый из них имеет свою длину.
 * Петя хочет найти для каждого бруска из первой кучи брусок из второй,
 * но при условии что их длина может отличаться не более чем на единицу.
 * Петя понимает, что возможно он не сможет для каждого бруска из первой кучки найти пару из второй.
 * По этому он хочет найти максимальное количество таких пар. Помоги ему в этом.
 * <p>
 * Входные данные:
 * В первой строке записано целое число p (1≤p≤100) — количество брусков в первой куче.
 * Вторая строка содержит последовательность b1,b2,...,bp (1≤bi≤100), где bi — длина i-го бруска.
 * <p>
 * Аналогично, третья строка содержит целое k (1≤k≤100) – количество брусков во второй кучке.
 * В четвертой строке содержится последовательность b1,b2,...,bk (1≤bj≤100), где bj — длина j-го бруска.
 * <p>
 * Выходные данные: Выведите единственное число — искомое максимальное возможное количество пар.
 */
public class Main {

    public static void main(String[] args) {
        System.out.print("Введите количество брусков в 1 куче: ");
        Scanner in = new Scanner(System.in);
        int firstHeapCount = in.nextInt();
        System.out.print("Введите бруски 1 кучи: ");
        in = new Scanner(System.in);
        Integer[] firstHeap = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
        System.out.print("Введите количество брусков во 2 куче: ");
        in = new Scanner(System.in);
        int secondHeapCount = in.nextInt();
        System.out.print("Введите бруски 2 кучи: ");
        in = new Scanner(System.in);
        Integer[] secondHeap = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
        in.close();
        if (firstHeapCount != firstHeap.length || secondHeapCount != secondHeap.length)
            throw new RuntimeException("Wrong amount");
        List<PrePair> list = getPairEveryElementFirstHeap(firstHeap, secondHeap);
        System.out.println(calculation(list));
    }

    public static int calculation(List<PrePair> list) {
        int count = 0;
        while (!list.isEmpty() && !list.get(0).getPossiblePairs().isEmpty()) {
            PrePair min = getMinPrePair(list);
            list = delete(list, min);
            count++;
        }
        return count;
    }

    public static List<PrePair> delete(List<PrePair> list, PrePair minPrePair) {
        list.remove(minPrePair);
        return list.stream()
                .peek(p -> p.getPossiblePairs().remove(findMinDifferenceIndex(minPrePair)))
                .filter(p -> !p.getPossiblePairs().isEmpty())
                .collect(Collectors.toList());
    }

    public static int findMinDifferenceIndex(PrePair prePair) {
        int index = 0;
        List<Integer> list = prePair.getPossiblePairs();
        int minDifference = Math.abs(prePair.getFirstHeapElement() - list.get(0));
        for (int i = 0; i < list.size(); i++) {
            int difference = Math.abs(prePair.getFirstHeapElement() - list.get(i));
            if (difference < minDifference) {
                minDifference = difference;
                index = i;
            }
        }
        return index;
    }

    public static PrePair getMinPrePair(List<PrePair> list) {
        PrePair min = list.get(0);
        for (PrePair prePair : list) {
            if (prePair.getPossiblePairs().size() < min.getPossiblePairs().size()) {
                min = prePair;
            }
        }
        return min;
    }

    public static List<PrePair> getPairEveryElementFirstHeap(Integer[] firstHeap,
                                                             Integer[] secondHeap) {
        List<PrePair> result = new ArrayList<>();
        for (int i = 0; i < firstHeap.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < secondHeap.length; j++) {
                if (Math.abs(firstHeap[i] - secondHeap[j]) <= 1) {
                    list.add(secondHeap[j]);
                }
            }
            result.add(new PrePair(firstHeap[i], list));
        }
        return result;
    }

}
