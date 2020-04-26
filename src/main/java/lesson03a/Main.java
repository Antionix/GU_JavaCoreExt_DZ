package lesson03a;
/*
Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("===== Домашнее задание 03 (a) =====");
        Scanner in = new Scanner(new File("src/main/java/lesson03a/lesson03a.txt"));
        HashMap<String, Integer> mapWord = new HashMap<>();
        TreeMap<String, Integer> treeWord = new TreeMap<>();

        while (in.hasNext()) {
            String word = in.next();
//            word = word.toLowerCase().replaceAll("[()-,.0-9]+", "");
            word = word.toLowerCase().replaceAll("[^a-zа-я]+", "");
//            System.out.printf("-[%s]\n", word);
            if (word.length() > 2) {
//                System.out.println(word);
                mapWord.put(word, mapWord.getOrDefault(word, 0) + 1);
                treeWord.put(word, mapWord.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("--------------------------------------");
        for (Map.Entry<String, Integer> el : mapWord.entrySet()) {
            System.out.printf("%s [%d]\n", el.getKey(), el.getValue());
        }

        System.out.println("--------------------------------------");
        for (Map.Entry<String, Integer> el2 : treeWord.entrySet()) {
            System.out.printf("%s [%d]\n", el2.getKey(), el2.getValue());
        }
    }
}
