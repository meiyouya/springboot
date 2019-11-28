package com.zql.thread.pool;

import com.zql.thread.pool.service.AsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadPoolApplicationTests {

    @Autowired
    private AsyncService asyncService;

    @Test
    public void test() {
        for (int i =0; i < 10; i++) {
            asyncService.executeTask(i);
        }
    }

}
