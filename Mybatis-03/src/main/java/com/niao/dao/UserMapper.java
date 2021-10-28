package com.niao.dao;

import com.niao.pojo.User;

import java.util.List;

/**
 * Dao就等价于mybatis中的Mapper
 * @author HuangSir
 * @create 2021-06-21 11:08
 */
public interface UserMapper {
   /**
    * 根据指定的ID查询用户
    * @param id
    * @return
    */
   User queryUserById(int id);

}
