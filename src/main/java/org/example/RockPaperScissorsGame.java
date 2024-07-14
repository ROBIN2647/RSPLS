package org.example;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
    private String[] moves;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private WinnerDeterminer winnerDeterminer = new WinnerDeterminer();
    private Crypto crypto = new Crypto();

    public RockPaperScissorsGame(String[] moves) {
        this.moves = moves;
    }

    public void play() {
        while (true) {
            String computerMove = getComputerMove();
            String hmac = crypto.calculateHMAC(computerMove);
            System.out.println("HMAC: " + hmac);

            String playerMove = getPlayerMove();

            if (playerMove.equals("?")) {
                System.out.println(GameTable.generateResultTable(moves));
                continue;
            } else if (playerMove.equals("0")) {
                System.out.println("Thanks for playing!");
                break;
            }

            playerMove = moveToString(playerMove);

            System.out.println("Your move: " + playerMove);
            System.out.println("Computer move: " + computerMove);

            String result = winnerDeterminer.determineWinner(playerMove, computerMove);
            System.out.println(result);
            System.out.println("HMAC key: " + crypto.getKey());

            System.out.println("Play again? (y/n)");
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("y")) {
                break;
            }
        }
        scanner.close();
    }

    private String getPlayerMove() {
        String move;
        while (true) {
            System.out.println("\nAvailable moves:");
            for (int i = 0; i < moves.length; i++) {
                System.out.println((i + 1) + " - " + moves[i]);
            }
            System.out.println("0 - Exit");
            System.out.println("? - Help");
            System.out.print("Enter your move: ");
            move = scanner.nextLine().trim();

            if (move.equals("?") || move.equals("0") || isValidMove(move)) {
                break;
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
        return move;
    }

    private boolean isValidMove(String move) {
        try {
            int index = Integer.parseInt(move);
            return index >= 1 && index <= moves.length;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String getComputerMove() {
        return moves[random.nextInt(moves.length)];
    }

    private String moveToString(String move) {
        try {
            int index = Integer.parseInt(move) - 1;
            return moves[index];
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return "Invalid move";
        }
    }


}
