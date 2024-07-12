package org.example;

class WinnerDeterminer {
    public String determineWinner(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "It's a draw!";
        } else if (
                (playerMove.equals("Rock") && (computerMove.equals("Scissors") || computerMove.equals("Lizard"))) ||
                        (playerMove.equals("Spock") && (computerMove.equals("Rock") || computerMove.equals("Scissors"))) ||
                        (playerMove.equals("Paper") && (computerMove.equals("Spock") || computerMove.equals("Lizard"))) ||
                        (playerMove.equals("Lizard") && (computerMove.equals("Paper") || computerMove.equals("Spock"))) ||
                        (playerMove.equals("Scissors") && (computerMove.equals("Paper") || computerMove.equals("Lizard")))
        ) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}
