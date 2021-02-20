package com.gino.graphql.demo.resolver;

import io.github.kobylynskyi.bikeshop.graphql.api.OrderQueryResolver;
import io.github.kobylynskyi.bikeshop.graphql.model.DepositOrderTO;
import io.github.kobylynskyi.bikeshop.graphql.model.NormalOrderTO;
import io.github.kobylynskyi.bikeshop.graphql.model.OrderBaseTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class QueriesResolver implements OrderQueryResolver {
    @Override
    public List<OrderBaseTO> Order() throws Exception {
        // data should be gotten from other service, such like database
        log.info("query data...");
        ArrayList<OrderBaseTO> objects = new ArrayList<>();

        DepositOrderTO depositOrderTO = new DepositOrderTO();
        depositOrderTO.setId("1");
        Date date = new Date();
        depositOrderTO.setTime(date.toInstant().atOffset(ZoneOffset.UTC));
        depositOrderTO.setType("Deposit");
        depositOrderTO.setAmount(BigDecimal.ONE);
        depositOrderTO.setRate(15.0D);
        objects.add(depositOrderTO);

        NormalOrderTO normalOrderTO = new NormalOrderTO();
        normalOrderTO.setId("2");
        normalOrderTO.setType("Normal");
        normalOrderTO.setAmount(BigDecimal.ONE);
        normalOrderTO.setTime(date.toInstant().atOffset(ZoneOffset.UTC));
        objects.add(normalOrderTO);

        return objects;
    }
}
