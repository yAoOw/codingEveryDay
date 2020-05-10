package com.chason.order.feign;

import com.chason.order.domain.MyOrder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Administrator
 * Created by Administrator on 2020/5/10
 */

@FeignClient(name = "ORDER-SERVICE")
public interface OrderFeignService {

    @PostMapping("/createOrder")
     void createOrder(@RequestBody MyOrder order);

    @GetMapping("/getByOrderNo")
     MyOrder getOrder (
            @RequestParam("orderNo")String orderNo
    );

}
