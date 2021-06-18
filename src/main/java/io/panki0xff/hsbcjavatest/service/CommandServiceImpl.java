package io.panki0xff.hsbcjavatest.service;

import io.panki0xff.hsbcjavatest.data.CurrencyUsageRepository;
import io.panki0xff.hsbcjavatest.data.model.CurrencyUsageEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CommandServiceImpl implements CommandService {
    private final CurrencyUsageRepository currencyUsageRepository;

    @Override
    public void readCommand(String command) {
        String[] splitCommand = StringUtils.split(command, " ");
        if (splitCommand == null || splitCommand.length != 2) {
            System.out.println("Please input as [CCY value]");
            return;
        }
        try {
            String currency = splitCommand[0];
            if (currency.length() != 3 || !currency.matches("[A-Za-z]{3}")) {
                System.out.println("Please use 3 letter currency code as CCY input.");
                return;
            }
            BigDecimal value = new BigDecimal(splitCommand[1]);
            CurrencyUsageEntity currencyUsageEntity = CurrencyUsageEntity.builder()
                    .currency(currency.toUpperCase())
                    .amount(value)
                    .build();
            currencyUsageRepository.save(currencyUsageEntity);
        } catch (NumberFormatException e) {
            System.out.println("Please use enter number as value input");
        } catch (Exception e) {
            System.out.println("Unknown error");
            e.printStackTrace();
        }
    }
}
