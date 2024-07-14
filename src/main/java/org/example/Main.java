package org.example;
import java.util.HashSet;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        if (args.length < 3 || args.length % 2 == 0) {
            System.out.println("Please provide an odd number of moves (at least 3).");
            System.out.println("Example: java -jar game.jar rock paper scissors");

            return;
        }
        Set<String> uniqueMoves = new HashSet<>();
        for (String move : args) {
            if (!uniqueMoves.add(move)) {
                System.out.println("Error: Moves must be non-repeating.");
                System.out.println("Example: java -jar game.jar rock paper scissors");
                return;
            }
        }

        RockPaperScissorsGame game = new RockPaperScissorsGame(args);
        game.play();
    }
}