package io.panki0xff.hsbcjavatest.data.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Currency_Usage")
@Data
@Builder
public class CurrencyUsageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "ccy")
    private String currency;

    @Column(name = "amount")
    private BigDecimal amount;
}
