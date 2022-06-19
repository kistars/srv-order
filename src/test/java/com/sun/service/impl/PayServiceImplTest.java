package com.sun.service.impl;

import com.sun.dto.OrderDTO;
import com.sun.service.OrderService;
import com.sun.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by SqMax on 2018/3/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() throws Exception{
        OrderDTO orderDTO=orderService.findOne("1234561");
        payService.create(orderDTO);
    }

    @Test
    public void refund(){
        OrderDTO orderDTO=orderService.findOne("1234561");
        payService.refund(orderDTO);
    }
}