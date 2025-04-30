package doggy.tictactoe.component;

import doggy.tictactoe.model.game.GameTable;
import doggy.tictactoe.model.game.Sign;

public interface Move {

    void make(GameTable gameTable, Sign sign);
}
