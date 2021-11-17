package game;

public class Game {
    public Game(String word) {


    public String getWordToGuess(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i == this.word.length(); i++) {
        Character currentLetter = word.charAt(0);
        if (i == 0) {
            builder.append(currentLetter);
        } else {
            builder.append("_");
        }
    }
}
    }

}
