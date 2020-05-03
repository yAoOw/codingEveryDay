package com.chason.order.service.impl;

import com.chason.order.domain.MyOrder;
import com.chason.order.mapper.MyOrderMapper;
import com.chason.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * Created by Administrator on 2020/5/3
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final MyOrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(MyOrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public void insertOne(MyOrder order) {
        orderMapper.insertSelective(order);
    }
}
