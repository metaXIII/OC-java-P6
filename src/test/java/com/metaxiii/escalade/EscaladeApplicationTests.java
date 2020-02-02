package com.metaxiii.escalade;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EscaladeApplicationTests {

    @Test
    public void contextLoads() {
        boolean valid = true;
        Assert.assertTrue(valid);
    }

}
