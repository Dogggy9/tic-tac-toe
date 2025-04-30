package doggy.tictactoe.component;

import doggy.tictactoe.model.game.GameTable;

public interface DataPrinter {

    void printInstructions();

    void printInfoMessage(String message);

    void printErrorMessage(String message);

    void printGameTable(GameTable gameTable);
}
