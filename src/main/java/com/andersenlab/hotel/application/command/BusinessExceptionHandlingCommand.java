package com.andersenlab.hotel.application.command;

import com.andersenlab.hotel.application.CustomErrorMessage;
import com.andersenlab.hotel.usecase.exception.ApartmentWithSameIdExists;
import com.andersenlab.hotel.usecase.exception.ClientIsAlreadyExistsException;

import java.io.PrintStream;
import java.util.List;


public final class BusinessExceptionHandlingCommand implements Command {

    private final Command original;

    public BusinessExceptionHandlingCommand(Command original) {
        this.original = original;
    }

    @Override
    public void execute(PrintStream output, List<String> arguments) {
        try {
            original.execute(output, arguments);
        } catch (ApartmentWithSameIdExists e) {
            output.println(CustomErrorMessage.APARTMENT_IS_ALREADY_EXISTS.getMessage());
        } catch (ClientIsAlreadyExistsException e) {
            output.println(CustomErrorMessage.CLIENT_IS_ALREADY_EXISTS.getMessage());
        }
    }

}