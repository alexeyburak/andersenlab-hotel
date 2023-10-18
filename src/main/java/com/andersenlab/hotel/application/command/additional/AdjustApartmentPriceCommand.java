package com.andersenlab.hotel.application.command.additional;

import com.andersenlab.hotel.application.CustomErrorMessage;
import com.andersenlab.hotel.application.command.ApplicationCommand;
import com.andersenlab.hotel.application.command.ArgumentsValidator;
import com.andersenlab.hotel.application.command.Command;
import com.andersenlab.hotel.usecase.AdjustApartmentPriceUseCase;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public final class AdjustApartmentPriceCommand implements Command, ArgumentsValidator<String> {

    private static final ApplicationCommand APPLICATION_COMMAND = ApplicationCommand.ADJUST;

    private final AdjustApartmentPriceUseCase useCase;

    @Override
    public ApplicationCommand getApplicationCommand() {
        return APPLICATION_COMMAND;
    }

    @Override
    public void execute(PrintStream output, List<String> arguments) {
        validateArguments(arguments);

        UUID apartmentId = UUID.fromString(arguments.get(1));
        BigDecimal newPrice = BigDecimal.valueOf(NumberUtils.toLong(arguments.get(2)));

        useCase.adjust(apartmentId, newPrice);
        output.println("Apartment price was adjusted");
    }

    @Override
    public void validateArguments(List<String> arguments) throws IllegalArgumentException {
        if (!NumberUtils.isParsable(arguments.get(2))) {
            throw new IllegalArgumentException(CustomErrorMessage.ILLEGAL_PRICE.getMessage());
        }
    }
}