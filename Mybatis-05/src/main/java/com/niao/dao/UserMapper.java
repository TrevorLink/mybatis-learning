package com.niao.dao;



import com.niao.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Dao就等价于mybatis中的Mapper
 * @author HuangSir
 * @create 2021-06-21 11:08
 */
public interface UserMapper {
   /**
    * 使用注解来获取所有的用户信息，这样就不需要Mapper.xml实现类了
    * @return
    */
   @Select("select * from user ")
   List<User> queryAllUsers();

   /**
    * 根据指定的id查询用户信息
    * @param id
    * @return
    */
   @Select("select * from user where id =#{id}")
   User queryUserById(@Param("id") int id);

   /**
    * 插入一条用户信息
    * @param user
    * @return
    */
   @Insert("insert into user (id,name,pwd)values(#{id},#{name},#{password})")
   int addUser(User user);

   /**
    * 根据id删除用户信息
    * @param id
    * @return
    */
   @Delete("delete from user where id =#{id}")
   int deleteUser(@Param("id") int id);

   /**
    * 修改指定用户信息
    * @param user
    * @return
    */
//对于实体类，他是引用类型的，实体类里面属性是啥就赋啥名的值
   @Update("update user set name=#{name},pwd=#{password} where id=#{id}")
   int updateUser(User user);
}
