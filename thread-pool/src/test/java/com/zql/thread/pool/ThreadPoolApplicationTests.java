package com.zql.thread.pool;

import com.zql.thread.pool.service.AsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        ArrayList<Future<String>> resList = new ArrayList<>();
        for (int i =0; i < 10; i++) {
            Future<String> res = asyncService.executeWithReturn(i);
//            System.out.println(res.get());  // 如果在这里直接读取结果，下面的线程就要等到这里读取完成之后，才能执行，就变成了同步的了
            resList.add(res);   // 这里直接把res放进一个列表，没有调用get方法，就不会影响到下面的线程执行
        }

        // 在所有线程运行完毕之后，在这里单独读取
        for (Future<String> res : resList) {
            System.out.println(res.get());
        }
    }

}
