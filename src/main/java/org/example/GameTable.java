package org.example;

import de.vandermeer.asciitable.AsciiTable;

public class GameTable {
    private static final String[] MOVES = {"Rock", "Spock", "Paper", "Lizard", "Scissors"};

    public static String generateResultTable() {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("v PC/User >", "Rock", "Spock", "Paper", "Lizard", "Scissors");
        table.addRule();
        table.addRow("Rock", "Draw", "Lose", "Win", "Win", "Lose");
        table.addRule();
        table.addRow("Spock", "Win", "Draw", "Lose", "Lose", "Win");
        table.addRule();
        table.addRow("Paper", "Lose", "Win", "Draw", "Win", "Lose");
        table.addRule();
        table.addRow("Lizard", "Lose", "Win", "Lose", "Draw", "Win");
        table.addRule();
        table.addRow("Scissors", "Win", "Lose", "Win", "Lose", "Draw");
        table.addRule();
        return table.render();
    }
}
