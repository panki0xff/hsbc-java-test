package io.panki0xff.hsbcjavatest.task;

import io.panki0xff.hsbcjavatest.data.CurrencyUsageRepository;
import io.panki0xff.hsbcjavatest.data.model.dto.CurrencyTotalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ScheduledDisplayTask {
    private final CurrencyUsageRepository currencyUsageRepository;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").withZone(ZoneId.systemDefault());

    @Scheduled(fixedRateString = "${app.display.gap}", initialDelay = 1000)
    public void display() {
        List<CurrencyTotalDto> currencyTotalDtoList = currencyUsageRepository.getSumGroupByCurrency();
        if (currencyTotalDtoList.size() > 0) {
            System.out.println(formatter.format(Instant.now()) + " the current net amounts of each currency is :");
            currencyTotalDtoList.forEach(currencyTotalDto -> {
                        if (currencyTotalDto.getTotalAmount().doubleValue() != 0) {
                            System.out.println("   " + currencyTotalDto.getCurrency() + " " + currencyTotalDto.getTotalAmount());
                        }
                    }
            );
        }
    }
}
