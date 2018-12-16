package com.qin.mutildatasource.entity;

import lombok.Data;

/**
 * 注释：
 * 作者：秦盟
 * 时间：2018-12-15 20:52
 */
@Data
public class User {
    private int age;
    private String name;

    public static void main(String[] args) {
        System.out.println(new User().toString());
    }
}
