package ru.mail.vsdanilov;

public class Counter {

    public void setBulls(int bulls) {
        this.bulls = bulls;
    }

    public int getBulls() {
        return bulls;
    }

    public int getCows() {
        return cows;
    }

    public void setCows(int cows) {
        this.cows = cows;
    }

    private int bulls;
    private int cows;

    public void countBullsAndCows(String userStr, String genStr) {
        for (int i = 0; i < userStr.length(); i++) {
            if (genStr.charAt(i) == userStr.charAt(i)) {
                bulls++;
            } else if (genStr.contains(userStr.charAt(i) + "")) {
                cows++;
            }
        }
    }

    public void printBullsAndCows() {
        StringBuilder notice = new StringBuilder();
        switch (cows) {
            case 0:
                notice.append(cows).append(" Коров ");
                break;
            case 1:
                notice.append(cows).append(" Корова ");
                break;
            default:
                notice.append(cows).append(" Коровы ");
                break;
        }
        switch (bulls) {
            case 0:
                notice.append(bulls).append(" Быков");
                break;
            case 1:
                notice.append(bulls).append(" Бык");
                break;
            default:
                notice.append(bulls).append(" Быка");
                break;
        }

        System.out.println(notice);
    }
}
