package ss8_clean_code_refactoring.ss8_exercise.tennis_game;

public class Main {
    public static void main(String[] args) {
        TennisGame game = new TennisGame();
        ScoreEvaluator evaluator = new ScoreEvaluator();
        Player playerOne = new Player("Player 1");
        Player playerTwo = new Player("Player 2");
        DisplayGame displayGame = new DisplayGame();

        game.play(playerOne, playerTwo, evaluator, displayGame);
    }
}
