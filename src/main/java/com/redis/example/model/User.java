package com.redis.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 周泽
 * @date Create in 16:39 2019/4/26
 * @Description 用户类
 */
@Data
@AllArgsConstructor
public class User implements Serializable {

    private Long id;

    private String name;

    private Integer age;

}
