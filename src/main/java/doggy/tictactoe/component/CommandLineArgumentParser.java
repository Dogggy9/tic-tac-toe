package doggy.tictactoe.component;

import doggy.tictactoe.model.PlayerType;
import doggy.tictactoe.model.UserInterface;

import static doggy.tictactoe.model.PlayerType.COMPUTER;
import static doggy.tictactoe.model.PlayerType.USER;
import static doggy.tictactoe.model.UserInterface.CONSOLE;
import static doggy.tictactoe.model.UserInterface.GUI;

public class CommandLineArgumentParser {

    private final String[] args;

    public CommandLineArgumentParser(String[] args) {
        this.args = args;
    }

    public CommandLineArguments parse() {

        PlayerType player1Type = null;
        PlayerType player2Type = null;
        UserInterface userInterface = null;
        for (String arg : args) {
            if (USER.name().equalsIgnoreCase(arg) || COMPUTER.name().equalsIgnoreCase(arg)) {
                if (player1Type == null) {
                    player1Type = PlayerType.valueOf(arg.toUpperCase());
                } else if (player2Type == null) {
                    player2Type = PlayerType.valueOf(arg.toUpperCase());
                } else {
                    System.err.println("Неподдерживаемый аргумент командной строки: '" + arg + "'");
                }
            }
            if (GUI.name().equalsIgnoreCase(arg) || CONSOLE.name().equalsIgnoreCase(arg)) {
                if (userInterface == null) {
                    userInterface = UserInterface.valueOf(arg.toUpperCase());
                } else {
                    System.err.println("Неподдерживаемый аргумент командной строки: '" + arg + "'");
                }

            } else {
                System.err.println("Неподдерживаемый аргумент командной строки: '" + arg + "'");
            }
        }
        if (userInterface == null) {
            userInterface = CONSOLE;
        }
        if (player1Type == null) {
            return new CommandLineArguments(USER, COMPUTER, userInterface);
        } else if (player2Type == null) {
            return new CommandLineArguments(USER, player1Type, userInterface);
        } else {
            return new CommandLineArguments(player1Type, player2Type, userInterface);
        }
    }

    public static class CommandLineArguments {

        private final PlayerType player1Type;

        private final PlayerType player2Type;

        private final UserInterface userInterface;

        private CommandLineArguments(PlayerType player1Type,
                                     PlayerType player2Type,
                                     UserInterface userInterface) {
            this.player1Type = player1Type;
            this.player2Type = player2Type;
            this.userInterface = userInterface;
        }

        public PlayerType getPlayer1Type() {
            return player1Type;
        }

        public PlayerType getPlayer2Type() {
            return player2Type;
        }

        public UserInterface getUserInterface() {
            return userInterface;
        }
    }
}
