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
    * 根据指定的ID查询用户
    * @param id
    * @return
    */
   User queryUserById(int id);

   /**
    *分页实现查询
    * @param map 参数一多就用万能的Map
    * @return
    */
   List<User> queryUserByLimit(Map<String,Integer> map);

   /**
    * 通过RowBounds实现分页查询
    * @return
    */
   List<User> queryListByRowBounds();
}
