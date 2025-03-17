package doggy.tictactoe.component.keypad;

import doggy.tictactoe.component.CellNumberConverter;
import doggy.tictactoe.model.Cell;

public class TerminalNumericKeypadCellNumberConverter implements CellNumberConverter {

    @Override
    public Cell toCell(final char number){

        int val = number - '0' - 1;
        return new Cell(val/3, val%3);
    }

    @Override
    public char toNumber(final Cell cell){
        return (char) ('0' + (cell.getRow() * 3 + cell.getCol() + 1));
    }
}
