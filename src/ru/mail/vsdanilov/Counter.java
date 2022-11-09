package ru.mail.vsdanilov;

public class Counter {

    private int bulls;
    private int cows;

    public int getBulls() {
        return bulls;
    }

    public int getCows() {
        return cows;
    }

    public void setCows(int cows) {
        this.cows = cows;
    }

    public void setBulls(int bulls) {
        this.bulls = bulls;
    }

    public void countBullsAndCows(String userStr, String genStr) {
        for (int i = 0; i < userStr.length(); i++) {
            if (genStr.charAt(i) == userStr.charAt(i)) {
                bulls++;
            } else if (genStr.contains(userStr.charAt(i) + "")) {
                cows++;
            }
        }
    }
}

