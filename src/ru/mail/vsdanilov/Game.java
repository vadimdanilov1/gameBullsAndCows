package ru.mail.vsdanilov;

import java.io.IOException;
import java.util.Scanner;

public class Game {

    public void startGame(int attemptCount, int gameCount, boolean tryAgain) throws IOException {

        System.out.println("Игра \u00ABБыки-Коровы\u00BB началась! Число из 4 разных цифр загадано.");
        Scanner scanner = new Scanner(System.in);

        Generator generator = new Generator();
        GameLog gameLog;

        while (tryAgain) {

            generator.genNumber();

            System.out.println("Загаданное число: ");
            String genStr = generator.getGenNumber();
            System.out.println(genStr);

            gameLog = new GameLog();
            gameCount = gameLog.returnGameCount();

            gameLog.setGameCount(gameCount);
            gameLog.writeStart(genStr);

            System.out.println("Ваше 4-значное число: ");

            Counter counter = new Counter();
            counter.setBulls(0);
            counter.setCows(0);

            while (true) {
                attemptCount++;

                UserNumber userNumber = new UserNumber(scanner.nextLine());
                userNumber.checkNumber();
                String userStr = userNumber.getUserStr();

                counter.countBullsAndCows(userStr, genStr);
                PrintBullsAndCows printBullsAndCows = new PrintBullsAndCows(counter.getCows(), counter.getBulls());
                printBullsAndCows.printBullsAndCows();

                gameLog.writeAttempt(userStr, counter.getBulls(), counter.getCows());

                if (counter.getBulls() == 4) {
                    System.out.println("Поздравляем! Вы отгадали число!");
                    gameLog.writeEnd(attemptCount);
                    attemptCount = 0;
                    break;
                }
                counter.setBulls(0);
                counter.setCows(0);
            }

            System.out.println("Сыграем ещё? y/n ");
            while (true) {
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")) {
                    tryAgain = answer.equalsIgnoreCase("y");
                    break;
                }
                System.out.println("Введите символы y/n");
            }

        }
        System.out.println("Спасибо за игру!");
    }
}
