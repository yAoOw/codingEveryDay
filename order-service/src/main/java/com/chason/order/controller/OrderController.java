package com.chason.order.controller;

import com.chason.order.domain.MyOrder;
import com.chason.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * Created by Administrator on 2020/5/3
 */
@RestController
@RequestMapping()
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public void createOrder(@RequestBody MyOrder order){
        orderService.insertOne(order);
    }
}
