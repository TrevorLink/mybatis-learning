package com.niao.dao;

import com.niao.pojo.User;
import org.apache.ibatis.annotations.Param;


/**
 * @author HuangSir
 * @create 2021-06-29 19:47
 */
public interface UserMapper {
   /**
    * 根据指定id查询用户信息
    * @param id
    * @return
    */
   User queryUserById(@Param("id") int id);
}
