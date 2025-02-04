package doggy.tictactoe.component;

import doggy.tictactoe.model.Cell;

public interface CellNumberConverter {

    Cell toCell(char number);

    char toNumber(Cell cell);
}
