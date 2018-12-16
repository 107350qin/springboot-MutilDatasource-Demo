package com.qin.mutildatasource.test1;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * 注释：
 * 作者：秦盟
 * 时间：2018-12-15 22:41
 */
public interface MybatisService1 {
    @Insert("insert user values(0,#{name},#{age})")
    void insertUser(@Param("age") int age, @Param("name") String name);
}
