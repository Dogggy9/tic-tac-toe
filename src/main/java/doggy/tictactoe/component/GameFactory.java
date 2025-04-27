package doggy.tictactoe.component;

import doggy.tictactoe.component.keypad.TerminalNumericKeypadCellNumberConverter;
import doggy.tictactoe.model.Player;
import doggy.tictactoe.model.PlayerType;

import static doggy.tictactoe.model.PlayerType.COMPUTER;
import static doggy.tictactoe.model.PlayerType.USER;
import static doggy.tictactoe.model.Sign.O;
import static doggy.tictactoe.model.Sign.X;

public class GameFactory {

    private final PlayerType player1Type;

    private final PlayerType player2Type;

    public GameFactory(final String[] args) {
        PlayerType player1Type = null;
        PlayerType player2Type = null;
        for (String arg : args) {
            if (USER.name().equalsIgnoreCase(arg) || COMPUTER.name().equalsIgnoreCase(arg)) {
                if (player1Type == null) {
                    player1Type = PlayerType.valueOf(arg.toUpperCase());
                } else if (player2Type == null) {
                    player2Type = PlayerType.valueOf(arg.toUpperCase());
                } else {
                    System.err.println("Неподдерживаемый аргумент командной строки: '" + arg + "'");
                }
            } else {
                System.err.println("Неподдерживаемый аргумент командной строки: '" + arg + "'");
            }
        }
        if (player1Type == null) {
            this.player1Type = USER;
            this.player2Type = COMPUTER;
        } else if (player2Type == null) {
            this.player2Type = player1Type;
            this.player1Type = USER;
        } else {
            this.player1Type = player1Type;
            this.player2Type = player2Type;
        }
    }

    public Game create() {
        final CellNumberConverter cellNumberConverter = new TerminalNumericKeypadCellNumberConverter();
        final Player player1;
        if (player1Type == USER) {
            player1 = new Player(X, new UserMove(cellNumberConverter));
        } else {
            player1 = new Player(X, new ComputerMove());
        }
        final Player player2;
        if (player2Type == USER) {
            player2 = new Player(O, new UserMove(cellNumberConverter));
        } else {
            player2 = new Player(O, new ComputerMove());
        }
        final boolean canSecondPlayerMakeFirstMove = player1Type != player2Type;
        return new Game(
                new DataPrinter(cellNumberConverter),
                player1,
                player2,
                new WinnerVerifier(),
                new CellVerifier(),
                canSecondPlayerMakeFirstMove
        );
    }
}
