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

package doggy.tictactoe;

import doggy.tictactoe.component.*;
import doggy.tictactoe.component.keypad.DesktopNumericKeypadCellNumberConverter;
import doggy.tictactoe.component.keypad.TerminalNumericKeypadCellNumberConverter;
import doggy.tictactoe.model.Player;

import static doggy.tictactoe.model.Sign.O;
import static doggy.tictactoe.model.Sign.X;

/**
 * @author doggy
 * @link
 */
public final class Launcher {
    public static void main(String[] args) {
        final GameFactory gameFactory = new GameFactory(args);
        final Game game = gameFactory.create();
        game.play();
    }
}
