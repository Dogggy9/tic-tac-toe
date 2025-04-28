package doggy.tictactoe.component.console;

import doggy.tictactoe.component.CellNumberConverter;
import doggy.tictactoe.component.DataPrinter;
import doggy.tictactoe.component.UserInputReader;
import doggy.tictactoe.model.Cell;

import java.util.Scanner;

public class ConsoleUserInputReader implements UserInputReader {

    private final CellNumberConverter cellNumberConverter;

    private final DataPrinter dataPrinter;

    public ConsoleUserInputReader(CellNumberConverter cellNumberConverter, DataPrinter dataPrinter) {
        this.cellNumberConverter = cellNumberConverter;
        this.dataPrinter = dataPrinter;
    }

    @Override
    public Cell getUserInput() {
        while (true) {
            dataPrinter.printInfoMessage("введите от 1 до 9");
            final String userInput = new Scanner(System.in).nextLine();
            if (userInput.length() == 1) {
                char ch = userInput.charAt(0);
                if (ch >= '1' && ch <= '9') {
                    return cellNumberConverter.toCell(ch);
                }
            }
        }
    }
}
