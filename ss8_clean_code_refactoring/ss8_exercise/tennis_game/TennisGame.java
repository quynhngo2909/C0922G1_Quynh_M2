package ss8_clean_code_refactoring.ss8_exercise.tennis_game;

public class TennisGame implements IGame{

    @Override
    public void playRound(Player playerOne, Player playerTwo) {
        playerOne.addPoint();
        playerTwo.addPoint();
    }

    @Override
    public boolean isGameWon(int playerOnePoints, int playerTwoPoints, ScoreEvaluator evaluator) {
        return evaluator.evaluateScore(playerOnePoints, playerTwoPoints) == GameStatus.GAME_Won;
    }

}
