package doggy.tictactoe.component.console;

import doggy.tictactoe.component.DataPrinter;
import doggy.tictactoe.component.GameOverHandler;

public class ConsoleGameOverHandler implements GameOverHandler {

    private final DataPrinter dataPrinter;

    public ConsoleGameOverHandler(DataPrinter dataPrinter) {
        this.dataPrinter = dataPrinter;
    }

    @Override
    public void gameOver() {
        dataPrinter.printInfoMessage("КОНЕЦ ИГРЫ!");
    }
}
