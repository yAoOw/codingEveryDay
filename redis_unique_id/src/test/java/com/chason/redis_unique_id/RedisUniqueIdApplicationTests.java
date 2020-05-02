package com.chason.redis_unique_id;

import com.chason.redis_unique_id.service.PrimaryKeyService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class RedisUniqueIdApplicationTests {

    @Autowired
    private PrimaryKeyService primaryKeyService;

    @Test
    void contextLoads() {
        System.out.println(primaryKeyService.getId());
    }

}
