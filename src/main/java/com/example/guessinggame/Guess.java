package com.example.guessinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Guess {

    private int secretNumber;

    private List<String> previousGuesses;

    Random random = new Random();

    public Guess() {
        init();
    }

    private void init() {
        secretNumber = random.nextInt(1, 101);
        previousGuesses = new ArrayList<>();
    }

    public String makeGuess(int guess) {
        String stringReply;

        if (guess < secretNumber) {
            stringReply = "too small";
            previousGuesses.add(guess + " : " + stringReply);
        } else if (guess > secretNumber) {
            stringReply = "too big";
            previousGuesses.add(guess + " : " + stringReply);
        } else {
            init();
            stringReply = "Correct";
        }
        return stringReply;
    }

    public List<String> getPreviousGuesses() {
        return previousGuesses;
    }

}
