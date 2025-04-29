package doggy.tictactoe.component;

import doggy.tictactoe.component.console.ConsoleDataPrinter;
import doggy.tictactoe.component.console.ConsoleUserInputReader;
import doggy.tictactoe.component.keypad.TerminalNumericKeypadCellNumberConverter;
import doggy.tictactoe.component.swing.GameWindow;
import doggy.tictactoe.model.Player;
import doggy.tictactoe.model.PlayerType;
import doggy.tictactoe.model.UserInterface;

import static doggy.tictactoe.model.PlayerType.USER;
import static doggy.tictactoe.model.Sign.O;
import static doggy.tictactoe.model.Sign.X;
import static doggy.tictactoe.model.UserInterface.GUI;

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
        if (userInterface == GUI) {
            final GameWindow gameWindow = new GameWindow();
            dataPrinter = gameWindow;
            userInputReader = gameWindow;
        } else {
            final CellNumberConverter cellNumberConverter = new TerminalNumericKeypadCellNumberConverter();
            dataPrinter = new ConsoleDataPrinter(cellNumberConverter);
            userInputReader = new ConsoleUserInputReader(cellNumberConverter, dataPrinter);
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
                canSecondPlayerMakeFirstMove
        );
    }
}
