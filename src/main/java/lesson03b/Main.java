package lesson03b;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.String.format;

/*
Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
телефонных номеров. В этот телефонный справочник с помощью метода add() можно
добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
учесть, что под одной фамилией может быть несколько телефонов (в случае
однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода
результатов проверки телефонного справочника.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("===== Домашнее задание 03(b) =====");
        Scanner in = new Scanner(new File("src/main/java/lesson03b/phone.txt"));
        TreeMap<String, User> phoneBook1 = new TreeMap<>();

        while (in.hasNext()) {
            String fName = in.next();
            String sName = in.next();
            String phone = in.next();
            String fio = format("%s %s", fName, sName);

            if (!phoneBook1.containsKey(fio)) {
                phoneBook1.put(fio, new User(fName, sName));
            }
            phoneBook1.get(fio).addPhoneNumber(phone);
        }

        char letter = 0;
        for (Map.Entry<String, User> usr : phoneBook1.entrySet()) {
            char curLetter = usr.getKey().charAt(0);
            if (letter != curLetter) {
                System.out.println(curLetter + ":------------------------------");
                letter = curLetter;
            }
            System.out.println(usr.getValue());
        }
    }
}
