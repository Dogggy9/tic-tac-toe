package doggy.tictactoe.component;

import doggy.tictactoe.component.keypad.TerminalNumericKeypadCellNumberConverter;
import doggy.tictactoe.model.Player;
import doggy.tictactoe.model.PlayerType;

import static doggy.tictactoe.model.Sign.O;
import static doggy.tictactoe.model.Sign.X;

public class GameFactory {

    private final PlayerType player1Type = PlayerType.USER;

    private final PlayerType player2Type = PlayerType.COMPUTER;

    public GameFactory(final String[] args) {
        // TODO
    }

    public Game create() {
        final CellNumberConverter cellNumberConverter = new TerminalNumericKeypadCellNumberConverter();
        return new Game(
                new DataPrinter(cellNumberConverter),
                // FIXME
                new Player(X, new UserMove(cellNumberConverter)),
                new Player(O, new UserMove(cellNumberConverter)),
//                new Player(O, new ComputerMove()),
//                new Player(X, new ComputerMove()),
                new WinnerVerifier(),
                new CellVerifier(),
                false
        );
    }
}
