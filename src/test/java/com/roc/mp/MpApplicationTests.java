package com.roc.mp;

import com.roc.mp.mapper.UserMapper;
import com.roc.mp.pojo.User;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MpApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserMapper userMapper;

    @Test
    public void getUserList(){

        List<User> userList = userMapper.selectList(null);

        userList.forEach(System.out::println);

    }

    @Test
    public void addUser(){
        User user = new User();
        //我们并没有setId，而是自动生成了Id
        user.setName("wangPeng");
        user.setAge(81);
        user.setEmail("1344471553@qq.com");
        userMapper.insert(user);
    }

    @Test
    public void update(){
        User user = new User();
        //我们并没有setId，而是自动生成了Id
        user.setId(6);
        user.setName("wangyufei");
        user.setAge(18);
        user.setEmail("1344471553@qq.com");
        userMapper.updateById(user);
    }

    @Test
    public void selectUserList(){
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectUserById(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void selectUserByIds(){
        List<User> userList = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        userList.forEach(System.out::println);
    }

    @Test
    public void setUserByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","wangyufei");
        List<User> userList = userMapper.selectByMap(map);
        userList.forEach(System.out::println);
    }

    @Test
    public void deleteById(){
        userMapper.deleteById(6);
    }

    @Test
    public void deleteByBatchId(){
        userMapper.deleteBatchIds(Arrays.asList(1, 2, 3));
    }

    @Test
    public void deleteByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","Sandy");
        userMapper.deleteByMap(map);
    }

}
