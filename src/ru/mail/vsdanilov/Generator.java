package ru.mail.vsdanilov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Generator {
    private final Integer[] arrayRnd = new Integer[4];

    public void genNumber() {
        Random random = new Random();

        for (int i = 0; i < arrayRnd.length; ) {
            int rnd = random.nextInt(10);
            List<Integer> list = new ArrayList<>(Arrays.asList(arrayRnd));
            if (!list.contains(rnd)) {
                arrayRnd[i] = rnd;
                i++;
            }
        }
    }

    public String getGenNumber() {
        StringBuilder strRnd = new StringBuilder();

        for (Integer integer : arrayRnd) {
            strRnd.append(integer);
        }
        return strRnd.toString();
    }
}
