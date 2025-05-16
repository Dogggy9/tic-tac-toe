# The Tic Tac Toe Project

-----------------------------------------------------------------------------------

## Инструкция по сборке

- Сборка дистрибутивов с помощью инструмента maven

```bash
mvn clean package
```

- Используйте следующие архивы:
  - `target/tic-tac-toe-${project.version}-windows.zip` for Windows
  - `target/tic-tac-toe-${project.version}-unix.tar.gz` for macOS and Linux

## Инструкции по выполнению

- Скачать [OpenJDK 21](https://jdk.java.net/21/)
- Распакуйте загруженный архив OpenJDK;
- Настройте переменную окружения `PATH`:
    - Добавить `%JDK_HOME%\bin\` directory for Windows;
  - Добавить `%JDK_HOME%/bin/` directory for macOS and Linux;
- Повторно войдите в систему или перезагрузите компьютер
- Распакуйте дистрибутив Tic tac toe:
    - Распакуйте `tic-tac-toe-${project.version}-windows.zip` for Windows
  - Распакуйте `tic-tac-toe-${project.version}-windows.zip` for macOS and Linux
- Перейдите в распакованный каталог;
- Запустите игру, дважды щелкнув на стартовом скрипте:
    - `start.cmd` for Windows;
  - `start.sh` for macOS and Linux;

-----------------------------------------------------------------------------------

## Readme tutorial

- https://guides.github.com/features/mastering-markdown/
- https://help.github.com/categories/writing-on-github/
