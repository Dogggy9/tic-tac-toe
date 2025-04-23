/*
 * Copyright (c) 2019. http://devonline.academy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package doggy.tictactoe.component;

import doggy.tictactoe.model.Cell;
import doggy.tictactoe.model.GameTable;
import doggy.tictactoe.model.Sign;

import static doggy.tictactoe.model.Sign.O;
import static doggy.tictactoe.model.Sign.X;

/**
 * @author doggy
 * @link
 */
public class WinnerVerifier {
    public boolean isUserWin(final GameTable gameTable) {
        return isWinner(gameTable, X);
    }

    public boolean isComputerWin(final GameTable gameTable) {
        return isWinner(gameTable, O);
    }

    private boolean isWinner(GameTable gameTable, Sign sign) {
        return verifierRows(gameTable, sign) ||
                verifierColumns(gameTable, sign) ||
                verifierMainDiagon(gameTable, sign) ||
                verifierSecondDiagon(gameTable, sign);
    }

    private boolean verifierRows(GameTable gameTable, Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(i, 0)) == gameTable.getSign(new Cell(i, 1)) &&
                    gameTable.getSign(new Cell(i, 1)) == gameTable.getSign(new Cell(i, 2)) &&
                    gameTable.getSign(new Cell(i, 2)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean verifierColumns(GameTable gameTable, Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(0, i)) == gameTable.getSign(new Cell(1, i)) &&
                    gameTable.getSign(new Cell(1, i)) == gameTable.getSign(new Cell(2, i)) &&
                    gameTable.getSign(new Cell(2, i)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean verifierMainDiagon(GameTable gameTable, Sign sign) {
        return (gameTable.getSign(new Cell(0, 0)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(2, 2)) &&
                gameTable.getSign(new Cell(2, 2)) == sign);
    }

    private boolean verifierSecondDiagon(GameTable gameTable, Sign sign) {
        return (gameTable.getSign(new Cell(0, 2)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(2, 0)) &&
                gameTable.getSign(new Cell(2, 0)) == sign);

    }
}
