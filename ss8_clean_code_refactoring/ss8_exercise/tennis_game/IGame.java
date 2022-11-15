package ss8_clean_code_refactoring.ss8_exercise.tennis_game;

public interface IGame {
    void playRound(Player playerOne, Player playerTwo);
    boolean isGameWon(int playerOnePoints, int playerTwoPoints, ScoreEvaluator evaluator);

   default void play(Player playerOne, Player playerTwo, ScoreEvaluator evaluator, DisplayGame displayGame) {
       int countRound = 1;
       while (!isGameWon(playerOne.getPoint(), playerTwo.getPoint(), evaluator)) {
           System.out.println("Round" + countRound);
           playRound(playerOne, playerTwo);
           displayGame.displayScore(playerOne, playerTwo);
           countRound += 1;
       }
       displayGame.displayWinner(playerOne, playerTwo);
       displayGame.displayScore(playerOne, playerTwo);
   }
}
