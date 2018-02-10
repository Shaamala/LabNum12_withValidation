import java.util.Random;

public class RandomPlayer extends Player {
    public String getName() {
        return "Random Player";
    }

    @Override
    public Roshambo generateRoshambo() {
        Random rand = new Random();
        int randNum = rand.nextInt(3) + 1;
        //System.out.println(randNum);
        if (randNum == 1) {
            return Roshambo.ROCK;
        }
        if (randNum == 2) {
            return Roshambo.PAPER;
        }
        return Roshambo.SCISSORS;
    }
}
