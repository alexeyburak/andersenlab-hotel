package com.andersenlab.hotel.command.additional;


import com.andersenlab.hotel.command.ApplicationCommand;
import com.andersenlab.hotel.command.Command;

import java.io.PrintStream;
import java.util.List;

public final class ExitApplicationCommand implements Command {

    private static final ApplicationCommand APPLICATION_COMMAND = ApplicationCommand.EXIT;

    @Override
    public ApplicationCommand getApplicationCommand() {
        return APPLICATION_COMMAND;
    }

    @Override
    public void execute(PrintStream output, List<String> arguments) {
        output.println("Goodbye, have a nice day!");
    }
}
