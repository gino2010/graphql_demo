package com.gino.graphql.demo.resolver;

import io.github.kobylynskyi.bikeshop.graphql.api.CreateOrderMutationResolver;
import io.github.kobylynskyi.bikeshop.graphql.api.UpdateOrderStatusMutationResolver;
import io.github.kobylynskyi.bikeshop.graphql.model.DepositOrderTO;
import io.github.kobylynskyi.bikeshop.graphql.model.InputOrderTO;
import io.github.kobylynskyi.bikeshop.graphql.model.NormalOrderTO;
import io.github.kobylynskyi.bikeshop.graphql.model.OrderBaseTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.util.Date;

@Component
@Slf4j
public class MutationsResolver implements CreateOrderMutationResolver, UpdateOrderStatusMutationResolver {
    @Override
    public OrderBaseTO createOrder(InputOrderTO order) throws Exception {
        // should persistent these data, such like DB
        if ("deposit".equalsIgnoreCase(order.getType())) {
            log.info("deposit order");
            DepositOrderTO depositOrderTO = new DepositOrderTO();
            depositOrderTO.setId("new");
            depositOrderTO.setType(order.getType());
            depositOrderTO.setAmount(order.getAmount());
            depositOrderTO.setTime((new Date()).toInstant().atOffset(ZoneOffset.UTC));
            depositOrderTO.setRate(10.0D);
            return depositOrderTO;
        } else if ("normal".equalsIgnoreCase(order.getType())) {
            log.info("normal order");
            NormalOrderTO normalOrderTO = new NormalOrderTO();
            normalOrderTO.setId("new");
            normalOrderTO.setType(order.getType());
            normalOrderTO.setAmount(order.getAmount());
            normalOrderTO.setTime((new Date()).toInstant().atOffset(ZoneOffset.UTC));
            return normalOrderTO;
        }
        return null;
    }

    @Override
    public OrderBaseTO updateOrderStatus(String orderId, String status) throws Exception {
        // should get data from other service by orderId, and update status
        log.info("orderId:{}, status:{}", orderId, status);
        NormalOrderTO normalOrderTO = new NormalOrderTO();
        normalOrderTO.setId("update");
        normalOrderTO.setType("Normal");
        normalOrderTO.setAmount(BigDecimal.ONE);
        normalOrderTO.setTime((new Date()).toInstant().atOffset(ZoneOffset.UTC));
        return normalOrderTO;
    }
}
