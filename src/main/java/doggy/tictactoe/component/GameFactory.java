package doggy.tictactoe.component;

import doggy.tictactoe.component.swing.GameWindow;
import doggy.tictactoe.model.Player;
import doggy.tictactoe.model.PlayerType;

import static doggy.tictactoe.model.PlayerType.USER;
import static doggy.tictactoe.model.Sign.O;
import static doggy.tictactoe.model.Sign.X;

public class GameFactory {

    private final PlayerType player1Type;

    private final PlayerType player2Type;

    public GameFactory(final String[] args) {
        final CommandLineArgumentParser.PlayerTypes playerTypes =
                new CommandLineArgumentParser(args).parse();
        this.player1Type = playerTypes.getPlayer1Type();
        this.player2Type = playerTypes.getPlayer2Type();
    }

    public Game create() {

        final GameWindow gameWindow = new GameWindow();

        //final CellNumberConverter cellNumberConverter = new TerminalNumericKeypadCellNumberConverter();
        final DataPrinter dataPrinter = gameWindow; // new ConsoleDataPrinter(cellNumberConverter);
        final UserInputReader userInputReader = gameWindow; // new ConsoleUserInputReader(cellNumberConverter, dataPrinter);

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
