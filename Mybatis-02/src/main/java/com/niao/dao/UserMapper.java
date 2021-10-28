package com.niao.dao;

import com.niao.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Dao就等价于mybatis中的Mapper
 * @author HuangSir
 * @create 2021-06-21 11:08
 */
public interface UserMapper {
   /**
    * 获取所有User构成的集合
    * @return
    */
   List<User> getUserList();


   /**
    * 根据指定的ID查询用户
    * @param id
    * @return
    */
   User queryUserById(int id);

   /**
    * 添加用户信息
    * @param user
    */
   int addUser(User user);

   /**
    * 修改用户信息为指定用户的信息
    * @param user
    * @return
    */
   int updateUser(User user);

   /**
    * 根据id删除用户信息
    * @param id
    * @return
    */
   int deleteUser(int id);
}
