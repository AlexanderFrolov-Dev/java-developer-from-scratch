package practice;

import java.util.List;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска вводимого номера в консоль в каждой из структуры данных
     - проанализировать полученные данные
     */

    public static void main(String[] args) {
        List<String> numberList = CoolNumbers.generateCoolNumbers();

//        for (String string : numberList) {
//            System.out.println(string);
//        }

        for (int i = 0; i < numberList.size(); i++) {
            System.out.println(i + " - " + numberList.get(i));
        }

        System.out.println(CoolNumbers.binarySearchInList(numberList, "Х822РН70"));
    }
}
