package ss8_clean_code_refactoring.ss8_exercise.tennis_game;

public class ScoreEvaluator {
    public static final int winningScore = 4;
    public static final int scoreGap = 2;

    public GameStatus evaluateScore(int playerOneScore, int playerTwoScore) {
        if (playerOneScore == winningScore && playerTwoScore == winningScore) {
            return GameStatus.DEUCE;
        }

        if (playerOneScore >= winningScore && (playerOneScore - playerTwoScore) >= scoreGap) {
            return GameStatus.GAME_Won;
        }

        if (playerTwoScore >= winningScore && (playerTwoScore - playerOneScore) >= scoreGap) {
            return GameStatus.GAME_Won;
        }

        return GameStatus.No_Winner;
    }
}
