package com.roc.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.roc.mp.mapper.UserMapper;
import com.roc.mp.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: WP
 * @date: 2021/1/31 16:05
 */
@SpringBootTest
public class WrapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    //查询name不为空，且邮箱不为空，年龄大于12岁的用户
    public void selectByWrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("name")
                    .isNotNull("email")
                    .ge("age",12);

        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void selectByName(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","kuangsheng");
        userMapper.selectList(queryWrapper);
    }

    @Test
    public void selectByBetween(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("age","10","30");
        userMapper.selectList(queryWrapper).forEach(System.out::println);
        Integer count = userMapper.selectCount(queryWrapper);
        System.out.println(count);
    }

    @Test
    public void selectByLike(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.notLike("name","e");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void selectBySql(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id","select id from user where id <5");
        List<Object> objects = userMapper.selectObjs(queryWrapper);
        objects.forEach(System.out::println);
    }

    @Test
    public void selectByOrder(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("Id");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }



}
