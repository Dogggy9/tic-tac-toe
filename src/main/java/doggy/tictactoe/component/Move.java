package doggy.tictactoe.component;

import doggy.tictactoe.model.GameTable;
import doggy.tictactoe.model.Sign;

public interface Move {

    void make(GameTable gameTable, Sign sign);
}
