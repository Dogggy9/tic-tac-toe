package doggy.tictactoe.component.console;

import doggy.tictactoe.model.game.Cell;

public interface CellNumberConverter {

    Cell toCell(char number);

    char toNumber(Cell cell);
}
