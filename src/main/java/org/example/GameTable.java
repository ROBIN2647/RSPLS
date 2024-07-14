package org.example;

import de.vandermeer.asciitable.AsciiTable;

public class GameTable {
    public static String generateResultTable(String[] moves) {
        AsciiTable table = new AsciiTable();
        table.addRule();
        String[] headerRow = new String[moves.length + 1];
        headerRow[0] = "PC/User >";
        System.arraycopy(moves, 0, headerRow, 1, moves.length);
        table.addRow(headerRow);
        table.addRule();

        for (String move : moves) {
            String[] row = new String[moves.length + 1];
            row[0] = move;
            for (int i = 0; i < moves.length; i++) {
                String result = determineResult(move, moves[i]);
                row[i + 1] = result;
            }
            table.addRow(row);
            table.addRule();
        }

        return table.render();
    }

    private static String determineResult(String move1, String move2) {
        if (move1.equals(move2)) {
            return "Draw";
        } else if (
                (move1.equals("Rock") && (move2.equals("Scissors") || move2.equals("Lizard"))) ||
                        (move1.equals("Spock") && (move2.equals("Rock") || move2.equals("Scissors"))) ||
                        (move1.equals("Paper") && (move2.equals("Spock") || move2.equals("Lizard"))) ||
                        (move1.equals("Lizard") && (move2.equals("Paper") || move2.equals("Spock"))) ||
                        (move1.equals("Scissors") && (move2.equals("Paper") || move2.equals("Lizard")))
        ) {
            return "Win";
        } else {
            return "Lose";
        }
    }
}
