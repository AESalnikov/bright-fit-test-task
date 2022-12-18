package main.java.task6;

import java.util.List;

public class PrePair {

    Integer firstHeapElement;
    List<Integer> possiblePairs;

    public PrePair(Integer firstHeapElement, List<Integer> possiblePairs) {
        this.firstHeapElement = firstHeapElement;
        this.possiblePairs = possiblePairs;
    }

    public Integer getFirstHeapElement() {
        return firstHeapElement;
    }

    public List<Integer> getPossiblePairs() {
        return possiblePairs;
    }

    @Override
    public String toString() {
        return "PrePair{" +
                "firstHeapElement=" + firstHeapElement +
                ", possiblePairs=" + possiblePairs +
                '}';
    }
}
