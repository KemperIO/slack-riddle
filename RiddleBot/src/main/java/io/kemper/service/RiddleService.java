package io.kemper.service;

import io.kemper.domain.Riddle;

/** Interface for getting riddles. Should be implemented with a Singleton **/
public interface RiddleService {

    public Riddle getRandomRiddle();

    public Riddle getRiddle(Integer id);
}
