package com.andersenlab.hotel.usecase;

import java.util.UUID;

public interface CalculateClientStayCurrentPriceUseCase {

    void calculatePrice(UUID id);
}