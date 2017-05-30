package io.kemper.db;

import io.kemper.domain.Riddle;

/** Interface for getting Riddle data
 *
 */
public interface DBHandler {
    Riddle getRandomRiddle();

    Riddle getRiddleByID(int id);
}
