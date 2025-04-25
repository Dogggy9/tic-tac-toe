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

import doggy.tictactoe.model.GameTable;
import doggy.tictactoe.model.Player;

import java.util.Random;

import static doggy.tictactoe.model.Sign.O;
import static doggy.tictactoe.model.Sign.X;

/**
 * @author doggy
 * @link
 */
public class Game {

    private final DataPrinter dataPrinter;

    private final UserMove userMove;

    private final ComputerMove computerMove;

    private final WinnerVerifier winnerVerifier;

    private final CellVerifier cellVerifier;

    public Game(final DataPrinter dataPrinter,
                final UserMove userMove,
                final ComputerMove computerMove,
                final WinnerVerifier winnerVerifier,
                final CellVerifier cellVerifier) {
        this.dataPrinter = dataPrinter;
        this.userMove = userMove;
        this.computerMove = computerMove;
        this.winnerVerifier = winnerVerifier;
        this.cellVerifier = cellVerifier;
    }

    public void play() {
        System.out.println("Используйте следующую таблицу сопоставлений, чтобы указать ячейку, используя цифры от 1 до 9.");
        dataPrinter.printMappingTable();

        final GameTable gameTable = new GameTable();

//        if (new Random().nextBoolean()) {
//            computerMove.make(gameTable);
//            dataPrinter.printGameTable(gameTable);
//        }

        final Player[] players = {new Player(X, userMove), new Player(O, computerMove)};
        while (true) {
            for (final Player player : players) {
                player.makeMove(gameTable);
                dataPrinter.printGameTable(gameTable);
                if (winnerVerifier.isWinner(gameTable, player)) {
                    System.out.println(player + " ПОБЕДИЛ!");
                    printGameOver();
                    return;
                }

                if (cellVerifier.allCellsFilled(gameTable)) {
                    System.out.println("Извини, НИЧЬЯ!");
                    printGameOver();
                    return;
                }
            }
        }
    }

    private void printGameOver() {
        System.out.println("КОНЕЦ ИГРЫ!");
    }
}
