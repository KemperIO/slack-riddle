package io.kemper.service;

import io.kemper.domain.Riddle;

public class RiddleService {

    private static Riddle riddle = new Riddle(0, "what is aws lambda?", "AWSome!");

    public static Riddle getRandomRiddle() {
        return riddle;
    }

    public static String getAnswer(Integer id) {
        return riddle.getAnswer();
    }
}
