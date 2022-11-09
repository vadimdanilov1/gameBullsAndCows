package ru.mail.vsdanilov;

import java.util.Scanner;

public class UserNumber {
    Scanner scanner;
    private String userStr;

    public UserNumber(String userStr) {
        this.userStr = userStr;
    }

    public String getUserStr() {
        return userStr;
    }

    public void checkNumber() {
        while (true) {
            try {
                if (userStr.length() != 4) {
                    throw new Exception("Число должно содержать 4 цифры");
                } else if (userStr.chars().distinct().count() != 4) {
                    throw new Exception("Цифры должны быть уникальными");
                } else break;
            } catch (Exception e) {
                System.out.println("ВНИМАНИЕ! " + e.getMessage());
            }
            scanner = new Scanner(System.in);
            userStr = scanner.nextLine();
        }
    }
}
