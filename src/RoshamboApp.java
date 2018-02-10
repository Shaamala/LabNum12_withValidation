import java.util.Scanner;

public class RoshamboApp {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String cont = "y";
        int counter = 0;
        String name = Validator.getString(scan, "Please enter your name: ");
        //Create human player object
        HumanPlayer human = new HumanPlayer();
        human.setName(name);
        while (cont.equalsIgnoreCase("y")) {
            // Your code should start here

            System.out.println("Opponents");
            System.out.println("________________________");
            System.out.println("1. The Rock");
            System.out.println("2. Random Player");
            System.out.println();

            // opponent input choice validation
            int playerChoice = Validator.getInt(scan,
                    "Hi, " + name + "!\nPlease select an opponent from the list above: ", 1, 2);
            System.out.println();
            ++counter;
            System.out.println("Round: #" + counter);

            switch (playerChoice) {
                case 1:
                    // select input validation
                    String humanSelection = Validator.getString(scan, "Please select ROCK, PAPER, or SCISSORS: ");
                    RockPlayer rock = new RockPlayer();

                    human.setUserChoice(humanSelection);
                    Roshambo p1 = human.generateRoshambo();
                    Roshambo p2 = rock.generateRoshambo();
                    System.out.println();
                    System.out.println(human.getName() + ": " + p1);
                    System.out.println(rock.getName() + ": " + p2);
                    winner(p1, p2);
                    break;
                case 2:
                    // select input validation
                    String hPSelection2 = Validator.getString(scan, "Please select ROCK, PAPER, or SCISSORS: ");
                    RandomPlayer randPlayer = new RandomPlayer();

                    human.setUserChoice(hPSelection2);
                    Roshambo p3 = human.generateRoshambo();
                    Roshambo p4 = randPlayer.generateRoshambo();
                    System.out.println();
                    System.out.println(human.getName() + ": " + p3);
                    System.out.println(randPlayer.getName() + ": " + p4);
                    winner(p3, p4);
                    break;
                default:
                    System.out.println("Something went wrong!");
                    break;
            }

            System.out.println();
            cont = Validator.getString(scan, "Do you want to continue? y/n ");
            System.out.println();

        }

        // end program
        System.out.println("Thanks for playing! Goodbye :)");

        scan.close();

    }

    // winner method
    public static void winner(Roshambo p1, Roshambo p2) {
        if ((p1 == Roshambo.ROCK && p2 == Roshambo.ROCK) || (p1 == Roshambo.PAPER && p2 == Roshambo.PAPER)
                || (p1 == Roshambo.SCISSORS && p2 == Roshambo.SCISSORS)) {
            System.out.println("TIE!");
        } else if ((p1 == Roshambo.PAPER && p2 == Roshambo.ROCK) || (p2 == Roshambo.PAPER && p1 == Roshambo.ROCK)) {
            System.out.println(Roshambo.PAPER + " WINS!");
        } else if ((p1 == Roshambo.PAPER && p2 == Roshambo.SCISSORS)
                || (p2 == Roshambo.PAPER && p1 == Roshambo.SCISSORS)) {
            System.out.println(Roshambo.SCISSORS + " WINS!");
        } else if ((p1 == Roshambo.SCISSORS && p2 == Roshambo.ROCK)
                || (p1 == Roshambo.ROCK && p2 == Roshambo.SCISSORS)) {
            System.out.println(Roshambo.ROCK + " WINS!");
        }
    }
}
