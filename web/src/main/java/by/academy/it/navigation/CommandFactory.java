package by.academy.it.navigation;

import by.academy.it.navigation.commands.Command;

public class CommandFactory {
    public static Command getCommand(String page) {
        Commands commands = Commands.valueOf(page.toUpperCase());
        return commands.getCommand();
    }
}
