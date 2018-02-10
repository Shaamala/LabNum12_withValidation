public class RockPlayer extends Player{
    @Override
    public String getName() {
        return "The Rock";
    }

    @Override
    public Roshambo generateRoshambo() {

        return Roshambo.ROCK;
    }
}
