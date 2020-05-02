package com.chason.redis_unique_id.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * Created by Administrator on 2020/5/2
 */
@RestController
@RequestMapping
public class TestController {

    @Autowired
    private PrimaryKeyService primaryKeyService;

    @GetMapping
    public Long getId(){
        return primaryKeyService.getId();
    }
}
