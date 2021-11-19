package game;

import java.util.ArrayList;

public class Game {
    int counter = 10;
    private ArrayList<Character> guessedLetters = new ArrayList<Character>();

    Game(WordChoser choser){
        words = choser.getRandomWordFromDictionary();
    }
    String words;

    public String getWordToGuess() {
        StringBuilder builder = new StringBuilder(words.length());
        for (int i = 0; i < words.length(); i++) {
            Character currentLetter = words.charAt(i);
            if (i == 0) {
                builder.append(currentLetter);
            } else {
                // show letter only if it was already guessed
                if (guessedLetters.indexOf(currentLetter) != -1) {
                    builder.append(currentLetter);
                } else {
                    builder.append("_");
                }
            }
        }
        return builder.toString();
    }
    
    public int getRemainingAttemps() {
        return counter;
    }
    
    public boolean guessLetter(Character letter) {
        if (words.indexOf(letter) != -1) {
            guessedLetters.add(letter);
            String line = String.format("Remaining attemps: %d", counter);
            System.out.println(line);
            return true;
        } else {
            counter--;
            String line = String.format("Remaining attemps: %d", counter);
            System.out.println(line);
            return false;
        }
    }
 
}
