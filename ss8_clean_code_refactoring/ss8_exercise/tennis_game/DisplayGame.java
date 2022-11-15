package ss8_clean_code_refactoring.ss8_exercise.tennis_game;

public class DisplayGame implements IDisplay {

    @Override
    public void displayScore(Player playerOne, Player playerTwo) {
        System.out.println("The score \n" +
               playerOne.getName() + " : " + playerTwo.getName() + " is " + playerOne.getPoint() + " : " + playerTwo.getPoint());
    }

    @Override
    public void displayWinner(Player playerOne, Player playerTwo) {
        System.out.print("KATA TENNIS \n" +
                "The winner is:" + getWinnerName(playerOne, playerTwo));
    }

    public static String getWinnerName(Player playerOne, Player playerTwo) {
        if (playerOne.getPoint() > playerTwo.getPoint()) {
            return playerOne.getName();
        }
        return playerTwo.getName();
    }
}
