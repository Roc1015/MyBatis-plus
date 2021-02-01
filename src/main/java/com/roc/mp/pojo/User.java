package com.roc.mp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @version 1.0
 * @author: WP
 * @date: 2021/1/31 9:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;
    private Integer age;
    private String email;
    private Date createTime;
    private Date updateTime;

    @TableLogic
    private Integer deleted;
}
