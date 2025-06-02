# The Tic Tac Toe Project

-----------------------------------------------------------------------------------

## Without JRE

### Инструкция по сборке

- Сборка дистрибутивов с помощью инструмента maven

```bash
mvn -P without-jre clean package
```

- Используйте следующие архивы:
  - `target/tic-tac-toe-${project.version}-windows.zip` для Windows
  - `target/tic-tac-toe-${project.version}-unix.tar.gz` для macOS и Linux

### Инструкции по выполнению

- Скачать [OpenJDK 21](https://jdk.java.net/21/)
- Распакуйте загруженный архив OpenJDK;
- Настройте переменную окружения `PATH`:
  - Добавить `%JDK_HOME%\bin\` directory для Windows;
  - Добавить `%JDK_HOME%/bin/` directory для macOS и Linux;
- Повторно войдите в систему или перезагрузите компьютер
- Распакуйте дистрибутив Tic tac toe:
  - Распакуйте `tic-tac-toe-${project.version}-windows.zip` для Windows
  - Распакуйте `tic-tac-toe-${project.version}-windows.zip` для macOS и Linux
- Перейдите в распакованный каталог;
- Запустите игру, дважды щелкнув на стартовом скрипте:
  - `start.cmd` для Windows;
  - `start.sh` для macOS and Linux;

-----------------------------------------------------------------------------------

## With JRE

### Инструкция по сборке

- Сборка дистрибутивов с помощью инструмента maven

```bash
mvn -P with-jre clean package
```

- Используйте следующие архивы:
  - `target/tic-tac-toe-${project.version}-windows-with-jre.zip` для Windows
  - `target/tic-tac-toe-${project.version}-macos-with-jre.tar.gz` для MacOS
  - `target/tic-tac-toe-${project.version}-linux-with-jre.tar.gz` для Linux

### Инструкции по выполнению

- Распакуйте дистрибутив Tic tac toe:
  - Распакуйте `tic-tac-toe-${project.version}-windows-with-jre.zip` для Windows;
  - Распакуйте `tic-tac-toe-${project.version}-macos-with-jre.tar.gz` для MacOS;
  - Распакуйте `tic-tac-toe-${project.version}-linux-with-jre.tar.gz` для Linux;
- Перейдите в распакованный каталог;
- Запустите игру, дважды щелкнув на стартовом скрипте:
  - `start.cmd` для Windows;
  - `start.sh` для MacOS и Linux;

-----------------------------------------------------------------------------------

## Readme tutorial

- https://guides.github.com/features/mastering-markdown/
- https://help.github.com/categories/writing-on-github/
