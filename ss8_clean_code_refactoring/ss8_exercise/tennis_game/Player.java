package ss8_clean_code_refactoring.ss8_exercise.tennis_game;

public class Player implements IPlayer {
    private String name;
    private int point;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void addPoint() {
       double numRandom = Math.random();
       if (numRandom < 0.5) {
           numRandom = 0;
       } else {
           numRandom = 1;
       }
       this.point += numRandom;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPoint() {
        return point;
    }
}
