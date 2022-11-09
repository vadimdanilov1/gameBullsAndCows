package ru.mail.vsdanilov;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class GameLog {

    private FileWriter gameFileWriter;
    private int gameCount;

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public int returnGameCount() throws IOException {
        try (FileReader reader = new FileReader("gameLog.log")) {

            Pattern pattern = Pattern.compile("Game №(\\d+)");
            List<String> list = Files.readAllLines(Path.of("gameLog.log"));
            for (String string : list) {
                Matcher matcher = pattern.matcher(string);
                if (matcher.find()) {
                    gameCount = parseInt(matcher.group(1));
                }
            }
            return gameCount + 1;
        } catch (FileNotFoundException e) {
            System.err.println("Файл \"gameLog.log\" не найден. Создаём новый файл.");
            return 1;
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





