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

import java.util.Random;

/**
 * @author doggy
 * @link
 */
public class Game {

    private final DataPrinter dataPrinter;

    private final UserMove userMove;

    private final ComputerMove computerMove;

    private final WinnerVerifier winnerVerifier;

    private final DrawVerifier drawVerifier;

    public Game(final DataPrinter dataPrinter,
                final UserMove userMove,
                final ComputerMove computerMove,
                final WinnerVerifier winnerVerifier,
                final DrawVerifier drawVerifier) {
        this.dataPrinter = dataPrinter;
        this.userMove = userMove;
        this.computerMove = computerMove;
        this.winnerVerifier = winnerVerifier;
        this.drawVerifier = drawVerifier;
    }

    public void play() {
        System.out.println("Используйте следующую таблицу сопоставлений, чтобы указать ячейку, используя цифры от 1 до 9.");
        dataPrinter.printMappingTable();

        final GameTable gameTable = new GameTable();

        if (new Random().nextBoolean()) {
            computerMove.make(gameTable);
            dataPrinter.printGameTable(gameTable);
        }

        while (true) {
            userMove.make(gameTable);
            dataPrinter.printGameTable(gameTable);
            if (winnerVerifier.isUserWin(gameTable)) {
                System.out.println("ТЫ ПОБЕДИЛ!");
                break;
            }

            if (drawVerifier.isDraw(gameTable)) {
                System.out.println("Извини, НИЧЬЯ!");
                break;
            }

            computerMove.make(gameTable);

            dataPrinter.printGameTable(gameTable);

            if (winnerVerifier.isComputerWin(gameTable)) {
                System.out.println("КОПЬЮТЕР ПОБЕДИЛ!");
                break;
            }

            if (drawVerifier.isDraw(gameTable)) {
                System.out.println("Извини, НИЧЬЯ!");
                break;
            }
        }
        System.out.println("КОНЕЦ ИГРЫ!");

    }
}
