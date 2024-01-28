package com.eguerra.data;

import javax.swing.plaf.PanelUI;
import java.util.*;

public class StreamsDemo {

    public static List<Integer> createRadomList(int longNumbersAdd) {
        var random = new Random();

        List<Integer> numbers = new LinkedList<Integer>();
        for (int i = 0; i < longNumbersAdd; i++) {
            numbers.add(random.nextInt(100));
        }
        return numbers;
    }

    public static List<Integer> sortListTradicional(List<Integer> unsortList) {
        // Programacion Imperativa
        Collections.sort(unsortList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        return unsortList;
    }

    public  static List<Integer> sortListClasic(List<Integer> unsortList) {
        // Programacion Declarativa
        Collections.sort(unsortList, (num1, num2) -> num1.compareTo(num2));
        return  unsortList;
    }

    public  static boolean isPrimeNumber(int n) {
        if (n <= 1)
            return false;

        var contador = 0;
        for (int i = n -1; i > 1; i--) {
            if (n % i == 0)
                contador++;
        }

        return contador <=0;
    }
}
