package doggy.tictactoe.component.console;

import doggy.tictactoe.component.CellNumberConverter;
import doggy.tictactoe.component.DataPrinter;
import doggy.tictactoe.model.Cell;
import doggy.tictactoe.model.GameTable;

public class ConsoleDataPrinter implements DataPrinter {

    private final CellNumberConverter cellNumberConverter;

    public ConsoleDataPrinter(CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
    }

    @Override
    public void printInfoMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printErrorMessage(String message) {
        System.err.println(message);
    }

    @Override
    public void printMappingTable() {

        print((i, j) -> String.valueOf(cellNumberConverter.toNumber(new Cell(i, j))));

    }

    @Override
    public void printGameTable(GameTable gameTable) {

        print((i, j) -> String.valueOf(gameTable.getSign(new Cell(i, j))));

    }

    private void print(final Lambda lambda) {

        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + lambda.getValue(i, j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");

    }

    @FunctionalInterface
    private interface Lambda {

        String getValue(int i, int j);
    }
}
