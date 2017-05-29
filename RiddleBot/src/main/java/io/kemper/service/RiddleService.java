package io.kemper.service;

import io.kemper.domain.Riddle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RiddleService {

    List<Riddle> riddles;
    Random randy;

    public RiddleService() {
        this.randy = new Random();

        this.riddles = new ArrayList<>();
        this.riddles.add(new Riddle(0, "what is AWS lambda?", "AWSome!!!"));
        this.riddles.add(new Riddle(1, "Riddle 1", "Answer 1"));
        this.riddles.add(new Riddle(2, "Riddle 2", "Answer 2"));
    }

    public Riddle getRandomRiddle() {
        int id = randy.nextInt(this.riddles.size());
        return riddles.get(id);
    }

    public String getAnswer(Integer id) {
        return riddles.get(id).getAnswer();
    }
}
