package doggy.tictactoe;

import doggy.tictactoe.component.*;
import doggy.tictactoe.component.config.CommandLineArgumentParser;
import doggy.tictactoe.component.console.CellNumberConverter;
import doggy.tictactoe.component.console.ConsoleDataPrinter;
import doggy.tictactoe.component.console.ConsoleGameOverHandler;
import doggy.tictactoe.component.console.ConsoleUserInputReader;
import doggy.tictactoe.component.console.keypad.TerminalNumericKeypadCellNumberConverter;
import doggy.tictactoe.component.swing.GameWindow;
import doggy.tictactoe.model.game.Player;
import doggy.tictactoe.model.config.PlayerType;
import doggy.tictactoe.model.config.UserInterface;

import static doggy.tictactoe.model.config.PlayerType.USER;
import static doggy.tictactoe.model.game.Sign.O;
import static doggy.tictactoe.model.game.Sign.X;
import static doggy.tictactoe.model.config.UserInterface.GUI;

public class GameFactory {

    private final PlayerType player1Type;

    private final PlayerType player2Type;

    private final UserInterface userInterface;

    public GameFactory(final String[] args) {
        final CommandLineArgumentParser.CommandLineArguments commandLineArguments =
                new CommandLineArgumentParser(args).parse();
        player1Type = commandLineArguments.getPlayer1Type();
        player2Type = commandLineArguments.getPlayer2Type();
        userInterface = commandLineArguments.getUserInterface();
    }

    public Game create() {

        final DataPrinter dataPrinter;
        final UserInputReader userInputReader;
        final GameOverHandler gameOverHandler;
        if (userInterface == GUI) {
            final GameWindow gameWindow = new GameWindow();
            dataPrinter = gameWindow;
            userInputReader = gameWindow;
            gameOverHandler = gameWindow;
        } else {
            final CellNumberConverter cellNumberConverter = new TerminalNumericKeypadCellNumberConverter();
            dataPrinter = new ConsoleDataPrinter(cellNumberConverter);
            userInputReader = new ConsoleUserInputReader(cellNumberConverter, dataPrinter);
            gameOverHandler = new ConsoleGameOverHandler(dataPrinter);
        }

        final Player player1;
        if (player1Type == USER) {
            player1 = new Player(X, new UserMove(userInputReader, dataPrinter));
        } else {
            player1 = new Player(X, new ComputerMove());
        }
        final Player player2;
        if (player2Type == USER) {
            player2 = new Player(O, new UserMove(userInputReader, dataPrinter));
        } else {
            player2 = new Player(O, new ComputerMove());
        }
        final boolean canSecondPlayerMakeFirstMove = player1Type != player2Type;
        return new Game(
                dataPrinter,
                player1,
                player2,
                new WinnerVerifier(),
                new CellVerifier(),
                gameOverHandler,
                canSecondPlayerMakeFirstMove
        );
    }
}
