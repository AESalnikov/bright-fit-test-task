package main.java.task5;

import java.util.List;
import java.util.stream.Collectors;

import static main.java.task5.ConstantUtils.INPUT;
import static main.java.task5.ConstantUtils.OUTPUT;
import static main.java.task5.FileUtils.readFromFile;
import static main.java.task5.FileUtils.writeToFile;

/**
 * В файле input.txt дан список сайтов (имя сайта или его ip адрес),
 * выбрать из них те сайты, которые доступны в данный момент времени и
 * сохранить в файле output.txt. Первый найденный доступный сайт открыть в браузере.
 */
public class Main {

    public static void main(String[] args) {
        List<String> list = readFromFile(INPUT);
        list = list.stream().filter(ConnectionUtils::isConnection)
                .collect(Collectors.toList());
        writeToFile(OUTPUT, list);
    }

}
