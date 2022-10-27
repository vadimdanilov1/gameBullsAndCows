package ru.mail.vsdanilov;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GameLog {

    private FileWriter gameFileWriter;
    private int gameCount;

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public int returnGameCount() throws IOException {
        try (FileReader gameFileReader = new FileReader("gameLog.log")) {
            Scanner scanner = new Scanner(gameFileReader);
            return (int) scanner.findAll("Game №").count();
        } catch (FileNotFoundException e) {
            System.err.println("Файл \"gameLog.log\" не найден. Создаём новый файл.");
            return 0;
        }

    }

    public void writeStart(String strGen) throws IOException {
        gameFileWriter = new FileWriter("gameLog.log", true);
        Date dateStart = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        gameFileWriter.append("Game №")
                .append(String.valueOf(gameCount))
                .append(" ")
                .append(sdf.format(dateStart))
                .append(" Загаданная строка ")
                .append(strGen)
                .append("\n");
        gameFileWriter.close();
    }

    public void writeAttempt(String userStr, int bulls, int cows) throws IOException {
        gameFileWriter = new FileWriter("gameLog.log", true);
        gameFileWriter.append("\tЗапрос: ")
                .append(userStr)
                .append(" Ответ: ")
                .append(String.valueOf(cows))
                .append(" ")
                .append(getCowsStr(cows))
                .append(", ")
                .append(String.valueOf(bulls))
                .append(" ")
                .append(getBullsStr(bulls))
                .append("\n");
        gameFileWriter.close();
    }

    public void writeEnd(int attemptCount) throws IOException {
        gameFileWriter = new FileWriter("gameLog.log", true);
        gameFileWriter.append("Строка была угадана за ")
                .append(String.valueOf(attemptCount))
                .append(" попыток.")
                .append("\n");
        gameFileWriter.close();
    }

    private String getCowsStr(int cows) {
        if (cows == 1)
            return "Корова";
        if (cows > 1 && cows < 5)
            return "Коровы";
        return "Коров";
    }

    private String getBullsStr(int bulls) {
        if (bulls == 1)
            return "Бык";
        if (bulls > 1 && bulls < 5)
            return "Быка";
        return "Быков";
    }
}





