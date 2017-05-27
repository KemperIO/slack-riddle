package io.kemper.db;

import io.kemper.domain.Riddle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Mock implementation of DBHandler. Uses in-memory data.
 *
 */
public class SimpleDBHandler implements DBHandler {

    List<Riddle> riddles;
    Random randy;

    public SimpleDBHandler() {
        randy = new Random();
        riddles = new ArrayList<>();

        riddles.add(new Riddle("Riddle 1 Q", "Riddle 1 A" ));
        riddles.add(new Riddle("Riddle 2 Q", "Riddle 2 A" ));
        riddles.add(new Riddle("Riddle 3 Q", "Riddle 3 A" ));
        riddles.add(new Riddle("Riddle 4 Q", "Riddle 4 A" ));
        riddles.add(new Riddle("Riddle 5 Q", "Riddle 5 A" ));
        riddles.add(new Riddle("Riddle 6 Q", "Riddle 6 A" ));
    }
    @Override
    public Riddle getRandomRiddle() {
        int id = randy.nextInt(riddles.size());
        return getRiddleByID(id);
    }

    @Override
    public Riddle getRiddleByID(int id) {
        return riddles.get(id);
    }
}
