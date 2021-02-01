package com.roc.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roc.mp.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @author: WP
 * @date: 2021/1/31 9:59
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
