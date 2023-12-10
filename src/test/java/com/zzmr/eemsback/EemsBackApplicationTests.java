package com.zzmr.eemsback;

import com.zzmr.eemsback.bean.Bpprt;
import com.zzmr.eemsback.bean.User;
import com.zzmr.eemsback.mapper.BpprtMapper;
import com.zzmr.eemsback.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EemsBackApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BpprtMapper bpprtMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    void testBpprt() {
        List<Bpprt> bpprts = bpprtMapper.selectList(null);
        System.out.println(bpprts);
    }

}
