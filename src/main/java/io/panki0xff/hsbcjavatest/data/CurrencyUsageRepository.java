package io.panki0xff.hsbcjavatest.data;

import io.panki0xff.hsbcjavatest.data.model.CurrencyUsageEntity;
import io.panki0xff.hsbcjavatest.data.model.dto.CurrencyTotalDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CurrencyUsageRepository extends JpaRepository<CurrencyUsageEntity, Long> {

    @Query(value = "Select e.currency as currency, sum(e.amount) as totalAmount from CurrencyUsageEntity e GROUP BY e.currency")
    List<CurrencyTotalDto> getSumGroupByCurrency();

}
