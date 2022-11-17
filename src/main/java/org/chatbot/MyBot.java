package org.chatbot;

import java.io.IOException;
import java.util.*;

public class MyBot {

    private static Map<String, String> blackouts;

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String message = scanner.nextLine();
//
//        find(message);
//
//        String botAnswer = process(message);
//        System.out.println(botAnswer);
    }

    public static String process(String message) {
        if (message.equalsIgnoreCase("q")) {
            return "Q W E R T Y";
        }

        if (isHelloMessage(message)) {
            String botName = "ChatBot";
            return "Вітаю, я - " + botName;
        }
        return find(message);
    }

    public static String find(String message) {
        readDataFromXLS();

        if (message.length() < 5) {
            return "ВВЕДИТЕ 5 начальных букв названия улицы";
        }
        message = message.toLowerCase();

        StringJoiner stringJoiner = new StringJoiner("\n\n");

        for (Map.Entry<String, String> entry : blackouts.entrySet()) {
            String word = entry.getKey();
            String[] splitStrings = word.split(";");
            for (String splitString : splitStrings) {
                String lowerCasedWord = splitString.toLowerCase();
                if (lowerCasedWord.contains(message)) {
                    stringJoiner.add(splitString + ": " + blackouts.get(word));
                }
            }
        }

        return stringJoiner.length() > 0 ? stringJoiner.toString() : "АДРЕС ОТСУТСТВУЕТ";
    }

    private static void readDataFromXLS() {
        ExcelReader reader = new ExcelReader();
        try {
            reader.read("src/main/resources/schedule.xls");
        } catch (IOException e) {
            e.printStackTrace();
        }
        blackouts = reader.getStreetsMap();
    }

    private static boolean isHelloMessage(String message) {
        message = message.toLowerCase();

        String startWord = "start";

        return message.contains(startWord);
    }
}
